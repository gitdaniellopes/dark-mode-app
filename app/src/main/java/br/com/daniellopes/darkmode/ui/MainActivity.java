package br.com.daniellopes.darkmode.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.daniellopes.darkmode.R;
import br.com.daniellopes.darkmode.adapter.NoteAdapter;
import br.com.daniellopes.darkmode.model.Note;
import br.com.daniellopes.darkmode.util.VerifyTheme;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VerifyTheme.themeVerify(this);

        bind();
        List<Note> notesCreated = createdNotes();
        NoteAdapter adapter = new NoteAdapter(notesCreated, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    private List<Note> createdNotes() {
        List<Note> notes = new ArrayList<>();
        for (int i = 0; i <= 12; i++) {
            notes.add(new Note("Learn", "Learn Kotlin and Java and Android Studio - Dark Mode"));
        }
        return notes;
    }

    private void bind() {
        recyclerView = findViewById(R.id.recycle_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.theme) {
            Intent intent = new Intent(this, ThemeActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}