package com.aleman.model;

public class WordModel {

    private int length;
    private int count;

    public WordModel(int length, int count) {
        this.length = length;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

}
