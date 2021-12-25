package com.pb.dolgopolyj.hw13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Класс TwoThreads, который организовывает работу с двумя потоками, разделяющих общий буфер данных
 */
public class TwoThreads
{
    //Переменная класса, для управления потоками
    //Значение 0 - совместная работа потоков, без блокировки
    //Значение 1 - необходима блокировка потока-производителя до конца работы блока-потребителя
    //Значение 2 - необходима блокировка блока-потребителя до конца работы блока-производителя
    private static volatile int controlValue = 0;

    //Для создания потока-производителя создаем свой класс MyThread1
    private static class MyThread1 implements Runnable
    {
        //Объявляем лист рабочего буфера класса
        List<Integer> dataBuffer;
        //Объявляем переменную класса Thread для взаимодействия с потоком-потребителем
        Thread consumerTread;
        public void setConsumerTread(Thread consumerTread) {
            this.consumerTread = consumerTread;
        }

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
            for (int i = 0; i < 5; i++)
            {
                //Организуем задержку работы потока
                for (int k = 0; k < 1000000; k++)
                {rundomNumber=random.nextInt(11);  }
                //Если поток-потребитель работает, организуем проверку, нужно ли дать ему завершить работу
                if (consumerTread.isAlive())
                {
                    //Проверяем, поставлена ли задача прервать выполнение потока-производителя
                    if (controlValue==1) {
                        //Пробуем остановиться до конца отработки потока-потребителя
                        try {
                            System.out.println("Поток 'производитель' приостановлен.");
                            consumerTread.join();
                            System.out.println("Завершена работа 'потребителя', возобновляем работу 'производителя'.");
                        } catch (InterruptedException e) {
                            System.out.println("Прерывание в потоке 'производителе'!!!");
                        }
                    }
                }

                //Генерируем случайное число от 0 до 10
                rundomNumber=random.nextInt(11);
                System.out.println("Производитель сгенерировал число," + " iteration: " + (i + 1)+"; rundom="+rundomNumber);
                dataBuffer.add(rundomNumber);
            }
        }
    }

    //Для создания потока-потребителя создаем свой класс MyThread2
    private static class MyThread2 implements Runnable
    {
        //Объявляем лист рабочего буфера класса
        List<Integer> dataBuffer;
        //Объявляем переменную класса Thread для взаимодействия с потоком-производителем
        Thread manufacturerTread;
        public void setManufacturerTread(Thread manufacturerTread)
        {
            this.manufacturerTread = manufacturerTread;
        }

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
            for (int i = 0; i < 5; i++)
            {
                //Организуем задержку работы потока
                for (int k = 0; k < 1000000; k++)
                {rundomNumber=random.nextInt(11);  }

                //Если поток-производитель работает, организуем проверку, нужно ли дать ему завершить работу
                if (manufacturerTread.isAlive())
                {
                    //Проверяем, поставлена ли задача прервать выполнение потока-потребителя
                    if (controlValue==2) {
                        //Пробуем остановиться до конца отработки потока-производителя
                        try {
                            System.out.println("Поток 'потребитель' приостановлен.");
                            manufacturerTread.join();
                            System.out.println("Завершена работа 'производителя', возобновляем работу 'потребителя'.");
                        } catch (InterruptedException e) {
                            System.out.println("Прерывание в потоке 'потребителе'!!!");
                        }
                    }
                }

                System.out.println("Потребляю на iteration: " + (i + 1));
                if (dataBuffer.size()>0)
                {
                    System.out.println("В буфере есть число, dataBuffer["+i+"]="+dataBuffer.get(i));
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
        Thread t1 = new Thread(manufacturerThread, "manufacturerThread");
        //Создаем объект класса MyThread2 для потока-потребителя
        //Thread consumerThread=new MyThread2();
        MyThread2 consumerThread=new MyThread2(dataBuffer);
        Thread t2 = new Thread(consumerThread, "consumerThread");

        //Задаем новое значение управляющей переменной
        controlValue=0;

        //Передаем в поток-производитель ссылку на поток-потребитель
        manufacturerThread.setConsumerTread(t2);
        //Передаем в поток-потребитель ссылку на поток-производитель
        consumerThread.setManufacturerTread(t1);
        //Запускаем поток-производитель
        t1.start();
        //Запускаем поток-потребитель
        t2.start();

        System.out.println("Переменная controlValue равна:"+controlValue);

        //Благодарности :)
        System.out.println("\n************************** Cпасибо за использование нашей 'TwoThreads'!!! ************************");
    }
}
