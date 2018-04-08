package com.chrisrisner.fragmentsample;

public class ListModel {

    private int imageId;
    private String text="";
    private int money;

    public ListModel(int imageId, String text, int money) {
        this.imageId = imageId;
        this.text = text;
        this.money = money;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


}
