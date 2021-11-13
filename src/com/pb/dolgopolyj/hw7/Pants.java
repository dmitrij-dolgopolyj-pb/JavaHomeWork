package com.pb.dolgopolyj.hw7;

/**
 * Это класс-наследник (штаны) класса Clothes, он реализует интерфейсы ManClothes и WomenClothes
 */
public class Pants extends Clothes implements ManClothes, WomenClothes
{
    //Добавим переменную, отвечающую за название штанов
    private String pantsName;

    //Cоздаем конструктор
    public Pants(String pantsName, Size clothingSize, float price, String color)
    {
        this.pantsName = pantsName;
        this.setClothingSize(clothingSize);
        this.setPrice(price);
        this.setColor(color);
    }

    @Override
    public void dressMan() {
        System.out.println("Штаны мужские "+this.pantsName+", размер "+this.getClothingSize()+", цвет -"+this.getColor()
                +", цена:"+this.getPrice());
    }

    @Override
    public void dressWomen() {
        System.out.println("Штаны женские "+this.pantsName+", размер "+this.getClothingSize()+", цвет -"+this.getColor()
                +", цена:"+this.getPrice());
    }

}
