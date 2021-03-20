package ru.geekbrains.Lesson.Lesson8.gui;

import ru.geekbrains.Lesson.Lesson8.core.GameService;
import ru.geekbrains.Lesson.Lesson8.core.domain.MatrixCoordinate;
import ru.geekbrains.Lesson.Lesson8.core.impl.GameServiceImpl;
import ru.geekbrains.Lesson.Lesson8.enums.DotType;
import ru.geekbrains.Lesson.Lesson8.gui.component.StatusBar;
import ru.geekbrains.Lesson.Lesson8.gui.dialog.Configureble;
import ru.geekbrains.Lesson.Lesson8.gui.dialog.impl.ConfigurationDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private final String human;
    private final String ai = "Компьютер";

    private final String DOT_EMPTY = "•";
    private JButton[][] buttons;
    private final DotType playerType;
    private final int mapSize;
    private final int dotsToWin;
    private GameService gameService;
    private StatusBar statusBar;

    public MainWindow (){

        setTitle("Крестики нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500,200,600,700);
        statusBar = new StatusBar();
        statusBar.setMessage("Ожидание хода");

        Configureble configureble = new ConfigurationDialog(this);
        mapSize = configureble.getMapSize();
        dotsToWin = configureble.getDotsToWin();
        human = configureble.getNamePlayer();
        playerType = configureble.getPlayerType();


        gameService = new GameServiceImpl(mapSize, dotsToWin, playerType);


        setLayout(new BorderLayout());
        add(createGridButtons(mapSize));

        JButton newGame = new JButton("Заново");
        newGame.addActionListener(e -> {
            setVisible(false);
            new MainWindow();
        });
        add(newGame, BorderLayout.EAST);

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

            if (isGameContinue(human)) {
                doAiTurn();
                if(isGameContinue(ai)){
                    statusBar.setMessage(human + ", ваш ход...");
                }
            }
        };
    }

    private boolean isGameContinue(String player) {
        if(gameService.checkWin()){
            finishGame("Победил - " + player);
            return false;
        }
        if(gameService.isMapFull()){
            finishGame("Ничья...");
            return false;
        }
        return true;
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
    }

    private void finishGame(String player) {
        statusBar.setMessage("Игра окончена! " + player);
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
