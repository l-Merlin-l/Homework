package ru.geekbrains.Lesson.Lesson8.core.domain;

public class MatrixCoordinate {

    private final int ROW;
    private final int COLUMN;

    public MatrixCoordinate(int row, int column) {
        ROW = row;
        COLUMN = column;
    }

    public int getROW() {
        return ROW;
    }

    public int getCOLUMN() {
        return COLUMN;
    }

}
