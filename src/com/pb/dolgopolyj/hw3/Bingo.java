//Создаваемая программа включается в пакет для выполнения Задания №3(hw3)
package com.pb.dolgopolyj.hw3;

//Для взаимодействия с пользователем импортируем класс Scanner
import java.util.Random;
import java.util.Scanner;

// Создаем класс Bingo
public class Bingo
{
    // Объявляем и описываем главный метод класса Bingo
    public static void main(String[] args)
    {
        //Создаем строковую переменную для получения от пользователя вводимых значений
        String userString="";
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);

        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nЭто игра 'Bingo!'");
        System.out.println("Ваша задача - угадать целое число, задуманное программой, в диапазоне от 0 до 100");
        //Cообщаем о типах вводимых чисел
        System.out.println("Допустим ввод целых чисел от 0 до 100");
        //Создаем целочисленную переменную для подсчета попыток пользователя
        int numberAttempts=0;
        //Cообщаем о способе завершения программы
        System.out.println("Если вы хотите закончить игру, вместо числа введите 'exit'");
        //Объявляем и инициализируем случайное число для отгадывания
        Random random=new Random();
        int randomNumber=random.nextInt(100);
        //Угадываем число до тех пор, пока пользователь не остановит программу вводом 'exit'
        for (;;)
            {
            //Обновляем счетчик попытки и сообщаем ее номер
            numberAttempts++;
            System.out.println("Это попытка №"+numberAttempts);
            System.out.println("Введите свой вариант:");
            userString = in.next();
            //Если пользователь больше не хочет играть, выходим из игры
            if (userString.equals("exit")==true)
                {
                System.out.println("Жаль, что Вы так и не отгадали это число:"+randomNumber);
                break;
                }
            System.out.println("Вы ввели:" + userString);

            }

        //Благодарности :)
        System.out.println("*** Cпасибо за игру, Ваша 'Bingo!' ***");
    }

}
