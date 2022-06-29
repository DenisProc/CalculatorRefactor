package com.example.calculatorrefactor.ui;

import com.example.calculatorrefactor.model.Calculator;
import com.example.calculatorrefactor.model.CalculatorImplement;
import com.example.calculatorrefactor.model.Operator;

public class CalculatorPresenter {
    private final CalculatorView view;
    private final Calculator calculator;
    private Operator selectedOperator;
    private double arg1;
    private Double arg2;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void argsPress(int number) {
        if (arg2 == null) {
            arg1 = arg1 * 10 + number;
            view.showResult(String.valueOf(arg1));
        } else {
            arg2 = arg2 * 10 + number;
            view.showResult(String.valueOf(arg2));
        }
    }

    public void operationsPress(Operator operator) {

        if (selectedOperator != null) {
            arg1 = calculator.calculate(arg1, arg2, selectedOperator);
            view.showResult(String.valueOf(arg1));
        }
        arg2 = 0.0;
        selectedOperator = operator;
    }
}
