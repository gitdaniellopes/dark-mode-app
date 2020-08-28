package br.com.daniellopes.darkmode.util;

import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class VerifyTheme {
    public static void themeVerify(Context context) {
        PreferenceManager preferenceManager = new PreferenceManager(context);
        if (preferenceManager.getDarkMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
