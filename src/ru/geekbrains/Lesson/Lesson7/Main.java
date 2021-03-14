package ru.geekbrains.Lesson.Lesson7;
import java.util.Random;

public class Main {
    private static Random random = new Random();
    private static final int MAX_CATS = 10;
    private static final String[] NAME = new String[]{"Барсик","Мур","Котенок","Щенок","Мурзик","Стрелка","Кто-то", "Рыжик"};
    private static Cat [] cats;
    private static Plate plate;

    public static void main(String[] args) {
        initCats(random.nextInt(MAX_CATS)+1);

        initPlate(50);

        catsEat();

        feedMore();
    }

    private static void initPlate(int size) {
        plate = new Plate(size);
        plate.printInfo();
    }

    private static void initCats(int quantity){
        cats = new Cat[quantity];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat(getName(), randomAppetite());
        }
    }

    private static void catsEat() {
        System.out.println("Коты едят -> ");
        for (Cat cat : cats) {
            cat.eat(plate);
        }
        System.out.println("Состояние котов после кормежки ->");
        stateSatiety();
        System.out.println("Еды осталось -> " + plate.info());
    }

    private static void feedMore() {
        final int food = 50;
        while (isSatietyCats() && addFoodPlate(food)){
            System.out.println("Еды добавили. Теперь еды ->" + plate.info());
            System.out.println("Кормим котов повторно");
            catsEat();
        }
    }

    private static void stateSatiety(){
        for (Cat cat : cats) {
            System.out.println(cat.stateSatiety());
        }
    }

    private static boolean isSatietyCats(){ //проверка на наличие голодных котов
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

    private static boolean addFoodPlate(int food){
        int foodLast = plate.getFood();
        plate.addFood(food);
        return  (foodLast != plate.getFood());
    }
}
