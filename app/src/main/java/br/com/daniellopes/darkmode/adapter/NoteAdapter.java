package br.com.daniellopes.darkmode.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.daniellopes.darkmode.R;
import br.com.daniellopes.darkmode.model.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> notes;
    private Context context;

    public NoteAdapter(List<Note> notes, Context context) {
        this.notes = notes;
        this.context = context;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCreated = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(viewCreated);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.bind(note);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView editTextTitle;
        private TextView editTextDescription;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            editTextTitle = itemView.findViewById(R.id.title_note);
            editTextDescription = itemView.findViewById(R.id.description_note);
        }

        public void bind(Note note) {
            editTextTitle.setText(note.getTitle());
            editTextDescription.setText(note.getDescription());
        }
    }
}
