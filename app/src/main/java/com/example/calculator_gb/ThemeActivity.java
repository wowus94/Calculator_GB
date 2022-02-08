package com.example.calculator_gb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class ThemeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String PREF_NAME = "key";
    private static final String PREF_THEME_KEY = "key_theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme());
        setContentView(R.layout.activity_theme);


        ((RadioButton) findViewById(R.id.radioButtonMaterialDefault)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.radioButtonMaterialRed)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.radioButtonMaterialGreen)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.radioButtonMaterialBlue)).setOnClickListener(this);
    }


    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.radioButtonMaterialDefault: {
                setAppTheme(R.style.Theme_Calculator_GB);
                break;
            }
            case R.id.radioButtonMaterialGreen: {
                setAppTheme(R.style.myThemeGreen);
                break;
            }
            case R.id.radioButtonMaterialBlue: {
                setAppTheme(R.style.myThemeBlue);
                break;
            }
            case R.id.radioButtonMaterialRed: {
                setAppTheme(R.style.myThemeRed);
                break;
            }
        }
        Intent intent = new Intent(ThemeActivity.this, MainActivity.class);
        intent.putExtra(MainActivity.KEY_INTENT_FROM_SECOND_TO_MAIN, getAppTheme());
        ThemeActivity.this.setResult(RESULT_OK, intent);
        finish();
    }

    private void setAppTheme(int style) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PREF_THEME_KEY, style);
        editor.apply();
    }

    private int getAppTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return sharedPreferences.getInt(PREF_THEME_KEY, R.style.Theme_Calculator_GB);
    }
}