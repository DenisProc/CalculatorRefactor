package com.example.calculatorrefactor.model;

public class CalculatorImplement implements Calculator{
    @Override
    public double calculate(double arg1, double arg2, Operator operator) {
        switch (operator) {
            case PLUS:
                return arg1 + arg2;
            case MINUS:
                return arg1- arg2;
            case MULTIPLY:
                return arg1 * arg2;
            case DIVIDE:
                return arg1 / arg2;
            case RESULT:
                return arg1;
            case POLARITY:
                if (arg1<0){
                    return arg1 *= -1;
                }else {
                    return arg1= arg1 - arg1 - arg1;
                }
        }
        return 0.0;
    }
}
