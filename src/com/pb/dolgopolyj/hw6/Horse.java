package com.pb.dolgopolyj.hw6;

import java.util.Objects;

/**
 * Класс Horse, расширяющий класс Animal
 * в качестве дополнительных переменных используем:
 * String horseName - имя животного
 * String animalKind - вид животного, в данном случае - лошадь
 */

public class Horse extends Animal{

    private String horseName;
    private String animalKind;

    public Horse(String location, String food, String horseName) {
        super(location, food);
        this.horseName = horseName;
        this.animalKind = "лошадь";
    }

    //Переопределяем метод makeNoise
    @Override
    public void makeNoise(String name) {
        super.makeNoise(name);
        System.out.println("Не подходите к нему близко в это врямя, у животного сильный удар копытом!");
    }

    //Переопределяем метод eat
    @Override
    public void eat(String name) {
        System.out.println("Сейчас "+name+" кушает. Корм для этого животного-"+this.getFood()+".");
        System.out.println("Осторожно, не подходите к животному сзади! Может сильно лягнуть!");
    }

    //Переопределяем метод toString
    @Override
    public String toString() {
        return "Horse{" +
                "horseName='" + horseName + '\'' +
                ", animalKind='" + animalKind + '\'' +
                '}';
    }

    //Переопределяем методы equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Objects.equals(horseName, horse.horseName) && Objects.equals(animalKind, horse.animalKind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horseName, animalKind);
    }

    public String getHorseName() {
        return horseName;
    }

    public String getAnimalKind() {
        return animalKind;
    }
}
