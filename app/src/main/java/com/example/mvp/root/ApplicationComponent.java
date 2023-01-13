package com.example.mvp.root;

import android.app.Application;

import com.example.mvp.LoginActivity;
import com.example.mvp.LoginModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

@Singleton
@Component (modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

        void inject(LoginActivity target);

    }

