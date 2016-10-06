package control;

import GameObjects.GameMap;
import not_name.LocalPlayer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by 123 on 06.10.2016.
 */
public class MouseControl extends Control implements MouseListener{

    public MouseControl(GameMap gm, LocalPlayer lp) {
        super(gm, lp);
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
        if(!lp.isPlay())return;
        int x=e.getX();
        int y=e.getY();
        if(x<gm.getWidth() && y<gm.getHeight()){
            lp.action(gm,gm.transformX(x),gm.transformY(y));
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
