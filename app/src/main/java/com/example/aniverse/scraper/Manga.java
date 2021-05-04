package com.example.aniverse.scraper;

import com.example.aniverse.BaseObject;

public class Manga extends BaseObject {

    public Manga(int id, String title) {
        super(id, title);
        this.setType(2);
    }

}
