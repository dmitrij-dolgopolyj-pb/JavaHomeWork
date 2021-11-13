package com.pb.dolgopolyj.hw7;

/**
 * Cоздаем интерфейс WomenClothes, отвечающий за женскую одежду.
 * После своей реализации он будет выводить информацию об одежде (название, размер, цену, цвет).
 */
public interface WomenClothes
{
    //Для примера используем один cтатический метод - выведем сообщение о типе одежды (женская)
    static void printTypeClothes ()
    {
        System.out.println("Это женская одежда");
    }
    //Cоздаем метод dressWomen, в котором будем реализовывать одевание женщины
    void dressWomen ();
}
