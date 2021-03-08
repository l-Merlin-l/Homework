package ru.geekbrains.Lesson.Lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int AUTOCOMPLETE = 15;
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static final int RANGE_RANDOM = 10;
    static final int ATTEMPTS = 3;
    public static void main(String[] args) {
        randomComputerValue();

        guessWord();

        scanner.close();
    }

    private static void randomComputerValue() {
        do {
            playerGuessing(random.nextInt(RANGE_RANDOM));
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        }while (isChoiceContinueOrEnd());
    }

    private static void playerGuessing(int randomValue) {
        System.out.println("Отгадайте загаданное число от 0 до " + (RANGE_RANDOM - 1) + ", с 3-х попыток.");
        for(int i = 0; i < ATTEMPTS; i++){
            System.out.print("Попытка номер " + (i + 1) + " -> ");
            int attempt = scanner.nextInt();
            if(attempt == randomValue){
                System.out.println("Верно! Компьютер загадал именно это число.");
                return;
            }else if(attempt > randomValue){
                System.out.println("Загаданное число меньше введенного вами");
            }else{
                System.out.println("Загаданное число больше введенного вами");
            }
        }
        System.out.println("Сожалею, но вы проиграли. Загаданное число было " + randomValue);
    }

    private static void guessWord() {
        final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        do{
            playerGuessingWord(words[random.nextInt(words.length)]);
            System.out.println("Хотите сыграть еще раз? 1 – да / 0 – нет");
        }while (isChoiceContinueOrEnd());

    }

    private static void playerGuessingWord(String word){
        System.out.println("Компьютер загадал слово, ваша задача отгадать его. Удачи!");

        System.out.println(word);
        do {
            System.out.print("Ваш вариант -> ");
            String playerWord = scanner.next();
            if (playerWord.equals(word)) {
                System.out.println("Поздравляю, вы отгадали слово.");
                return;
            }
            int minLength = (word.length() < playerWord.length())
                    ?word.length()
                    :playerWord.length();
            String variant = "";
            for (int i = 0; i < minLength; i++) {
                variant += (word.charAt(i) == playerWord.charAt(i))
                        ?word.charAt(i)
                        :"*";
            }
            for (int i = word.length(); i < AUTOCOMPLETE; i++) {
                variant += "*";
            }
            System.out.println(variant + "\nЭти буквы были отгаданы в слове.\nПопробуете еще раз? 1 – да / 0 – нет");
        }while (isChoiceContinueOrEnd());
    }

    public static boolean isChoiceContinueOrEnd (){
        switch (scanner.nextInt()) {
            case 0:
                return false;
            case 1:
                return true;
        }
        System.out.println("Вы ввели недопустимый вариант. Закрываем программу.");
        scanner.close();
        System.exit(0);
        return false;
    }
}
