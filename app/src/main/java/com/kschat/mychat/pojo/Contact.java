package com.kschat.mychat.pojo;

import android.graphics.Bitmap;

/**
 * Created by DOLPHIN on 25-Nov-17.
 */

public class Contact {
    private String name;
    private Bitmap bitmap;

    public Contact() {
    }

    public Contact(String name, Bitmap bitmap) {
        this.name = name;
        this.bitmap = bitmap;
    }

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
