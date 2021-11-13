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

        Size mySize = Size.L;
        System.out.println("Текущий размер-"+mySize);
        System.out.println(mySize.getDescription());
        System.out.println("В числовом формате это размер:"+mySize.getEuroSize());
        //Демонстрация работы статических методов интерфейсов
        ManClothes.printTypeClothes();
        WomenClothes.printTypeClothes();

        //Создадим разные виды одежды
        Tshirt tshirt1 = new Tshirt("Хулиганка",mySize,330, "красная");
        tshirt1.dressMan();
        tshirt1.dressWomen();
        Pants pants1= new Pants("Трубы", Size.S, 950,"черные");
        pants1.dressMan();
        pants1.dressWomen();
        Skirt skirt1= new Skirt("Разлетайка",Size.XS,1010,"зеленая");
        skirt1.dressWomen();
        Tie tie1= new Tie("Полосатик", Size.XXS, 520, "фиолетовый");
        tie1.dressMan();




        //Благодарности :)
        System.out.println("\n*** Cпасибо за использование класса 'Atelier'! ***");
    }
}
