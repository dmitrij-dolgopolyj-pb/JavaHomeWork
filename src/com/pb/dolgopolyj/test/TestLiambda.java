package com.pb.dolgopolyj.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestLiambda
{
    @FunctionalInterface
    interface Operation {
        int execute(int x, int y);
    }

    public static void main(String[] args) {
        Operation add = new Operation() {
            @Override
            public int execute(int x, int y) {
                return x + y;
            }
        };

        Operation sub = (x, y) -> x - y;
        Operation div = (x, y) -> x / y;
        Operation mul = (x, y) -> x * y;

        int resAdd = add.execute(12, 4);
        int resSub = sub.execute(12, 4);
        int resDiv = div.execute(12, 4);
        int resMul = mul.execute(12, 4);

        System.out.println("add: " + resAdd);
        System.out.println("sub: " + resSub);
        System.out.println("div: " + resDiv);
        System.out.println("mul: " + resMul);
    }
}
//package com.pb.dolgopolyj.hw13;
//
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Random;
///**
// * Класс TwoThreads, который организовывает работу с двумя потоками, разделяющих общий буфер данных
// */
//public class TwoThreads
//{
//    //Переменная класса, для управления потоками
//    //Значение 0 - совместная работа потоков, без блокировки
//    //Значение 1 - необходима блокировка потока-производителя до конца работы блока-потребителя
//    //Значение 2 - необходима блокировка блока-потребителя до конца работы блока-производителя
//    private static volatile int controlValue;
//
//    //Для создания потока-производителя создаем свой класс MyThread1
//    private static class MyThread1 implements Runnable
//    {
//        //Объявляем лист рабочего буфера класса
//        List<Integer> dataBuffer;
//        //Объявляем переменную класса Thread для взаимодействия с потоком-потребителем
//        Thread consumerTread;
//        public void setConsumerTread(Thread consumerTread) {
//            this.consumerTread = consumerTread;
//        }
//
//        public MyThread1(List<Integer> dataBuffer)
//        {
//            this.dataBuffer = dataBuffer;
//        }
//
//        //Переопределим метод run этого потока - он будет генерировать случайные числа
//        @Override
//        public void run()
//        {
//            //Объявляем переменную, которая будет помогать генерировать случайное число
//            Random random=new Random();
//            int rundomNumber;
//            for (int i = 0; i < 50; i++)
//            {
//                //Организуем задержку для лучшей демонстрации работы потока
//                for (int k = 0; k < 1000000; k++)
//                {rundomNumber=random.nextInt(100);  }
//
//                //Работаем, только если в буфере менее 5-ти элементов, иначе cообщаем о полном буфере и ждем появления в нем свободного места
//                if (dataBuffer.size()<3)
//                {
//                    //Проверяем, поставлена ли задача прервать выполнение потока-производителя
////                    if (controlValue == 1)
////                    {
////                        //Пробуем остановиться до конца отработки потока-потребителя
////                        try {
////                            System.out.println("Поток 'производитель' приостановлен.");
////                            consumerTread.join();
////                            System.out.println("Завершена работа 'потребителя', возобновляем работу 'производителя'.");
////                            //Разрешаем работу обоих потоков
////                            controlValue = 0;
////                        } catch (InterruptedException e) {
////                            System.out.println("Прерывание в потоке 'производителе'!!!");
////                        }
////                    }
//
//                    //Генерируем случайное число от 0 до 100
//                    rundomNumber = random.nextInt(101);
//                    System.out.println("Произвожу на iteration: " + (i + 1));
//                    bufferInOut (rundomNumber,true, dataBuffer);
//                }
//                else
//                {
//                    System.out.println("------------------------------Буфер заполнен полностью! Поток 'производитель' ожидает освобождения буфера...--------------------");
//                }
//            }
//        }
//    }
//
//    //Для создания потока-потребителя создаем свой класс MyThread2
//    private static class MyThread2 implements Runnable
//    {
//        //Объявляем лист рабочего буфера класса
//        List<Integer> dataBuffer;
//        //Объявляем переменную класса Thread для взаимодействия с потоком-производителем
//        Thread manufacturerTread;
//        public void setManufacturerTread(Thread manufacturerTread)
//        {
//            this.manufacturerTread = manufacturerTread;
//        }
//
//        //Конструктор класса
//        public MyThread2(List<Integer> dataBuffer)
//        {
//            this.dataBuffer = dataBuffer;
//        }
//
//        //Переопределим метод run этого потока - он будет генерировать случайные числа
//        @Override
//        public void run()
//        {
//            //Объявляем переменную, которая будет помогать генерировать случайное число
//            Random random=new Random();
//            int rundomNumber;
//            for (int i = 0; i < 50; i++)
//            {
//                //Организуем задержку для лучшей демонстрации работы потока
//                for (int k = 0; k < 1000000; k++)
//                {rundomNumber=random.nextInt(11);  }
//
//                //Работаем, если в буфере есть хотя бы 1 элемент, иначе ждем, пока место не освободится
//                if (dataBuffer.size()>0)
//                {
//                    //Проверяем, поставлена ли задача прервать выполнение потока-потребителя
////                    if (controlValue == 2) {
////                        //Пробуем остановиться до конца отработки потока-производителя
////                        try {
////                            System.out.println("Поток 'потребитель' приостановлен.");
////                            manufacturerTread.join();
////                            System.out.println("Завершена работа 'производителя', возобновляем работу 'потребителя'.");
////                            //Разрешаем работу обоих потоков
////                            controlValue = 0;
////                        } catch (InterruptedException e) {
////                            System.out.println("Прерывание в потоке 'потребителе'!!!");
////                        }
////                    }
//
//                    System.out.println("Потребляю на iteration: " + (i + 1));
//                    bufferInOut (-1,false, dataBuffer);
//
//                }
//                else
//                {
//                    System.out.println("-------------------------------------Буфер пуст! Поток 'потребитель' ожидает данные...------------------------------------------------");
//                }
//            }
//        }
//    }
//
//    //Для правильной работы с буфером данных по вводу/выводу этот метод синхронизируем
//    synchronized public static void bufferInOut (int in, boolean isIn, List<Integer> dataBuffer)
//    {
//        if (isIn==true)
//        {
//            dataBuffer.add(in);
//            System.out.print("Производитель сгенерировал число:"+in+".");
//            System.out.println("Теперь dataBuffer");
//            for (int l=0;l<dataBuffer.size();l++)
//            {
//                System.out.print("["+l+"]="+dataBuffer.get(l)+";");
//            }
//        }
//        else
//        {
//            System.out.print("Потребитель изымает число:"+dataBuffer.get((dataBuffer.size() - 1)));
//            dataBuffer.remove((dataBuffer.size() - 1));
//            System.out.println("После потребления dataBuffer");
//            for (int l=0;l<dataBuffer.size();l++)
//            {
//                System.out.print("["+l+"]="+dataBuffer.get(l)+";");
//            }
//        }
//    }
//
//    public static void main(String[] args)
//    {
//        //Выводим на экран приветствие программы и выполняемые ей действия
//        System.out.println("**************************************** Добрый день! ********************************************\n");
//        System.out.println("***************************Вас приветствует программа 'TwoThreads'!!!*****************************\n");
//        System.out.println("Она демонстрирует работу с двумя потоками, разделяющих общий буфер данных, размером 5 элементов.");
//        System.out.println("Поток 'Производитель' генерирует данные (случайные числа от 1 до 100) и помещает их в буфер.");
//        System.out.println("Поток 'Потребитель' «потребляет» их из буфера - выводит на печать в консоль и очищает буфер.");
//
//        List<Integer> dataBuffer=new ArrayList<>();
//
//        //Создаем объект класса MyThread1 для потока-производителя
//        MyThread1 manufacturerThread=new MyThread1(dataBuffer);
//        Thread t1 = new Thread(manufacturerThread, "manufacturerThread");
//        //Создаем объект класса MyThread2 для потока-потребителя
//        MyThread2 consumerThread=new MyThread2(dataBuffer);
//        Thread t2 = new Thread(consumerThread, "consumerThread");
//        //Разрешаем совместную работу обоих потоков
//        controlValue=0;
//        //Передаем в поток-производитель ссылку на поток-потребитель
//        manufacturerThread.setConsumerTread(t2);
//        //Передаем в поток-потребитель ссылку на поток-производитель
//        consumerThread.setManufacturerTread(t1);
//        //Запускаем поток-производитель
//        t1.start();
//        //Запускаем поток-потребитель
//        t2.start();
//
//        System.out.println("Переменная controlValue равна:"+controlValue);
//
//        //Благодарности :)
//        System.out.println("\n************************** Cпасибо за использование нашей 'TwoThreads'!!! ************************");
//    }
//}
