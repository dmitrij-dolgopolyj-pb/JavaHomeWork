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
        //Проверяем правильность заполнения логина, пароля и контрольного пароля

        //Присваиваем поля
        this.setLogin(login);
        this.setPassword(password);
        System.out.println("Поздравляем, регистрация на 'OnlineShop' прошла успешно!!!");
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
