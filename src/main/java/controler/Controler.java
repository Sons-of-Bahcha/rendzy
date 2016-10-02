package controler;

import gui.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 123 on 02.10.2016.
 */
public class Controler implements ActionListener {
    private Window w;
    public Controler(Window w){
        this.w=w;
        Timer t=new Timer(20,this);
        t.start();
    }

    public void actionPerformed(ActionEvent e) {
        w.repaint();
    }
}
