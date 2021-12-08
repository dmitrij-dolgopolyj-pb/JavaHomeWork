package com.pb.dolgopolyj.hw11;

//Импортируем для работы с датами дополнительные библиотеки
import java.util.*;

/**
 * Класс PhoneBook, который организовывает работу с телефонной книгой.
 */
public class PhoneBook
{
    public static void main(String[] args)
    {
        //Cоздаём объект класса Scanner для обработки ввода с клавиатуры
        Scanner in = new Scanner(System.in);
        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nВас приветствует 'PhoneBook'!!!");
        System.out.println("Вы сможете работать с нашей телефонной книгой в удобном для Вас режиме.");

        //Создаем 1-й объект класса Subscriber (абонента телефонной книги)
        Calendar calendar = Calendar.getInstance();
        calendar.set(1975, 8, 8,0,0,0);
        Date dateBirth=calendar.getTime();

        List<String> phoneNumber = new ArrayList<>();
        phoneNumber.add("+38-050-883-9418");
        phoneNumber.add("+38-066-883-9418");
        phoneNumber.add("+38-093-883-9418");

        Subscriber subs1= new Subscriber("Долгополый Дмитрий Юрьевич", dateBirth, phoneNumber,
                "г.Краматорск, бул.Краматорский 2/262");
        //Вывод информации об абоненте
        subs1.subscriberInfo();

        //Благодарности :)
        System.out.println("\n*** Cпасибо за использование нашей 'PhoneBook'!!! ***");
    }
}
