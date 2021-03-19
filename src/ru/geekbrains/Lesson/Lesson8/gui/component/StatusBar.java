package ru.geekbrains.Lesson.Lesson8.gui.component;

import javax.swing.*;
import java.awt.*;

public class StatusBar extends JLabel {
    public StatusBar(){
        super();
        super.setPreferredSize((new Dimension(100, 50)));
    }

    public void setMessage(String message){
        setText(" " + message);
    }
}
