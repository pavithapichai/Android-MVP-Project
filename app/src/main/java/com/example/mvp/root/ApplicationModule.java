package com.example.mvp.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final MVPApp application;

    public ApplicationModule(MVPApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideContext(){
        return application;
    }
}
