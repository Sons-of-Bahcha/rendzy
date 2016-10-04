package not_name;

import GameObjects.GameMap;
import GameObjects.stone.Stone;

import java.awt.*;

/**
 * Created by ROOT on 04.10.2016.
 */
public class LocalPlayer implements Player {
    private Color color;
    private Stone stone;
    public void action() {

    }

    public boolean checkCoordinates(int x, int y) {
        return false;
    }

    public boolean checkEmptyCell(GameMap m,int x, int y) {
        return (m.isCellFree(x,y));
    }

    public void setStone(GameMap m,int x, int y) {
        m.setCell(x,y,stone);
    }
}
