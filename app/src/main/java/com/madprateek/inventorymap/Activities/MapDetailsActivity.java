package com.madprateek.inventorymap.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.madprateek.inventorymap.HelperClasses.DatabaseHelper;
import com.madprateek.inventorymap.HelperClasses.MyAdapter;
import com.madprateek.inventorymap.ModelClasses.InventoryModel;
import com.madprateek.inventorymap.R;

import java.util.ArrayList;

public class MapDetailsActivity extends AppCompatActivity {

    DatabaseHelper db;
    ArrayList<InventoryModel> inventoryModels;
    private TextView mMapNo,mQuality,mQuantity,mDesign,mGrColorName,mBrColorName,mSize,mShape,mLocation,mWeaverName,mIssueDate,mDueDate,mQs;
    private static final String TAG = MapDetailsActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Toolbar mToolbar;
    private Button mPPRBtn, mQualityCheckBtn;
    private int mapQuantity;
    String mapNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_details);

        mToolbar = (Toolbar) findViewById(R.id.mapDetailsBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Map Details");

        mMapNo = (TextView) findViewById(R.id.mapNo);
        mQuality = (TextView) findViewById(R.id.quality);
        mDesign = (TextView) findViewById(R.id.design);
        mGrColorName = (TextView) findViewById(R.id.grColorName);
        mBrColorName = (TextView) findViewById(R.id.brColorName);
        mSize = (TextView) findViewById(R.id.size);
        mShape = (TextView) findViewById(R.id.shape);
        mLocation = (TextView) findViewById(R.id.location);
        mWeaverName = (TextView) findViewById(R.id.weaverName);
        mIssueDate = (TextView) findViewById(R.id.issueDate);
        mDueDate = (TextView) findViewById(R.id.dueDate);
        mPPRBtn = (Button) findViewById(R.id.enterPPNBtn);
        mQs = (TextView) findViewById(R.id.qs);
        mQuantity = (TextView) findViewById(R.id.quantity);
        mQualityCheckBtn = (Button) findViewById(R.id.qualityCheckBtn);
        db = new DatabaseHelper(this);

        Bundle bundle = getIntent().getExtras();
        final String mapNo = bundle.getString("mapNo");
        inventoryModels = (ArrayList<InventoryModel>) db.getAllMaps(mapNo);
        mapQuantity = inventoryModels.size();

            setStaticDetails();
            mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
            mLayoutManager = new LinearLayoutManager(getApplicationContext());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
            mAdapter = new MyAdapter(inventoryModels,getApplicationContext());
            mRecyclerView.setAdapter(mAdapter);


        mPPRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerView.setVisibility(View.VISIBLE);
            }
        });

        mQualityCheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent qualityCheck = new Intent(MapDetailsActivity.this, QualityCheckActivity.class);
                qualityCheck.putExtra("mapNo", mapNo);
                startActivity(qualityCheck);
            }
        });

    }

    private void setStaticDetails() {

        InventoryModel invent = inventoryModels.get(0);
        mMapNo.setText(invent.getMAP_SERIAL_NO());
        mapNo = invent.getMAP_SERIAL_NO();
        mQuality.setText(invent.getQUALITY());
        mDesign.setText(invent.getDESIGN());
        mGrColorName.setText(invent.getGR_COLOR_NAME() + " (" + invent.getGROUND_COLOR() + ")");
        mBrColorName.setText(invent.getBR_COLOR_NAME() + " (" + invent.getBORDER_COLOR() + ")");
        mSize.setText(invent.getSIZE());
        mShape.setText(invent.getSHAPE());
        mQuantity.setText(String.valueOf(mapQuantity));
        mLocation.setText(invent.getPRODUCTION_LOCATION());
        mWeaverName.setText(invent.getWEAVER_NAME());
        mIssueDate.setText(invent.getACTUAL_WEAVER_ISSUE_DATE());
        mDueDate.setText(invent.getREVISED_ORDER_DUE_DATE());
        mQs.setText(invent.getQS());

    }
}
