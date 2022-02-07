package com.example.calculator_gb;

import static com.example.calculator_gb.R.id.radioButtonMaterialDefault;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.RadioButton;

public class ThemeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        setTheme(MyApp.currentTheme);

        ((RadioButton) findViewById(R.id.radioButtonMaterialDefault)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.radioButtonMaterialRed)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.radioButtonMaterialGreen)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.radioButtonMaterialBlue)).setOnClickListener(this);
    }


    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    public void onClick(View view) {
        switch (view.getId()) {
            case radioButtonMaterialDefault: {
                MyApp.currentTheme = R.style.Theme_Calculator_GB;
                break;
            }
            case R.id.radioButtonMaterialGreen: {
                MyApp.currentTheme = R.style.myThemeGreen;
                break;
            }
            case R.id.radioButtonMaterialBlue: {
                MyApp.currentTheme = R.style.myThemeBlue;
                break;
            }
            case R.id.radioButtonMaterialRed: {
                MyApp.currentTheme = R.style.myThemeRed;
                break;
            }
        }
        recreate();
    }
}