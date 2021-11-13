package com.pb.dolgopolyj.hw7;

/**
 * Класс Atelier, демонстрирующий работу cо всеми типами одежды.
 */

public class Atelier
{
    public static void main(String[] args)
    {
        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nЭто класс 'Atelier'");
        System.out.println("Он демонстрирует работу cо всеми типами одежды.\n");

        Size mySize = Size.XXS;
        System.out.println("Текущий размер-"+mySize);
        System.out.println(mySize.getDescription());
        System.out.println("В числовом формате это размер:"+mySize.getEuroSize());

        //Благодарности :)
        System.out.println("\n*** Cпасибо за использование класса 'Atelier'! ***");
    }
}
