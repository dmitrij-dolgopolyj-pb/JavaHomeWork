package com.pb.dolgopolyj.hw11;

//Импортируем для работы с датами дополнительные библиотеки
import java.util.*;

/**
 * Класс PhoneBook, который организовывает работу с телефонной книгой.
 */
public class PhoneBook extends Subscriber
{
    public PhoneBook(String fio, Date dateBirth, List phoneNumber, String address) {
        super(fio, dateBirth, phoneNumber, address);
    }

    public static void main(String[] args)
    {
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);
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
        //Вывод информации об абоненте 1
        subscriberInfo(subs1);

        calendar.set(1983, 6, 1,0,0,0);
        dateBirth=calendar.getTime();

        List<String> phoneNumber2 = new ArrayList<>();
        phoneNumber2.add("+380-99-044-6050");
        phoneNumber2.add("+380-63-222-4189");

        Subscriber subs2= new Subscriber("Буц Наталья Юрьевна", dateBirth, phoneNumber2,
                "г.Изюм, ул.Харьковская 39");
        //Вывод информации об абоненте 2
        subscriberInfo(subs2);

        calendar.set(1962, 3, 13,0,0,0);
        dateBirth=calendar.getTime();

        List<String> phoneNumber3 = new ArrayList<>();
        phoneNumber3.add("+359-89-843-3510");
        phoneNumber3.add("+359-23-666-4189");
        phoneNumber3.add("+359-59-555-1894");
        phoneNumber3.add("+359-13-444-4189");

        Subscriber subs3= new Subscriber("Баглаенко Виктория Николаевна", dateBirth, phoneNumber3,
                "г.Пловдив, ул.Горно Броди, 3/6");
        //Вывод информации об абоненте 3
        subscriberInfo(subs3);

        //Создаем коллекцию для хранения в ней всех абонентов
        List<Subscriber> phoneBook = new ArrayList<>();
        phoneBook.add(subs1);
        phoneBook.add(subs2);
        phoneBook.add(subs3);

        //Здесь, возможно, нужно будет отсортировать нашу коллекцию сортом с компаратором)

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
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);
        //Запрашиваем, что хочет пользователь
        System.out.println("Если хотите просмотреть/изменить информацию об абоненте, введите его номер, в противном случае введите любой другой символ");
        String sign = in.next();
        if (sign.matches("[0-9]+") == true)
        {
            int a=Integer.parseInt(sign);
            if (a>subs.size()||(a-1)<0)
            {
                System.out.println("Выбрана операция по несуществующему абоненту!!!");
            }
            else
            {
                System.out.println("Выбрана операция по абоненту №"+a);
                subscriberInfo(subs.get(a-1));
            }

        }
//      System.out.println("Адрес:"+this.address);
//      System.out.println("Дата создания/модификации данных абонента:"+this.dateIni);
    }
}
