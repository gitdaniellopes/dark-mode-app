package br.com.daniellopes.darkmode.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import br.com.daniellopes.darkmode.R;
import br.com.daniellopes.darkmode.util.PreferenceManager;
import br.com.daniellopes.darkmode.util.VerifyTheme;

public class ThemeActivity extends AppCompatActivity {

    private CardView cardView;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        preferenceManager = new PreferenceManager(this);
        VerifyTheme.themeVerify(this);
        bind();
        onClickCard();
    }

    private void onClickCard() {
        cardView.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ThemeActivity.this);
            builder.setTitle(R.string.dark_mode)
                    .setMessage(R.string.dark_message)
                    .setPositiveButton(R.string.yes, (dialogInterface, i) -> {
                        if (preferenceManager.getDarkMode()) {
                            darkMode(false);
                        } else {
                            darkMode(true);
                        }
                    }).setNegativeButton(R.string.No, null)
                    .create().show();
        });
    }

    private void bind() {
        cardView = findViewById(R.id.cardView);
    }

    private void darkMode(boolean b) {
        preferenceManager.setDarkMode(b);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }, 1000);
    }
}