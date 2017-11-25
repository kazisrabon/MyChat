package com.kschat.mychat.pojo;

import android.graphics.Bitmap;

/**
 * Created by DOLPHIN on 25-Nov-17.
 */

public class Chat {
    private String name, lastChatLine;
    private Bitmap bitmap;

    public Chat() {
    }

    public Chat(String name, String lastChatLine, Bitmap bitmap) {
        this.name = name;
        this.lastChatLine = lastChatLine;
        this.bitmap = bitmap;
    }

    public Chat(String name, String lastChatLine) {
        this.name = name;
        this.lastChatLine = lastChatLine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastChatLine() {
        return lastChatLine;
    }

    public void setLastChatLine(String lastChatLine) {
        this.lastChatLine = lastChatLine;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
