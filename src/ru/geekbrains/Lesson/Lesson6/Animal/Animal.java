package ru.geekbrains.Lesson.Lesson6.Animal;

public abstract class Animal {

    private int maxRun;
    private int maxSwim;
    private String animal;
    private String name;
    private String color;
    private int age;

    protected Animal(String animal, String name, String color, int age, int maxRun, int maxSwim){
        this.animal = animal;
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
    }

    public void run(int distance){
        if(maxRun > 0) {
            System.out.println(name + " пробежал(а) " + (Math.min(distance, maxRun)) + " м.");
        }else{
            System.out.println(name + " не может бежать");
        }
    }

    public void swim(int distance){
        if(maxSwim > 0) {
            System.out.println(name + " проплыл(а) " + (Math.min(distance, maxSwim)) + " м.");
        }else{
            System.out.println(name + " не может плыть");
        }
    }

    public String toString(){
        return animal +
                "{name='" + name + "', " +
                "color='" + color + "', " +
                "age=" + age + "}";
    }

    public String getAnimal() {
        return animal;
    }

    public int getMaxRun(){
        return maxRun;
    }

    public int getMaxSwim(){
        return maxSwim;
    }
}
