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
            case CLEAN:
                return arg1 = 0.0;
        }
        return 0.0;
    }
}
