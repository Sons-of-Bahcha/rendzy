package controler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 123 on 02.10.2016.
 */
public class Controler implements ActionListener {
    public Controler(){
        Timer t=new Timer(20,this);
        t.start();
    }

    public void actionPerformed(ActionEvent e) {

    }
}
