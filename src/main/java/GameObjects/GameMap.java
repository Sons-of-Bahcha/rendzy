package GameObjects;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by ROOT on 02.10.2016.
 */
public class GameMap extends BufferedImage {
    Table map;
    private Graphics g;
    @Override
    public Graphics getGraphics() {
        return super.getGraphics();
    }

    public GameMap(int width, int height, int imageType) {
        super(width, height, imageType);
        map=new Table();
    }
}
