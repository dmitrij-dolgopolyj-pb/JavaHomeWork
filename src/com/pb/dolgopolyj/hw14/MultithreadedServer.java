package com.pb.dolgopolyj.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Класс MultithreadedServer, который организовывает работу Клиент-Сервер
 */
public class MultithreadedServer
{
    public static void main(String[] args) throws Exception
    {
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);
        //Cоздаём переменную для ввода строки с клавиатуры
        String inputString="";
        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("**************************************** Добрый день! ********************************************\n");
        System.out.println("***********************Вас приветствует программа 'MultithreadedServer'!!!************************\n");
        System.out.println("Она демонстрирует работу по передаче и обработке данных в паре Клиент-Сервер");

        // Определяем номер порта, на котором нас ожидает сервер для ответа
        int portNumber = 49153;

        System.out.println("Подключение к серверу будет осуществляться через порт:"+portNumber+"\n");
        System.out.println("ВАЖНО!!! Перед дальнейшей работой, убедитесь, что программа Server уже запущена!");
        System.out.println("В ее консоли должно появиться сообщение: Сервер ожидает соединения с пользователем(и), используем порт:"+portNumber);

        System.out.print("\nВведите строку для передачи серверу->");
        //Ждем ввода cтроки пользователем
        inputString = in.nextLine();

        try
        {
        // Открыть сокет (Socket) для обращения к локальному компьютеру
        // Сервер мы будем запускать на этом же компьютере
        // Это специальный класс для сетевого взаимодействия c клиентской стороны
        Socket socket = new Socket("127.0.0.1", portNumber);
            // Пишем, что стартовали клиент
            System.out.println("Клиент запущен! (host:127.0.0.1,port:"+portNumber+")");

            // Создать поток для чтения символов из сокета
            // Для этого надо открыть поток сокета - socket.getInputStream()
            // Потом преобразовать его в поток символов - new InputStreamReader
            // И уже потом сделать его читателем строк - BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Создать поток для записи символов в сокет
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            // Отправляем тестовую строку в сокет
            pw.println(inputString);

            String str;
            // Входим в цикл чтения, что нам ответил сервер
            while ((str = br.readLine()) != null) {
                // Если пришел ответ “bye”, то заканчиваем цикл
                if (str.equals("bye")) {
                    break;
                }
                // Печатаем ответ от сервера на консоль для проверки
                System.out.println("Получен ответ сервера:"+str);
                // Посылаем ему "bye" для окончания "разговора"
                pw.println("bye");
            }

            br.close();
            pw.close();
            socket.close();
            System.out.println("Cеанс связи с сервером успешно завершен!");
        }
        catch (IOException ex)
        {System.out.println("Ошибка подключения! Проверьте, запущен ли сервер!!! Выполнение программы будет прекращено.");
            ex.printStackTrace(System.out);}

        //Благодарности :)
        System.out.println("\n************************** Cпасибо за использование нашей 'MultithreadedServer'!!! ************************");
    }
}
