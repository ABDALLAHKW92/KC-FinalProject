package com.example.mystory;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

public class Story implements Serializable {

    private String storyName;
    private int storyLength;
    private String storyCategory;
    private String storyBackground;
private String storyTeller;
private String storyLink;
private int storyTellerIMG;




    public Story(String storyName, int storyLength, String storyCategory, String storyBackground, String storyTeller, String storyLink, int storyTellerIMG) {
        this.storyName = storyName;
        this.storyLength = storyLength;
        this.storyCategory = storyCategory;
        this.storyBackground = storyBackground;
        this.storyTeller = storyTeller;
        this.storyLink = storyLink;
        this.storyTellerIMG = storyTellerIMG;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public int getStoryLength() {
        return storyLength;
    }

    public void setStoryLength(int storyLength) {
        this.storyLength = storyLength;
    }

    public String getStoryCategory() {
        return storyCategory;
    }

    public void setStoryCategory(String storyCategory) {
        this.storyCategory = storyCategory;
    }

    public String getStoryBackground() {
        return storyBackground;
    }

    public void setStoryBackground(String storyBackground) {
        this.storyBackground = storyBackground;
    }

    public String getStoryTeller() {
        return storyTeller;
    }

    public void setStoryTeller(String storyTeller) {
        this.storyTeller = storyTeller;
    }

    public String getStoryLink() {
        return storyLink;
    }

    public void setStoryLink(String storyLink) {
        this.storyLink = storyLink;
    }

    public int getStoryTellerIMG() {
        return storyTellerIMG;
    }

    public void setStoryTellerIMG(int storyTellerIMG) {
        this.storyTellerIMG = storyTellerIMG;
    }
}

