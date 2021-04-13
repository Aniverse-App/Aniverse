package com.example.aniverse.login;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Discussion")
public class Post extends ParseObject {
    public static final String KEY_POST="Post";
    public static final String KEY_IMAGE ="Image";
    public static final String KEY_USER ="User";
    public static final String KEY_CREATED_KEY = "createdAt";

    public String getPost() {
        return getString(KEY_POST);
    }
    public void setPost(String post) {
        put(KEY_POST, post);

    }
    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user){
        put(KEY_USER, user);
    }

}
