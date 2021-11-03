package com.pb.dolgopolyj.hw6;

/**
 * Класс Сat, расширяющий класс Animal
 * в качестве дополнительных переменных используем:
 * String catName - имя животного
 * String animalKind - вид животного, в данном случае - кот/кошка
 */

public class Cat extends Animal {

    private String catName;
    private String animalKind;

    public Cat(String location, String food, String catName) {
        super(location, food);
        this.catName = catName;
        this.animalKind = "кот";
    }

    //Переопределяем метод makeNoise
    @Override
    public void makeNoise(String name) {
        super.makeNoise(name);
        System.out.println("Осторожно, при игре с ним животное царапается!");
    }

    public String getCatName() {
        return catName;
    }

    public String getAnimalKind() {
        return animalKind;
    }
}
