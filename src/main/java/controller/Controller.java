package controller;

import gui.GameField;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 123 on 02.10.2016.
 */

public class Controller implements ActionListener {
    private GameField gf;
    public Controller(GameField gf){
        this.gf = gf;
        Timer t=new Timer(20,this);
        t.start();
    }

    public void actionPerformed(ActionEvent e) {
        gf.repaint();
    }
}


