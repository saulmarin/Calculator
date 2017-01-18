package com.marin.saul.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.marin.saul.calculator.model.Calculator;
import com.marin.saul.calculator.model.CalculatorOperation;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_result)TextView resultText;

    @BindView(R.id.activity_main_number0)Button number0;
    @BindView(R.id.activity_main_number1)Button number1;
    @BindView(R.id.activity_main_number2)Button number2;
    @BindView(R.id.activity_main_number3)Button number3;
    @BindView(R.id.activity_main_number4)Button number4;
    @BindView(R.id.activity_main_number5)Button number5;
    @BindView(R.id.activity_main_number6)Button number6;
    @BindView(R.id.activity_main_number7)Button number7;
    @BindView(R.id.activity_main_number8)Button number8;
    @BindView(R.id.activity_main_number9)Button number9;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final Calculator calculator = new Calculator();
        calculator.clear();
        resultText.setText("0");

        number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printNumber("0");
            }
        });

        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printNumber("1");
            }
        });

        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printNumber("2");
            }
        });

        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printNumber("3");
            }
        });

        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printNumber("4");
            }
        });

        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printNumber("5");
            }
        });

        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printNumber("6");
            }
        });

        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printNumber("7");
            }
        });

        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printNumber("8");
            }
        });
        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printNumber("9");
            }
        });

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
                resultText.setText("");
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
        resultText.setText(resultText.getText() + i);
    }
}
