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
        //Cоздаём объект класса Auth
        Auth newAuth = new Auth();

        //Объявляем переменную, отвечающую за ответы пользователя
        String answer;
        //Объявляем переменные, отвечающие за логин, пароль и контрольный пароль пользователя
        String login, password, confirmPassword;

        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nВас приветствует наш 'OnlineShop'!!!");
        System.out.println("Мы предлагаем Вам зарегистрироваться и посетить сайт нашего онлайн магазина.");
        System.out.println("Если Вы согласны пройти регистрацию, введите 'да':");

        //После тестирования раскоментить и убрать присваивание
        //answer=in.next();
        answer="да";


        //Если пользователь согласен, проходим регистрацию на сайте
        if (answer.equals("да"))
        {
            //Печатаем правила регистрации
            System.out.println("Для регистрации на нашем сайте Вам необходимо ввести свой уникальный логин и пароль.");
            System.out.println("Длина логина должна быть от 5 до 20 символов, он может содержать только латинские буквы и цифры.\n");

            //Запросы ввода логина и пароля
//            System.out.println("Введите логин:");
//            login = in.next();
//            System.out.println("Вы ввели логин:"+login);
//
//            System.out.println("Длина пароля должна быть более 5, он может содержать только латинские буквы и цифры и знак подчеркивания.\n");
//            System.out.println("Введите пароль:");
//            password = in.next();
//            System.out.println("Вы ввели пароль:"+password);
//
//            System.out.println("Введите пароль ещё раз:");
//            confirmPassword = in.next();
//            System.out.println("Вы ввели контрольный пароль:"+confirmPassword);

            //Для упрощения тестирования здесь статичные значения полей;
            login="Dmitry";password="dedis_2016";confirmPassword="dedis_2016";


            //Здесь позже нужно создать try и catch для (signUp)
            newAuth.signUp(login,password,confirmPassword);

            System.out.println("На сайте зарегистрирован новый пользователь!\n");
            System.out.println("Его логин:"+newAuth.getLogin()+", пароль:"+newAuth.getPassword()+"\n");

            System.out.println("Вы хотите сразу войти на наш сайт? Если согласны, введите 'да':");
            //После тестирования раскоментить и убрать присваивание
            //answer=in.next();
            answer="да";

            //Если пользователь согласен, проходим регистрацию на сайте
            if (answer.equals("да"))
            {
                //Здесь позже нужно создать try и catch для (signIn)
                //newAuth.signIn("Дмитрий","dedis2016");
            }
            else
            {
                System.out.println("Ок, Вы можете посетить наш сайт в любое другое время. До встречи!");
            }

        }
        //иначе заканчиваем диалог
        else
        {
            System.out.println("Жаль, что Вы пока не готовы зайти к нам! Ждем Вас в будущем!");
        }

        //Благодарности :)
        System.out.println("\n*** Cпасибо за посещение нашего 'OnlineShop'!!! ***");
    }
}
