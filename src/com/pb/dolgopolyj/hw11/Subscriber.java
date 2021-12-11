package com.pb.dolgopolyj.hw11;

//Импортируем для работы с датами дополнительные библиотеки
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
    public static void subscriberInfo(Subscriber subs)
    {
        System.out.println("\nФ.И.О.- "+subs.fio);
        System.out.println("Дата рождения - "+subs.dateBirth);
        int i=0;
        for (String p: subs.phoneNumber)
        {
            i++;
            System.out.println("Телефон №"+i+":"+p);
        }
        System.out.println("Адрес:"+subs.address);
        System.out.println("Дата создания/модификации данных абонента:"+subs.dateIni);
    }

    //Создадим метод, редактирущий информацию об абоненте
    public static void subscriberEdit(Subscriber subs)
    {
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры и переменную inString для обработки запросов
        Scanner in = new Scanner(System.in);
        String inString;
        //Создаем объект класса Calendar для работы с датами
        Calendar calendar = null;
        //Организовываем диалог с пользователем и изменяем нужные ему данные в полях абонента
        System.out.println("\nФ.И.О.- "+subs.fio);
        System.out.println("\nРедактируем Ф.И.О.? Введите 'да' или любой другой символ,если нет\n");
        inString = in.next();
        if (inString.equals("да"))
            {
                inString="";
                System.out.println("Введите фамилию абонента:");
                inString += in.next()+" ";
                System.out.println("Введите имя абонента:");
                inString+= in.next()+" ";
                System.out.println("Введите отчество абонента:");
                inString+= in.next();
                subs.setFio(inString);
            }
        System.out.println("Дата рождения - "+subs.dateBirth);
        System.out.println("\nРедактируем дату рождения абонента? Введите 'да' или любой другой символ,если нет\n");
        inString = in.next();
        if (inString.equals("да"))
        {
            int year, month, date;
            System.out.println("Введите год рождения абонента:");
            year= Integer.parseInt(in.next());
            System.out.println("Введите месяц рождения абонента(1-12):");
            month= Integer.parseInt(in.next());
            System.out.println("Введите день рождения абонента(1-31):");
            date= Integer.parseInt(in.next());
            calendar = Calendar.getInstance();
            calendar.set(year, (month-1), date,0,0,0);
            subs.setDateBirth(calendar.getTime());
        }
        int i=0;
        for (String p: subs.phoneNumber)
        {
            i++;
            System.out.println("Телефон №"+i+":"+p);
        }
        System.out.println("Адрес:"+subs.address);
        System.out.println("\nРедактируем адрес абонента? Введите 'да' или любой другой символ,если нет\n");
        inString = in.next();
        if (inString.equals("да"))
        {
            inString="г.";
            System.out.println("Введите город проживания абонента:");
            inString += in.next()+", ул.";
            System.out.println("Введите улицу проживания абонента:");
            inString+= in.next()+", д.";
            System.out.println("Введите дом/квартиру проживания абонента:");
            inString+= in.next();
            subs.setAddress(inString);
        }


        //Обновляем дату и время модификации записи абонента
        calendar = Calendar.getInstance();
        subs.setDateIni(calendar.getTime());
        System.out.println("Дата создания/модификации данных абонента:"+subs.dateIni);

        //Здесь нужно вызвать упорядочинивание???

    }

}
