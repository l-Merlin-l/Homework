package ru.geekbrains.Lesson.Lesson8.gui.dialog.impl;

import ru.geekbrains.Lesson.Lesson8.enums.DotType;
import ru.geekbrains.Lesson.Lesson8.gui.dialog.Configureble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ConfigurationDialog extends  JDialog implements Configureble {

    private int mapSize = 3;
    private int dotsToWin = mapSize;
    private final int minDotsToWin = 3;
    private DotType playerType = DotType.X;
    private String playerName = "Игрок";


    private JTextField mapSizeTextField = new JTextField(String.valueOf(mapSize));
    private JTextField dotsToWinTextField = new JTextField(String.valueOf(dotsToWin));
    private JTextField playerNameTextField = new JTextField(String.valueOf(playerName));

    public ConfigurationDialog(JFrame parentFrame){
        super(parentFrame, "Конфигурация игры", true);
        int widthDialog = 400;
        int heightDialog = 200;
        setBounds(parentFrame.getX() + (parentFrame.getWidth() - widthDialog) / 2,
                  parentFrame.getY() + (parentFrame.getHeight() - heightDialog) / 2,
                widthDialog, heightDialog);

        dotsToWinTextField.addActionListener(getListenerText());
        mapSizeTextField.addActionListener(getListenerText());
        playerNameTextField.addActionListener(getListenerText());

        JPanel commonPanel = getConfigurationPanel();
        setLayout(new BorderLayout());
        add(commonPanel, BorderLayout.CENTER);
        add(createApplyButton(), BorderLayout.SOUTH);
        setVisible(true);
    }

    private ActionListener getListenerText() {
        return e -> {
            checkIntText();
            getMapSizeListener();
            getDotsToWinListener();
        };
    }

    private JPanel getConfigurationPanel() {

        JPanel commonPanel = new JPanel(new GridLayout(4, 2, 15, 10));
        commonPanel.add(new JLabel("Выберите за кого вы будете играть?"));
        commonPanel.add(createChoiceButtonPanel());
        commonPanel.add(new JLabel("Как вас зовут?"));
        commonPanel.add(playerNameTextField);
        commonPanel.add(new JLabel("Укажите размер игрового поля"));
        commonPanel.add(mapSizeTextField);
        commonPanel.add(new JLabel("Укажите количество ячеек для победы \n(не больше размера поля и не меньше 3)"));
        commonPanel.add(dotsToWinTextField);

        return commonPanel;
    }

    private JPanel createChoiceButtonPanel() {
        JRadioButton xButtonChoice = getRadioButton(DotType.X, true);
        JRadioButton oButtonChoice = getRadioButton(DotType.O, false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(xButtonChoice);
        buttonPanel.add(oButtonChoice);

        ButtonGroup group = new ButtonGroup();
        group.add(xButtonChoice);
        group.add(oButtonChoice);

        return buttonPanel;
    }

    private JRadioButton getRadioButton(DotType buttonDotType, boolean selected) {
        JRadioButton choiceBtn = new JRadioButton(buttonDotType.toString(), selected);
        choiceBtn.addActionListener(e -> playerType = buttonDotType);

        return choiceBtn;
    }

    private boolean checkIntText(){
        boolean result = true;
         try{
             Integer.parseInt(mapSizeTextField.getText());
         }catch (NumberFormatException e){
             mapSizeTextField.setText(mapSize + "");
             result = false;
         }
         try {
             Integer.parseInt(dotsToWinTextField.getText());
         }catch (NumberFormatException e){
             dotsToWinTextField.setText(dotsToWin + "");
             result = false;
         }
         return result;
    }

    private void getDotsToWinListener() {
        if (Integer.parseInt(dotsToWinTextField.getText()) > Integer.parseInt(mapSizeTextField.getText())) {
            dotsToWinTextField.setText(mapSizeTextField.getText());
        } else if(Integer.parseInt(dotsToWinTextField.getText()) < minDotsToWin){
            dotsToWinTextField.setText(minDotsToWin + "");
        }
        initConfigData();
    }

    private void getMapSizeListener() {
        if(Integer.parseInt(mapSizeTextField.getText()) < minDotsToWin){
            mapSizeTextField.setText(minDotsToWin + "");
        }
        initConfigData();
    }

    private void initConfigData(){
        mapSize = Integer.parseInt(mapSizeTextField.getText());
        dotsToWin = Integer.parseInt(dotsToWinTextField.getText());
    }

    private JButton createApplyButton() {
        JButton applyButton = new JButton("Принять");

        WindowEvent closeEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        applyButton.addActionListener(e -> {
            boolean check = checkIntText();
            getMapSizeListener();
            getDotsToWinListener();
            if (check){
                dispatchEvent(closeEvent);
            }
        });

        return applyButton;
    }

    @Override
    public DotType getPlayerType() {
        return playerType;
    }

    @Override
    public int getDotsToWin() {
        return dotsToWin;
    }

    @Override
    public int getMapSize() {
        return mapSize;
    }

    @Override
    public String getNamePlayer() {
        return playerName;
    }
}
