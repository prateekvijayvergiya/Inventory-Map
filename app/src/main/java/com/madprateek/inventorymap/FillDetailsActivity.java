package com.madprateek.inventorymap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class FillDetailsActivity extends AppCompatActivity {

    private TextView mOtnNo;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_details);

        mToolbar = (Toolbar) findViewById(R.id.fillDetailsAppBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Fill Details");

        mOtnNo = (TextView) findViewById(R.id.otnNo);
        Bundle bundle = getIntent().getExtras();
        String otnNo = bundle.getString("otnNo");
        mOtnNo.setText(otnNo);

    }
}
