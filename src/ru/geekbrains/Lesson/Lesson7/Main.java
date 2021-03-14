package ru.geekbrains.Lesson.Lesson7;
import java.util.Random;

public class Main {
    private static Random random = new Random();
    private static final int MAX_CATS = 10;
    private static final String[] NAME = new String[]{"Барсик","Мур","Котенок","Щенок","Мурзик","Стрелка","Кто-то", "Рыжик"};
    private static Cat [] cats;

    public static void main(String[] args) {
        initCats(random.nextInt(MAX_CATS)+1);

        Plate plate = new Plate(50);
        plate.printInfo();

        catsEat(plate);

        feedMore(plate);
    }

    private static void initCats(int quantity){
        cats = new Cat[quantity];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat(getName(), randomAppetite());
        }
    }

    private static void catsEat(Plate plate) {
        System.out.println("Коты едят -> ");
        for (Cat cat : cats) {
            cat.eat(plate);
        }
        System.out.println("Состояние котов после кормежки ->");
        stateSatiety();
        System.out.println("Еды осталось");
        plate.printInfo();
    }

    private static void feedMore(Plate plate) {
        final int food = 50;
        while (isSatietyCats()){
            plate.addFood(food);
            System.out.println("Еды добавили. Теперь еды ->");
            plate.printInfo();
            System.out.println("Кормим котов повторно");
            catsEat(plate);
        }
    }

    private static void stateSatiety(){
        for (Cat cat : cats) {
            System.out.println(cat.stateSatiety());
        }
    }

    private static boolean isSatietyCats(){
        for (Cat cat : cats){
            if(!cat.getSatiety()){
                return true;
            }
        }
        return false;
    }

    private static String getName() {
        return NAME[random.nextInt(NAME.length)];
    }

    private static int randomAppetite(){
        final int MAX_APPETITE = 20;
        final int MIN_APPETITE = 5;
        return random.nextInt(MAX_APPETITE - MIN_APPETITE) + MIN_APPETITE;
    }
}
