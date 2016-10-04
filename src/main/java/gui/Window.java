package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Класс представляющий из себя главное окно
 * Created by Viteker on 02.10.2016.
 * @author Viteker
 * @version 1.2
 */
public class Window extends JFrame {
    private final BufferedImage bg;//главный фон

    /**
     * Стартовый конструктор, в котором создается окно с указанными размерами и title для него устанавливаетя строчкой s
     * @param width - ширина окна
     * @param height - высота окна
     * @param s - title
     */
    public Window(int width, int height, String s){
        this(width,height);
        setTitle(s);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        setVisible(true);
    }

    /**
     * Второстепенный конструктор который вызывается из главного, в котором просто подготавливает фон окна
     * @param width - ширина фона (ширина фона совпадает с шириной окна)
     * @param height - высота фона (высота фона совпадает с высотой окна)
     */
    private Window(int width, int height){
        super();
        this.bg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        prepareBackground();

    }

    /**
     * Подготавливаем белый фон для окна
     */
    private void prepareBackground(){
        Graphics g=bg.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,bg.getWidth(),bg.getHeight());
    }

    /**
     * Отрисовка фона окна
     * @param g - графический рбъекта на главного окна {@link Window}
     */
    public void paint(Graphics g){
        g.drawImage(bg,0,0,null);
    }
}
