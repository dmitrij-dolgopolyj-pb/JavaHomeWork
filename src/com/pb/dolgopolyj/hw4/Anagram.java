//Создаваемая программа включается в пакет для выполнения Задания №4(hw4)
package com.pb.dolgopolyj.hw4;

//Для взаимодействия с пользователем импортируем класс Scanner
import java.util.Scanner;

// Создаем класс Anagram
public class Anagram
{
    // Объявляем и описываем главный метод класса Anagram
    public static void main(String[] args)
    {
        //Создаем строковую переменную для получения от пользователя вводимых значений
        String userString="";
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);

        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nЭто класс 'Anagram'\nОн поможет находить в строках анаграммы");


        //Благодарности :)
        System.out.println("*** Cпасибо за использование класса 'Anagram'! ***");
    }
}
