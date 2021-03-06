package com.marin.saul.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.marin.saul.calculator.model.Calculator;
import com.marin.saul.calculator.model.CalculatorOperation;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.activity_main_result)TextView resultText;

    @BindView(R.id.activity_main_add)Button buttonAdd;
    @BindView(R.id.activity_main_substrac)Button buttonSubstrac;
    @BindView(R.id.activity_main_multiply)Button buttonMultiply;
    @BindView(R.id.activity_main_divide)Button buttonDivide;
    @BindView(R.id.activity_main_equal)Button buttonEqual;
    @BindView(R.id.activity_main_ce)Button buttonCe;
    @BindView(R.id.activity_main_m_in)Button buttonMin;
    @BindView(R.id.activity_main_m_out)Button buttonMout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        NumericPadFragment numericPadFragment = (NumericPadFragment) getSupportFragmentManager().findFragmentById(R.id.numeric_pad_fragment);
        numericPadFragment.setOnDigitPressedListener(new NumericPadFragment.DigitPressed() {
            @Override
            public void onDigitPressed(String digit) {
                printNumber(digit);
            }
        });

        final Calculator calculator = new Calculator();
        calculator.clear();
        resultText.setText("0");

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // take actual text and save it to num1
                float floatResult = Float.parseFloat(resultText.getText().toString());
                calculator.setNum1(floatResult);
                // set operation to ADD
                calculator.setOperation(CalculatorOperation.ADD);
                // clear screen
                resultText.setText("0");
            }
        });

        buttonSubstrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // take actual text and save it to num1
                float floatResult = Float.parseFloat(resultText.getText().toString());
                calculator.setNum1(floatResult);
                // set operation to ADD
                calculator.setOperation(CalculatorOperation.SUBSTRAC);
                // clear screen
                resultText.setText("0");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // take actual text and save it to num1
                float floatResult = Float.parseFloat(resultText.getText().toString());
                calculator.setNum1(floatResult);
                // set operation to ADD
                calculator.setOperation(CalculatorOperation.MULTIPLY);
                // clear screen
                resultText.setText("0");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // take actual text and save it to num1
                float floatResult = Float.parseFloat(resultText.getText().toString());
                calculator.setNum1(floatResult);
                // set operation to ADD
                calculator.setOperation(CalculatorOperation.DIVIDE);
                // clear screen
                resultText.setText("0");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // take actual text and save it to num2
                float floatResult = Float.parseFloat(resultText.getText().toString());
                calculator.setNum2(floatResult);

                //  Execute operation
                float finalResult;
                finalResult = calculator.calculate(calculator.getNum1(), calculator.getNum2(), calculator.getOperation());

                // show result
                resultText.setText("" + finalResult);
            }
        });

        buttonCe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // clears calculator
                calculator.clear();
                resultText.setText("0");
            }
        });

        buttonMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float floatResult = Float.parseFloat(resultText.getText().toString());
                calculator.setMem1(floatResult);
            }
        });

        buttonMout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.setNum1(calculator.getMem1());
                resultText.setText("" + calculator.getNum1());
            }
        });
    }

    private void printNumber(String i) {
        if (resultText.getText().equals("0")){
            resultText.setText("");
        }
        if( i.equals(".")) {
            String actualText = resultText.getText().toString();
            if (actualText.indexOf(".") < 0) {
                resultText.setText(resultText.getText().toString() + ".");
            }
        }else {
            resultText.setText(resultText.getText() + i);
        }
    }
}
