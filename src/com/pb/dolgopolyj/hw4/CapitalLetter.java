//Создаваемая программа включается в пакет для выполнения Задания №4(hw4)
package com.pb.dolgopolyj.hw4;

//Для взаимодействия с пользователем импортируем класс Scanner
import java.util.Scanner;

// Создаем класс CapitalLetter
public class CapitalLetter
{
    //Создаем метод для деления строки на отдельные слова и преобразование их символов в верхний регистр
    //Метод принимает в качестве аргумента строку strFirst, возвращает строковый массив
    static String[] getUserStrParts (String strFirst)
    {
        //Поскольку у нас будет два преобразования строки, объявляем два строковых массива для их работы
        String[] strParts, strParts2;
        //Преобразуем передаваемую строку в строковый массив отдельных слов, с помощью регулярного выражения (RegEx)
        //в качестве разделителя слов принимаем пробелы, точку, запятую, дефис, тире и двоеточие
        strParts=strFirst.split("\\s*(\\s|,|-|—|:|\\.)\\s*");
        //Уже зная размерность массива strParts, инициализируем массив strParts2
        strParts2=new String[strParts.length];
        for (int i=0;i<strParts.length;i++)
        {
            //Преобразуем буквы в словах слов в верхний регистр и сохраняем результат во втором массиве
            strParts2[i]=strParts[i].toUpperCase();
        }
        //Возвращаем уже преобразованные в верхний регистр слова в строковом массиве
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
        System.out.println("В качестве разделителя слов в строке можно использовать пробелы, точку, запятую, дефис, тире и двоеточие.");
        System.out.println("Введите строку для требуемого преобразования:");
        userString = in.nextLine();

        //Создаем копию введенной строки в виде массива символов для дальнейших преобразований
        char[] copyString=userString.toCharArray();

        //Объявляем строковый массив для хранения отдельных слов из первоначальной строки
        //после дробления строки и преобразования слов, заполняем его с помощью своего метода
        String[] userStrParts=getUserStrParts(userString);

        //Инициализируем переменную, отвечающую за обработку номера слова в строке пользователя
        int wordNumber=0;
        //Создаем символьные переменные для опознования в строке знаков припинания и пробелов
        char s=" ".charAt(0),s1=",".charAt(0),s2=".".charAt(0),s3=":".charAt(0),s4="-".charAt(0),s5="—".charAt(0);

        //Запускаем цикл для изменения первых символов слов в строке пользователя
        for (int i=0;i<copyString.length;i++)
        {
            //Проверку продолжаем, если в букве №i строки не символ препинания
            if (copyString[i]!=s&&copyString[i]!=s1&&copyString[i]!=s2&&copyString[i]!=s3&&copyString[i]!=s4&&copyString[i]!=s5)
                {
                //найден первый символ слова №wordNumber
                //необходимо заменить его первым символом из преобразованного слова
                copyString[i]=userStrParts[wordNumber].charAt(0);
                //наращиваем счетчик i, пропуская текущее слово до следующих разделителей
                i=i+userStrParts[wordNumber].length()-1;
                //переходим к обработке следующего слова в строке
                wordNumber++;
                }
        }

        System.out.println("Полученная после преобразования строка:");
        for (int i=0;i<copyString.length;i++)
        {
            System.out.print(copyString[i]);
        }

       //Благодарности :)
        System.out.println("\n*** Cпасибо за использование класса 'CapitalLetter'! ***");
    }
}
