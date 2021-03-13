package ru.geekbrains.Lesson.Lesson6.Animal;

public class Cat extends Animal{
    private static final int MAX_RUN = 200;
    private static final int MAX_SWIM = 0;
    private static final String ANIMAL = "Cat";

    public Cat(String name, String color, int age){
        super(name,color, age);
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
        return super.toString().replaceAll("animal", ANIMAL);
    }

    public int getMaxRun(){
        return MAX_RUN;
    }

    public int getMaxSwim(){
        return MAX_SWIM;
    }
}
