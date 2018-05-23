package com.blackspider.archcomponentdemo;
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

import android.app.Application;

import com.blackspider.archcomponentdemo.di.AppComponent;
import com.blackspider.archcomponentdemo.di.AppModule;
import com.blackspider.archcomponentdemo.di.DaggerAppComponent;


public class AppController extends Application {
    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
