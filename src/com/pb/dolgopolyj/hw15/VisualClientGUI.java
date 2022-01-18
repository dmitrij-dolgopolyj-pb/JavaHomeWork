package com.pb.dolgopolyj.hw15;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    //Определяем переменную-флаг соединения c cервером
    private static boolean connection;
    // Определяем номер порта, на котором нас ожидает сервер для ответа
    private static final int portNumber = 49153;

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
                connection=true;
                textField2.setText("Есть подключение к серверу!");
                textField3.setText("Введите сообщение->");
                textField4.setEnabled(true);
                textField5.setText("Ответ сервера->");
                textField5.setEnabled(true);
                textField6.setEnabled(true);
                buttonSendMessage.setEnabled(true);
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
                ////Далее обрабатываем событие - нажатия кнопки отправки на сервер сообщения
                textField6.setText(textField4.getText());
                textField4.setText("");
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
