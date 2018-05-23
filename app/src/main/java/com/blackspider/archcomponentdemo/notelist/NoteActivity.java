package com.blackspider.archcomponentdemo.notelist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.blackspider.archcomponentdemo.R;
import com.blackspider.archcomponentdemo.addnote.AddNoteActivity;
import com.blackspider.archcomponentdemo.database.NoteModel;

import java.util.ArrayList;
import java.util.List;

public class NoteActivity extends AppCompatActivity implements NoteAdapter.OnNoteClickListener{
    private NotesViewModel notesViewModel;
    private RecyclerView rvNotes;
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoteActivity.this, AddNoteActivity.class));
            }
        });

        rvNotes = findViewById(R.id.rv_notes);
        noteAdapter = new NoteAdapter(new ArrayList<NoteModel>());
        noteAdapter.setListener(this);
        rvNotes.setLayoutManager(new LinearLayoutManager(this));
        rvNotes.setAdapter(noteAdapter);

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);
        notesViewModel.getNotes().observe(this, new Observer<List<NoteModel>>() {
            @Override
            public void onChanged(@Nullable List<NoteModel> noteModels) {
                noteAdapter.addNote(noteModels);
            }
        });
    }

    @Override
    public void onNoteClicked(final NoteModel noteModel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Delete")
                .setMessage(" will be deleted permanently")
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        notesViewModel.deleteNote(noteModel);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
