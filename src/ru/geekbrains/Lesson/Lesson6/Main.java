package ru.geekbrains.Lesson.Lesson6;

import ru.geekbrains.Lesson.Lesson6.Animal.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    private static Random random = new Random();
    private static Animal[] animals;
    private static final String[] NAME = new String[]{"Барсик","Барбоскин","Котенок","Щенок","Белка","Стрелка","Кто-то", "Рыжик"};
    private static final String[] COLOR = new String[]{"Серый","Черный","Белый","Рыжий","Полосатый"};
    private static final int MAX_AGE = 10;
    private static final int MAX_ANIMALS = 10;
    private static final String ANIMAL_CAT = "Cat";
    private static final String ANIMAL_DOG = "Dog";


    public static void main(String[] args) {
        initAnimals();

        printAnimals();

        act();

        countAnimal();

    }

    private static void act() {
        for(Animal animal: animals){
            if(random.nextBoolean()){
                animal.run(random.nextInt(animal.getMaxRun() + 1));
            } else {
                animal.swim(random.nextInt(animal.getMaxSwim() + 1));
            }
        }
    }

    private static void countAnimal() {
        int numberCats = 0, numberDogs = 0;
        for (Animal animal: animals) {
            switch (animal.getAnimal()){
                case ANIMAL_CAT:
                    numberCats++;
                    break;
                case ANIMAL_DOG:
                    numberDogs++;
                    break;
            }
        }
        System.out.println("Всего животных -> " + animals.length +
                            "\nКотов -> " + numberCats +
                            "\nСобак -> " + numberDogs);
    }

    private static void printAnimals() {
        for (Animal animal: animals) {
            System.out.println(animal.toString());
        }
    }

    private static void initAnimals() {
        animals = new Animal[random.nextInt(MAX_ANIMALS)+1];
        for (int i = 0; i < animals.length; i++) {
            animals[i] = getAnimal(NAME[random.nextInt(NAME.length)], COLOR[random.nextInt(COLOR.length)], random.nextInt(MAX_AGE)+1);
        }
    }

    private static Animal getAnimal(String name, String color, int age){
        if(random.nextBoolean()){
            return new Cat(name, color, age);
        }
        return new Dog(name, color, age);
    }
}
