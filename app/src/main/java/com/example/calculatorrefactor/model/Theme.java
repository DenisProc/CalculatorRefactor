package com.example.calculatorrefactor.model;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.example.calculatorrefactor.R;

public enum Theme {
    DARK(R.style.Theme_CalculatorRefactorDark,R.string.key_darkTheme,"theme_1"),
    LIGHT(R.style.Theme_CalculatorRefactorLight,R.string.key_lightTheme,"theme_2");

    @StyleRes
    private final int themeRes;
    @StringRes
    private final int title;

    private final String key;

    Theme(int themeRes, int title, String key) {
        this.themeRes = themeRes;
        this.title = title;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public int getTitle() {
        return title;
    }

    public int getThemeRes() {
        return themeRes;
    }
}
