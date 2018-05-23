package com.blackspider.archcomponentdemo.database;
/*
 *  ****************************************************************************
 *  * Created by : Md. Hasnain on 5/23/2018 at 12:05 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Md. Hasnain on 5/23/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface NoteModelDao {

    @Query("SELECT * FROM NoteModel")
    LiveData<List<NoteModel>> loadNotes();

    @Query("SELECT * FROM NoteModel WHERE id = :id")
    NoteModel getNote(int id);

    @Insert(onConflict = REPLACE)
    long save(NoteModel noteModel);

    @Delete
    void delete(NoteModel noteModel);
}
