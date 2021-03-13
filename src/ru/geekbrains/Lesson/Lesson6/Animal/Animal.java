package ru.geekbrains.Lesson.Lesson6.Animal;

public abstract class Animal {

    private String animal;
    private String name;
    private String color;
    private int age;

    protected Animal(String animal, String name, String color, int age){
        this.animal = animal;
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void run(int distance){
        if(distance > 0) {
            System.out.println(name + " пробежал(а) " + distance+ " м.");
        }else{
            System.out.println(name + " не может бежать");
        }
    }

    public void swim(int distance){
        if(distance > 0) {
            System.out.println(name + " проплыл(а) " + distance + " м.");
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
}
