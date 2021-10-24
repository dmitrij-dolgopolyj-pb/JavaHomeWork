//Создаваемая программа включается в пакет для выполнения Задания №4(hw4)
package com.pb.dolgopolyj.hw4;

//Для взаимодействия с пользователем импортируем класс Scanner
import java.util.Scanner;

// Создаем класс CapitalLetter
public class CapitalLetter
{
    //Создаем метод для вывода на печать массива отдельных слов
    static void printArrayWord (String[] arrayWord)
    {
        for (int i=0;i<arrayWord.length;i++)
        {
            //Печатаем очередное слово
            System.out.print(arrayWord[i]+"$");
        }
    }

    // Объявляем и описываем главный метод класса CapitalLetter
    public static void main(String[] args)
    {
        //Объявляем строковую переменную для получения от пользователя первоначальной строки
        String userString;

        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);

        //Объявляем строковый массив для хранения отдельных слов из первоначальной строки
        String[] userStrParts;

        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nЭто класс 'CapitalLetter'.");
        System.out.println("Он переводит первую букву каждого слова заданной строки в верхний регистр.");

        //Cообщаем о порядке разделения слов в строке и запрашиваем ее ввод
        System.out.println("В качестве разделителя слов в строке можно использовать пробелы, точку, запятую, тире и двоеточие.");
        System.out.println("Введите строку для требуемого преобразования:");

        userString = in.nextLine();

        System.out.println("Ваша строка:"+userString);

       //Преобразуем введенную строку в строковый массив отдельных слов с помощью регулярного выражения (RegEx)
       //в качестве разделителя слов принимаем пробелы, точку, запятую, тире и двоеточие
       userStrParts=userString.split("\\s|,|:|-|\\.");
        //userStrParts=userString.split("\\s*(\\s|,|-|\\.)\\s*");

        //Организуем печать измененной строки с помощью метода printArrayWord
        printArrayWord (userStrParts);

       //Благодарности :)
        System.out.println("*** Cпасибо за использование класса 'CapitalLetter'! ***");
    }
}
