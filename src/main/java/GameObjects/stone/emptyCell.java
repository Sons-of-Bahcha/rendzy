package GameObjects.stone;

import java.awt.*;

/**
 * Created by ROOT on 04.10.2016.
 * я хочу, чтобы этот класс был соседом класса Stone. Т.е пустые ячейки тоже будут содержать объекты. Объекты этого класса.
 * Это будет просто черный крест по середине, и по итогу мы получим сетку как в реверси
 */
public class emptyCell implements DrawStone {
    public void draw(Graphics g, int x, int y, int size) {

    }
}
