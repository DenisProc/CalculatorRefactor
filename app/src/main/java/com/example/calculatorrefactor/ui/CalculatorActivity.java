package com.example.calculatorrefactor.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.calculatorrefactor.R;
import com.example.calculatorrefactor.model.CalculatorImplement;
import com.example.calculatorrefactor.model.Operator;

import java.util.HashMap;
import java.util.Map;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {
    private TextView resultTxt;
    private CalculatorPresenter calculatorPresenter;

    Operator operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        resultTxt = findViewById(R.id.showResultTxt);
        calculatorPresenter = new CalculatorPresenter(this, new CalculatorImplement());

        Map<Integer, Integer> args = new HashMap<>();
        args.put(R.id.key_0, 0);
        args.put(R.id.key_1, 1);
        args.put(R.id.key_2, 2);
        args.put(R.id.key_3, 3);
        args.put(R.id.key_4, 4);
        args.put(R.id.key_5, 5);
        args.put(R.id.key_6, 6);
        args.put(R.id.key_7, 7);
        args.put(R.id.key_8, 8);
        args.put(R.id.key_9, 9);

        View.OnClickListener argsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.argsPress(args.get(view.getId()));
            }
        };
        findViewById(R.id.key_0).setOnClickListener(argsClickListener);
        findViewById(R.id.key_1).setOnClickListener(argsClickListener);
        findViewById(R.id.key_2).setOnClickListener(argsClickListener);
        findViewById(R.id.key_3).setOnClickListener(argsClickListener);
        findViewById(R.id.key_4).setOnClickListener(argsClickListener);
        findViewById(R.id.key_5).setOnClickListener(argsClickListener);
        findViewById(R.id.key_6).setOnClickListener(argsClickListener);
        findViewById(R.id.key_7).setOnClickListener(argsClickListener);
        findViewById(R.id.key_8).setOnClickListener(argsClickListener);
        findViewById(R.id.key_9).setOnClickListener(argsClickListener);

        Map<Integer, Operator> operations = new HashMap<>();
        operations.put(R.id.key_plus, Operator.PLUS);
        operations.put(R.id.key_minus, Operator.MINUS);
        operations.put(R.id.key_multiply, Operator.MULTIPLY);
        operations.put(R.id.key_divide, Operator.DIVIDE);
        operations.put(R.id.key_result, Operator.RESULT);
        operations.put(R.id.key_polarity, Operator.POLARITY);


        View.OnClickListener operationsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.operationsPress(operations.get(view.getId()));
            }
        };
        findViewById(R.id.key_plus).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_minus).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_multiply).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_divide).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_result).setOnClickListener(operationsClickListener);
        findViewById(R.id.key_polarity).setOnClickListener(operationsClickListener);

        findViewById(R.id.key_polarity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.polarityPass();
            }
        });
        findViewById(R.id.key_сlean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorPresenter.cleanPass();
            }
        });
    }


    @Override
    public void showResult(String result) {
        resultTxt.setText(result);
    }
}