//Создаваемая программа включается в пакет для выполнения Задания №2(hw2)
package com.pb.dolgopolyj.hw2;

//Для взаимодействия с пользователем импортируем класс Scanner
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

// Создаем класс Calculator
public class Calculator {

    // Объявляем и описываем главный метод класса Calculator
    public static void main(String[] args) {
    //Объявляем две необходимые по заданию целочисленные переменные operand1 и operand2
    int operand1,operand2;

    //Создаем строковую переменную для получения типа выполняемой операции
    String sign;
    //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
    Scanner in = new Scanner(System.in);

    //Выводим на экран приветствие программы и выполняемые ей действия
    System.out.println("Добрый день! \nЭто Ваш 'Калькулятор'");
    System.out.println("Им выполняется действие: переменная№1 'операция' переменная№2");
    //Cообщаем о типах выполняемых калькулятором операций
    System.out.println("Допустимы операции: +,-,*,/");

    //Запрашиваем ввод переменных для выполнения операции
    // с присвоением им введенных значений
    System.out.println("Введите переменную №1:");
    operand1=in.nextInt();
    System.out.println("Введите переменную №2:");
    operand2=in.nextInt();
    //Запрашиваем тип выполняемой операции и принимаем его в переменную sign
    System.out.println("Введите символ нужной операции:");
    sign = in.next();
    System.out.println("Вам необходима операция:"+operand1+sign+operand2);

    //Организовываем проверку операции деления на ноль
   if ((sign.equals("/")&&operand2==0)){
       //при попытке деления на ноль выводим сообщение о недопустимой операции
       System.out.println("Это недопустимая операция - деление на ноль \nВыполнение программы будет прекращено");
       }
   else {
       //если недопустимой операции нет, продолжаем выполнение программы

       //Объявляем и инициализируем переменную для хранения результата вычисления
       float caclcresult=0;
       //Объявляем и инициализируем переменную для результата корректности операции
       boolean correctoperation=true;

       //В зависимости от типа вычисления, получаем результат
       switch (sign.charAt(0)){

           case ('-'):
               caclcresult=operand1-operand2;
               break;
           case ('+'):
               caclcresult=operand1+operand2;
               break;
           case ('*'):
               caclcresult=operand1*operand2;
               break;
           case ('/'):
               caclcresult=operand1/operand2;
               break;

           default:
               //Если в знак операции введен некорректный символ, вычисления не проводим
               correctoperation=false;
       }

       if (correctoperation==true) {
           //Если операция корректна, отображаем ее результат
           System.out.println("Операция с переменными корректна");
           System.out.println("Результат операции:" + operand1 + sign + operand2+"="+caclcresult);
           }
       else {
           //Иначе сообщаем об ошибке
           System.out.println("Это некорректная операция \nВыполнение программы будет прекращено");
           }

       }

       //Благодарности :)
       System.out.println("*** Cпасибо, что используете программу 'Калькулятор' ***");
   }
}
