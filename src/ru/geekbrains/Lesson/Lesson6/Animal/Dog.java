package ru.geekbrains.Lesson.Lesson6.Animal;

public class Dog extends Animal{
    public static final int MAX_RUN = 500;
    public static final int MAX_SWIM = 10;
    private static final String ANIMAL = "Dog";

    public Dog(String name, String color, int age){
        super(ANIMAL, name, color, age, MAX_RUN, MAX_SWIM);
    }
}
