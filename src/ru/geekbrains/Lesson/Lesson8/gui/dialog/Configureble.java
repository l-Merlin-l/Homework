package ru.geekbrains.Lesson.Lesson8.gui.dialog;

import ru.geekbrains.Lesson.Lesson8.enums.DotType;

public interface Configureble {

    DotType getPlayerType();

    int getMapSize();

    int getDotsToWin();

    String getNamePlayer();
}
