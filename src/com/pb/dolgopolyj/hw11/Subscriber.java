package com.pb.dolgopolyj.hw11;

//Импортируем для работы с датами дополнительные библиотеки
import java.io.Serializable;
import java.util.*;

/**
 * Класс Subscriber, который организовывает работу по хранинию и обработке данных
 * одного абонента из телефонной книгой.
 */
public class Subscriber implements Serializable
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

    public List<String> getPhoneNumber() { return phoneNumber;}

    public String getAddress() {
        return address;
    }

    public Date getDateIni() {
        return dateIni;
    }

    //Создадим метод, выводящий на экран всю информацию об абоненте
    public static void subscriberInfo(Subscriber subs)
    {
        System.out.println("Ф.И.О.- "+subs.fio);
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

    //Создадим метод для ручного ввода нового телефона абонента
    public static String inputNewPhoneNumber()
    {
        //Объявляем нужные для работы строковые переменные
        String newPhoneNumber, inString;
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);
        //С помощью регулярных выражений ограничиваем необходимые параметры ввода номера
        inString="";
        while (inString.matches("[0-9]{3,3}") == false)
        {
            System.out.print("Введите первые три цифры номера:");
            inString = in.next();
        }
        //Далее из полученных вводимых цифр "соберем" нужный номер телефона в формате +...-..-...-....
        newPhoneNumber = "+"+inString;
        inString="";
        while (inString.matches("[0-9]{2,2}") == false)
        {
            System.out.print("Введите следующие две цифры номера:");
            inString = in.next();
        }
        newPhoneNumber = newPhoneNumber+"-"+inString;
        inString="";
        while (inString.matches("[0-9]{3,3}") == false)
        {
            System.out.print("Введите следующие три цифры номера:");
            inString = in.next();
        }
        newPhoneNumber = newPhoneNumber+"-"+inString;
        while (inString.matches("[0-9]{4,4}") == false)
        {
            System.out.print("Введите последние четыре цифры номера:");
            inString = in.next();
        }
        newPhoneNumber = newPhoneNumber+"-"+inString;
        //Возвращаем полученный телефонный номер
        return newPhoneNumber;
    }

    //Создадим метод, редактирущий информацию об абоненте (в случае проведения редактирования возвращает "true")
    public static boolean subscriberEdit(Subscriber subs)
    {
        //Инициализируем переменную-флаг, отвечающую за какое-либо изменение данных абонента
        boolean isEdit=false;
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры и переменную inString для обработки запросов
        Scanner in = new Scanner(System.in);
        String inString;
        //Создаем объект класса Calendar для работы с датами
        Calendar calendar = null;
        //Организовываем диалог с пользователем и изменяем нужные ему данные в полях абонента
        System.out.println("Ф.И.О.- "+subs.fio);
        System.out.println("Редактируем Ф.И.О.? Введите 'да' или любой другой символ,если нет");
        inString = in.next();
        if (inString.equals("да"))
            {
                inString="";
                System.out.print("Введите фамилию абонента:");
                inString += in.next()+" ";
                System.out.print("Введите имя абонента:");
                inString+= in.next()+" ";
                System.out.print("Введите отчество абонента:");
                inString+= in.next();
                subs.setFio(inString);
                isEdit=true;
            }
        System.out.println("Дата рождения - "+subs.dateBirth);
        System.out.println("Редактируем дату рождения абонента? Введите 'да' или любой другой символ,если нет");
        inString = in.next();
        if (inString.equals("да"))
        {
            int year, month, date;
            System.out.print("Введите год рождения абонента:");
            year= Integer.parseInt(in.next());
            System.out.print("Введите месяц рождения абонента(1-12):");
            month= Integer.parseInt(in.next());
            System.out.print("Введите день рождения абонента(1-31):");
            date= Integer.parseInt(in.next());
            calendar = Calendar.getInstance();
            calendar.set(year, (month-1), date,0,0,0);
            subs.setDateBirth(calendar.getTime());
            isEdit=true;
        }

        for (int i=0;i<subs.phoneNumber.size();i++)
        {
            System.out.println("Телефон №"+(i+1)+":"+subs.phoneNumber.get(i));
            System.out.println("'1'-редактировать этот номер телефона;'2'-удалить этот номер;'3'-пропустить этот шаг");
            inString="";
            while (inString.equals("1")==false&&inString.equals("2")==false&&inString.equals("3")==false)
            {
                inString = in.next();
                if (inString.equals("1"))
                {
                    //Вызываем метод ввода нового номера телефона и перезаписываем его в нужный элемент списка телефонов
                    subs.phoneNumber.set(i,inputNewPhoneNumber());
                    System.out.println("Добавлен новый телефон абонента:"+subs.phoneNumber.get(i));
                    isEdit=true;
                    //Переходим на следующий шаг
                    inString="3";
                }
                else
                {
                    if (inString.equals("2"))
                        {
                            System.out.println("Этот номер телефона будет удален!\n" +
                                    "Вы уверены('да' - удалить без возможности восстановления)?");
                            inString = in.next();
                            //Если пользователь подтвердил действие, проводим удаление
                            if (inString.equals("да")) subs.phoneNumber.remove(i);
                            i=i-1;
                            isEdit=true;
                            System.out.println("Номер телефона удален!");
                            //Переходим на следующий шаг
                            inString="3";
                        }
                    if (inString.equals("3")==false)
                    {
                        System.out.println("Повторите ввод!('1','2'или'3')");
                    }
                }
            }
        }
        //Если пользователь хочет ввести дополнительный телефон, даем ему такую возможность
        inString ="да";
        while (inString.equals("да")==true)
        {
            System.out.println("Добавить ещё один номер телефона? Введите 'да' или любой другой символ,если нет");
            inString = in.next();
            if (inString.equals("да"))
                {
                    subs.phoneNumber.add(inputNewPhoneNumber());
                    System.out.println("Добавлен новый телефон абонента:"+subs.phoneNumber.get((subs.phoneNumber.size()-1)));
                    isEdit=true;
                }

        }
        //Если пользователь хочет изменить адрес абонента, даем ему такую возможность
        System.out.println("Адрес:"+subs.address);
        System.out.println("Редактируем адрес абонента? Введите 'да' или любой другой символ,если нет");
        inString = in.next();
        if (inString.equals("да"))
        {
            //Поскольку название города и/или улицы может содержать несколько слов, нужно применить построковый ввод
            in.nextLine();
            inString="г.";
            System.out.print("Введите город проживания абонента:");
            inString += in.nextLine()+", ул.";
            //Поскольку название города и/или улицы может содержать несколько слов, разде
            System.out.print("Введите улицу проживания абонента:");
            inString+= in.nextLine()+", д.";
            System.out.print("Введите дом/квартиру проживания абонента:");
            inString+= in.next();
            subs.setAddress(inString);
            isEdit=true;
        }
        //Если произошло редактирование данных абонента, обновляем поле даты и времени модификации записи абонента
        if (isEdit==true)
        {
            calendar = Calendar.getInstance();
            subs.setDateIni(calendar.getTime());
        }

        return isEdit;
    }

    //Создадим метод, организовывающий ввод пользователем нового абонента
    public static Subscriber subscriberNew()
    {
        System.out.println("\nСейчас мы добавим в нашу телефонную книгу нового абонента!");
        //Объявляем переменные - будущие поля для нашего абонента
        //Фамилия, имя и отчество
        String fio;
        //Дата рождения
        Date dateBirth;
        //Телефон абонента
        List<String> phoneNumber=new ArrayList<>();
        //Адрес абонента
        String address;
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры и переменную inString для обработки запросов
        Scanner in = new Scanner(System.in);
        String inString;
        //Создаем объект класса Calendar для работы с датами
        Calendar calendar = null;
        //Организовываем диалог с пользователем и получаем данные для полей абонента
        fio="";
        System.out.print("Введите фамилию абонента:");
        fio += in.next()+" ";
        System.out.print("Введите имя абонента:");
        fio+= in.next()+" ";
        System.out.print("Введите отчество абонента:");
        fio+= in.next();

        int year, month, date;
        System.out.print("Введите год рождения абонента:");
        year= Integer.parseInt(in.next());
        System.out.print("Введите месяц рождения абонента(1-12):");
        month= Integer.parseInt(in.next());
        System.out.print("Введите день рождения абонента(1-31):");
        date= Integer.parseInt(in.next());
        calendar = Calendar.getInstance();
        calendar.set(year, (month-1), date,0,0,0);
        dateBirth=calendar.getTime();

        //Предлагаем пользователю ввести номер(а) телефона(ов) абонента
        inString ="да";
        while (inString.equals("да")==true)
        {
            System.out.println("Если хотите добавить номер телефона абонента, введите 'да' или любой другой символ,если нет");
            inString = in.next();
            if (inString.equals("да"))
            {
                phoneNumber.add(inputNewPhoneNumber());
                System.out.println("Добавлен новый телефон абонента:"+phoneNumber.get((phoneNumber.size()-1)));
            }
        }
        //Поскольку название города и/или улицы может содержать несколько слов, нужно применить построковый ввод
        in.nextLine();
        address="г.";
        System.out.print("Введите город проживания абонента:");
        address += in.nextLine()+", ул.";
        //Поскольку название города и/или улицы может содержать несколько слов, разде
        System.out.print("Введите улицу проживания абонента:");
        address+= in.nextLine()+", д.";
        System.out.print("Введите дом/квартиру проживания абонента:");
        address+= in.next();
        //Вызываем конструктор объекта
        Subscriber subs= new Subscriber(fio, dateBirth, phoneNumber, address);
        //Возвращаем созданный объект
        return subs;
    }
}
