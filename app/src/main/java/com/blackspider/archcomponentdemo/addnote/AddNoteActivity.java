package com.blackspider.archcomponentdemo.addnote;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blackspider.archcomponentdemo.R;
import com.blackspider.archcomponentdemo.database.NoteModel;

public class AddNoteActivity extends AppCompatActivity {
    private EditText etTitle;
    private EditText etDescription;
    private Button btnAdd;

    private AddNoteViewModel addNoteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etTitle = findViewById(R.id.et_title);
        etDescription = findViewById(R.id.et_description);
        btnAdd = findViewById(R.id.btn_add_note);

        addNoteViewModel = ViewModelProviders.of(this).get(AddNoteViewModel.class);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etTitle.getText() == null || etDescription.getText() == null){
                    Toast.makeText(AddNoteActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }
                else {
                    String title = etTitle.getText().toString();
                    String description = etDescription.getText().toString();

                    addNoteViewModel.addNote(new NoteModel(title, description));

                    finish();
                }
            }
        });
    }

}
