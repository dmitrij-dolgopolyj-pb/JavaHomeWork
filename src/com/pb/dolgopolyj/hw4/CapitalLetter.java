//Создаваемая программа включается в пакет для выполнения Задания №4(hw4)
package com.pb.dolgopolyj.hw4;

//Для взаимодействия с пользователем импортируем класс Scanner
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

// Создаем класс CapitalLetter
public class CapitalLetter
{
    //Создаем метод для деления строки на отдельные слова и преобразование их символов в верхний регистр
    //Метод принимает в качестве аргумента строку strFirst, возвращает сстроковый массив слов userStrParts
    static String[] getUserStrParts (String strFirst)
    {
        //Поскольку у нас будет два преобразования строки, объявляем два строковых массива для их работы
        String[] strParts, strParts2;
        //Преобразуем передаваемую строку в строковый массив отдельных слов, с помощью регулярного выражения (RegEx)
        //в качестве разделителя слов принимаем пробелы, точку, запятую, тире и двоеточие
        strParts=strFirst.split("\\s*(\\s|,|-|:|\\.)\\s*");
        //Уже зная размерность массива strParts, инициализируем массив strParts2
        strParts2=new String[strParts.length];
        for (int i=0;i<strParts.length;i++)
        {
            //Преобразуем буквы в словах слов в верхний регистр и сохраняем результат во втором массиве
            strParts2[i]=strParts[i].toUpperCase();
        }
        //Возвращаем уже преобразованные в верхний регистр слова
        return strParts2;
    }

    // Объявляем и описываем главный метод класса CapitalLetter
    public static void main(String[] args)
    {
        //Объявляем строковую переменную для получения от пользователя первоначальной строки
        String userString;
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);

        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nЭто класс 'CapitalLetter'.");
        System.out.println("Он переводит первую букву каждого слова заданной строки в верхний регистр.");

        //Cообщаем о порядке разделения слов в строке и запрашиваем ее ввод
        System.out.println("В качестве разделителя слов в строке можно использовать пробелы, точку, запятую, тире и двоеточие.");
        System.out.println("Введите строку для требуемого преобразования:");
        userString = in.nextLine();

        //Создаем копию введенной строки в виде массива символов для дальнейших преобразований
        char[] copyString=userString.toCharArray();

        //Объявляем строковый массив для хранения отдельных слов из первоначальной строки
        //после дробления строки и преобразования слов, заполняем его с помощью своего метода
        String[] userStrParts=getUserStrParts(userString);

        System.out.println("Копия первоначальной строки:");
        for (int i=0;i<userString.length();i++)
        {
            System.out.print(copyString[i]);
        }
        System.out.println("\nПолученные преобразованные слова:");
        for (int i=0;i<userStrParts.length;i++)
        {
            //Печатаем очередное слово
            System.out.print("cлово"+i+":"+userStrParts[i]);
        }

       //Благодарности :)
        System.out.println("*** Cпасибо за использование класса 'CapitalLetter'! ***");
    }
}
