package com.pb.dolgopolyj.hw7;

import com.pb.dolgopolyj.hw6.Animal;

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
        System.out.println("Демонстрация работы статических методов интерфейсов:");
        ManClothes.printTypeClothes();
        WomenClothes.printTypeClothes();

        //Создадим разные виды одежды и продемонстрируем методы dressMan() и dressWomen()
        System.out.println("Демонстрация одежды и методов dressMan() и dressWomen():");
        Tshirt tshirt1 = new Tshirt("Хулиганка",mySize,330, "красная", true);
        tshirt1.dressMan();
        Tshirt tshirt2 = new Tshirt("Декольте",Size.S,250, "голубая", false);
        tshirt2.dressWomen();
        Pants pants1= new Pants("Клеш", Size.S, 950,"черные",true);
        pants1.dressMan();
        Pants pants2= new Pants("Трубы", Size.XS, 850,"cерые",false);
        pants2.dressWomen();
        Skirt skirt1= new Skirt("Разлетайка",Size.XS,1010,"зеленая");
        skirt1.dressWomen();
        Tie tie1= new Tie("Полосатик", Size.XXS, 520, "фиолетовый");
        tie1.dressMan();

        //Создаем массив всей имеющийся в ателье одежды
        Clothes [] clothes= new Clothes[6];
        clothes[0]=tshirt1;
        clothes[1]=pants1;
        clothes[2]=skirt1;
        clothes[3]=tie1;
        clothes[4]=pants2;
        clothes[5]=tshirt2;

        //Выведем список товаров ателье для одежды мужчин
        dressMan(clothes);

        //Выведем список товаров ателье для одежды женщин
        dressWomen(clothes);

        //Завершающая фраза
        System.out.println("\nЖелаем удачных покупок в нашем ателье!");

        //Благодарности :)
        System.out.println("\n*** Cпасибо за использование класса 'Atelier'! ***");
    }

    static void dressMan(Clothes[] clothes)
    {
        System.out.println("\nВ нашем ателье мы предлагаем мужчинам следующую одежду:");
        //Определяем переменную для передачи на печать названия одежды
        String anObjectName="";
        for (Clothes anObject: clothes)
        {
            anObjectName="";
            //Проверка класса объектов
            if (anObject instanceof Skirt)
                {
                    //Это юбка, ее не предлагаем
                }
            else
                {
                    if (anObject instanceof Pants)
                    {
                        Pants pants = (Pants) anObject;
                        if (pants.isPantsForMan() == true)
                        anObjectName = "Штаны " + pants.getPantsName();
                    }
                    else
                    {
                        if (anObject instanceof Tie)
                        {
                            Tie tie= (Tie) anObject;
                            anObjectName="Галстук "+tie.getTieName();
                        }
                        else
                        {
                            //Остался только объект класса Tshirt
                            Tshirt tshirt=(Tshirt) anObject;
                            if (tshirt.isTshirtForMan()==true)
                            anObjectName="Футболка "+tshirt.getTshirtName();
                        }
                    }

                }
            if (anObjectName!="")
            {   //Выводим на печать полученный результат
                System.out.println(anObjectName + ", размер:" + anObject.getClothingSize() + ", цвет -" + anObject.getColor()
                        + ", по цене " + anObject.getPrice() + "грн.");
            }
        }
    }

    static void dressWomen(Clothes[] clothes)
    {
        System.out.println("\nВ нашем ателье мы предлагаем женщинам следующую одежду:");
        //Определяем переменную для передачи на печать названия одежды
        String anObjectName="";
        for (Clothes anObject: clothes)
        {
            anObjectName="";
            //Проверка класса объектов
            if (anObject instanceof Tie)
            {
                //Это галстук, его не предлагаем
            }
            else
            {
                if (anObject instanceof Pants)
                {
                    Pants pants = (Pants) anObject;
                    if (pants.isPantsForMan() == false)
                        anObjectName = "Штаны " + pants.getPantsName();
                }
                else
                {
                    if (anObject instanceof Skirt)
                    {
                        Skirt skirt= (Skirt) anObject;
                        anObjectName="Юбка "+skirt.getSkirtName();
                    }
                    else
                    {
                        //Остался только объект класса Tshirt
                        Tshirt tshirt=(Tshirt) anObject;
                        if (tshirt.isTshirtForMan()==false)
                            anObjectName="Футболка "+tshirt.getTshirtName();
                    }
                }

            }
            if (anObjectName!="")
            {   //Выводим на печать полученный результат
                System.out.println(anObjectName + ", размер:" + anObject.getClothingSize() + ", цвет -" + anObject.getColor()
                        + ", по цене " + anObject.getPrice() + "грн.");
            }
        }
    }

}
