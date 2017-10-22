package com.kschat.mychat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.hbb20.CountryCodePicker;

public class RegActivity extends AppCompatActivity {

    private CountryCodePicker countryCodePicker;
    private Button regButton;
    private TextView signInTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

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

        regButton = (Button) findViewById(R.id.regButton);
        signInTV = (TextView) findViewById(R.id.signInTV);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), ConfirmationActivity.class));
            }
        });
        signInTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }
}
