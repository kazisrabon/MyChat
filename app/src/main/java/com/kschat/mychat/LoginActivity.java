package com.kschat.mychat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.hbb20.CountryCodePicker;
import com.sandro.restaurant.Restaurant;

import static com.kschat.mychat.R.id.typedCodeET;

public class LoginActivity extends AppCompatActivity {

    private CountryCodePicker countryCodePicker;
    private Button loginButton;
    private TextView signUpTV;
    private TextInputEditText typedPhoneET, typedPassET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        init();
    }

    private void init() {
        countryCodePicker = (CountryCodePicker) findViewById(R.id.ccpicker);
        if (!countryCodePicker.getSelectedCountryNameCode().toLowerCase().contentEquals("bd"))
            countryCodePicker.setCountryForNameCode("bd");

        loginButton = (Button) findViewById(R.id.loginButton);
        signUpTV = (TextView) findViewById(R.id.signUpTV);
        typedPhoneET = (TextInputEditText) findViewById(R.id.typedPhoneET);
        typedPassET = (TextInputEditText) findViewById(R.id.typedPassET);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ccode = countryCodePicker.getSelectedCountryCode();
                String typedPhoneNumber = typedPhoneET.getText().toString();
                typedPhoneNumber = ccode+typedPhoneNumber;
                String typedPass = typedPassET.getText().toString();
                if (validateLogin(typedPhoneNumber, typedPass)) {
                    new Restaurant(LoginActivity.this, "CONFIRMED!!!", Snackbar.LENGTH_LONG)
                            .setBackgroundColor(Color.GRAY)
                            .setTextColor(Color.GREEN)
                            .show();
                } else {
                    new Restaurant(LoginActivity.this, "NOT VALIDATE!!!"+countryCodePicker.getSelectedCountryNameCode(), Snackbar.LENGTH_LONG)
                            .setBackgroundColor(Color.BLACK)
                            .setTextColor(Color.RED)
                            .show();
                }
            }
        });
        signUpTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), RegActivity.class));
            }
        });
    }

    private boolean validateLogin(String typedCode, String typedPass) {
        return false;
    }
}
