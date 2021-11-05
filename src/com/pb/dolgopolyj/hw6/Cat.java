package com.pb.dolgopolyj.hw6;

import java.util.Objects;

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

    //Переопределяем метод eat
    @Override
    public void eat(String name) {
        System.out.println(name+"-"+this.animalKind+". Сейчас "+name+" кушает. Корм для этого животного-"+this.getFood()+".");
    }

    //Переопределяем метод toString
    @Override
    public String toString() {
        return "Cat{" +
                "catName='" + catName + '\'' +
                ", animalKind='" + animalKind + '\'' +
                '}';
    }

    //Переопределяем методы equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(catName, cat.catName) && Objects.equals(animalKind, cat.animalKind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catName, animalKind);
    }

    public String getCatName() {
        return catName;
    }

    public String getAnimalKind() {
        return animalKind;
    }
}
