package com.example.calculator_gb;

import static com.example.calculator_gb.R.id.radioButtonMaterialDefault;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    Button button_5;
    Button button_6;
    Button button_7;
    Button button_8;
    Button button_9;
    Button button_0;
    Button sum;
    Button min;
    Button multiply;
    Button division;
    Button equality;
    Button point;
    Button clear;
    Button procent;
    TextView result;
    EditText editText;
    Double operand = null;
    String lastOperation = "";
    Button setTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        initView();
        initListeners();
        setTheme = findViewById(R.id.setTheme);
        setTheme.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemeActivity.class);
                startActivity(intent);
            }
        });
    }


    void initView() {
        button_0 = findViewById(R.id.button_0);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);
        sum = findViewById(R.id.sum);
        min = findViewById(R.id.min);
        multiply = findViewById(R.id.multiply);
        division = findViewById(R.id.division);
        equality = findViewById(R.id.equality);
        point = findViewById(R.id.point);
        clear = findViewById(R.id.clear);
        procent = findViewById(R.id.procent);
        result = findViewById(R.id.result);
        editText = findViewById(R.id.editText);

    }


    void initListeners() {
        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        sum.setOnClickListener(this);
        min.setOnClickListener(this);
        multiply.setOnClickListener(this);
        division.setOnClickListener(this);
        equality.setOnClickListener(this);
        point.setOnClickListener(this);
        clear.setOnClickListener(this);
        procent.setOnClickListener(this);

    }

    Double first = 0.0;
    Double two = 0.0;
    int operation = 0;
    String input = "";


    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    public void onClick(View view) {

        Button button = (Button) view;
        editText.setText(editText.getText().toString() + button.getText().toString());
        switch (view.getId()) {
            case R.id.button_0:
            case R.id.button_1:
            case R.id.button_2:
            case R.id.button_3:
            case R.id.button_4:
            case R.id.button_5:
            case R.id.button_6:
            case R.id.button_7:
            case R.id.button_8:
            case R.id.button_9:
            case R.id.point: {
                input += button.getText().toString();
                break;
            }
            case R.id.clear: {
                editText.setText("");
                first = 0.0;
                two = 0.0;
                lastOperation = "";
            }
            case R.id.sum: {
                two = first;
                first = Double.parseDouble(input);
                operation = 1;
                input = "";
                break;

            }
            case R.id.equality: {
                two = first;
                first = Double.parseDouble(input);
                result();
            }
        }
    }

    @SuppressLint("DefaultLocale")
    void result() {
        switch (operation) {
            case 1: {
                result.setText(String.format("%.2f", two + first));
                break;
            }

        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("OPERATION", lastOperation);
        if (operand != null)
            outState.putDouble("OPERAND", operand);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastOperation = savedInstanceState.getString("OPERATION");
        operand = savedInstanceState.getDouble("OPERAND");
        result.setText(lastOperation);

    }

}