package com.pb.dolgopolyj.hw7;

/**
 * Это класс-наследник (галстук) класса Clothes, он реализует реализует интерфейс ManClothes
 */
public class Tie extends Clothes implements ManClothes
{
    //Добавим переменную, отвечающую за название галстука
    private String tieName;

    //Cоздаем конструктор
    public Tie(String tieName, Size clothingSize, float price, String color)
    {
        this.tieName = tieName;
        this.setClothingSize(clothingSize);
        this.setPrice(price);
        this.setColor(color);
    }

    @Override
    public void dressMan() {
        System.out.println("Штаны мужские "+this.tieName+", размер "+this.getClothingSize()+", цвет -"+this.getColor()
                +", цена:"+this.getPrice());
    }

}
