package com.pb.dolgopolyj.hw5;

/**
 * Класс, описывающий пользователя библиотеки
 * String userName - Ф.И.О.
 * String facultyName - факультет
 * String birthDate - дата рождения
 * String telephonNumber - номер телефона
 * int ticketNumber - номер читательского билета
 */
public class Reader {
    private String userName;
    private String facultyName;
    private String birthDate;
    private String telephonNumber;
    private int ticketNumber;
    //Объявляем и инициализируем статичную переменную, которая будет отвечать за количество читателей
    static private int readersNumber=0;

    //Создадим конструктор класса Reader
    public Reader ()
    {
        //Конструктор будет выполнять подсчет пользователей библиотеки,
        //т.е. при каждом новом обращении к нему он будет наращивать переменную readersNumber
        //и присваивать этот номер членскому билету читателя
        readersNumber+=1;
        ticketNumber=readersNumber;
    }

    //Блок "геттеров" сгенерирован в среде разработки автоматически:
    public String getUserName() {
        return userName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getTelephonNumber() {
        return telephonNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    //Блок "сеттеров" сгенерирован в среде разработки автоматически:

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setTelephonNumber(String telephonNumber) {
        this.telephonNumber = telephonNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public static int getReadersNumber() {
        return readersNumber;
    }

    //Создаем требуемые по заданию методы
    //Выводим на консоль сообщение о количестве взятых читателем книг
    //Немного усложним задачу - метод получает не только кол-во взятых книг, но и Ф.И.О. читателя
    public static void takeBook (String readerName, int bookNumbers){
        System.out.println(readerName+" взял(а) "+bookNumbers+" книг(и)");
    }
    //Выводим на консоль сообщение о наименованиях взятых читателем книг
    public static void takeBook (String readerName, String [] bookNames){
        System.out.println(readerName+" взял(а) книги:");
        for (int i=0;i<bookNames.length;i++)
            System.out.print(bookNames[i]+";");
        System.out.println("\n");
    }
    //Выводим на консоль сообщение о взятых читателем книг (объектов класса Book)
    public static void takeBook (String readerName, Book [] book){
        System.out.println(readerName+" взял(а) книги:");
        for (int i=0;i<book.length;i++)
            System.out.print(book[i].getBookName()+"("+book[i].getAuthorName()+","+book[i].getYearPublish()+"г.);");
        System.out.println("\n");
    }

    //Теперь, аналогично, делаем перегруженные методы returnBook()
    public static void returnBook (String readerName, int bookNumbers){
        System.out.println(readerName+" вернул(а) "+bookNumbers+" книг(и)");
    }
    public static void returnBook (String readerName, String [] bookNames){
        System.out.println(readerName+" вернул(а) книги:");
        for (int i=0;i<bookNames.length;i++)
            System.out.print(bookNames[i]+";");
        System.out.println("\n");
    }
    public static void returnBook (String readerName, Book [] book){
        System.out.println(readerName+" вернул(а) книги:");
        for (int i=0;i<book.length;i++)
            System.out.print(book[i].getBookName()+"("+book[i].getAuthorName()+","+book[i].getYearPublish()+"г.);");
        System.out.println("\n");
    }
}
