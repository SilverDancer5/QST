package com.example.qst_test_4;

import java.io.Serializable;

public class Person implements Serializable {
    private int ID;
    private String name;
    private String sex;

    public Person(int ID, String name, String sex) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
    }

    public Person() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
