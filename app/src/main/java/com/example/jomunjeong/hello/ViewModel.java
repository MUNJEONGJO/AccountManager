package com.example.jomunjeong.hello;

import android.graphics.Bitmap;

/**
 * Created by jomunjeong on 2015. 11. 15..
 */
public class ViewModel {

    String title = null;
    Bitmap bm = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getBm() {
        return bm;
    }

    public void setBm(Bitmap bm) {
        this.bm = bm;
    }
}
