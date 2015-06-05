package com.strsong.calculator;

import java.text.DecimalFormat;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

    private TextView Display;
    private Boolean inputNumber = false;
    private Calculator Calculator;
    private  String DIGITS = "0123456789.";

    DecimalFormat df = new DecimalFormat("@###########");
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calculator = new Calculator();
        Display = (TextView) findViewById(R.id.textView1);

        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.buttonAdd).setOnClickListener(this);
        findViewById(R.id.buttonSubtract).setOnClickListener(this);
        findViewById(R.id.buttonMultiply).setOnClickListener(this);
        findViewById(R.id.buttonDivide).setOnClickListener(this);
        findViewById(R.id.buttonSign).setOnClickListener(this);
        findViewById(R.id.buttonDecimalPoint).setOnClickListener(this);
        findViewById(R.id.buttonEquals).setOnClickListener(this);
        findViewById(R.id.buttonClear).setOnClickListener(this);
        findViewById(R.id.buttonSquareRoot).setOnClickListener(this);
        findViewById(R.id.buttonSine).setOnClickListener(this);
        findViewById(R.id.buttonCosine).setOnClickListener(this);
        findViewById(R.id.buttonTangent).setOnClickListener(this);
        findViewById(R.id.buttonLog).setOnClickListener(this);
        findViewById(R.id.buttonE).setOnClickListener(this);
        findViewById(R.id.buttonPi).setOnClickListener(this);
        findViewById(R.id.buttonFactorial).setOnClickListener(this);
        findViewById(R.id.buttonExponential).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String buttonPressed = ((Button) v).getText().toString();

        if (DIGITS.contains(buttonPressed)) {

            if (inputNumber) {

                if (buttonPressed.equals(".") && Display.getText().toString().contains(".")) {
                } else {
                    Display.append(buttonPressed);
                }

            } else {

                if (buttonPressed.equals(".")) {
                    Display.setText(0 + buttonPressed);
                } else {
                    Display.setText(buttonPressed);
                }

                inputNumber = true;
            }

        } else {

            if (inputNumber) {

                Calculator.setNumber(Double.parseDouble(Display.getText().toString()));
                inputNumber = false;
            }

            Calculator.doTheMath1(buttonPressed);
            Display.setText(df.format(Calculator.getResult()));

        }

    }

}

