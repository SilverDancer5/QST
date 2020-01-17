package com.example.areyouhungry.takeoutPage;

public class Bill {
    private int ID;
    private int userID;
    private int shopID;
    private int foodNumber1;
    private int foodNumber2;
    private int foodNumber3;
    private int foodNumber4;
    private int foodNumber5;

    public Bill(int ID, int userID, int shopID, int foodNumber1, int foodNumber2, int foodNumber3, int foodNumber4, int foodNumber5) {
        this.ID = ID;
        this.userID = userID;
        this.shopID = shopID;
        this.foodNumber1 = foodNumber1;
        this.foodNumber2 = foodNumber2;
        this.foodNumber3 = foodNumber3;
        this.foodNumber4 = foodNumber4;
        this.foodNumber5 = foodNumber5;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public int getFoodNumber1() {
        return foodNumber1;
    }

    public void setFoodNumber1(int foodNumber1) {
        this.foodNumber1 = foodNumber1;
    }

    public int getFoodNumber2() {
        return foodNumber2;
    }

    public void setFoodNumber2(int foodNumber2) {
        this.foodNumber2 = foodNumber2;
    }

    public int getFoodNumber3() {
        return foodNumber3;
    }

    public void setFoodNumber3(int foodNumber3) {
        this.foodNumber3 = foodNumber3;
    }

    public int getFoodNumber4() {
        return foodNumber4;
    }

    public void setFoodNumber4(int foodNumber4) {
        this.foodNumber4 = foodNumber4;
    }

    public int getFoodNumber5() {
        return foodNumber5;
    }

    public void setFoodNumber5(int foodNumber5) {
        this.foodNumber5 = foodNumber5;
    }
}
