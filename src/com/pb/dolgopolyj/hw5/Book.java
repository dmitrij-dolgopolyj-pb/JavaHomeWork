package com.pb.dolgopolyj.hw5;

/**
 * Класс, описывающий книгу
 * String bookName - название книги
 * String authorName - автор книги
 * int yearPublish - год издания книги
 */
public class Book {
    private String bookName;
    private String authorName;
    private int yearPublish;

    //Описываем блок "cеттеров"
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setBookName (String bookName){
       this.bookName=bookName;
    }

    //Используем метод setYearPublish для проверки ввода некорректного - например,отрицательного, значения года
    public void setYearPublish (int yearPublish){
        if (yearPublish<0) {
            Library.printError();
            return;
        }
        else this.yearPublish=yearPublish;
    }

    //Блок "геттеров" сгенерирован в среде разработки автоматически:
    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getYearPublish() {
        return yearPublish;
    }
}
