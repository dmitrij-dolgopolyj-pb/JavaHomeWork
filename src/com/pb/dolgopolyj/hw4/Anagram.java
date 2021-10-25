//Создаваемая программа включается в пакет для выполнения Задания №4(hw4)
package com.pb.dolgopolyj.hw4;

//Для взаимодействия с пользователем импортируем класс Scanner
import java.util.Scanner;

//import CapitalLetter;

// Создаем класс Anagram
public class Anagram
{
    //Создаем метод для cравнения строк из двух строковых массивов в поисках в них анаграммы слов(фраз)
    //Метод принимает в качестве аргумента два строковых массива
    //Метод возвращает "true", если все их элементы идентичны, вне зависимости от их места расположения
    //В противном случае метод возвращает значение "false"
    static boolean compareStrArray (String[] strMas1,String[] strMas2)
    {
        //Нам необходимо задать переменную, которая будет отвечать за количество совпадений слов
        int numberCoin = 0;
        //Если количество слов в строках не совпадают, это не анаграмма
        if (strMas1.length==strMas2.length)
        {

            //Организуем цикл сравнения всех слов из первого массива со словами другого
            for (int i = 0; i < strMas1.length; i++) {
                for (int k = 0; k < strMas2.length; k++) {
                    //Для начала найдем совпадения размеров слов
                    if (strMas1[i].length() == strMas2[k].length()) {
                        //размеры слов совпали,организуем проверку их содержимого




                        // наращиваем счетчик совпадений
                        numberCoin++;
                        //заканчиваем цикл по переменной K
                        k= strMas2.length;
                        System.out.println("Есть совпадение №" + numberCoin);
                    }
                }
            }
        }
        //Если количество совпадений слов равно их количеству в массивах, это анаграмма
        if (numberCoin==strMas1.length) return true;
        //Иначе это просто разные строки с одинаковым количеством слов в них
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
        System.out.println("Программа определяет, является ли одна строка анаграммой другой строки");
        System.out.println("Введите строку №1:");
        userString1=in.nextLine();
        System.out.println("Введите строку №2:");
        userString2=in.nextLine();

        //Создаем копии введенных строк в виде массивов символов для дальнейших преобразований
        //char[] copyString1=userString1.toCharArray();
        //char[] copyString2=userString2.toCharArray();
        //Проверяем правильность копий строк
        //System.out.println("Полученная копия строки 1:");
        //for (int i=0;i<copyString1.length;i++)
        //{
        //    System.out.print(copyString1[i]);
        //}
        //System.out.println("\nПолученная копия строки 2:");
        //for (int i=0;i<copyString2.length;i++)
        //{
        //    System.out.print(copyString2[i]);
        //}

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
            System.out.println("Первая строка является анаграммой второй строки");
        }
        else
        {
            //Массивы не совпали, это не анаграмма
            System.out.println("Строки не являются анаграммой");
        }

        //Благодарности :)
        System.out.println("*** Cпасибо за использование класса 'Anagram'! ***");
    }
}
