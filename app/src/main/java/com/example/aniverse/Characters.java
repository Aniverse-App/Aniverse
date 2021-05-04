package com.example.aniverse;

public class Characters {

    private String characterName;
    private String anime;
    private int characterIcon;

    public Characters(String name, String animeName, int imageId) {
        characterName = name;
        anime = animeName;
        characterIcon = imageId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getAnime() {
        return anime;
    }

    public int getCharacterIcon() {
        return characterIcon;
    }
}


