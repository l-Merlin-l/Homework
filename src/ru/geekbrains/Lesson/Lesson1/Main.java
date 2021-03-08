package ru.geekbrains.Lesson.Lesson1;

public class Main {
    public static void main(String[] args) {
        byte b = 127;
        short shor = 200;
        int i = 1500;
        long l = 200000l;

        float f = 15.5f;
        double d = 150.65;

        char c = '!';

        boolean t = true;

        String name = "Igor";

        System.out.println(expressionFloat(15.5f, 16.6f, 22.35f, 100.4f));

        System.out.println(amountLimit(5, 1));

        positiveNumber(15);

        System.out.println(negativeNumber(-4));

        helloName("Андрей");

        leapYear(2021);
    }

    public static float expressionFloat(float a, float b, float c, float d){
        return a * (b + (c/d));
    }

    public static boolean amountLimit(int a, int b){
        return (a + b >= 10 && a + b <= 20);
    }

    public static void positiveNumber(int a){
        if(a >= 0){
            System.out.println("Число " + a + " положительное");
        }else{
            System.out.println("Число " + a + " отрицательное");
        }
    }

    public static boolean negativeNumber(int a){
        return (a<0);
    }

    public static void helloName(String name){
        System.out.println("Привет, " + name);
    }

    public static void leapYear(int year){
        if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)){
            System.out.println("Год " + year + " високосный");
        }else {
            System.out.println("Год " + year + " не високосный");
        }
    }
}
