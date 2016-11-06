package gui;

import gameObjects.GameMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Класс представляющий из себя главное окно на котором будут расположены: главное меню, игровое поле и еще может что-нибудь
 * Created by Viteker on 02.10.2016.
 * @author Viteker
 * @version 1.3
 */
public class Window extends JFrame {
    private final GameMap bg;//Игровое поле на котором расположены ячейки поля

    /**
     * Стартовый конструктор, в котором создается окно с указанными размерами width, height
     * и title для него устанавливаетя строчкой s
     * именно в этом конструкторе устанавливается закрытие окна, расположение и отображение.
     *
     * В самом начале вызывается приватный конструктор this(width,height)
     * в котором вызывается коструктор super() класса
     * и инициализируется игровое поле GameMap
     *
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
     * Второстепенный конструктор который вызывается из главного,
     * в котором инициализируется игровое поле GameMap
     *
     * @param width - ширина фона (ширина фона совпадает с шириной окна)
     * @param height - высота фона (высота фона совпадает с высотой окна)
     */
    private Window(int width, int height){
        super();
        this.bg=new gameObjects.GameMap(50,50,BufferedImage.TYPE_INT_RGB,32,15);
    }

    /**
     * Отрисовка игрового поля GameMap
     * @param g - графический объект главного окна {@link Window}
     */
    public void paint(Graphics g){
        g.drawImage(bg,bg.getX(),bg.getY(),null);
    }

    /**
     *
     * @return возвращает игровое поле GameMap
     */
    public GameMap getBg() {
        return bg;
    }
}
