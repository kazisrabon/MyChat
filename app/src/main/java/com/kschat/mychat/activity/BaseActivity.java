package com.kschat.mychat.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public boolean validateLogin(String typedCode, String typedPass) {
        return true;
    }

    public boolean validateConfirmationCode(String typedCode) {
        return true;
    }
}
