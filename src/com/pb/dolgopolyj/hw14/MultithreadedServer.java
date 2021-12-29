package com.pb.dolgopolyj.hw14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Класс MultithreadedServer, который организовывает работу Клиент-Сервер
 */
public class MultithreadedServer
{
    public static void main(String[] args) throws Exception
    {
        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("**************************************** Добрый день! ********************************************\n");
        System.out.println("***********************Вас приветствует программа 'MultithreadedServer'!!!************************\n");
        System.out.println("Она демонстрирует работу по передаче и обработке данных в паре Клиент-Сервер");

        // Определяем номер порта, на котором нас ожидает сервер для ответа
        int portNumber = 49153;

        // Открыть сокет (Socket) для обращения к локальному компьютеру
        // Сервер мы будем запускать на этом же компьютере
        // Это специальный класс для сетевого взаимодействия c клиентской стороны
        Socket socket = new Socket("127.0.0.1", portNumber);

        // Пишем, что стартовали клиент
        System.out.println("Client is started");

        // Создать поток для чтения символов из сокета
        // Для этого надо открыть поток сокета - socket.getInputStream()
        // Потом преобразовать его в поток символов - new InputStreamReader
        // И уже потом сделать его читателем строк - BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Создать поток для записи символов в сокет
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

        // Отправляем тестовую строку в сокет
        pw.println("Тестовая строка для передачи");

        String str;
        // Входим в цикл чтения, что нам ответил сервер
        while ((str = br.readLine()) != null) {
            // Если пришел ответ “bye”, то заканчиваем цикл
            if (str.equals("bye")) {
                break;
            }
            // Печатаем ответ от сервера на консоль для проверки
            System.out.println(str);
            // Посылаем ему "bye" для окончания "разговора"
            pw.println("bye");
        }

        br.close();
        pw.close();
        socket.close();

        //Благодарности :)
        System.out.println("\n************************** Cпасибо за использование нашей 'MultithreadedServer'!!! ************************");
    }
}
