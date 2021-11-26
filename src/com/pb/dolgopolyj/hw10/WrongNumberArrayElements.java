package com.pb.dolgopolyj.hw10;

/**
 * Класс WrongNumberArrayElements, который обрабатывает ошибку ввода чрезмерного элемента массива.
 */
public class WrongNumberArrayElements extends Exception
{
    public WrongNumberArrayElements(int number) {
        System.out.println("Вы пытаетесь заполнить массив элементом №"+(number+1)+"!");
    }
}
