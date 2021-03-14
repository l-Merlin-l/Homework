package ru.geekbrains.Lesson.Lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        if(food <= 0){
            System.out.println("Вы взяли пустую тарелку");
            return;
        }
        this.food = food;
    }

    public String info() {
        return ("plate: " + food);
    }

    public boolean emptyingPlate(int decrease){
        if(food < decrease){
            return false;
        }
        this.food -= decrease;
        return true;
    }

    public void addFood(int food){
        if (food > 0) {
            this.food += food;
        }else {
            System.out.println("Вы ничего не положили дополнительно в тарелку");
        }
    }

    public void printInfo(){
        System.out.println(info());
    }

    public int getFood(){
        return this.food;
    }
}
