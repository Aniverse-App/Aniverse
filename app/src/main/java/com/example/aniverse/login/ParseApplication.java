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
                .applicationId("WAZNM4I2IDbtueImWsnFTjkAa1VjHggf4tnYGDXF")
                .clientKey("JBZvgAk2IVrDcc0fBDNnL7znRwIT2bViWcZhSPt7")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
