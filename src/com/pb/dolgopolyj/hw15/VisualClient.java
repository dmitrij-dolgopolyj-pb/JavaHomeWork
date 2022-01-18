package com.pb.dolgopolyj.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Класс VisualClient, который организовывает работу Клиент-Сервер, реализуя для пользователя работу
 * с сервером через графический интерфейс
 */

public class VisualClient {

    static private JLabel mylabel, mylabel2;

    public static void main(String[] args) {
        JFrame myWindow = new JFrame("VisualClient");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setSize(400, 300);

        myWindow.setLayout(new FlowLayout());

        String messages="->";

        mylabel = new JLabel(messages);
        mylabel.setFont(new Font("Serif", Font.BOLD, 14));
        mylabel.setBounds(20, 20, 60, 25);

        mylabel2 = new JLabel(messages);
        mylabel2.setFont(new Font("Serif", Font.BOLD, 14));
        mylabel2.setBounds(20, 20, 60, 25);

        JButton jButtonHi = new JButton("Привет!");
        JButton jButtonBye = new JButton("Пока!");

        jButtonHi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null,"Привет","Нажато",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        jButtonBye.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null,"Пора выходить из программы?","Выход из программы",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        myWindow.add(jButtonBye, BorderLayout.NORTH);
        messages+="Дима делает программу.\n";
        mylabel.setText(messages);
        myWindow.add(mylabel, BorderLayout.SOUTH);
        //myWindow.add(mylabel);
        //myWindow.add(jButtonHi);

        myWindow.add(mylabel2, BorderLayout.SOUTH);

        myWindow.setVisible(true);
        messages+="Дедис помогает делать программу\n";
        mylabel2.setText(messages);
        messages=mylabel.getText()+"плюс действие";
        mylabel.setText(messages);

    }
}
