package com.pb.dolgopolyj.hw11;

//Импортируем для работы с датами дополнительные библиотеки
import java.util.*;

/**
 * Класс PhoneBook, который организовывает работу с телефонной книгой.
 */
public class PhoneBook extends Subscriber
{
    public PhoneBook(String fio, Date dateBirth, List phoneNumber, String address)
    {
        super(fio, dateBirth, phoneNumber, address);
    }

    public static void main(String[] args)
    {
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);
        //Назначаем флаги для выходов из меню
        boolean exit1,exit2;
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

        //Создаем коллекцию для хранения в ней всех абонентов
        List<Subscriber> phoneBook = new ArrayList<>();
        phoneBook.add(subs1);
        phoneBook.add(subs2);
        phoneBook.add(subs3);

        //Здесь, возможно, нужно будет отсортировать нашу коллекцию сортом с компаратором)

        //Выводим информацию обо всех абонентах телефонной книги
        phoneBookShowInfo(phoneBook);
        //Запрашиваем, хочет ли пользователь просмотреть/изменить информацию об абоненте
        System.out.println("Если хотите просмотреть/изменить информацию об абоненте, введите его номер, в противном случае введите любой другой символ");
        String sign = in.next();
        if (sign.matches("[0-9]+") == true)
        {
            int a = Integer.parseInt(sign);
            if (a > phoneBook.size() || (a - 1) < 0)
                {
                System.out.println("Выбрана операция по несуществующему абоненту!!!");
                }
            else
                {
                System.out.println("Выбрана операция по абоненту №" + a);
                subscriberInfo(phoneBook.get(a - 1));
                System.out.println("\nЕсли хотите изменить/удалить информацию об абоненте, введите 'да',\n"
                        +"в противном случае любой другой символ");
                    sign = in.next();
                    if (sign.equals("да"))
                    {
                        //Назначаем флаг для выхода из меню
                        exit2=false;
                        System.out.println("Что необходимо сделать?\n" +
                                "'1'-редактировать данные абонента;\n" +
                                "'2'-удалить данные этого абонента из телефонной книги\n" +
                                "'3' - выход из меню");
                        while (exit2!=true) {
                            sign = in.next();
                            if (sign.equals("1"))
                            {
                                subscriberEdit(phoneBook.get(a - 1));
                                System.out.println("Теперь данные этого абонента выглядят так:");
                                subscriberInfo(phoneBook.get(a - 1));
                                exit2 = true;
                            }
                            else
                            {
                                if (sign.equals("2"))
                                {
                                    System.out.println("Данные по абоненту будут удалены!\n" +
                                            "Вы уверены('да' - удалить без возможности восстановления)?");
                                    sign = in.next();
                                    if (sign.equals("да")) phoneBook.remove((a-1));
                                    exit2 = true;
                                }
                                else
                                {
                                    if (sign.equals("3")) exit2 = true;
                                    System.out.println("Повторите ввод!('1','2' или '3')");
                                }
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Выбран выход из меню!");
                    }
                }
        }

        phoneBookShowInfo(phoneBook);

        //Благодарности :)
        System.out.println("\n*** Cпасибо за использование нашей 'PhoneBook'!!! ***");

    }

    //Создадим метод, выводящий на экран информацию обо всех абонентах, содержащихся в телефонной книге
    static void phoneBookShowInfo(List<Subscriber> subs)
    {
        System.out.println("\nВ нашей телефонной книге хранится информация о следующих абонентах:");
        int i = 0;
        for (Subscriber p: subs)
        {
            i++;
            System.out.println("№"+i+":"+p.getFio());
        }

    }

}

