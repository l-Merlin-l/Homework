package ru.geekbrains.Lesson.Lesson6.Animal;

public class Dog extends Animal{
    public static final int MAX_RUN = 500;
    public static final int MAX_SWIM = 10;
    private static final String ANIMAL = "Dog";

    public Dog(String name, String color, int age){
        super(name, color, age);
    }

    @Override
    public void run(int distance) {
        super.run(Math.min(distance, MAX_RUN));
    }

    @Override
    public void swim(int distance) {
        super.swim(Math.min(distance, MAX_SWIM));
    }

    @Override
    public String getAnimal() {
        return ANIMAL;
    }
    @Override
    public String toString() {
        return ANIMAL + super.toString();
    }

    public int getMaxRun(){
        return MAX_RUN;
    }

    public int getMaxSwim(){
        return MAX_SWIM;
    }
}
