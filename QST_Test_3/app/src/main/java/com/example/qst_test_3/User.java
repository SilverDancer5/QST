package com.example.qst_test_3;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String age;
    private int img;


    public User(String name, String age, int img) {
        this.name = name;
        this.age = age;
        this.img = img;

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
