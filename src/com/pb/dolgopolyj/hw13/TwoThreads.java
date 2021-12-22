package com.pb.dolgopolyj.hw13;

import java.util.Random;
/**
 * Класс TwoThreads, который организовывает работу с двумя потоками, разделяющих общий буфер данных
 */
public class TwoThreads
{
    //Для создания одного из потоков создаем свой класс MyThread1, наследника класса Thread
    static class MyThread1 extends Thread
    {
        //Конструктор класса
        public MyThread1()
        {
        }
        //Переопределим метод run этого потока - он будет генерировать случайные числа
        @Override
        public void run()
        {
            //Объявляем переменную, которая будет помогать генерировать случайное число
            Random random=new Random();
            int rundomNumber;
            for (int i = 0; i < 10; i++)
            {
                //Организуем задержку работы потока
                for (int k = 0; k < 1000000; k++)
                { rundomNumber=random.nextInt(11);  }
                //Генерируем случайное число от 0 до 10
                rundomNumber=random.nextInt(11);
                System.out.println(getName() + " iteration: " + (i + 1)+"rundom="+rundomNumber);
            }
        }
    }

    //Для создания второго потока создаем свой класс MyThread2, наследника класса Thread
    static class MyThread2 extends Thread
    {
        //Конструктор класса
        public MyThread2()
        {
        }
        //Переопределим метод run этого потока - он будет генерировать случайные числа
        @Override
        public void run()
        {
            //Объявляем переменную, которая будет помогать генерировать случайное число
            Random random=new Random();
            int rundomNumber;
            for (int i = 0; i < 10; i++)
            {
                //Организуем задержку работы потока
                for (int k = 0; k < 1000000; k++)
                {rundomNumber=random.nextInt(11);  }
                //Генерируем случайное число от 11 до 20
                rundomNumber=random.nextInt(11)+11;
                System.out.println(getName() + " Потребляю на iteration: " + (i + 1)+"rundom="+rundomNumber);
            }
        }
    }

    public static void main(String[] args)
    {
        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("**************************************** Добрый день! ********************************************\n");
        System.out.println("***************************Вас приветствует программа 'TwoThreads'!!!*****************************\n");
        System.out.println("Она демонстрирует работу с двумя потоками, разделяющих общий буфер данных, размером 5 элементов.");
        System.out.println("Поток 'Производитель' генерирует данные (случайные числа от 1 до 100) и помещает их в буфер.");
        System.out.println("Поток 'Потребитель' «потребляет» их из буфера - выводит на печать в консоль и очищает буфер.");

        //Создаем объект класса MyThread1 для потока-производителя
        Thread manufacturerThread=new MyThread1();
        //Создаем объект класса MyThread2 для потока-потребителя
        Thread consumerThread=new MyThread2();
        //Запускаем поток-производитель
        manufacturerThread.start();
        //Запускаем поток-потребитель
        consumerThread.start();

        //Благодарности :)
        System.out.println("\n************************** Cпасибо за использование нашей 'TwoThreads'!!! ************************");
    }
}
