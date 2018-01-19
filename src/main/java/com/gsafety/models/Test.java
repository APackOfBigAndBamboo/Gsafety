package com.gsafety.models;

public class Test {
    private int id;
    private byte[] img;


    public Test(int id, byte[] img) {

        this.id = id;
        this.img = img;
    }

    public Test() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
