package ru.geekbrains.Lesson.Lesson8.core;

import ru.geekbrains.Lesson.Lesson8.core.domain.MatrixCoordinate;
import ru.geekbrains.Lesson.Lesson8.enums.DotType;

public interface GameService {

    MatrixCoordinate aiTurn();

    void humanTurn (int rowIndex, int columnIndex);

    boolean checkWin(DotType dotType);

    boolean isMapNotFull();

}
