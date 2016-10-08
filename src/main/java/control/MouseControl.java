package control;

import GameObjects.GameMap;
import GameObjects.stone.EmptyCell;
import gui.Window;
import not_name.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by 123 on 06.10.2016.
 */
public class MouseControl extends Control implements MouseListener{
    private final Window w;
    public MouseControl(Player lp, Window w) {
        super(lp);
        this.w=w;
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e
     */
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e
     */
    public void mousePressed(MouseEvent e) {
        int x=e.getX();
        int y=e.getY();
        GameMap mp=w.getBg();

        if(x>mp.getX() && x< mp.getX()+mp.getWidth() && y>mp.getY() && y<mp.getY() + mp.getHeight()){
            x-=mp.getX();
            y-=mp.getY();
            lp.action(mp, mp.transformX(x), mp.transformY(y));

            try {
                isPlayerWinner();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            w.repaint();
        }

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e
     */
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e
     */
    public void mouseExited(MouseEvent e) {

    }
    /*
    Как работают эти злоебучие методы?
    Первый метод просто вызывает метод isFiveInRow(), Для каждой НЕПУСТОЙ клетки поля, если хоть один вернёт тру, значит нашли победителя.
    isFiveInRow(i,j,"direction"), принимает как аргументы координаты той точки которую мы проверяем и строку, которая указывает нам
    направление запуска проверяющего луча, который проверяет каждую следующую клетку от текущей в поисках похожих елементов
    там карочи творится магия, я не могу её объяснить. Работает и ладно?! Она слишком очевидная
     */
    private void isPlayerWinner() throws Exception {
        for(int i=0;i<15;i++)
            for(int j=0;j<15;j++)
            {
                if(!(w.getBg().getCell(i,j).getStone() instanceof EmptyCell))
                    if(isFiveInRow(i,j,"right-down") || isFiveInRow(i,j,"up")||isFiveInRow(i,j,"down") || isFiveInRow(i,j,"left")||isFiveInRow(i,j,"right")
                            ||isFiveInRow(i,j,"left-down") || isFiveInRow(i,j,"right-up") || isFiveInRow(i,j,"left-up"))
                        throw new Exception("Winner is found. Winner color is "+lp.getOponent().getStone().getColor());
            }

    }
    private boolean isFiveInRow(int x,int y, String direction)
    {
        int flag=0;   // переменная нужная для того чтобы проверять насколько мы должны были сместиться во время проверки и насколько реально сместились
        int isInRow=0; // счетчик подряд идущих элементов
        int dx=0;   // смещение по Х
        int dy=0;// смещение по У
        for(int i=1;i<5;i++)
        {

            if(direction.contains("down"))// если наша строка содержит, что надо идти вниз, значит заходим в иф
            {
                flag++;//раз мы зашли в иф, то инкрементируем, чтобы не получилось говняшек всяких из-за следующего ифа
                if(x<15 && x>=0 && y>=0 && y+5<15)//этот иф проверяет не вылезем ли мы со своими ебучими проверками за поле и получим outofboundsexception
                    dy++; // все заебись, дошли до этой строки? инкрементируем смещение по У
                // следующие ифы аналогично
            }
            if(direction.contains("up"))
            {
                flag++;
                if(x<15 && x>=0 && y-5>=0 && y<15)
                    dy--;
            }
            if(direction.contains("left"))
            {
                flag++;
                if(x<15 && x-5>=0 && y>=0 && y<15)
                    dx--;
            }

            if(direction.contains("right"))
            {
                flag++;
                if(x+5<15 && x>=0 && y>=0 && y<15)
                    dx++;
            }
            if(flag==Math.abs(dx)+Math.abs(dy))// проверяем, совпадает ли то сколько мы должны были пройти, с правдой?
                if(w.getBg().getCell(dx+x,dy+y).getStone()==w.getBg().getCell(x,y).getStone())// сверяем текущий камешек со следующим
                    isInRow++;//пиздато? ++

        }
        return (isInRow==4);
    }
}
