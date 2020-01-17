package com.example.qst_test_2;

public class Image {
    int[] images;
    int position;

    public Image(int[] images, int position) {
        this.images = images;
        this.position = position;
    }

    public int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
