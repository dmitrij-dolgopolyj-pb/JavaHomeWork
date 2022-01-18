package com.pb.dolgopolyj.hw15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Класс - сервер, принимает запросы от клиентов и отдает данные в многопоточном режиме
 */

public class ServerMultiThread
{

    //Объявляем класс SharedServer, который наследует класс Runnable для многопоточной обработки пользовательских запросов
    static class SharedServer implements Runnable {
        private final Socket socket;

        public SharedServer(Socket socket) {
            this.socket = socket;
        }

        //Переопределяем метод run для работы с клиентом
        @Override
        public void run()
        {
            //Создаем объект класса Calendar для работы с датами
            Calendar calendar = null;
            System.out.println(Thread.currentThread().getName() + ": Получен запрос от клиента");
            // Работаем с потоками ввода-вывода
            try (Socket localSocket = socket;
                 PrintWriter pw = new PrintWriter(localSocket.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(localSocket.getInputStream()))) {

                // Читаем сообщения от клиента до тех пор пока он не скажет "exit"
                String str;
                while ((str = br.readLine()) != null) {
                    // Печатаем сообщение
                    System.out.println("Cообщение от пользователя("+Thread.currentThread().getName()+"): " + str);

                    // Сравниваем с "exit" и если это так - выходим из цикла
                    if (str.equals("exit"))
                    {
                        //Сообщаем, что пользователь завершил работу с сервером
                        System.out.println("Пользователь("+Thread.currentThread().getName()+") завершил работу с сервером");
                        //Посылаем сообщение пользователю о расставании с ним и выходим из цикла
                        pw.println("Bye!");
                        break;
                    }
                    else
                    {
                        // Посылаем клиенту ответ
                        calendar = Calendar.getInstance();
                        str = calendar.getTime()+" " + str;
                        System.out.println("Клиенту("+Thread.currentThread().getName()+") передан ответ: " + str);
                        pw.println(str);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }

        public static void main(String[] args) throws Exception {
            //Выводим на экран приветствие программы и выполняемые ей действия
            System.out.println("***************************************************** Добрый день! ************************************************");
            System.out.println("*************************************Вас приветствует программа 'ServerMultiThread'!!!************************************\n");
            System.out.println("Вместе с работой программ(ы) 'Client', она демонстрирует работу по обработке полученных данных в паре Клиент-Сервер");
            System.out.println("Программа работает в многопоточном режиме (до 10 потоков), для демонстрации работы сервера с несколькими клиентами\n");

            int port = 49153;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Сервер ожидает соединения с пользователем(и), используем порт:" + port);
            ExecutorService threadPool = Executors.newFixedThreadPool(10);

            // В цикле ждем запроса клиента
            while (true)
            {
                Socket clientSocket = serverSocket.accept();
                threadPool.submit(new SharedServer(clientSocket));
            }
        }
    }
}
