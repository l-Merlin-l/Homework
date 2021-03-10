package ru.geekbrains.Lesson.Lesson6.Animal;

public class Cat extends Animal{
    public static final int MAX_RUN = 200;
    public static final int MAX_SWIM = 0;
    private static final String ANIMAL = "Cat";

    public Cat(String name, String color, int age){
        super(ANIMAL, name,color, age, MAX_RUN, MAX_SWIM);
    }
}
