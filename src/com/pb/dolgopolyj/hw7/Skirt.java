package com.pb.dolgopolyj.hw7;

/**
 * Это класс-наследник (юбка) класса Clothes, он реализует реализует интерфейс WomenClothes
 */
public class Skirt extends Clothes implements WomenClothes
{
    //Добавим переменную, отвечающую за название юбки
    private String skirtName;

    //Cоздаем конструктор
    public Skirt(String skirtName, Size clothingSize, float price, String color)
    {
        this.skirtName = skirtName;
        this.setClothingSize(clothingSize);
        this.setPrice(price);
        this.setColor(color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Юбка "+this.skirtName+", размер "+this.getClothingSize()+", цвет -"+this.getColor()
                +", цена:"+this.getPrice());
    }

    public String getSkirtName() {
        return skirtName;
    }
}
