package br.com.daniellopes.darkmode.util;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

public class PreferenceManager {
    private Context context;
    private SharedPreferences preferences;

    public PreferenceManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE);
    }

    public void setDarkMode(boolean enable) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("darkMode", enable);
        editor.apply();
    }

    public boolean getDarkMode() {
        return preferences.getBoolean("darkMode", false);
    }

}
