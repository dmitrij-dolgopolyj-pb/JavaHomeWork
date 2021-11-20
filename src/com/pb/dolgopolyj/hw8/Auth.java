package com.pb.dolgopolyj.hw8;

//Для взаимодействия с пользователем импортируем класс Scanner
import java.util.Scanner;

/**
 * Класс Auth, который регистрирует пользователя на сайте.
 */
public class Auth
{
    //Объявляем переменные, отвечающие за логин и пароль пользователя
    private String login, password;

    //Метод, отвечающий за регистрацию на сайте
    public void signUp(String login, String password, String confirmPassword)
    {
        //Блок проверок правильности заполнения логина, пароля и контрольного пароля
        if (login.length()<5||login.length()>20||login.matches("[a-z||A-Z||0-9]+")==false)
            System.out.println("Неверный логин!");
        else
            {
                if (password.length()<5||password.matches("[a-z||A-Z||0-9||_]+")==false
                        ||password.equals(confirmPassword)==false) System.out.println("Неверный пароль!");
                else
                {
                    //Все проверки пройдены, присваиваем поля
                    this.setLogin(login);
                    this.setPassword(password);
                    System.out.println("Поздравляем, регистрация на 'OnlineShop' прошла успешно!!!");
                }
            }
    }

    //Метод, отвечающий за вход на сайт после регистрации
    public void signIn(String login, String password)
    {
        //Проверяем соответствие логина и пароля записанным в полях значениям
        if (this.login.equals(login)&&this.password.equals(password))
        {
            //Проверка не прошла, выбрасываем исключение WrongLoginException.
            System.out.println(login+"!\n Приветствуем Вас на сайте нашего магазина 'OnlineShop'!");
        }
        else
        {
            //Проверка не прошла, выбрасываем исключение WrongLoginException.
            System.out.println("Неверный логин/пароль!");
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
