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
    static private int readersNumber=0;

    //Создадим конструктор класса Reader
    public Reader ()
    {
        //Конструктор будет выполнять подсчет пользователей библиотеки,
        //т.е. при каждом новом обращении к нему он будет наращивать переменную readersNumber
        //и присваивать этот номер членскому билету читателя
        this.readersNumber+=1;
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
}
