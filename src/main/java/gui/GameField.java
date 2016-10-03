package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by 123 on 02.10.2016.
 */
public class GameField extends JFrame {
    BufferedImage map;
    public GameField(int width, int height, String s){
        super(s);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    private GameField(int width, int height){
        this.map=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g=map.getGraphics();

        setVisible(true);
    }
    
    public void paint(Graphics g){
        g.drawImage(map,0,0,null);

    }
}
