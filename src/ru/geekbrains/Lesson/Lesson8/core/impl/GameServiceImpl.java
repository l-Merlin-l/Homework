package ru.geekbrains.Lesson.Lesson8.core.impl;

import ru.geekbrains.Lesson.Lesson8.core.GameService;
import ru.geekbrains.Lesson.Lesson8.core.domain.MatrixCoordinate;
import ru.geekbrains.Lesson.Lesson8.enums.DotType;

import java.util.Random;

public class GameServiceImpl implements GameService {
    private final int dotsToWin;
    private final int size;

    private DotType[][] map;
    private final DotType playerType;
    private final DotType aiType;

    private Random random = new Random();

    public GameServiceImpl(int mapSize, int dotsToWin, DotType playerType) {
        this.size = mapSize;
        this.dotsToWin = dotsToWin;

        this.playerType = playerType;
        this.aiType = DotType.getEnemyType(playerType);

        initMap();
    }

    public void humanTurn(int rowIndex, int columnIndex){
        map[rowIndex][columnIndex] = playerType;
        printMap();
    }

    public MatrixCoordinate aiTurn() {
        int x, y;

        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (isCeilNotValid(x, y));

        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[x][y] = aiType;

        return new MatrixCoordinate(x, y);
    }

    public boolean checkWin(){
        return row() || column() || mainDiagonal() || sideDiagonal();
    }

    public boolean isMapFull(){
        for (DotType [] map: map){
            for(DotType dot : map){
                if(dot == DotType.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    private void initMap() {
        map = new DotType[size][size];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DotType.EMPTY;
            }
        }
    }

    private void printMap() {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
            for(DotType dot : map[i]){
                System.out.print(dot + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isCeilNotValid(int x, int y){
        return (x < 0 || x >= size ||
                y < 0 || y >= size ||
                map[x][y] != DotType.EMPTY);
    }

    private boolean row() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j <= map[i].length - dotsToWin; j++) {
                if(map[i][j] != DotType.EMPTY && isWinRow(i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinRow(int i, int j) {
        for (int y = j + 1; y < j + dotsToWin; y++) {
            if(map[i][y] != map[i][j]){
                return false;
            }
        }
        return true;
    }

    private boolean column() {
        for (int j = 0; j < map.length; j++) {
            for (int i = 0; i <= map.length - dotsToWin; i++) {
                if(map[i][j] != DotType.EMPTY && isWinСolumn(i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinСolumn(int i, int j) {
        for (int x = i + 1; x < i + dotsToWin; x++) {
            if(map[x][j] != map[i][j]){
                return false;
            }
        }
        return true;
    }

    private boolean mainDiagonal() {
        for (int i = 0; i <= map.length - dotsToWin; i++) {
            for (int j = 0; j <= map.length - dotsToWin; j++) {
                if(map[i][j] != DotType.EMPTY && isWinMainDiagonal(i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinMainDiagonal(int i, int j){
        for (int x = i + 1, y = j + 1; (x < i + dotsToWin) || (y < j + dotsToWin); x++, y++) {
            if(map[x][y] != map[i][j]){
                return false;
            }
        }
        return true;
    }

    private boolean sideDiagonal() {
        for (int i = dotsToWin - 1; i < map.length ; i++) {
            for (int j = 0; j <= map.length - size; j++) {
                if(map[i][j] != DotType.EMPTY && isWinSideDiagonal(i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinSideDiagonal(int i, int j){
        for (int x = i - 1, y = j + 1; (x < i - dotsToWin) || (y < j + dotsToWin); x--, y++) {
            if(map[x][y] != map[i][j]){
                return false;
            }
        }
        return true;
    }

}
