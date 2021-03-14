package ru.geekbrains.Lesson.Lesson7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate plate) {
        if(this.satiety){
            System.out.println("cat " + this.name + " не голоден(голодна)");
            return;
        }
        this.satiety = plate.emptyingPlate(appetite);
    }

    public String stateSatiety(){
        return "cat " +
                this.name +
                ((satiety)
                    ?" сыт(а)"
                    :" голоден(голодна)");
    }

    public void setSatiety(boolean satiety){
        this.satiety = satiety;
    }

    public boolean getSatiety(){
        return this.satiety;
    }

}
