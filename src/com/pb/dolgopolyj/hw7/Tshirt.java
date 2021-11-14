package com.pb.dolgopolyj.hw7;

/**
* Это класс-наследник (футболка) класса Clothes, он реализует интерфейсы ManClothes и WomenClothes
 */
public class Tshirt extends Clothes implements ManClothes, WomenClothes
{
    //Добавим переменную, отвечающую за название футболки
    private String tshirtName;
    //Добавим переменную, отвечающую за тип футболки, если она мужская
    private boolean tshirtForMan;
    //Cоздаем конструктор
    public Tshirt(String tshirtName, Size clothingSize, float price, String color, boolean tshirtForMan)
    {
        this.tshirtName = tshirtName;
        this.tshirtForMan=tshirtForMan;
        this.setClothingSize(clothingSize);
        this.setPrice(price);
        this.setColor(color);
    }

    @Override
    public void dressMan() {
        System.out.println("Футболка мужская "+this.tshirtName+", размер "+this.getClothingSize()+", цвет -"+this.getColor()
        +", цена:"+this.getPrice());
    }

    @Override
    public void dressWomen() {
        System.out.println("Футболка женская "+this.tshirtName+", размер "+this.getClothingSize()+", цвет -"+this.getColor()
                +", цена:"+this.getPrice());
    }

    public String getTshirtName() {
        return tshirtName;
    }

    public boolean isTshirtForMan() {
        return tshirtForMan;
    }
}
