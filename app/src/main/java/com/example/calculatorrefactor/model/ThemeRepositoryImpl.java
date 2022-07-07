package com.example.calculatorrefactor.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.calculatorrefactor.R;

public class ThemeRepositoryImpl implements ThemeRepository{
    private SharedPreferences preferences;
    private static ThemeRepository INSTANCE;
    private static final String KEY_THEME = "KEY_THEME";

    public ThemeRepositoryImpl(Context context) {
        preferences = context.getSharedPreferences("themes.xml", Context.MODE_PRIVATE);
    }

    public static ThemeRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new ThemeRepositoryImpl(context);
        }
        return INSTANCE;
    }

    @Override
    public Theme getSavedTheme() {
        String savedKey = preferences.getString(KEY_THEME, Theme.LIGHT.getKey());

        for (Theme them : Theme.values()) {
            if (them.getKey().equals(savedKey)) {
                return them;
            }
        }

        return Theme.LIGHT;
    }

    @Override
    public void saveTheme(Theme theme) {
        preferences.edit().putString(KEY_THEME,theme.getKey())
                .apply();
    }
}
