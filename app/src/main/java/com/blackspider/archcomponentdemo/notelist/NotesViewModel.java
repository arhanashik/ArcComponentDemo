package com.blackspider.archcomponentdemo.notelist;
/*
 *  ****************************************************************************
 *  * Created by : Md. Hasnain on 5/23/2018 at 1:17 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Md. Hasnain on 5/23/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.blackspider.archcomponentdemo.AppController;
import com.blackspider.archcomponentdemo.database.NoteDatabase;
import com.blackspider.archcomponentdemo.database.NoteModel;

import java.util.List;

import javax.inject.Inject;

public class NotesViewModel extends AndroidViewModel {
    private final LiveData<List<NoteModel>> notes;
    @Inject NoteDatabase noteDatabase;

    public NotesViewModel(@NonNull Application application) {
        super(application);
        ((AppController) getApplication()).getAppComponent().inject(this);

        notes = noteDatabase.noteModelDao().loadNotes();
    }

    public LiveData<List<NoteModel>> getNotes(){
        return notes;
    }

    public void deleteNote(NoteModel noteModel){
        new DeleteNoteAsync(noteDatabase).execute(noteModel);
    }

    private class DeleteNoteAsync extends AsyncTask<NoteModel, Void, Void>{
        private NoteDatabase noteDatabase;

        public DeleteNoteAsync(NoteDatabase noteDatabase) {
            this.noteDatabase = noteDatabase;
        }

        @Override
        protected Void doInBackground(NoteModel... noteModels) {
            noteDatabase.noteModelDao().delete(noteModels[0]);
            return null;
        }
    }
}
