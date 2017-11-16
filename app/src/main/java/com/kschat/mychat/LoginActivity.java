package com.kschat.mychat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class LoginActivity extends BaseActivity {

    private CountryCodePicker countryCodePicker;
    private Button loginButton;
    private TextView signUpTV;
    private EditText typedPhoneET, typedPassET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window w = getWindow(); // in Activity's onCreate() for instance
//            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        }

        init();
    }

    private void init() {
        countryCodePicker = (CountryCodePicker) findViewById(R.id.ccpicker);
        if (!countryCodePicker.getSelectedCountryNameCode().toLowerCase().contentEquals("bd"))
            countryCodePicker.setCountryForNameCode("bd");

        loginButton = (Button) findViewById(R.id.loginButton);
        signUpTV = (TextView) findViewById(R.id.signUpTV);
        typedPhoneET = (EditText) findViewById(R.id.phoneNumberET);
        typedPassET = (EditText) findViewById(R.id.passET);

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

        typedPassET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if(motionEvent.getRawX() >= (typedPassET.getRight() - typedPassET.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here
                        typedPassET.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        return true;
                    }
                }
                else if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    if(motionEvent.getRawX() >= (typedPassET.getRight() - typedPassET.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here
                        typedPassET.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
