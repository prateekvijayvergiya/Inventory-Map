package com.madprateek.inventorymap.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.madprateek.inventorymap.HelperClasses.DatabaseHelper;
import com.madprateek.inventorymap.HelperClasses.MyJsonArrayRequest;
import com.madprateek.inventorymap.HelperClasses.MySingleton;
import com.madprateek.inventorymap.HelperClasses.SessionManager;
import com.madprateek.inventorymap.ModelClasses.InventoryModel;
import com.madprateek.inventorymap.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText mUsername,mPass;
    private Button mLoginBtn;
    String url = "http://portal.jaipurrugsco.com/jrapi/public/rugline";
    ProgressDialog mProgressDialog;
    SessionManager session;
    private static final String TAG = LoginActivity.class.getSimpleName();
    DatabaseHelper db = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = (EditText) findViewById(R.id.loginUsername);
        mPass = (EditText) findViewById(R.id.loginPass);
        mLoginBtn = (Button) findViewById(R.id.loginBtn);
        session = new SessionManager(getApplicationContext());
        mProgressDialog = new ProgressDialog(this);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = mUsername.getText().toString();
                String pass = mPass.getText().toString();
                try {
                    json();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
    }
}
