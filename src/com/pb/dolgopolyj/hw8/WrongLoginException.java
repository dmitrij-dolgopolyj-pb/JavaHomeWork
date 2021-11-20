package com.pb.dolgopolyj.hw8;

/**
 * Класс WrongLoginException, который обрабатывает ошибки ввода логина пользователя.
 */
public class WrongLoginException extends Exception
{

    //Это конструктор по умолчанию
    public WrongLoginException()
    {
    }

    //Это конструктор, принимающий сообщение и передающий его в конструктор класса Exception
    public WrongLoginException(String message) {
        super(message);
    }
}
