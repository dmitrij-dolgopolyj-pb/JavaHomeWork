//Создаваемая программа включается в пакет для выполнения Задания №3(hw3)
package com.pb.dolgopolyj.hw3;

//Для взаимодействия с пользователем импортируем класс Scanner
import java.util.Scanner;

public class Array {

    // Объявляем и описываем главный метод класса Array
    public static void main(String[] args)
    {
        //Задаем переменную, которая будет отвечать за размерность массива
        int arraySize=3;
        // Создаем нужный нам массив целых чисел из 10 элементов
        int [] array = new int[arraySize];

        //Создаем строковую переменную для получения от пользователя вводимых значений
        String userString="";
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);

        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nЭто класс 'Array'\nОн поможет в обработке массива");
        //Cообщаем о типе вводимых элементов массива
        System.out.println("Необходимо ввести значения 10-ти элементов массива(допустим ввод целых чисел)");
        //Объявляем переменную для хранения числовых значений, вводимых пользователем
        int userInInt;

        //Организуем ввод элементов массива
        for (int i=0;i<arraySize;i++)
        {
            System.out.println("Введите элемент массива: array["+i+"]");
            userString = in.next();
            //Проверка корректности введения данных
            try
            {
            userInInt = Integer.valueOf(userString);
            //Если все ОК, записываем данные в массив
                array[i]=userInInt;
            }
            catch (NumberFormatException e)
            {
            //Иначе сообщаем об ошибке и повторяем ввод
            System.out.println("Неправильный ввод данных!");
            i--;
            }
        }

        //Организуем вывод элементов массива
        System.out.println("Ваш исходный массив:");
        for (int i=0;i<arraySize;i++)
        {
            System.out.println("array["+i+"]="+array[i]+";");
        }

    }

}
