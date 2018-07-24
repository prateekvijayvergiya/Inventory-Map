package com.madprateek.inventorymap.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.madprateek.inventorymap.HelperClasses.DatabaseHelper;
import com.madprateek.inventorymap.HelperClasses.MyJsonObjectRequest;
import com.madprateek.inventorymap.HelperClasses.MySingleton;
import com.madprateek.inventorymap.ModelClasses.QualityCheckModel;
import com.madprateek.inventorymap.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class QualityCheckActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Button mSubmitBtn;
    private static final String TAG = QualityCheckActivity.class.getSimpleName();
    JSONArray jsonArray = new JSONArray();
    String dharawatKam="0", dharawatJyada="0", taniDhili="0", taniTight="0", designSahi="0", designGalat="0", colorSahi="0", colorGalat="0";
    DatabaseHelper db = new DatabaseHelper(this);
    private CheckBox mDharawatLowCheck,mDharawatHighCheck, mTaniLooseCheck,mTaniTightCheck, mDesignRightCheck,mDesignWrongCheck, mColorRightCheck, mColorWrongCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality_check);

        mToolbar = (Toolbar) findViewById(R.id.qualityCheckAppBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Quality Check");

        mDharawatLowCheck = (CheckBox) findViewById(R.id.dharawatLowCheck);
        mDharawatHighCheck = (CheckBox) findViewById(R.id.dharawatHighCheck);
        mTaniLooseCheck = (CheckBox) findViewById(R.id.taniLooseCheck);
        mTaniTightCheck = (CheckBox) findViewById(R.id.taniTightCheck);
        mDesignRightCheck = (CheckBox) findViewById(R.id.designRightCheck);
        mDesignWrongCheck = (CheckBox) findViewById(R.id.designWrongCheck);
        mColorRightCheck = (CheckBox) findViewById(R.id.colorRightCheck);
        mColorWrongCheck = (CheckBox) findViewById(R.id.colorWrongCheck);
        mSubmitBtn = (Button) findViewById(R.id.qualitySubmitDetailsBtn);

        Bundle bundle = getIntent().getExtras();
        final String mapNo = bundle.getString("mapNo");

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForValues();
                storeQualityCheck(mapNo);
                uploadServer();
                Toast.makeText(QualityCheckActivity.this,"Details Submitted Successfully",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(QualityCheckActivity.this,MainActivity.class));
                finish();
            }
        });

    }

    private void uploadServer() {
        List<QualityCheckModel> qualityList = db.getAllQualityCheck();
        for (QualityCheckModel qualityDetail : qualityList){
            createArray(qualityDetail);
        }
        Log.d(TAG,"Value of array : " + jsonArray.toString());
        String url = "http://portal.jaipurrugsco.com/jrapi/public/quality";
        MyJsonObjectRequest myJsonObjectRequest = new MyJsonObjectRequest(url, jsonArray, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d(TAG,"response from server : " + response.toString());
                db.deleteAllQualityCheck();
                Log.d(TAG,"All rows of quality check details deleted");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                
            }
        });
        MySingleton.getInstance(getApplicationContext()).addTorequestque(myJsonObjectRequest);
    }

    private void storeQualityCheck(String mapNo) {
        QualityCheckModel qualityCheckModel = new QualityCheckModel(mapNo,dharawatKam,dharawatJyada,taniDhili,taniTight,designSahi,designGalat,colorSahi,colorGalat);
        db.addQualityCheck(qualityCheckModel);
    }

    private void createArray(final QualityCheckModel qualityDetail){
        JSONObject details = new JSONObject();
        try {
            details.put("map_no",qualityDetail.getMapNo());
            details.put("dharawat_kam",qualityDetail.getDharawatKam());
            details.put("dharawat_jyada",qualityDetail.getDharawatJyada());
            details.put("taani_dheeli",qualityDetail.getTaniDhili());
            details.put("taani_tight",qualityDetail.getTaniTight());
            details.put("design_sahi",qualityDetail.getDesignSahi());
            details.put("design_galat",qualityDetail.getDesignGalat());
            details.put("color_sahi",qualityDetail.getColorSahi());
            details.put("color_galat",qualityDetail.getColorGalat());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        jsonArray.put(details);
    }

    private void checkForValues() {

        if (mDharawatLowCheck.isChecked())
            dharawatKam = "1";
        else dharawatJyada = "1";

        if (mTaniLooseCheck.isChecked())
            taniDhili = "1";
        else taniTight = "1";

        if (mDesignRightCheck.isChecked())
            designSahi = "1";
        else designGalat = "1";

        if (mColorRightCheck.isChecked())
            colorSahi = "1";
        else colorGalat = "1";
    }


    public void onClickCheckBox(View view) {
        switch (view.getId()){

            case R.id.dharawatLowCheck:
                if (mDharawatLowCheck.isChecked())
                    mDharawatHighCheck.setClickable(false);
                else mDharawatHighCheck.setClickable(true);
                break;

            case R.id.dharawatHighCheck:
                if (mDharawatHighCheck.isChecked())
                     mDharawatLowCheck.setClickable(false);
                else mDharawatLowCheck.setClickable(true);
                break;

            case R.id.taniLooseCheck:
                if (mTaniLooseCheck.isChecked())
                    mTaniTightCheck.setClickable(false);
                else mTaniTightCheck.setClickable(true);
                break;

            case R.id.taniTightCheck:
                if (mTaniTightCheck.isChecked())
                    mTaniLooseCheck.setClickable(false);
                else mTaniLooseCheck.setClickable(true);
                break;

            case R.id.designRightCheck:
                if (mDesignRightCheck.isChecked())
                    mDesignWrongCheck.setClickable(false);
                else mDesignWrongCheck.setClickable(true);
                break;

            case R.id.designWrongCheck:
                if (mDesignWrongCheck.isChecked())
                    mDesignRightCheck.setClickable(false);
                else mDesignRightCheck.setClickable(true);
                break;

            case R.id.colorRightCheck:
                if (mColorRightCheck.isChecked())
                    mColorWrongCheck.setClickable(false);
                else mColorWrongCheck.setClickable(true);
                break;

            case R.id.colorWrongCheck:
                if (mColorWrongCheck.isChecked())
                    mColorRightCheck.setClickable(false);
                else mColorRightCheck.setClickable(true);
                break;

                default:
        }
    }
}
