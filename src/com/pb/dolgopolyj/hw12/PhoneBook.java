package com.pb.dolgopolyj.hw12;

//Импортируем для работы с датами дополнительные библиотеки

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

/**
 * Класс PhoneBook, который организовывает работу с телефонной книгой.
 * Для выполнения домашнего задания №12 класс будет использовать лямбда-выражения в процедуре сортировки абонентов
 * и Stream API.
 */
public class PhoneBook extends Subscriber implements Serializable
{
    //Для организации сериалиазации объектов класса установим номер своей версии
    private final static long serialVersionUID = 75;

    public PhoneBook(String fio, Date dateBirth, List phoneNumber, String address)
    {
        super(fio, dateBirth, phoneNumber, address);
    }

    //Это функциональный интерфейс, он поможет нам в организации сортировки абонентов
    @FunctionalInterface
    interface SubscribersSort
    {
        void sortByFlag(List<Subscriber> listSubscribers, boolean SortFlag);
    }

    public static void main(String[] args) throws Exception
    {
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);
        //Cоздаём переменную для ввода строки с клавиатуры
        String inputString="";
        //Назначаем флаги для выходов из меню
        boolean exit1,exit2;
        //Инициализирум два компаратора - один для сортировки по Ф.И.О.
        PersonFioComparator pcomp1 = new PersonFioComparator();

        //Второй для сортировки по адресам
        PersonAdressComparator pcomp2 = new PersonAdressComparator();
        //Инициализируем флаг, отвечающий за текущий порядок сортировки
        boolean isSortFio=true;
        //Создаем коллекцию для хранения в ней всех абонентов
        List<Subscriber> phoneBook = new ArrayList<>();

        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("**************************************** Добрый день! ********************************************\n");
        System.out.println("***************************Вас приветствует программа 'PhoneBook'!!!******************************\n");
        System.out.println("Вы сможете работать с нашей телефонной книгой в удобном для Вас режиме.");
        System.out.println("При выводе списка абонентов они сортируются в алфавитном порядке по Ф.И.О. или адресу.");
        System.out.println("Способ переключения сортировки указан в меню.");
        System.out.println("Для более удобной работы класс будет класс будет использовать лямбда-выражения и Stream API.");
        System.out.println("Удачной и приятной работы!\n");

        //Загружаем телефонную книгу из файла
        phoneBook=deserializationPhoneBook();

        //Наполняем нужной нам логикой функциональный интерфейс, используя лямбда-выражение
        SubscribersSort mySort=(listSubscribers, SortFlag)->
        {
            if (SortFlag==true) listSubscribers.sort(pcomp1);
            else listSubscribers.sort(pcomp2);
        };

        //Cортируем коллекцию, в зависимости от текущей настройки флага сортировки
        mySort.sortByFlag(phoneBook,isSortFio);

        //Работаем в программе, пока пользователь не даст команду на выход из программы
        while (inputString.equals("в")!=true)
        {
            //Выводим краткую информацию обо всех абонентах телефонной книги
            phoneBookShowShortInfo(phoneBook);

            //Организовываем вывод основного меню
            phoneBookShowMenu(phoneBook.size());

            System.out.print("\nВведите символы нужного действия->");
            //Ждем ввода необходимого действия от пользователя
            inputString = in.next();

            //Если введено число, отрабатываем блок просмотра и редактирования данных абонента
            if (inputString.matches("[0-9]+") == true)
            {
                if (phoneBookInfoEdit(phoneBook, inputString)==true)
                {
                    //Произошло редактирование данных абонента, вызываем сортировку на текущих настройках
                    mySort.sortByFlag(phoneBook,isSortFio);
                }
            }

            //Если пользователь хочет добавить нового абонента, вызываем соответствующий метод
            if (inputString.equals("д")==true)
            {
                phoneBook.add(subscriberNew());
                //Cортируем коллекцию, в зависимости от текущей настройки флага сортировки
                if (isSortFio==true) phoneBook.sort(pcomp1);
                else phoneBook.sort(pcomp2);
            }

            //Если пользователь хочет получить полную информацию обо всех абонентах, выводим всю телефонную книгу
            if (inputString.equals("и")==true)
            {
                //Выводим полную информацию обо всех абонентах телефонной книги
                phoneBookShowFullInfo(phoneBook);
            }

            //Если пользователь хочет изменить порядок сортировки записей, делаем нужные действия
            if (inputString.equals("с")==true)
            {
                //Изменяем флаг сортировки на противоположный
                if (isSortFio==true) isSortFio=false;
                else isSortFio=true;
                //Cортируем коллекцию, в зависимости от текущей настройки флага сортировки
                mySort.sortByFlag(phoneBook,isSortFio);
            }

            //Если пользователь хочет найти абонента, вызываем метод такого поиска
            if (inputString.equals("п")==true)
            {
                //Вызываем метод поиска абонента телефонной книги
                FindSubscriber(phoneBook);
            }

        }

        //Сохраним нашу телефонную книгу в файл
        serializationPhoneBook(phoneBook);

        //Благодарности :)
        System.out.println("\n************************** Cпасибо за использование нашей 'PhoneBook'!!! *******************************");

    }

    //Создадим метод, выводящий на экран основное меню программы (аргументом метод получает размер телефонной книги)
    static void phoneBookShowMenu(int phoneBookSize)
    {
        //Объявляем переменные, для вывода на экран первого и последнего номера абонента в телофонной книге
        String startElement="-",endElement="-";
        if (phoneBookSize>0)
        {
            startElement="1";
            endElement=String.valueOf(phoneBookSize);
        }
        System.out.println("\n----------------------------------------МЕНЮ ПРОГРАММЫ-------------------------------------------");
        System.out.println("    '"+startElement+"'..'"+endElement+"'           'д'             'и'             'с'            'п'             'в'");
        System.out.println("    Просмотр/        Добавить        Вывести         Сменить         Поиск           Выход");
        System.out.println(" редактирование      абонента          всю           порядок        абонента           из");
        System.out.println(" данных абонента                    информацию      сортировки                      программы");
    }

    //Создадим метод, выводящий на экран краткую информацию обо всех абонентах, содержащихся в телефонной книге
    static void phoneBookShowShortInfo(List<Subscriber> phoneBook)
    {
        if (phoneBook.size()>0)
        {
            System.out.println("\n----------------------------------------ТЕЛЕФОННАЯ КНИГА-----------------------------------------\n");
            int i = 0;
            for (Subscriber p : phoneBook) {
                i += 1;
                System.out.println("№" + i + ":" + p.getFio() + ", тел." + p.getPhoneNumber().get(0) + "; адрес:" + p.getAddress());
            }
        }
        else
        {
            System.out.println("\nВ нашей телефонной книге пока нет абонентов. Добавьте их!");
        }
    }

    //Создадим метод, выводящий на экран полную информацию обо всех абонентах, содержащихся в телефонной книге
    static void phoneBookShowFullInfo(List<Subscriber> phoneBook)
    {
        if (phoneBook.size()>0)
        {
            System.out.println("\nВ нашей телефонной книге хранится информация о следующих абонентах:");
            int i = 0;
            for (Subscriber p : phoneBook) {
                i += 1;
                System.out.println("-------------------АБОНЕНТ №" + i + "----------------------------------------------------");
                subscriberInfo(p);
                ;
                System.out.println("---------------------------------------------------------------------------------");
            }
        }
        else
        {
            System.out.println("\nВ нашей телефонной книге пока нет абонентов. Добавьте их!");
        }
    }

    //Создадим метод, выводящий на экран информацию об абонентах, содержащихся в телефонной книге.
    //При необходимости, метод позволяет внести изменения в данные абонента
    static boolean phoneBookInfoEdit(List<Subscriber> phoneBook, String inputString)
    {
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);
        //Cоздаём cтроковую переменную для обмена данных с пользователем
        String sign;
        //Назначаем флаги для выходов из меню
        boolean exit1,exit2;
        //Инициализируем флаг, который сообщит вызывающему методу была ли произведено внутри метода редактирование
        //данных абонента
        boolean isEdit=false;
        exit1=false;
        //Цикл работает до тех пор, пока не получит флаг на выход
        while (exit1==false)
        {
            if (inputString.matches("[0-9]+") == true)
            {
                int a = Integer.parseInt(inputString);
                if (a > phoneBook.size() || (a - 1) < 0) {
                    System.out.println("Выбрана операция по несуществующему абоненту!!!");
                    exit1=true;
                }
                else
                {
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
                                    isEdit=true;
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
        return isEdit;
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
        System.out.println("\nТелефонная книга сохранена в файл:"+file.getPath());
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

    //Создадим метод, осуществляющий поиск абонента телефонной книги по Ф.И.О.
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

