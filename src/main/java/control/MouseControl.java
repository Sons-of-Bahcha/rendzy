package control;

import GameObjects.GameMap;
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
}
