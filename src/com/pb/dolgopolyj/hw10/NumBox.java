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

    //Метод, добавляющий число в массив
    void add(T num) throws WrongNumberArrayElements
    {
        //При попытке записать значение в несуществующий элемент массива, выбрасываем исключение
        if (currentElemArray==numBoxArray.length) throw new WrongNumberArrayElements(currentElemArray);
        numBoxArray[currentElemArray]=num;
        currentElemArray++;
    }

    //Метод, возвращающий число по индексу
    T get(int index)
    {
        return numBoxArray[index];
    }

    //Метод, возвращающий текущее количество элементов.
    int length()
    {
        return currentElemArray;
    }

    //Метод, который ведет подсчет суммы всех элементов массива.
    double sum()
    {
        double sum=0;
        for (int i=0;i<currentElemArray;i++)
        {
            sum+=(numBoxArray[i]).doubleValue();
        }
        return sum;
    }

    //Метод, который ведет подсчет среднего арифметического среди элементов массива.
    double average()
    {
        double average=0;
        average=this.sum()/currentElemArray;
        return average;
    }

    //Метод, который находит максимальный элемент массива.
    T max()
    {
        int maxNumber=0;
        double maxValue=(numBoxArray[maxNumber]).doubleValue();
        for (int i=0;i<currentElemArray;i++)
        {
            if ((numBoxArray[i]).doubleValue()>maxValue)
            {
                maxValue=(numBoxArray[i]).doubleValue();
                maxNumber=i;
            }
        }
        return this.get(maxNumber);
    }

}
