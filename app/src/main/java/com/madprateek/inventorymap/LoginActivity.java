package com.madprateek.inventorymap;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText mUsername,mPass;
    private Button mLoginBtn;
    ProgressDialog mProgressDialog;
    SessionManager session;
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

            }
        });
    }
}
