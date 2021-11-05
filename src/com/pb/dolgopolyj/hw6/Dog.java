package com.pb.dolgopolyj.hw6;

import java.util.Objects;

/**
 * Класс Dog, расширяющий класс Animal
 * в качестве дополнительных переменных используем:
 * String dogName - имя животного
 * String animalKind - вид животного, в данном случае - собака
 */

public class Dog extends Animal {

    private String dogName;
    private String animalKind;

    public Dog(String location, String food, String dogName) {
        super(location, food);
        this.dogName = dogName;
        this.animalKind = "собака";
    }

    //Переопределяем метод makeNoise
    @Override
    public void makeNoise(String name) {
        super.makeNoise(name);
        System.out.println("При этом животное громко лает!");
    }

    //Переопределяем метод eat
    @Override
    public void eat(String name) {
        System.out.println("Сейчас "+name+" кушает. Корм для этого животного-"+this.getFood()+".");
        System.out.println("Если при этом вы будете пытаться забрать его миску с едой, он будет рычать!");
    }

    //Переопределяем метод toString - cопроводим получаемую строку значками класса Dog - @, с обеих сторон
    @Override
    public String toString() {
        return ("@"+super.toString()+"@");
    }

    //Переопределяем методы equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(dogName, dog.dogName) && Objects.equals(animalKind, dog.animalKind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dogName, animalKind);
    }

    public String getDogName() {
        return dogName;
    }

    public String getAnimalKind() {
        return animalKind;
    }
}
