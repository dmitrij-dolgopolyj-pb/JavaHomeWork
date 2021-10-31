package com.pb.dolgopolyj.hw5;

/**
 * Класс, демонстрирующий работу классов Book и Reader
 */
public class Library {

    //Описываем метод, выводящий сообщение о попытке ввода некорректного значения
    static void printError() {
        System.out.println("Вы пытаетесь ввести некорректные данные");
    }

    public static void main(String[] args) {



        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nЭто класс 'Library'");
        System.out.println("Он демонстрирует работу классов Book и Reader");

        //Инициируем переменную для определения количества книг в библиотеке
        int numberOffBooks=5;
        //Инициализируем массив книг в библиотеке, то есть ссылок на объекты класса Book
        Book [] book = new Book[numberOffBooks];
        //Теперь инициализируем непосредственно сами "книги", то есть отдельные объекты класса Book
        for (int i=0;i<numberOffBooks;i++) book[i]= new Book();



       book[0].setBookName("Знакомьтесь: JAVA");
       book[0].setAuthorName("Аккуратов Е.Е.");
       book[0].setYearPublish(2009);
       book[1].setBookName("Блицкриг 1941");
       book[1].setAuthorName("Исаев А.В.");
       book[1].setYearPublish(2001);
       book[2].setBookName("Приключения");
       book[2].setAuthorName("Иванов И.И.");
       book[2].setYearPublish(2000);
       book[3].setBookName("Словарь");
       book[3].setAuthorName("Сидоров А.В.");
       book[3].setYearPublish(1980);
       book[4].setBookName("Энциклопедия");
       book[4].setAuthorName("Гусев К.В.");
       book[4].setYearPublish(2010);

        //Выводим на экран имеющиеся в библиотеке книги
        for (int i=0;i<book.length;i++) {
            System.out.println("Название книги:" + book[i].getBookName() + ", автор:" + book[i].getAuthorName() + ", год издания:" + book[i].getYearPublish());
        }

        //Благодарности :)
        System.out.println("*** Cпасибо за использование класса 'Library'! ***");
    }
}
