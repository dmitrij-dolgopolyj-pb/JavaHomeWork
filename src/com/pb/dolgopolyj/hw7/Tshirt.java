package com.pb.dolgopolyj.hw7;

/**
* Это класс-наследник (футболка) класса Clothes, он реализует интерфейсы ManClothes и WomenClothes
 */
public class Tshirt extends Clothes implements ManClothes, WomenClothes
{
    //Добавим переменную, отвечающую за название футболки
    private String tshirtName;

    //Cоздаем конструктор
    public Tshirt(String tshirtName, Size clothingSize, float price, String color)
    {
        this.tshirtName = tshirtName;
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
}
