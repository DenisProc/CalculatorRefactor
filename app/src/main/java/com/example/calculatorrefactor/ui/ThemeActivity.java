package com.example.calculatorrefactor.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.calculatorrefactor.R;
import com.example.calculatorrefactor.model.Theme;
import com.example.calculatorrefactor.model.ThemeRepository;
import com.example.calculatorrefactor.model.ThemeRepositoryImpl;
import com.google.android.material.button.MaterialButton;

public class ThemeActivity extends AppCompatActivity {
    public static final String EXTRA_THEME = "EXTRA_THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);

        ThemeRepository repository = ThemeRepositoryImpl.getInstance(this);

        findViewById(R.id.dark_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repository.saveTheme(Theme.DARK);
                Intent data = new Intent();
                data.putExtra(EXTRA_THEME, repository.getSavedTheme());

                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });

        findViewById(R.id.light_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repository.saveTheme(Theme.LIGHT);
                Intent data = new Intent();
                data.putExtra(EXTRA_THEME, repository.getSavedTheme());

                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}