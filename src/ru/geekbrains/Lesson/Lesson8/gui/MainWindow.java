package ru.geekbrains.Lesson.Lesson8.gui;

import ru.geekbrains.Lesson.Lesson8.core.GameService;
import ru.geekbrains.Lesson.Lesson8.core.domain.MatrixCoordinate;
import ru.geekbrains.Lesson.Lesson8.core.impl.GameServiceImpl;
import ru.geekbrains.Lesson.Lesson8.enums.DotType;
import ru.geekbrains.Lesson.Lesson8.gui.component.StatusBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private final String human = "Игрок";
    private final String ai = "Компьютер";

    private final String DOT_EMPTY = "•";
    private JButton[][] buttons;
    private DotType playerType  = DotType.X;
    private int mapSize = 3;
    private int dotsToWin = 3;
    private GameService gameService;
    private StatusBar statusBar;

    public MainWindow (){
        setTitle("Крестики нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500,200,600,700);
        statusBar = new StatusBar();
        statusBar.setMessage("Ожидание хода");

        gameService = new GameServiceImpl(mapSize, dotsToWin, playerType);


        setLayout(new BorderLayout());
        add(createGridButtons(mapSize));
        add(statusBar, BorderLayout.SOUTH);





        setVisible(true);
    }

    private JPanel createGridButtons(int mapSize){
        JPanel gridPanel = new JPanel(new GridLayout(mapSize, mapSize));

        buttons = new JButton[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                JButton button = new JButton(DOT_EMPTY);
                button.setFont(new Font(button.getFont().getName(), button.getFont().getStyle(), 20));
                button.putClientProperty("INDEX_ROW", i);
                button.putClientProperty("INDEX_COLUMN", j);

                button.addActionListener(getButtonListener());


                buttons[i][j] = button;
                gridPanel.add(button);
            }
        }


        return gridPanel;
    }

    private ActionListener getButtonListener() {
        return e -> {
            doHumanTurn((JButton) e.getSource());

            if (isGameContinue(playerType)) {
                doAiTurn();
                statusBar.setMessage(human + ", ваш ход...");
            } else {
                finishGame(human);
            }
        };
    }

    private boolean isGameContinue(DotType dotType) {
        return !gameService.checkWin(dotType) && gameService.isMapNotFull();
    }

    private void doHumanTurn(JButton selectedButton) {
        int rowIndex = (int) selectedButton.getClientProperty("INDEX_ROW");
        int columnIndex = (int) selectedButton.getClientProperty("INDEX_COLUMN");

        gameService.humanTurn(rowIndex, columnIndex);

        disableButtonWithMark(selectedButton, playerType);
    }

    private void disableButtonWithMark(JButton button, DotType dotType) {
        button.setEnabled(false);
        button.setText(dotType.toString());
    }

    private void doAiTurn(){
        DotType aiDot = DotType.getEnemyType(playerType);
        statusBar.setMessage("Ход компьютера...");
        MatrixCoordinate coordinate = gameService.aiTurn();
        JButton aiSelectedButton = buttons[coordinate.getROW()][coordinate.getCOLUMN()];
        disableButtonWithMark(aiSelectedButton, aiDot);

        if(!isGameContinue(aiDot)){
            finishGame(ai);
        }
    }

    private void finishGame(String player) {
        statusBar.setMessage("Игра окончена! Победил - " + player);
        disableAllButtons();
    }

    private void disableAllButtons() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
}
