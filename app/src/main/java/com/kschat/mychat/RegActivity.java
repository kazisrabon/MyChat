package com.kschat.mychat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hbb20.CountryCodePicker;
import com.sandro.restaurant.Restaurant;

public class RegActivity extends BaseActivity {

    private CountryCodePicker countryCodePicker;
    private Button regButton;
    private TextView signInTV;
    private EditText phoneET, passET, u_nameET;

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
        u_nameET = (EditText) findViewById(R.id.userNameET);
        phoneET = (EditText) findViewById(R.id.phoneNumberET);//userNameET phoneNumberET passET
        passET = (EditText) findViewById(R.id.passET);
        regButton = (Button) findViewById(R.id.regButton);
        signInTV = (TextView) findViewById(R.id.signInTV);
        countryCodePicker = (CountryCodePicker) findViewById(R.id.ccpicker);

        if (!countryCodePicker.getSelectedCountryNameCode().toLowerCase().contentEquals("bd"))
            countryCodePicker.setCountryForNameCode("bd");

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ccode = countryCodePicker.getSelectedCountryCode();
                String typedPhoneNumber = phoneET.getText().toString();
                typedPhoneNumber = ccode+typedPhoneNumber;
                String typedPass = passET.getText().toString();
                if (validateLogin(typedPhoneNumber, typedPass)) {
                    new Restaurant(RegActivity.this, "CONFIRMED!!!", Snackbar.LENGTH_LONG)
                            .setBackgroundColor(Color.GRAY)
                            .setTextColor(Color.GREEN)
                            .show();

                    startActivity( new Intent(getApplicationContext(), ConfirmationActivity.class));
                } else {
                    new Restaurant(RegActivity.this, "NOT VALIDATE!!!"+countryCodePicker.getSelectedCountryNameCode(), Snackbar.LENGTH_LONG)
                            .setBackgroundColor(Color.BLACK)
                            .setTextColor(Color.RED)
                            .show();
                }
            }
        });
        signInTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        passET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if(motionEvent.getRawX() >= (passET.getRight() - passET.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here
                        passET.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        return true;
                    }
                }
                else if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    if(motionEvent.getRawX() >= (passET.getRight() - passET.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here
                        passET.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
