package com.kschat.mychat;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.sandro.restaurant.Restaurant;

public class ConfirmationActivity extends AppCompatActivity {

    private Button confirmationButton;
    private EditText typedCodeET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        init();
    }

    private void init() {
        confirmationButton = (Button) findViewById(R.id.confirmationButton);
        typedCodeET = (EditText) findViewById(R.id.typedCodeET);

        confirmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                do something
                String typedCode = typedCodeET.getText().toString();
                if (validateConfirmationCode(typedCode)) {
                    new Restaurant(ConfirmationActivity.this, "CONFIRMED!!!", Snackbar.LENGTH_LONG)
                            .setBackgroundColor(Color.GRAY)
                            .setTextColor(Color.GREEN)
                            .show();
                } else {
                    new Restaurant(ConfirmationActivity.this, "NOT VALIDATE!!!", Snackbar.LENGTH_LONG)
                            .setBackgroundColor(Color.BLACK)
                            .setTextColor(Color.RED)
                            .show();
                }
            }
        });
    }

    private boolean validateConfirmationCode(String typedCode) {
        return false;
    }
}
