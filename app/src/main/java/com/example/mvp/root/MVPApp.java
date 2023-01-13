package com.example.mvp.root;

import android.app.Application;
import android.content.Context;


public class MVPApp extends Application {
    private ApplicationComponent applicationComponent;

    public void onCreate(){
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();


    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }


}
