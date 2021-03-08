package ru.geekbrains.Lesson.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static char [][] map;
    private static final char DOT_PLAYER = 'X';
    private static final char DOT_COMPUTER = '0';
    private static final char DOT_EMPTY = '*';

    private static final int SIZE = 5;
    private static final int DOTS_WIN = 4;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        gameplay();

        scanner.close();
    }

    private static void gameplay() {
        boolean turn = true;
        do{
            if(turn){ player(); }
            else { computer(); }
            printMap();
            if(isWin()){
                System.out.println("Выиграл -> " + ((turn)
                        ?"игрок"
                        :"компьютер"));
                return;
            }
            turn = !turn;
        }while (checkMap());
        System.out.println("Ничья!");
    }

    private static void player() {
        int x, y;
        do{
            System.out.println("Введите координаты X Y (Строка / столбец)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }while (isCeilNoValid(x, y));
        map[x][y] = DOT_PLAYER;
    }

    private static void computer() {
        int x, y;
        do{
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        }while (isCeilNoValid(x, y));
        map[x][y] = DOT_COMPUTER;
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
            for(char dot : map[i]){
                System.out.print(dot + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isCeilNoValid(int x, int y){
        return (x < 0 || x >= SIZE ||
                y < 0 || y >= SIZE ||
                map[x][y] != DOT_EMPTY);
    }

    private static boolean isWin(){
        return row() || column() || mainDiagonal() || sideDiagonal();
    }

    private static boolean row() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j <= map[i].length - DOTS_WIN; j++) {
                if(map[i][j] != DOT_EMPTY && isWinRow(i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isWinRow(int i, int j) {
        for (int y = j + 1; y < j + DOTS_WIN; y++) {
            if(map[i][y] != map[i][j]){
                return false;
            }
        }
        return true;
    }

    private static boolean column() {
        for (int j = 0; j < map.length; j++) {
            for (int i = 0; i <= map.length - DOTS_WIN; i++) {
                if(map[i][j] != DOT_EMPTY && isWinСolumn(i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isWinСolumn(int i, int j) {
        for (int x = i + 1; x < i + DOTS_WIN; x++) {
            if(map[x][j] != map[i][j]){
                return false;
            }
        }
        return true;
    }

    private static boolean mainDiagonal() {
        for (int i = 0; i <= map.length - DOTS_WIN; i++) {
            for (int j = 0; j <= map.length - DOTS_WIN; j++) {
                if(map[i][j] != DOT_EMPTY && isWinMainDiagonal(i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isWinMainDiagonal(int i, int j){
        for (int x = i + 1, y = j + 1; (x < i + DOTS_WIN) || (y < j + DOTS_WIN); x++, y++) {
            if(map[x][y] != map[i][j]){
                return false;
            }
        }
        return true;
    }

    private static boolean sideDiagonal() {
        for (int i = DOTS_WIN - 1; i < map.length ; i++) {
            for (int j = 0; j <= map.length - SIZE; j++) {
                if(map[i][j] != DOT_EMPTY && isWinSideDiagonal(i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isWinSideDiagonal(int i, int j){
        for (int x = i - 1, y = j + 1; (x < i - DOTS_WIN) || (y < j + DOTS_WIN); x--, y++) {
            if(map[x][y] != map[i][j]){
                return false;
            }
        }
        return true;
    }

    private static boolean checkMap(){
        for (char [] map: map){
            for(char m : map){
                if(m == DOT_EMPTY){
                    return true;
                }
            }
        }
        return false;
    }
}
