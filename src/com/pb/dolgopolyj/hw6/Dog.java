package com.pb.dolgopolyj.hw6;

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

    public String getDogName() {
        return dogName;
    }

    public String getAnimalKind() {
        return animalKind;
    }
}
