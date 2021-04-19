package com.example.aniverse.login;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;


public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("cxxu1riHNQElFEBet6wP4U6jR0ZFAqvDbIO72zrR")
                .clientKey("ejD9QijdsmLpmbrqqB7XBJ2PJSuMTee8lgdiqok8")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
