package com.example.zhaogaofei.linearlayoutadapter;


public class TestTwoModel {
    private int type;
    private String imageUrl;
    private String text;

    public TestTwoModel(int type, String imageUrl, String text) {
        this.type = type;
        this.imageUrl = imageUrl;
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
