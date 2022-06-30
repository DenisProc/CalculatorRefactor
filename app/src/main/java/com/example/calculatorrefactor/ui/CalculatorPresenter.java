package com.example.calculatorrefactor.ui;

import com.example.calculatorrefactor.model.Calculator;

import com.example.calculatorrefactor.model.Operator;

import java.text.DecimalFormat;

public class CalculatorPresenter {
    private final CalculatorView view;
    private final Calculator calculator;
    private Operator selectedOperator;
    private double arg1;
    private Double arg2;
    private boolean dot = false;
    private int dotArg1 = 10;
    private int dotArg2 = 10;

    DecimalFormat formater = new DecimalFormat("#.#########");

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void argsPress(double number) {
        if (arg2 == null) {
            if (!dot) {
                arg1 = arg1 * 10 + number;
                format(arg1);
            } else {
                arg1 = arg1 + number / dotArg1;
                dotArg1 = dotArg1 * 10;
                format(arg1);
            }
            dotArg2 = 10;
        } else {
            if (!dot) {
                arg2 = arg2 * 10 + number;
                format(arg2);
            } else {
                arg2 = arg2 + number / dotArg2;
                dotArg2 = dotArg2 * 10;
                format(arg2);
            }
            dotArg1 = 10;
        }
    }

    public void operationsPress(Operator operator) {
        dot = false;
        dotArg1 = 10;
        dotArg2 = 10;
        if (selectedOperator != null) {
            arg1 = calculator.calculate(arg1, arg2, selectedOperator);
            format(arg1);
        }
        arg2 = 0.0;
        selectedOperator = operator;
    }

    public void polarityPass() {
        if (arg1 < 0) {
            arg1 = arg1 * -1;
        } else {
            arg1 = arg1 * -1;
        }
        format(arg1);
    }

    public void cleanPass() {
        arg1 = 0.0;
        arg2 = 0.0;
        dot = false;
        dotArg1 = 10;
        dotArg2 = 10;
        format(arg1);
    }

    public boolean dotPass() {
        return dot = true;
    }

    public void radicalPass() {
        arg1 = Math.sqrt(arg1);
        format(arg1);
    }


    private void format(double value) {

        view.showResult(formater.format(value));
    }
}
