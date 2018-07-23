package com.madprateek.inventorymap.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.madprateek.inventorymap.HelperClasses.DatabaseHelper;
import com.madprateek.inventorymap.ModelClasses.QualityCheckModel;
import com.madprateek.inventorymap.R;

public class QualityCheckActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Button mSubmitBtn;
    String dharawat, tani, design, color;
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
                Toast.makeText(QualityCheckActivity.this,"Details Submitted Successfully",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(QualityCheckActivity.this,MainActivity.class));
                finish();
            }
        });

    }

    private void storeQualityCheck(String mapNo) {
        QualityCheckModel qualityCheckModel = new QualityCheckModel(mapNo,dharawat,tani,design,color);
        db.addQualityCheck(qualityCheckModel);
    }

    private void checkForValues() {

        if (mDharawatLowCheck.isChecked())
            dharawat = "कम";
        else dharawat = "ज्यादा";

        if (mTaniLooseCheck.isChecked())
            tani = "ढीली";
        else tani = "टाइट";

        if (mDesignRightCheck.isChecked())
            design = "सही";
        else design = "गलत";

        if (mColorRightCheck.isChecked())
            color = "सही";
        else color = "गलत";
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
