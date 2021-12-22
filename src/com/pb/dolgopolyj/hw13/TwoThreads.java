package com.pb.dolgopolyj.hw13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Класс TwoThreads, который организовывает работу с двумя потоками, разделяющих общий буфер данных
 */
public class TwoThreads
{
    //Переменная класса
    private static volatile int myValue = 0;

    //Для создания одного из потоков создаем свой класс MyThread1
    private static class MyThread1 implements Runnable
    {
        private int x;
        List<Integer> dataBuffer;

        public MyThread1(List<Integer> dataBuffer)
        {
            this.dataBuffer = dataBuffer;
        }

        //Переопределим метод run этого потока - он будет генерировать случайные числа
        @Override
        public void run()
        {
            //Объявляем переменную, которая будет помогать генерировать случайное число
            Random random=new Random();
            int rundomNumber;
            x=0;
            for (int i = 0; i < 10; i++)
            {
                //Организуем задержку работы потока
                for (int k = 0; k < 1000000; k++)
                {rundomNumber=random.nextInt(11);  }
                //Генерируем случайное число от 0 до 10
                rundomNumber=random.nextInt(11);
                System.out.println("Производитель сгенерировал число," + " iteration: " + (i + 1)+"rundom="+rundomNumber);
                dataBuffer.add(rundomNumber);
                System.out.println("Число:"+rundomNumber+" записано в dataBuffer");
                myValue=myValue+1;
                x=myValue+2;
                System.out.println("myValue="+myValue+"; x="+x);
            }
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }

    //Для создания второго потока создаем свой класс MyThread2
    private static class MyThread2 implements Runnable
    {
        List<Integer> dataBuffer;
        //Конструктор класса
        public MyThread2(List<Integer> dataBuffer)
        {
            this.dataBuffer = dataBuffer;
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
                rundomNumber=random.nextInt(11)+10;
                System.out.println("Потребляю на iteration: " + (i + 1)+"rundom="+rundomNumber);
                myValue=myValue+100;
                System.out.println("Потребитель изменил внутреннюю переменную, myValue="+myValue);
                if (dataBuffer.size()>0)
                {
                    System.out.println("В буфере есть число, dataBuffer[0]="+dataBuffer.get(0));
                }
//                // Проверяем, работает ли ещё "производитель"
//                if (manufacturerThread.isAlive()) {
//                    try {
//                        // Если "производитель" еще работает, ждем окончания его работы
//                        manufacturerThread.join();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println("Ожидаю окончания работы производителя...");
//
//                } else {
//                    //если "производитель" уже закончил работу, спокойно завершаем свою
//                    System.out.println("Производитель уже завершил работу, можно заканчивать свою.");
//                }
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

        List<Integer> dataBuffer=new ArrayList<>();

        //Создаем объект класса MyThread1 для потока-производителя
        //Thread manufacturerThread=new MyThread1();
        MyThread1 manufacturerThread=new MyThread1(dataBuffer);
        Thread t1 = new Thread(manufacturerThread, "t1");
        //Создаем объект класса MyThread2 для потока-потребителя
        //Thread consumerThread=new MyThread2();
        MyThread2 consumerThread=new MyThread2(dataBuffer);
        Thread t2 = new Thread(consumerThread, "t2");
        //Запускаем поток-производитель
        t1.start();
        //Запускаем поток-потребитель
        t2.start();

        System.out.println("Переменная х 'производителя' равна:"+manufacturerThread.getX());
        System.out.println("Переменная myValue равна:"+myValue);

        //Благодарности :)
        System.out.println("\n************************** Cпасибо за использование нашей 'TwoThreads'!!! ************************");
    }
}
