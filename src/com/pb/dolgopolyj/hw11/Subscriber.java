package com.pb.dolgopolyj.hw11;

//Импортируем для работы с датами дополнительные библиотеки
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Класс Subscriber, который организовывает работу по хранинию и обработке данных
 * одного абонента из телефонной книгой.
 */
public class Subscriber
{
    //Описывем поля нашего класса

    //Фамилия, имя и отчество
    private String fio;
    //Дата рождения
    private Date dateBirth;
    //Телефон абонента
    private List<String> phoneNumber;
    //Адрес абонента
    private String address;
    //Дата и время создания записи/ее модификации
    private Date dateIni;

    //Конструктор класса
    public Subscriber(String fio, Date dateBirth, List phoneNumber, String address)
    {
        this.fio = fio;
        this.dateBirth = dateBirth;
        this.phoneNumber= phoneNumber;
        this.address = address;
        //Используя Calendar и Date cохраняем дату и время записи данных абонента
        Calendar calendar = Calendar.getInstance();
        this.dateIni = calendar.getTime();
    }

    //Блок геттеров и сеттеров
    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateIni(Date dateIni) {
        this.dateIni = dateIni;
    }

    public String getFio() {
        return fio;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateIni() {
        return dateIni;
    }

    //Создадим метод, выводящий на экран всю информацию об абоненте
    void subscriberInfo()
    {
        System.out.println("Ф.И.О.- "+this.fio);
        System.out.println("Дата рождения - "+this.dateBirth);
        int i=0;
        for (String p: phoneNumber)
        {
            i++;
            System.out.println("Телефон №"+i+":"+p);
        }
        System.out.println("Адрес:"+this.address);
        System.out.println("Дата создания/модификации данных абонента:"+this.dateIni);
    }
}
