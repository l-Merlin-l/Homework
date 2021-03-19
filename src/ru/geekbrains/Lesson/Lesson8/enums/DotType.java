package ru.geekbrains.Lesson.Lesson8.enums;

public enum DotType {
    X,
    O,
    EMPTY;

    public static DotType getEnemyType(DotType playerType) {
        if (playerType == DotType.X) {
            return DotType.O;
        } else {
            return DotType.X;
        }
    }
}
