package com.pb.dolgopolyj.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

/**
 * Класс - сервер, принимает запросы от клиентов и отдает данные
 */
public class Server {
    public static void main(String[] args) {
        // Определяем номер порта, который будет "слушать" сервер
        int port = 49153;

        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("***************************************************** Добрый день! ************************************************");
        System.out.println("*****************************************Вас приветствует программа 'Server'!!!************************************\n");
        System.out.println("Вместе с работой программ(ы) 'Client', она демонстрирует работу по обработке полученных данных в паре Клиент-Сервер");
        System.out.println("Данная программа работает в однопоточном режиме, для простой демонстрации работы сервера с данными из 'Client'\n");

        //Создаем объект класса Calendar для работы с датами
        Calendar calendar = null;

        try {
            // Открыть серверный сокет (ServerSocket)
            // Это специальный класс для сетевого взаимодействия с серверной стороны
            ServerSocket servSocket = new ServerSocket(port);

            // Входим в бесконечный цикл - ожидаем соединения
            while (true) {
                System.out.println("Сервер ожидает соединения с пользователем(и), используем порт:" + port);

                // Получив соединение начинаем работать с сокетом
                Socket fromClientSocket = servSocket.accept();

                // Работаем с потоками ввода-вывода
                try (Socket localSocket = fromClientSocket;
                     PrintWriter pw = new PrintWriter(localSocket.getOutputStream(), true);
                     BufferedReader br = new BufferedReader(new InputStreamReader(localSocket.getInputStream()))) {

                    // Читаем сообщения от клиента до тех пор пока он не скажет "exit"
                    String str;
                    while ((str = br.readLine()) != null) {
                        // Печатаем сообщение
                        System.out.println("Получено сообщение от пользователя: " + str);

                        // Сравниваем с "exit" и если это так - выходим из цикла
                        if (str.equals("exit"))
                        {
                            //Сообщаем, что пользователь завершил работу с сервером
                            System.out.println("Пользователь завершил работу с сервером");
                            //Посылаем сообщение пользователю о расставании с ним и выходим из цикла
                            pw.println("Bye!");
                            break;
                        }
                        else
                        {
                            // Посылаем клиенту ответ
                            calendar = Calendar.getInstance();
                            str = calendar.getTime()+" " + str;
                            System.out.println("Клиенту передан ответ: " + str);
                            pw.println(str);
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
