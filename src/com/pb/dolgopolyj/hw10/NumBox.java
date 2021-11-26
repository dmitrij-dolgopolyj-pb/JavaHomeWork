package com.pb.dolgopolyj.hw10;

import com.pb.dolgopolyj.hw3.Array;

/**
 * Класс NumBox, который демонстрирует работу с обобщениями.
 */
public class NumBox<T extends Number>
{
    //Объявляем массив объектов класса T, необходимый по условиям задания
    private final T numBoxArray[];
    //Объявляем переменную, которая будет отвечать за текущий заполняемый номер элемента массива
    private int currentElemArray;
    //Создаем конструктор класса, принимающий параметр максимального количества элементов массива
    public NumBox(int arrayMaxLenght)
    {
        //Инициализируем переменную, текущего заполняемого номера элемента массива
        currentElemArray=0;
        //Инициализируем массив объектов класса T
        numBoxArray= (T[]) new Number[arrayMaxLenght];
    }
    void add(T num) throws WrongNumberArrayElements
    {
        //При попытке записать значение в несуществующий элемент массива, выбрасываем исключение
        if (currentElemArray==numBoxArray.length) throw new WrongNumberArrayElements(currentElemArray);
        numBoxArray[currentElemArray]=num;
        System.out.println("В массив T["+currentElemArray+"] добавлено значение:"+numBoxArray[currentElemArray]);
        currentElemArray++;
    }
}
