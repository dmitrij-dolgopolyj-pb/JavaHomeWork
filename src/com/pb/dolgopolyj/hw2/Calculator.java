package com.pb.dolgopolyj.hw2;
//Для взаимодействия с пользователем импортируем класс Scanner
import java.util.Scanner;


// Создаем класс Calculator
public class Calculator {


    //Инициализируем две необходимые по заданию целочисленные переменные operand1 и operand2
    static int operand1,operand2;

    public static void main(String[] args) {
    // Выводим на экран приветствие программы
    System.out.println("Добрый день! Это Ваш калькулятор");
    System.out.println("operand1="+operand1+" ; operand2="+operand2);
    // создаём объект класса Scanner для обработки ввода с клавиатуры
    Scanner in = new Scanner(System.in);
    // создаем строковую локальную переменную с именем usertext
    // и принимаем в нее ввод от пользователя
    String usertext = in.next();
    System.out.println("Добрый день! Это Ваш текст"+usertext);
    }
}
