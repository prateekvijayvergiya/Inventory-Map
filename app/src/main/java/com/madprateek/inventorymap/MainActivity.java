package com.madprateek.inventorymap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.madprateek.inventorymap.HelperClasses.DatabaseHelper;
import com.madprateek.inventorymap.ModelClasses.InventoryModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    private Toolbar mToolbar;
    String url = "http://portal.jaipurrugsco.com/jrapi/public/rugline";
    Button mBtn,mSearchBtn;
    EditText mSearchText;
    DatabaseHelper db;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.mainAppBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Inventory");

        db = new DatabaseHelper(this);
        mBtn = (Button) findViewById(R.id.btn);
        mSearchBtn = (Button) findViewById(R.id.searchBtn);
        mSearchText = (EditText) findViewById(R.id.mapText);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    json();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mapNo = mSearchText.getText().toString();
                Intent sendIntent = new Intent(MainActivity.this,MapDetailsActivity.class);
                sendIntent.putExtra("mapNo",mapNo);
                startActivity(sendIntent);
            }
        });

    }

    private void json() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("qs", "ROHITASH");
        Map<String, String> details = new HashMap<>();
        details.put("qs", "ROHITASH");
        Log.d(TAG,"Sending value is :" + new JSONObject(details));
        MyJsonArrayRequest request=new MyJsonArrayRequest(Request.Method.POST, url, new JSONObject(details), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, "response :" + response.toString());
                for (int i =0; i < response.length(); i++){

                    try {
                        JSONObject obj = response.getJSONObject(i);
                        String mapNo = obj.getString("Map No");
                        String itemNo = obj.getString("Item No_");
                        String quality = obj.getString("Quality");
                        String design = obj.getString("Design");
                        String grColorName = obj.getString("GR Color Name");
                        String brColorName = obj.getString("BR Color Name");
                        String groundColor = obj.getString("Ground Color");
                        String borderColor = obj.getString("Border Color");
                        String size = obj.getString("Size");
                        String shape = obj.getString("Shape");
                        int priority = obj.getInt("Order Priority");
                        String currentStatus = obj.getString("Current Status");
                        String prodOrderNo = obj.getString("Prod_ Order No_");
                        String otnNo = obj.getString("OTN No_");
                        String location = obj.getString("Location");
                        String branchManager = obj.getString("Branch Manager");
                        String weaverName = obj.getString("Vendor");
                        int runningLength = obj.getInt("Running Length");
                        int remainingWork = obj.getInt("Pending Work");
                        String actualWeaverIssueDate = obj.getString("Actual Weaver Issue Date");
                        String revisedOrderDueDate = obj.getString("Revised Order Due Date");
                        String qs = obj.getString("QS");
                        String ptnNo = obj.getString("PTN No_");
                        String weaverOnLoomDate = obj.getString("Weaver On Loom Date");
                        String merchantName = "Null";
                        String territoryHead = "Null";

                        storeRugline(mapNo, itemNo, quality, design, grColorName, brColorName, groundColor, borderColor, size, shape, priority,
                                currentStatus, prodOrderNo, otnNo, location, branchManager, weaverName, runningLength, remainingWork, actualWeaverIssueDate,
                                revisedOrderDueDate,qs, ptnNo, weaverOnLoomDate, merchantName, territoryHead);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.d(TAG, "Error from Server is " + error.toString());
            }
        });
        MySingleton.getInstance(getApplicationContext()).addTorequestque(request);
    }

    private void storeRugline(String mapNo, String itemNo, String quality, String design, String grColorName, String brColorName, String groundColor, String borderColor, String size, String shape, int priority, String currentStatus, String prodOrderNo, String otnNo, String location, String branchManager, String weaverName, int runningLength, int remainingWork, String actualWeaverIssueDate, String revisedOrderDueDate, String qs, String ptnNo, String weaverOnLoomDate, String merchantName, String territoryHead) {

        InventoryModel inventoryModel = new InventoryModel(mapNo, itemNo, quality, design, grColorName, brColorName, groundColor, borderColor, size, shape, priority,
                currentStatus, prodOrderNo, otnNo, location, branchManager, weaverName, runningLength, remainingWork, actualWeaverIssueDate,
                revisedOrderDueDate,qs, ptnNo, weaverOnLoomDate, merchantName, territoryHead);
        db.addRugline(inventoryModel);
        Log.d(TAG,"Rugline Row Added");
    }

    private void sendReq() throws JSONException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("qs", "ROHITASH");
        Log.d(TAG,"object value is :" + jsonObject);
        Map<String, String> details = new HashMap<>();
        details.put("qs", "ROHITASH");
        //Set<Map.Entry<String, String>> demoEntrySet = details.entrySet();
        String[] arr = {"qs", "ROHITASH"};
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);
        Log.d(TAG,"Sending value is :" + jsonArray);

      JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //  Toast.makeText(this,response.toString(),Toast.LENGTH_LONG).show();
                Log.d(TAG, "response :" + response.toString());

             /*   for (int i =0; i < response.length(); i++){

                    try {
                        JSONObject obj = response.getJSONObject(i);
                        String mapNo = obj.getString("Map No");
                        String ItemNo = obj.getString("Item No_");
                        String quality = obj.getString("Quality");
                        String design = obj.getString("Design");
                        String grColorName = obj.getString("GR Color Name");
                        String brColorName = obj.getString("BR Color Name");
                        String groundColor = obj.getString("Ground Color");
                        String borderColor = obj.getString("Border Color");
                        String size = obj.getString("Size");
                        String shape = obj.getString("Shape");
                        int priority = obj.getInt("Order Priority");
                        String currentStatus = obj.getString("Current Status");
                        String prodOrderNo = obj.getString("Prod_ Order No_");
                        String otnNo = obj.getString("OTN NO_");
                        String location = obj.getString("Location");
                        String branchManager = obj.getString("Branch Manager");
                        String weaverName = obj.getString("Vendor");
                        String runningLength = obj.getString("Running Length");
                        String remainingWork = obj.getString("Pending Work");
                        String actualWeaverIssueDate = obj.getString("Actual Weaver Issue Date");


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d(TAG, "Error from Server is " + error.toString());
            }
        }){
           @Override
           protected Map<String, String> getParams() {
               Map<String, String> details = new HashMap<>();
               details.put("qs", "ROHITASH");
               Log.d(TAG,"Sending value is :" + details.toString());
               return details;
           }

           @Override
           protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
               String responseString;
               JSONArray array = new JSONArray();
               if (response != null) {

                   try {
                       responseString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                       JSONObject obj = new JSONObject(responseString);
                       (array).put(obj);
                   } catch (Exception ex) {
                   }
               }
               //return array;
               return Response.success(array, HttpHeaderParser.parseCacheHeaders(response));
           }

           @Override
           public int getMethod() {
               return Method.POST;
           }

      };

        MySingleton.getInstance(getApplicationContext()).addTorequestque(jsonArrayRequest);
    }



    public void send(){

        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("qs", "ROHITASH");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Map<String, String> details = new HashMap<>();
        details.put("qs", "ROHITASH");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(details), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "response :" + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d(TAG,"Error : " + error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> details = new HashMap<>();
                details.put("qs", "ROHITASH");
                Log.d(TAG, "Sending value is :" + details.toString());
                return details;
            }
        };

        MySingleton.getInstance(getApplicationContext()).addTorequestque(jsonObjectRequest);
    }

}
