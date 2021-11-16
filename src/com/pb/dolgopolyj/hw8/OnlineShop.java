package com.pb.dolgopolyj.hw8;

//Для взаимодействия с пользователем импортируем класс Scanner
import java.util.Scanner;

/**
 * Класс OnlineShop, который предлагает пользователю регистрацию и посещение сайта онлайн-магазина.
 */
public class OnlineShop
{
    public static void main(String[] args)
    {

        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);

        //Объявляем переменную, отвечающую за ответы пользователя
        String answer;
        //Объявляем переменные, отвечающие за логин, пароль и контрольный пароль пользователя
        String login, password, confirmPassword;

        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nВас приветствует наш 'OnlineShop'!!!");
        System.out.println("Мы предлагаем Вам зарегистрироваться и посетить сайт нашего онлайн магазина.");
        System.out.println("Если Вы согласны пройти регистрацию, введите 'да':");
        answer=in.next();

        //Если пользователь согласен, проходим регистрацию на сайте
        if (answer.equals("да"))
        {
            //Печатаем правила регистрации
            System.out.println("Для регистрации на нашем сайте Вам необходимо ввести свой уникальный логин и пароль.");
            System.out.println("Длина логина должна быть от 5 до 20 символов, он должен содержать только латинские буквы и цифры.\n");

            //Запросы ввода логина и пароля
            System.out.println("Введите логин:");
            login = in.next();
            System.out.println("Вы ввели логин:"+login);

            System.out.println("Введите пароль:");
            password = in.next();
            System.out.println("Вы ввели пароль:"+password);

            System.out.println("Введите пароль ещё раз:");
            confirmPassword = in.next();
            System.out.println("Вы ввели контрольный пароль:"+confirmPassword);

            Auth newAuth = new Auth();
            newAuth.signUp(login,password,confirmPassword);

            System.out.println("На сайте зарегистрирован новый пользователь!\n");
            System.out.println("Его логин:"+newAuth.getLogin()+", пароль:"+newAuth.getPassword()+"\n");
        }
        //иначе заканчиваем диалог
        else
        {
            System.out.println("Жаль, что Вы не пока не готовы зайти к нам! Ждем Вас в будущем!");
        }

        //Благодарности :)
        System.out.println("\n*** Cпасибо за посещение нашего 'OnlineShop'!!! ***");
    }
}
