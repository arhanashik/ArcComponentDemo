package com.blackspider.archcomponentdemo.database;
/*
 *  ****************************************************************************
 *  * Created by : Md. Hasnain on 5/23/2018 at 12:09 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Md. Hasnain on 5/23/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = NoteModel.class, version = 1)
public abstract class NoteDatabase extends RoomDatabase{
    public static NoteDatabase database;

    public static NoteDatabase getInstance(Context context) {
        if(database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class,
                    "note_db")
                    .build();
        }

        return database;
    }

    public static void destroyInstance(){
        database = null;
    }

    public abstract NoteModelDao noteModelDao();

}
