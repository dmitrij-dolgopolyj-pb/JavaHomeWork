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
    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException
    {
        //Блок проверок правильности заполнения логина, пароля и контрольного пароля
        if (login.length()<5||login.length()>20)
        {
            throw new WrongLoginException("Число символов логина не соответствует требованиям.");
        }
        else
        {
            if (login.matches("[a-z||A-Z||0-9]+") == false) throw new WrongLoginException("Недопустимые символы в логине.");
            else
            {
                if (password.length() < 5) throw new WrongPasswordException("Количество символов в пароле должно быть не менее пяти.");
                else
                    {
                        //Можно написать регулярное выражение так, что и не потребуется до этого и проверка от 5 до 20
                        //"[a-zA-Z0-9_]{5,20}" или для пароля:"[a-zA-Z0-9_]{5,}"
                    if (password.matches("[a-z||A-Z||0-9||_]+") == false) throw new WrongPasswordException("Недопустимые символы в пароле.");
                    else
                    {
                        if (password.equals(confirmPassword) == false) throw new WrongPasswordException("Несоответствие пароля и контрольного пароля.");
                        else
                        {
                            //Все проверки пройдены, присваиваем поля
                            this.setLogin(login);
                            this.setPassword(password);
                        }
                    }
                }
            }
        }
    }

    //Метод, отвечающий за вход на сайт после регистрации
    public void signIn(String login, String password) throws WrongLoginException
    {
        //Проверяем соответствие логина и пароля записанным в полях значениям
        if (this.login.equals(login)&&this.password.equals(password))
        {
            //Проверка прошла успешно, пользователь зашел на сайт
            System.out.println(login+"!\n Приветствуем Вас на сайте нашего магазина 'OnlineShop'!");
        }
        else
        {
            //Проверка не прошла, выбрасываем исключение WrongLoginException.
            throw new WrongLoginException("Вы ввели неверный логин/пароль");
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
