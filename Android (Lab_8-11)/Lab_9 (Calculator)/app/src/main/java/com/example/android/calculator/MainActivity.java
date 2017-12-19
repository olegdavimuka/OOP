package com.example.android.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String condition;
    double num1, num2;

    TextView tvCondition, tvResult;
    EditText et1, et2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.etNum1);
        et2 = (EditText) findViewById(R.id.etNum2);

        tvResult = (TextView) findViewById(R.id.tvResult);
        tvCondition = (TextView) findViewById(R.id.tvCondition);
    }


    public void onClick(View view) {
        double result;

        if (et1.getText().toString().equals("")) {
            num1 = 0;
        } else {
            num1 = Double.parseDouble(et1.getText().toString());
        }
        if (et2.getText().toString().equals("")) {
            num2 = 0;
        } else {
            num2 = Double.parseDouble(et2.getText().toString());
        }

        condition = tvCondition.getText().toString();

        switch (view.getId()) {
            case R.id.btnAdd:
                result = num1 + num2;
                tvResult.setText("" + result);
                et1.setText("" + result);
                et2.setText("");
                if (condition.equals("")) {
                    condition += num1 + " " + "+" + " " + num2;
                } else {
                    condition += " " + "+" + " " + num2;
                }
                tvCondition.setText(condition);
                break;
            case R.id.btnSub:
                result = num1 - num2;
                tvResult.setText("" + result);
                et1.setText("" + result);
                et2.setText("");
                if (condition.equals("")) {
                    condition += num1 + " " + "-" + " " + num2;
                } else {
                    condition += " " + "-" + " " + num2;
                }
                tvCondition.setText(condition);
                break;
            case R.id.btnMult:
                result = num1 * num2;
                tvResult.setText("" + result);
                et1.setText("" + result);
                et2.setText("");
                if (condition.equals("")) {
                    condition += num1 + " " + "*" + " " + num2;
                } else {
                    condition += " " + "*" + " " + num2;
                }
                tvCondition.setText(condition);
                break;
            case R.id.btnDiv:
                result = num1 / num2;
                tvResult.setText("" + result);
                et1.setText("" + result);
                et2.setText("");
                if (condition.equals("")) {
                    condition += num1 + " " + "/" + " " + num2;
                } else {
                    condition += " " + "/" + " " + num2;
                }
                tvCondition.setText(condition);
                break;
            case R.id.btnReset:
                num1 = 0;
                num2 = 0;
                tvResult.setText("");
                tvCondition.setText("");
                et1.setText("");
                et2.setText("");
                break;
        }
    }
}

