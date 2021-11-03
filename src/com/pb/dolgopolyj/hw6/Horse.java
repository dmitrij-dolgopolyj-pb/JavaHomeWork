package com.pb.dolgopolyj.hw6;

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

    public String getHorseName() {
        return horseName;
    }

    public String getAnimalKind() {
        return animalKind;
    }
}
