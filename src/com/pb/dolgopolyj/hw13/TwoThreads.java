package com.pb.dolgopolyj.test;

import java.util.*;

/**
 * Класс TwoThreads, который организовывает работу с двумя потоками, разделяющих общий буфер данных
 */
public class TwoThreads
{
    //Для создания потока-производителя создаем свой класс MyThread1
    private static class MyThread1 implements Runnable
    {
        //Объявляем рабочий буфер класса
        private final Queue<Integer> dataBuffer;
        //Объявляем переменную класса Thread
        Thread consumerTread;
        public void setConsumerTread(Thread consumerTread) {
            this.consumerTread = consumerTread;
        }

        public MyThread1(Queue <Integer> dataBuffer)
        {
            this.dataBuffer = dataBuffer;
        }

        //Переопределим метод run этого потока - он будет генерировать случайные числа и отправлять их в буфер
        @Override
        public void run()
        {
            //Объявляем переменную, которая будет помогать генерировать случайное число
            Random random=new Random();
            int rundomNumber;
            for (int i = 0; i < 50; i++)
            {
                //Организуем задержку для лучшей демонстрации работы потока
                for (int k = 0; k < 1000000; k++)
                {rundomNumber=random.nextInt(11);  }

                //Работаем, только если в буфере менее 5-ти элементов, иначе cообщаем о полном буфере и ждем появления в нем свободного места
                if (dataBuffer.size()<5)
                {
                    //Генерируем случайное число от 0 до 100
                    rundomNumber = random.nextInt(101);

                    synchronized (dataBuffer)
                    {
                        dataBuffer.add(rundomNumber);
                        System.out.println("Производитель сгенерировал число:"+rundomNumber+".");
                    }

                }
                else
                {
                    System.out.println("------------------------------Буфер заполнен полностью! Поток 'производитель' ожидает освобождения буфера...--------------------");
                    try
                    {
                        synchronized (dataBuffer)
                        {
                            System.out.println("Оживляем поток потребителя, заставляем уснуть производителя");
                            dataBuffer.notify();
                            dataBuffer.wait();
                        }
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            //Поток полностью отработал, даем возможность завершить работу другому потоку, если он в ожидании
            synchronized (dataBuffer) {dataBuffer.notify();}
        }
    }

    //Для создания потока-потребителя создаем свой класс MyThread2
    private static class MyThread2 implements Runnable
    {
        //Объявляем рабочий буфер класса
        private final Queue<Integer> dataBuffer;
        //Объявляем переменную класса Thread для взаимодействия с потоком-производителем
        Thread manufacturerTread;
        public void setManufacturerTread(Thread manufacturerTread)
        {
            this.manufacturerTread = manufacturerTread;
        }

        //Конструктор класса
        public MyThread2(Queue <Integer> dataBuffer)
        {
            this.dataBuffer = dataBuffer;
        }

        //Переопределим метод run этого потока - он будет изымать из буфера сгенирированные случайные числа
        @Override
        public void run()
        {
            //Объявляем переменную, которая будет помогать генерировать случайное число
            Random random=new Random();
            int rundomNumber;
            for (int i = 0; i < 50; i++)
            {
                //Организуем задержку для лучшей демонстрации работы потока
                for (int k = 0; k < 1000000; k++)
                {rundomNumber=random.nextInt(11);  }

                //Работаем, если в буфере есть хотя бы 1 элемент, иначе ждем, пока место не освободится
                if (dataBuffer.size()>0)
                {
                    synchronized (dataBuffer)
                    {System.out.println("Потребитель изымает число:"+dataBuffer.poll());}
                }
                else
                {
                    System.out.println("-------------------------------------Буфер пуст! Поток 'потребитель' ожидает данные...------------------------------------------------");
                    try {
                         synchronized (dataBuffer) {
                             System.out.println("Оживляем поток производителя, заставляем уснуть потребителя");
                            dataBuffer.notify();
                            dataBuffer.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            //Поток полностью отработал, даем возможность завершить работу другому потоку, если он в ожидании
            synchronized (dataBuffer) {dataBuffer.notify();}
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

        Queue<Integer> dataBuffer=new PriorityQueue<>();

        //Создаем объект класса MyThread1 для потока-производителя
        MyThread1 manufacturerThread=new MyThread1(dataBuffer);
        Thread t1 = new Thread(manufacturerThread, "manufacturerThread");
        //Создаем объект класса MyThread2 для потока-потребителя
        MyThread2 consumerThread=new MyThread2(dataBuffer);
        Thread t2 = new Thread(consumerThread, "consumerThread");

        //Передаем в поток-производитель ссылку на поток-потребитель
        manufacturerThread.setConsumerTread(t2);
        //Передаем в поток-потребитель ссылку на поток-производитель
        consumerThread.setManufacturerTread(t1);

        //Запускаем поток-производитель
        t1.start();
        //Запускаем поток-потребитель
        t2.start();

        //Благодарности :)
        System.out.println("\n************************** Cпасибо за использование нашей 'TwoThreads'!!! ************************");
    }
}
