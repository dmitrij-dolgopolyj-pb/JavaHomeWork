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

        //Инициализируем логические переменные для установки "флагов" корректности логина и пароля
        boolean loginCorrect=true;
        boolean passwordCorrect=true;
        //Для организации необходимых проверок переведем строки login, password в строковые массивы
        char [] loginArray=login.toCharArray();
        char [] passwordArray=password.toCharArray();

        //Блок проверок правильности заполнения логина, пароля и контрольного пароля
        if (loginArray.length<5||loginArray.length>20) loginCorrect=false;
        else
            {
                if (passwordArray.length<5) passwordCorrect=false;
                else
                    {
                        if (password.equals(confirmPassword)==false) passwordCorrect=false;
                        else
                        {
                            //Проверяем логин и пароль на наличие "посторонних" символов
                        }
                    }
            }


        if (loginCorrect==true&&passwordCorrect==true)
        {
        //Все проверки пройдены, присваиваем поля
        this.setLogin(login);
        this.setPassword(password);
        System.out.println("Поздравляем, регистрация на 'OnlineShop' прошла успешно!!!");
        }
        else
        {
        //Иначе, вызываем исключения
            if (loginCorrect==false)
            {
                //вызываем исключение WrongLoginException
                System.out.println("Неверный логин!");
            }
            else
            {
                //вызываем исключение WrongPasswordException
                System.out.println("Неверный пароль!");
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
