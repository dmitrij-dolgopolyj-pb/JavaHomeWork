package com.pb.dolgopolyj.hw6;

/**
 * Класс, описывающий животное
 * String location - место обитания животного
 * String food - пища животного
 */

public class Animal {
    private String location;
    private String food;

    //Создадим конструктор класса Animal
    public Animal(String location, String food) {
        this.location = location;
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public String getFood() {
        return food;
    }

    public void makeNoise (String name){
        System.out.println(name+" живет в стране "+location+", бегает и хочет играть.");
    }

    public void eat (String name){
        System.out.println(name+" кушает. Корм этого животного-"+food+".");
    }

    public void sleep (String name){
        System.out.println(name+" крепко cпит.");
    }

}
