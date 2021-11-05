package com.pb.dolgopolyj.hw6;

/**
 * Класс Veterinarian
 */

public class Veterinarian {

    static public void treatAnimal(Animal animal)
    {
        System.out.println("На прием к ветеринару пришло животное из страны "+animal.getLocation());
        System.out.println("Пищей для этого животного является "+animal.getFood());
    }

}
