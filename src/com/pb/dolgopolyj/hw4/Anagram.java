//Создаваемая программа включается в пакет для выполнения Задания №4(hw4)
package com.pb.dolgopolyj.hw4;

//Для взаимодействия с пользователем импортируем класс Scanner
import java.util.Scanner;

// Создаем класс Anagram
public class Anagram
{
    //Создаем метод для cравнения строк из двух строковых массивов в поисках в них анаграммы слов(фраз)
    //Метод принимает в качестве аргумента два строковых массива
    //Метод возвращает "true", если все их элементы идентичны, вне зависимости от их места расположения
    //В противном случае метод возвращает значение "false"
    static boolean compareStrArray (String[] strMas1,String[] strMas2)
    {
        //Объеденим строковые массивы в две строковые переменные
        String firstStr="",secondStr="";
        for (int i=0;i<strMas1.length;i++) firstStr=firstStr+strMas1[i];
        for (int i=0;i<strMas2.length;i++) secondStr=secondStr+strMas2[i];

        //Нам необходимо задать переменную, которая будет отвечать за количество совпадений букв в словах
        int numberCoinLetter = 0;
        //Инициализируем массив, который будет индикатором выявленных совпадений букв второй строки с первой
        boolean[] compareLetterStr2=new boolean[secondStr.length()];
        //Первоначально всем его элементам присваеваем значения false-совпадений пока не найдено
        for (int i=0;i<secondStr.length();i++) compareLetterStr2[i]=false;

        //Организуем цикл сравнения всех символов из первой строки со второй
        for (int i = 0; i < firstStr.length(); i++) {
            for (int k = 0; k < secondStr.length(); k++) {
                //Дальнейшую проверку в этом цикле выполняем в том случае, если ранее не найдено совпадение
                //текущей буквы во второй строке с текущей буквой в первой строке
                if (compareLetterStr2[k] != true) {
                    if (firstStr.charAt(i) == secondStr.charAt(k)) {
                        // наращиваем счетчик совпадений букв
                        numberCoinLetter++;
                        //Cообщаем программе, что эта буква уже найдена во второй строке
                        compareLetterStr2[k] = true;
                        //заканчиваем цикл по переменной k - ищем совпадение следующего символа первой строки со второй
                        k = secondStr.length();
                    }
                }
            }
        }
       //Если количество совпадений букв равно их количеству, вторая строка - это анаграмма первой
        if (numberCoinLetter==secondStr.length()) return true;
        //Иначе не все символы во второй строке найдены в первой строке - это не анаграмма
        else return false;
    }

    // Объявляем и описываем главный метод класса Anagram
    public static void main(String[] args)
    {
        //Создаем строковые переменные для получения от пользователя вводимых строк
        String userString1,userString2;
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);

        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nЭто класс 'Anagram'");
        System.out.println("Программа определяет, является ли вторая строка анаграммой первой строки");
        System.out.println("Введите строку №1:");
        userString1=in.nextLine();
        System.out.println("Введите строку №2:");
        userString2=in.nextLine();

        //Объявляем строковый массив для хранения отдельных слов из строки №1, введенной пользователем.
        //Для их нахождения и преобразования в верхний регистр (это поможет сравнению слов в случае,
        //если они состоят в вводимых пользователем строках из строчных и заглавных букв)
        //Заполняем его с помощью своего метода из класса CapitalLetter.
        String[] userStr1Parts=CapitalLetter.getUserStrParts(userString1);
        //Аналогично объявляем строковый массив для хранения отдельных слов из строки №2
        String[] userStr2Parts=CapitalLetter.getUserStrParts(userString2);

        //Вызываем метод для сравнения строковых массивов
        if (compareStrArray(userStr1Parts, userStr2Parts)==true)
        {
            //Массивы совпали, это анаграмма
            System.out.println("Вторая строка является анаграммой первой строки");
        }
        else
        {
            //Массивы не совпали, это не анаграмма
            System.out.println("Вторая строка НЕ является анаграммой первой строки");
        }

        //Благодарности :)
        System.out.println("*** Cпасибо за использование класса 'Anagram'! ***");
    }
}
