package com.pb.dolgopolyj.hw11;

//Импортируем для работы с датами дополнительные библиотеки
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Класс PhoneBook, который организовывает работу с телефонной книгой.
 */
public class PhoneBook extends Subscriber implements Serializable
{
    //Для организации сериалиазации объектов класса установим номер своей версии
    private final static long serialVersionUID = 75;

    public PhoneBook(String fio, Date dateBirth, List phoneNumber, String address)
    {
        super(fio, dateBirth, phoneNumber, address);
    }

    public static void main(String[] args) throws Exception
    {
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);
        //Назначаем флаги для выходов из меню
        boolean exit1,exit2;
        //Инициализирум два компаратора - один для сортировки по Ф.И.О.
        PersonFioComparator pcomp1 = new PersonFioComparator();
        //Второй для сортировки по адресам
        PersonAdressComparator pcomp2 = new PersonAdressComparator();
        //Инициализируем флаг, отвечающий за текущий порядок сортировки
        boolean isSortFio=true;
        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nВас приветствует 'PhoneBook'!!!");
        System.out.println("Вы сможете работать с нашей телефонной книгой в удобном для Вас режиме.");

        //Создаем объекты класса Subscriber (абонента телефонной книги)
        Calendar calendar = Calendar.getInstance();
        calendar.set(1975, 8, 8,0,0,0);
        Date dateBirth=calendar.getTime();

        List<String> phoneNumber = new ArrayList<>();
        phoneNumber.add("+380-50-883-9418");
        phoneNumber.add("+380-66-999-1234");
        phoneNumber.add("+380-93-888-5678");

        Subscriber subs1= new Subscriber("Долгополый Дмитрий Юрьевич", dateBirth, phoneNumber,
                "г.Краматорск, бул.Краматорский 2/262");

        calendar.set(1983, 6, 1,0,0,0);
        dateBirth=calendar.getTime();

        List<String> phoneNumber2 = new ArrayList<>();
        phoneNumber2.add("+380-99-044-6050");
        phoneNumber2.add("+380-63-222-4189");

        Subscriber subs2= new Subscriber("Буц Наталья Юрьевна", dateBirth, phoneNumber2,
                "г.Изюм, ул.Харьковская 35");

        calendar.set(1962, 3, 13,0,0,0);
        dateBirth=calendar.getTime();

        List<String> phoneNumber3 = new ArrayList<>();
        phoneNumber3.add("+359-89-843-3510");
        phoneNumber3.add("+359-23-666-4189");
        phoneNumber3.add("+359-59-555-1894");
        phoneNumber3.add("+359-13-444-4189");

        Subscriber subs3= new Subscriber("Баглаенко Виктория Николаевна", dateBirth, phoneNumber3,
                "г.Пловдив, ул.Горно Броди, 3/6");

        calendar.set(1953, 4, 19,0,0,0);
        dateBirth=calendar.getTime();

        List<String> phoneNumber4 = new ArrayList<>();
        phoneNumber4.add("+380-99-038-8753");

        Subscriber subs4= new Subscriber("Долгополый Юрий Петрович", dateBirth, phoneNumber4,
                "г.Изюм, ул.Рыночная, 8/76");

        //Создаем коллекцию для хранения в ней всех абонентов
        List<Subscriber> phoneBook = new ArrayList<>();
        //Загружаем телефонную книгу из файла
        //phoneBook=deserializationPhoneBook();
        phoneBook.add(subs1);
        phoneBook.add(subs2);
        phoneBook.add(subs3);
        phoneBook.add(subs4);

        //Cортируем коллекцию, в зависимости от текущей настройки флага сортировки
        if (isSortFio==true) phoneBook.sort(pcomp1);
        else phoneBook.sort(pcomp2);

        //Выводим краткую информацию обо всех абонентах телефонной книги
        //phoneBookShowShortInfo(phoneBook);

        //Выводим полную информацию обо всех абонентах телефонной книги
        phoneBookShowFullInfo(phoneBook);

        //Организовываем вывод основного меню

//        phoneBook.add(subscriberNew());
//        phoneBook.sort(pcomp);

        //FindSubscriber(phoneBook);


        //phoneBookShowInfo(phoneBook);

        //Сохраним нашу телефонную книгу в файл
        serializationPhoneBook(phoneBook);

        //Благодарности :)
        System.out.println("\n*** Cпасибо за использование нашей 'PhoneBook'!!! ***");

    }

    //Создадим метод, выводящий на экран краткую информацию обо всех абонентах, содержащихся в телефонной книге
    static void phoneBookShowShortInfo(List<Subscriber> phoneBook)
    {
        System.out.println("\nВ нашей телефонной книге хранится информация о следующих абонентах:");
        int i = 0;
        for (Subscriber p: phoneBook)
        {
          i+=1;
          System.out.println("№"+i+":"+p.getFio()+", тел."+p.getPhoneNumber().get(0)+"; адрес:"+p.getAddress());
        }
    }

    //Создадим метод, выводящий на экран полную информацию обо всех абонентах, содержащихся в телефонной книге
    static void phoneBookShowFullInfo(List<Subscriber> phoneBook)
    {
        System.out.println("\nВ нашей телефонной книге хранится информация о следующих абонентах:");
        int i = 0;
        for (Subscriber p: phoneBook)
        {
            i+=1;
            System.out.println("-------------------АБОНЕНТ №"+i+"----------------------------------------------------");
            subscriberInfo(p);;
            System.out.println("---------------------------------------------------------------------------------");
        }
    }

    //Создадим метод, выводящий на экран информацию об абонентах, содержащихся в телефонной книге.
    //При необходимости, метод позволяет внести изменения в данные абонента
    static void phoneBookInfoEdit(List<Subscriber> phoneBook,PersonFioComparator pcomp)
    {
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);
        //Назначаем флаги для выходов из меню
        boolean exit1,exit2;
        //Выводим информацию обо всех абонентах телефонной книги
        phoneBookShowShortInfo(phoneBook);
        //Запрашиваем, хочет ли пользователь просмотреть/изменить информацию об абоненте
        exit1=false;
        System.out.println("Что бы просмотреть/изменить информацию об абоненте, введите его номер, в противном случае введите любой другой символ");
        while (exit1==false)
        {
            String sign = in.next();
            if (sign.matches("[0-9]+") == true)
            {
                int a = Integer.parseInt(sign);
                if (a > phoneBook.size() || (a - 1) < 0) {
                    System.out.println("Выбрана операция по несуществующему абоненту!!!");
                } else {
                    System.out.println("Выбрана операция по абоненту №" + a);
                    subscriberInfo(phoneBook.get(a - 1));
                    System.out.println("\nЕсли хотите изменить/удалить информацию об абоненте, введите 'да',\n"
                            + "в противном случае любой другой символ");
                    sign = in.next();
                    if (sign.equals("да"))
                    {
                        //Назначаем флаг для выхода из меню
                        exit2 = false;
                        System.out.println("Что необходимо сделать?\n" +
                                "'1'-редактировать данные абонента;\n" +
                                "'2'-удалить данные этого абонента из телефонной книги\n" +
                                "'3'-выход из меню");
                        while (exit2 != true)
                        {
                            sign = in.next();
                            if (sign.equals("1"))
                            {
                                if (subscriberEdit(phoneBook.get(a - 1)) == true)
                                {
                                    System.out.println("Теперь данные этого абонента выглядят так:");
                                    subscriberInfo(phoneBook.get(a - 1));
                                    //Поскольку произошло редактирование какого-то абонента, пересортировываем
                                    // нашу телефонную книгу по текущему алгоритму и выходим
                                    phoneBook.sort(pcomp);
                                }
                                exit1=true;
                                exit2=true;
                            } else
                            {
                                if (sign.equals("2")) {
                                    System.out.println("Данные по абоненту будут удалены!\n" +
                                            "Вы уверены('да' - удалить без возможности восстановления)?");
                                    sign = in.next();
                                    //Если пользователь подтвердил действие, проводим удаление и выходим
                                    if (sign.equals("да")) {
                                        System.out.println("Данные по абоненту удалены!");
                                        phoneBook.remove((a - 1));
                                    }
                                    exit1=true;
                                    exit2=true;
                                } else
                                    {
                                        if (sign.equals("3"))
                                        { exit1=true; exit2=true;}
                                        else
                                        {
                                        System.out.println("Повторите ввод!('1','2' или '3')");
                                        }
                                    }
                            }
                        }
                    }
                    else
                    {
                        exit1 = true;
                    }
                }
            }
            else
            {
                exit1 = true;
            }
        }
    }

    //Создадим класс PersonFioComparator, для сортировки нашей коллекции объектов абонентов по полю Ф.И.О.
    static class PersonFioComparator implements Comparator<Subscriber> {

        public int compare(Subscriber a, Subscriber b) {
            return a.getFio().compareTo(b.getFio());
        }
    }

    //Создадим класс PersonAdressComparator, для сортировки нашей коллекции объектов абонентов по их адресам
    static class PersonAdressComparator implements Comparator<Subscriber> {

        public int compare(Subscriber a, Subscriber b) { return a.getAddress().compareTo(b.getAddress());}
    }

    //Создадим метод, сохраняющий в файл объект нашего класса
    static void serializationPhoneBook (List<Subscriber> phoneBook) throws Exception
    {
        // Рабочий файл программы будем хранить в папке нашего домашнего задания
        File file = Paths.get("out\\production\\JavaHomeWork\\com\\pb\\dolgopolyj\\hw11\\phoneBook.data").toFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // сохраняем в файл нашу телефонную книгу
        objectOutputStream.writeObject(phoneBook);
        System.out.println("Телефонная книга сохранена в файл:"+file.getPath());
        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();

    }

    //Создадим метод, загружающий ранее сохраненную телефонную книгу из файла в объект нашего класса List<Subscriber>
    static List<Subscriber> deserializationPhoneBook () throws Exception
    {
        // Рабочий файл программы хранитcя в папке нашего домашнего задания
        File file = Paths.get("out\\production\\JavaHomeWork\\com\\pb\\dolgopolyj\\hw11\\phoneBook.data").toFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        // Загружаем файл и приводим его к формату нашего листа телефонной книги
        List<Subscriber> phoneBook = (List<Subscriber>) objectInputStream.readObject();
        System.out.println("Телефонная книга загружена из файла:"+file.getPath());
        //закрываем поток и освобождаем ресурсы
        objectInputStream.close();
        return phoneBook;
    }

    ////Создадим метод, осуществляющий поиск абонента телефонной книги по Ф.И.О.
    static void FindSubscriber(List<Subscriber> phoneBook)
    {
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);
        String inString,inString2;
        int index;
        inString2 ="да";
        while (inString2.equals("да")==true) {
            //Переменная, отвественная за нахождение совпадения
            boolean isСoincidence = false;
            System.out.println("\nВы выбрали функцию поиска абонента. Поиск будет осуществлен по всем полям Ф.И.О. телефонной книги.");
            System.out.println("В качестве результата Вы получите полную информацию по всем абонентам,");
            System.out.println("которые в указанном поле будут содержать введенную Вами строку. То есть, например,");
            System.out.println("введя только имя абонента, вы получите список всех абонентов с этим именем и т.п.");
            System.out.print("Введите Ф.И.О. абонента (в качестве разделителя используйте пробелы):");
            //Для сравнения строк приведем их к верхнему регистру
            inString = in.nextLine().toUpperCase(Locale.ROOT);
            for (int i = 0; i < phoneBook.size(); i++) {
                index = phoneBook.get(i).getFio().toUpperCase(Locale.ROOT).lastIndexOf(inString);
                if (index == -1) {
                    //Нужная подстрока не найдена
                } else {
                    //Найдено совпадение, выводим информацию об абоненте и обновляем значение флага isСoincidence
                    subscriberInfo(phoneBook.get(i));
                    isСoincidence = true;
                }
            }
            if (isСoincidence == false) {
                System.out.println("По введенным данным абонентов не найдено!");
            }
            System.out.println("Повторить поиск(введите 'да' или любой другой символ,если нет)?");

            inString2 = in.next();
            in.nextLine();
        }
    }

}

