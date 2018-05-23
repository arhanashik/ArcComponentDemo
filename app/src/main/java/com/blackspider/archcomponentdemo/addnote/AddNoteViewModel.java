package com.blackspider.archcomponentdemo.addnote;
/*
 *  ****************************************************************************
 *  * Created by : Md. Hasnain on 5/23/2018 at 2:08 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Md. Hasnain on 5/23/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.blackspider.archcomponentdemo.database.NoteDatabase;
import com.blackspider.archcomponentdemo.database.NoteModel;

public class AddNoteViewModel extends AndroidViewModel {
    private NoteDatabase noteDatabase;

    public AddNoteViewModel(@NonNull Application application) {
        super(application);

        noteDatabase = NoteDatabase.getInstance(application);
    }

    public void addNote(final NoteModel noteModel){
        new AddNoteAsync(noteDatabase).execute(noteModel);
    }

    private class AddNoteAsync extends AsyncTask<NoteModel, Void, Void> {
        private NoteDatabase noteDatabase;

        public AddNoteAsync(NoteDatabase noteDatabase) {
            this.noteDatabase = noteDatabase;
        }

        @Override
        protected Void doInBackground(NoteModel... noteModels) {
            noteDatabase.noteModelDao().save(noteModels[0]);
            return null;
        }
    }
}
