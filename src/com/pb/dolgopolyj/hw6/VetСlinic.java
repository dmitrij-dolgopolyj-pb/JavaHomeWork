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

        //Выведем инфу о Василии
        System.out.println("Новое животное обитает в cтране:"+vasilij.getLocation()+", его еда-"+vasilij.getFood());
        vasilij.makeNoise("Василий");
        vasilij.eat("Василий");
        vasilij.sleep("Василий");

        Dog baks = new Dog("Украина", "мясо", "Бакс");
        //Выведем инфу о Баксе
        System.out.println("Знакомтесь, это животное-"+baks.getAnimalKind()+", его зовут - "+baks.getDogName());
        System.out.println("Новое животное обитает в cтране:"+baks.getLocation()+", его еда-"+baks.getFood());
        baks.makeNoise(baks.getDogName());
        baks.eat(baks.getDogName());
        baks.sleep(baks.getDogName());

        Cat bajun = new Cat("РФ", "мыши", "Баюн");
        //Выведем инфу о Баюне
        System.out.println("Знакомтесь, это животное-"+bajun.getAnimalKind()+", его зовут - "+bajun.getCatName());
        System.out.println("Новое животное обитает в cтране:"+bajun.getLocation()+", его еда-"+bajun.getFood());
        bajun.makeNoise(bajun.getCatName());
        bajun.eat(bajun.getCatName());
        bajun.sleep(bajun.getCatName());

        Horse bella = new Horse("Белорусия", "cено", "Белла");
        //Выведем инфу о Белле
        System.out.println("Знакомтесь, это животное-"+bella.getAnimalKind()+", его зовут - "+bella.getHorseName());
        System.out.println("Новое животное обитает в cтране:"+bella.getLocation()+", его еда-"+bella.getFood());
        bella.makeNoise(bella.getHorseName());
        bella.eat(bella.getHorseName());
        bella.sleep(bella.getHorseName());


        //Благодарности :)
        System.out.println("\n*** Cпасибо за использование класса 'VetСlinic'! ***");
    }
}
