package control;

import not_name.LocalPlayer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by 123 on 06.10.2016.
 */
public class MouseMotionControl extends Control implements MouseMotionListener{

    public MouseMotionControl(LocalPlayer lp) {
        super(lp);
    }

    /**
     * Invoked when a mouse button is pressed on a component and then
     * dragged.  <code>MOUSE_DRAGGED</code> events will continue to be
     * delivered to the component where the drag originated until the
     * mouse button is released (regardless of whether the mouse position
     * is within the bounds of the component).
     * <p>
     * Due to platform-dependent Drag&amp;Drop implementations,
     * <code>MOUSE_DRAGGED</code> events may not be delivered during a native
     * Drag&amp;Drop operation.
     *
     * @param e
     */
    public void mouseDragged(MouseEvent e) {

    }

    /**
     * Invoked when the mouse cursor has been moved onto a component
     * but no buttons have been pushed.
     *
     * @param e
     */
    public void mouseMoved(MouseEvent e) {

    }
}
