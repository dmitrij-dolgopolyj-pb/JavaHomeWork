package com.pb.dolgopolyj.hw6;

/**
 * Класс, демонстрирующий работу c классами Animal и расширяющими его классами Dog, Cat, Horse.
 */


public class VetСlinic {
    public static void main(String[] args) {

        //Выводим на экран приветствие программы и выполняемые ей действия
        System.out.println("*** Добрый день! ***\nЭто класс 'VetСlinic'");
        System.out.println("Он демонстрирует работу c классами Animal и расширяющими его классами (Dog,Cat,Horse).");

        //Блок тестирования
        Animal vasilij = new Animal("Украина", "рыба");

        //Выведем инфу о животном, которого зовут Василий
        System.out.println("Это класс:"+vasilij.toString());
        System.out.println("Животное обитает в cтране:"+vasilij.getLocation()+", его еда-"+vasilij.getFood());
        vasilij.makeNoise("Василий");
        vasilij.eat("Василий");
        vasilij.sleep("Василий");

        Dog baks = new Dog("Украина", "мясо", "Бакс");
        //Выведем инфу о Баксе
        System.out.println("Это класс:"+baks.toString());
        System.out.println("Знакомьтесь, это животное-"+baks.getAnimalKind()+", по имени "+baks.getDogName()+", его еда-"+baks.getFood());
        baks.makeNoise(baks.getDogName());
        baks.eat(baks.getDogName());
        baks.sleep(baks.getDogName());
        //Создадим ещё два объекта класса Cat для тестирования работы переопределенного метода equals
        Dog baks2 = new Dog("Украина", "мясо", "Бакс");
        Dog betta = new Dog("Украина", "мясо", "Бетта");
        System.out.println("eq baks baks2:"+baks.equals(baks2));
        System.out.println("eq baks betta:"+baks.equals(betta));

        Cat bajun = new Cat("РФ", "мыши", "Баюн");
        //Выведем инфу о Баюне
        System.out.println("Это класс:"+bajun.toString());
        System.out.println("Перед вами животное-"+bajun.getAnimalKind()+", по имени "+bajun.getCatName()+", его еда-"+bajun.getFood());
        bajun.makeNoise(bajun.getCatName());
        bajun.eat(bajun.getCatName());
        bajun.sleep(bajun.getCatName());
        //Создадим ещё два объекта класса Cat для тестирования работы переопределенного метода equals
        Cat murka = new Cat("РФ", "мыши", "Мурка");
        Cat murzic = new Cat("РФ", "мыши", "Баюн");
        System.out.println("eq bajun murka:"+bajun.equals(murka));
        System.out.println("eq bajun murzic:"+bajun.equals(murzic));

        Horse bella = new Horse("Белоруcсия", "cено", "Белла");
        //Выведем инфу о Белле
        System.out.println("Это класс:"+bella.toString());
        System.out.println("А вот это животное-"+bella.getAnimalKind()+", по имени "+bella.getHorseName()+", его еда-"+bella.getFood());
        bella.makeNoise(bella.getHorseName());
        bella.eat(bella.getHorseName());
        bella.sleep(bella.getHorseName());
        //Создадим ещё два объекта класса Horse для тестирования работы переопределенного метода equals
        Horse veter = new Horse("Белоруcсия", "cено", "Ветер");
        Horse pella = new Horse("Белоруcсия", "cено", "Белла");
        System.out.println("eq bella pella:"+bella.equals(pella));
        System.out.println("eq bella murzic:"+bella.equals(veter));

        //Благодарности :)
        System.out.println("\n*** Cпасибо за использование класса 'VetСlinic'! ***");
    }
}
