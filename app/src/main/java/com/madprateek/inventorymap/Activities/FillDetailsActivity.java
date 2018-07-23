package com.madprateek.inventorymap.Activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.madprateek.inventorymap.HelperClasses.Connection;
import com.madprateek.inventorymap.HelperClasses.DatabaseHelper;
import com.madprateek.inventorymap.HelperClasses.MyJsonObjectRequest;
import com.madprateek.inventorymap.HelperClasses.MySingleton;
import com.madprateek.inventorymap.ModelClasses.MapDetailsModel;
import com.madprateek.inventorymap.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.List;

public class FillDetailsActivity extends AppCompatActivity {

    private TextView mOtnNo;
    private static final String TAG = FillDetailsActivity.class.getSimpleName();
    private EditText mLength,mKarni1,mKarni2,mDharawat;
    private Toolbar mToolbar;
    private Button mSubmitBtn;
    String url = "http://portal.jaipurrugsco.com/jrapi/public/ppr";
    String otnNo, mLocation = "";
    DatabaseHelper db = new DatabaseHelper(this);
    Context context;
    int REQUEST_LOCATION = 1;
    JSONArray jsonArray = new JSONArray();
    LocationListener locationListener;
    LocationManager locationManager;

    public FillDetailsActivity(Context context) {
        this.context = context;
    }

    public FillDetailsActivity(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_details);

        mToolbar = (Toolbar) findViewById(R.id.fillDetailsAppBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Fill Details");

        mOtnNo = (TextView) findViewById(R.id.otnNo);
        mLength = (EditText) findViewById(R.id.lengthText);
        mKarni1 = (EditText) findViewById(R.id.karni1Text);
        mKarni2 = (EditText) findViewById(R.id.karni2Text);
        mDharawat = (EditText) findViewById(R.id.dharawatText);
        mSubmitBtn = (Button) findViewById(R.id.submitDetailsBtn);
        final Bundle bundle = getIntent().getExtras();
        otnNo = bundle.getString("otnNo");
        final int runningLength = Integer.parseInt(bundle.getString("previousLength"));
        Log.d(TAG,"value is : " + runningLength);
        mOtnNo.setText(otnNo);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, REQUEST_LOCATION);

        }

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int lengthInInches = Integer.valueOf(mLength.getText().toString());
              if (lengthInInches >= runningLength){
                  String length = mLength.getText().toString();
                  String karni1 = mKarni1.getText().toString();
                  String karni2 = mKarni2.getText().toString();
                  String dharawat = mDharawat.getText().toString();
                  mLocation = getLocation();
                  storeMapDetails(otnNo,length,karni1,karni2,dharawat,mLocation);
                  Toast.makeText(FillDetailsActivity.this,"Details Submitted Successfully",Toast.LENGTH_SHORT).show();
                  mLength.setText("");
                  mKarni1.setText("");
                  mKarni2.setText("");
                  mDharawat.setText("");
              }else mLength.setError("This must be greater than " + runningLength + " in inches");

                //sendData(jsonArray);
                Connection connection = new Connection();
                if (connection.isConnectingToInternet(getApplicationContext())){
                    customReq(jsonArray);
                }else {
                    Toast.makeText(FillDetailsActivity.this, "Please Check Connectivity", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void customReq(JSONArray jsonArray) {

        List<MapDetailsModel> mapList = db.getAllMapDetails();
        for (MapDetailsModel mapDetail : mapList){
            createArray(mapDetail);
        }
        Log.d(TAG,"Value of array : " + jsonArray.toString());
        MyJsonObjectRequest myJsonObjectRequest = new MyJsonObjectRequest(url, jsonArray, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"response from server : " + response.toString());
                db.deleteAllMapDetails();
                Log.d(TAG,"All rows of map details deleted");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MySingleton.getInstance(getApplicationContext()).addTorequestque(myJsonObjectRequest);
    }


    private void createArray(final MapDetailsModel mapDetail) {


        JSONObject details = new JSONObject();
        try {
            details.put("otn_no", mapDetail.getOtnNo());
            details.put("length_in_inches", mapDetail.getLengthInInches());
            details.put("karni_1", mapDetail.getKarni1());
            details.put("karni_2", mapDetail.getKarni2());
            details.put("dharawat", mapDetail.getDharawat());
            details.put("app_date", mapDetail.getSaveDate());
            details.put("location", mapDetail.getLocation());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        jsonArray.put(details);
    }

    private void storeMapDetails(String otnNo, String length, String karni1, String karni2, String dharawat, String location) {
        String uploadTimeStamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
        MapDetailsModel mapDetail = new MapDetailsModel(otnNo,length,karni1,karni2,dharawat,uploadTimeStamp, location);
        db.addMapDetails(mapDetail);
    }


    public String getLocation() {
        locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                mLocation = "Latitude : " + location.getLatitude() + " , " + "Longitude : " + location.getLongitude();
                //Log.v("TAG","Value of mLocation in main onLocationChanged :" + mLocation);
                // Toast.makeText(MainActivity.this, "Return inside onLocation" + mLocation, Toast.LENGTH_SHORT).show();
                //Log.v("TAG", "Latitude : " + location.getLatitude() + " , " + "Longitude : " + location.getLongitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, REQUEST_LOCATION);

        } else {
            //Log.v("TAG","Entered in else");
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            return mLocation;
        }

         Log.v(TAG,"returning value in Main is :" + mLocation);
        // Toast.makeText(this, "Return outside in Main onLocation" + mLocation, Toast.LENGTH_SHORT).show();
        return mLocation;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //Do your work.
                mLocation = getLocation();
            }
        }
    }
}
