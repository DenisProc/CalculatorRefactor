package com.example.calculatorrefactor.model;

public interface ThemeRepository {
    Theme getSavedTheme();

    void saveTheme(Theme theme);
}
