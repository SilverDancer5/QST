package com.example.asus.classdemo03;

public class User {
    private String name;
    private int img;
    private String age;

    public User(String name, int img, String age) {
        this.name = name;
        this.img = img;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
