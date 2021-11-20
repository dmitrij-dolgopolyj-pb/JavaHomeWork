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
        answer=in.next();

        //Если пользователь согласен, проходим регистрацию на сайте
        if (answer.equals("да")) {
            //Печатаем правила регистрации
            System.out.println("Для регистрации на нашем сайте Вам необходимо ввести свой уникальный логин и пароль.");
            System.out.println("Длина логина должна быть от 5 до 20 символов, он может содержать только латинские буквы и цифры.\n");

            //Запросы ввода логина и пароля
            System.out.println("Введите логин:");
            login = in.next();
            System.out.println("Длина пароля должна быть более 5, он может содержать только латинские буквы и цифры и знак подчеркивания.\n");
            System.out.println("Введите пароль:");
            password = in.next();
            System.out.println("Введите пароль ещё раз:");
            confirmPassword = in.next();
            System.out.println("Вы ввели контрольный пароль:"+confirmPassword);

            //Пытаемся зарегистрировать пользователя и отловить исключения, если это не удалось
            try
            {
                newAuth.signUp(login, password, confirmPassword);
                //Если регистрация успешна, предлагаем пользователю переход на сайт
                System.out.println("Поздравляем, регистрация на 'OnlineShop' прошла успешно!!!");
                System.out.println("На сайте зарегистрирован новый пользователь,"+newAuth.getLogin()+"!\n");
                System.out.println("Вы хотите сразу войти на наш сайт? Если согласны, введите 'да':");
                answer=in.next();

                //Если пользователь согласен, переходим на сайт
                if (answer.equals("да"))
                {
                    try
                    {
                        //Запросы ввода логина и пароля
                        System.out.println("Введите логин:");
                        login = in.next();
                        System.out.println("Введите пароль:");
                        password = in.next();
                        //Вход на сайт
                        newAuth.signIn(login,password);
                    }
                    catch (WrongLoginException e)
                    {
                        //Сообщаем причину отказа доступа на сайт
                        System.out.println("Вход на сайт невозможен!");
                        System.out.println(e.getMessage());
                    }
                }
                else
                {
                    System.out.println("Ок, Вы можете посетить наш сайт в любое другое время. До встречи!");
                }

            }
            catch (WrongLoginException e)
            {
                //Сообщаем причину отказа регистрации
                System.out.println("Регистрация невозможна - Вы ввели неверный логин!");
                System.out.println(e.getMessage());
            }
            catch (WrongPasswordException e)
            {
                //Сообщаем причину отказа регистрации
                System.out.println("Регистрация невозможна - Вы ввели неверный пароль!");
                System.out.println(e.getMessage());
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
