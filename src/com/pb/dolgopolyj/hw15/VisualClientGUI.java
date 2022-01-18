package com.pb.dolgopolyj.hw15;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Класс VisualClientGUI, который организовывает работу Клиент-Сервер
 * с помощью графического интерфейса
 */

public class VisualClientGUI {
    //Определение переменных графического интерфейса
    private JPanel VisualClientField;
    private JTextField textField1;
    private JButton button1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton buttonSendMessage;
    private JTextField textField5;
    private JTextField textField6;
    private JButton buttonExitConnect;
    //Определяем переменную-флаг соединения c cервером
    private static boolean connection;
    // Определяем номер порта, на котором нас ожидает сервер для ответа
    private static final int portNumber = 49153;
    // Объявляем сокет для обращения к локальному компьютеру
    private static Socket socket;
    // Объявляем переменные для буфера чтения и записи;
    private static BufferedReader br;
    private static PrintWriter pw;

    public VisualClientGUI() {
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Далее обрабатываем событие - нажатия кнопки соединения с сервером
                //Здесь как-то организовать защиту от повторного подключения
                if (connection==false)
                {
                    try
                    {
                        // Открыть сокет (Socket) для обращения к локальному компьютеру
                        socket = new Socket("127.0.0.1", portNumber);
                        // Создать поток для чтения символов из сокета
                        // Для этого надо открыть поток сокета - socket.getInputStream()
                        // Потом преобразовать его в поток символов - new InputStreamReader
                        // И уже потом сделать его читателем строк - BufferedReader
                        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        // Создать поток для записи символов в сокет
                        pw = new PrintWriter(socket.getOutputStream(), true);
                        //Оповещаем пользователя о подключении и активируем все графические элементы
                        connection=true;
                        textField2.setText("Есть подключение к серверу! host:127.0.0.1,port:" + portNumber);
                        textField3.setText("Введите сообщение->");
                        textField4.setEnabled(true);
                        textField5.setText("Ответ сервера->");
                        textField5.setEnabled(true);
                        textField6.setEnabled(true);
                        buttonSendMessage.setEnabled(true);
                        buttonExitConnect.setEnabled(true);
                    }
                    catch (IOException ex)
                    {
                        System.out.println("Ошибка подключения! Проверьте, запущен ли сервер!!!");
                        ex.printStackTrace(System.out);
                    }
                }
                else
                {
                    textField2.setText("Соединение с сервером уже установлено!");
                }
            }
        });
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        buttonSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Далее обрабатываем событие - нажатия кнопки отправки на сервер сообщения
                // Отправляем строку из поля ввода сообщения в сокет
                pw.println(textField4.getText());
                //Очищаем поле ввода сообщения
                textField4.setText("");
                //Инициализируем строковую переменную для получения ответа сервера
                String serverAnswer;
                // Входим в цикл чтения, что нам ответил сервер
                try
                {
                    while ((serverAnswer = br.readLine()) != null) {
                        // Печатаем ответ от сервера и прерываем цикл
                        textField6.setText(serverAnswer);
                        break;
                    }
                }
                catch (IOException ex)
                {
                    System.out.println("Ошибка получения данных от сервера!");
                    ex.printStackTrace(System.out);
                }
            }
        });
        buttonExitConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Далее обрабатываем событие - нажатия кнопки завершения сеанса
                try {
                    //Закрываем потоки и освобождаем все используемые ресурсы
                    br.close();
                    pw.close();
                    socket.close();
                    textField2.setText("");
                    textField3.setText("");
                    textField5.setText("");
                    textField4.setText("");
                    textField6.setText("");
                    textField4.setEnabled(false);
                    textField5.setEnabled(false);
                    textField6.setEnabled(false);
                    buttonSendMessage.setEnabled(false);
                    buttonExitConnect.setEnabled(false);
                    connection=false;
                }
                catch (IOException ex)
                {
                    System.out.println("Ошибка закрытия потоков связи с сервером!");
                    ex.printStackTrace(System.out);
                }
            }
        });
    }

    public static void main(String[] args)
    {
        //Устанавливаем флаг соединения
        connection=false;
        JFrame frame = new JFrame("VisualClientGUI");
        frame.setContentPane(new VisualClientGUI().VisualClientField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        // Определяем номер порта, на котором нас ожидает сервер для ответа
        int portNumber = 49153;

    }
}
