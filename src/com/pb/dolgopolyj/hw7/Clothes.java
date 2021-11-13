package com.pb.dolgopolyj.hw7;

public abstract class Clothes
{
    private Size clothingSize;
    private float price;
    private String color;

    public void setClothingSize(Size clothingSize) {
        this.clothingSize = clothingSize;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Size getClothingSize() {
        return clothingSize;
    }

    public float getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}
