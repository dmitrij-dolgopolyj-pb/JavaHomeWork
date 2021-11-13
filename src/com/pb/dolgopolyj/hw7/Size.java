package com.pb.dolgopolyj.hw7;


/**
 * Это объявление класса перечисления enum Size, необходимое для работы с разными размерами одежды.
 */

public enum Size
{
    XXS("детский размер",32),
    XS("супер малый взрослый размер",34),
    S("малый взрослый размер",36),
    M("средний взрослый размер",38),
    L("большой взрослый размер", 40);
    private String description;
    private int euroSize;

    //Cоздаем конструктор, принимающий на вход description и euroSize
    Size(String description, int euroSize) {

       this.description = description;
       this.euroSize = euroSize;
    }


    //Метод для определения детского/взрослого размера одежды
    String getDescription()
    {
        String answer;
        if (this.equals(Size.XXS))
            answer= "Детский размер";
        else
            answer="Взрослый размер";
        return answer;
    };

    //Метод для возврата "европейского" размера одежды
    int getEuroSize()
    {
        return this.euroSize;
    }

}
