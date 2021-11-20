package com.pb.dolgopolyj.hw8;

/**
 * Класс WrongLoginException, который обрабатывает ошибки ввода логина пользователя.
 */
public class WrongPasswordException extends RuntimeException
{
    //Это конструктор по умолчанию
    public WrongPasswordException() {
    }

    //Это конструктор, принимающий сообщение и передающий его в конструктор класса RuntimeException (дочерний от Exception)
    public WrongPasswordException(String message) {
        super(message);
    }
}
