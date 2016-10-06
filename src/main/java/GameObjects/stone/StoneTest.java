package GameObjects.stone;

import gui.*;
import gui.Window;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by ROOT on 06.10.2016.
 */
public class StoneTest {

    @Test
    public void testDraw(){
        Stone stone=new Stone(Color.BLUE);
        gui.Window w=new Window(200,200,"pedik");
        stone.draw(w.getBg().getGraphics(), 50, 50, 30);
        w.repaint();
        while(true)
        {

        }
    }
}