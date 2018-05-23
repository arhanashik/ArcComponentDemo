package com.blackspider.archcomponentdemo.di;
/*
 *  ****************************************************************************
 *  * Created by : Md. Hasnain on 5/23/2018 at 4:05 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Md. Hasnain on 5/23/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import android.content.Context;

import com.blackspider.archcomponentdemo.AppController;
import com.blackspider.archcomponentdemo.database.NoteDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final AppController appController;

    public AppModule(AppController appController){
        this.appController = appController;
    }

    @Provides
    @Singleton
    Context provideAppContext(){
        return appController;
    }

    @Provides
    @Singleton
    NoteDatabase provideNoteDatabase(Context application){
        return NoteDatabase.getInstance(application);
    }
}
