package com.pb.dolgopolyj.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Класс Client, который организовывает работу Клиент-Сервер
 */
public class Client
{
    public static void main(String[] args) throws Exception
    {
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);
        //Cоздаём переменные для ввода строки с клавиатуры и обмена данных с сервером
        String inputString,str;
        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("******************************************** Добрый день! ********************************************");
        System.out.println("********************************Вас приветствует программа 'Client'!!!********************************\n");
        System.out.println("В паре с программой 'Server', она демонстрирует работу по передаче и обработке данных (Клиент-Сервер)");

        // Определяем номер порта, на котором нас ожидает сервер для ответа
        int portNumber = 49153;

        System.out.println("Подключение данного клиента к серверу будет осуществляться через порт:"+portNumber+"\n");
        System.out.println("ВАЖНО!!! Перед дальнейшей работой, убедитесь, что программа Server уже запущена!");
        System.out.println("В ее консоли должно появиться сообщение: Сервер ожидает соединения с пользователем(и), используем порт:"+portNumber);
        System.out.println("После получения сообщения о запуске клиента вы сможете вводить сообщения, которые будут отправлены на сервер");
        System.out.println("Для завершения работы с сервером необходимо будет отправить ему слово 'exit'");

            try {
                // Открыть сокет (Socket) для обращения к локальному компьютеру
                // Сервер мы будем запускать на этом же компьютере
                // Это специальный класс для сетевого взаимодействия c клиентской стороны
                Socket socket = new Socket("127.0.0.1", portNumber);
                // Пишем, что стартовали клиент
                System.out.println("Клиент запущен! (host:127.0.0.1,port:" + portNumber + ")");
                System.out.print("\nВведите строку для передачи серверу:");
                // Создать поток для чтения символов из сокета
                // Для этого надо открыть поток сокета - socket.getInputStream()
                // Потом преобразовать его в поток символов - new InputStreamReader
                // И уже потом сделать его читателем строк - BufferedReader
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // Создать поток для записи символов в сокет
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

                inputString ="";
                while (inputString.equals("exit")==false)
                {
                    //Ждем ввода cтроки пользователем
                    System.out.print("->");
                    inputString = in.nextLine();
                    // Отправляем полученную строку в сокет
                    pw.println(inputString);
                    // Входим в цикл чтения, что нам ответил сервер
                    while ((str = br.readLine()) != null)
                    {
                        // Печатаем ответ от сервера и прерываем цикл
                        System.out.println("Получен ответ сервера:" + str);
                        break;
                    }
                }
                //Если пользователь завершил сеанс, выводим соответствующее сообщение
                System.out.println("Пользователь завершил работу с сервером.");
                //Закрываем потоки и освобождаем все используемые ресурсы
                br.close();
                pw.close();
                socket.close();
                System.out.println("Cеанс связи с сервером успешно завершен!");
            }
            catch (IOException ex)
            {
                System.out.println("Ошибка подключения! Проверьте, запущен ли сервер!!! Выполнение программы будет прекращено.");
                ex.printStackTrace(System.out);
            }

        //Благодарности :)
        System.out.println("\n************************** Cпасибо за использование нашей программы 'Client'!!! ************************");
    }
}