package com.blackspider.archcomponentdemo.di;
/*
 *  ****************************************************************************
 *  * Created by : Md. Hasnain on 5/23/2018 at 4:20 PM.
 *  * Email : ashik.pstu.cse@gmail.com
 *  *
 *  * Last edited by : Md. Hasnain on 5/23/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

import com.blackspider.archcomponentdemo.AppController;
import com.blackspider.archcomponentdemo.notelist.NoteActivity;
import com.blackspider.archcomponentdemo.notelist.NotesViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(AppController appController);

    void inject(NotesViewModel notesViewModel);
}
