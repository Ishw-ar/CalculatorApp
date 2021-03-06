package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    boolean isNewOp=true;
    String op="+";
    String oldNumber="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.etText);
    }

    public void numberEvent(View view) {
        if(isNewOp)
            editText.setText("");
        isNewOp=false;
        String number = editText.getText().toString();
        switch (view.getId()){
            case R.id.btnOne:
            number +="1";
            break;
            case R.id.btnTwo:
                number +="2";
                break;
            case R.id.btnThree:
                number +="3";
                break;
            case R.id.btnFour:
                number +="4";
                break;
            case R.id.btnFive:
                number +="5";
                break;
            case R.id.btnSix:
                number +="6";
                break;
            case R.id.btnSeven:
                number +="7";
                break;
            case R.id.btnEight:
                number +="8";
                break;
            case R.id.btnNine:
                number +="9";
                break;
            case R.id.btnZero:
                number +="0";
                break;
            case R.id.btnDot:
                number +=".";
                break;
            case R.id.btnplusminus:
                number +="-"+number;
                break;

        }
        editText.setText(number);

    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = editText.getText().toString();
        switch (view.getId()){
            case R.id.btnDivision:op="/";break;
            case R.id.btnMultiplication:op="*";break;
            case R.id.btnPlus:op="+";break;
            case R.id.btnMinus:op="-";break;

        }

    }

    public void equalEvent(View view) {
        String newNumber =editText.getText().toString();
        double result =0.0;
        switch (op){
            case "-":
            result =Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);
            break;
            case "*":
                result =Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);
                break;
            case "+":
                result =Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);
                break;
            case "/":
                result =Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                break;
        }
        editText.setText(result+"");
    }

    public void acEvent(View view) {
        editText.setText("0");
        isNewOp=true;
    }

    public void percentEvent(View view) {
        double no=Double.parseDouble(editText.getText().toString())/100;
        editText.setText(no+"");
        isNewOp=true;
    }

    public void deleteEvent(View view) {
        editText.setText("");
        isNewOp=true;
    }
}