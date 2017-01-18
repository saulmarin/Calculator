package com.marin.saul.calculator.model;

import static com.marin.saul.calculator.model.CalculatorOperation.NONE;

/**
 * Created by usuario on 18/01/2017.
 */

public class Calculator {

    public float num1;
    public float num2;
    public CalculatorOperation operation;

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public CalculatorOperation getOperation() {
        return operation;
    }

    public void setOperation(CalculatorOperation operation) {
        this.operation = operation;
    }

    public void calculate(int num1, int num2, CalculatorOperation operation){
        float result;
        switch(operation){
            case NONE:
                break;
            case ADD:
                result = add(num1,num2);
                break;
            case SUBSTRAC:
                result = substrac(num1,num2);
                break;
            case MULTIPLY:
                result = multiply(num1,num2);
                break;
            case DIVIDE:
                result = divide(num1,num2);
                break;
        }
    }

    private float divide(float num1, float num2) {
        if (num2 == 0){
            return -1;
        }
        return num1/num2;
    }

    private float multiply(float num1, float num2) {
        return num1 * num2;
    }

    private float substrac(float num1, float num2) {
        return num1 - num2;
    }

    private float add(float num1, float num2) {
        return num1 + num2;
    }

    public void clear(){
        this.num1 = 0.0f;
        this.num2 = 0.0f;
        this.operation = NONE;
    }
}
