package not_name;

import GameObjects.GameMap;
import GameObjects.stone.Stone;
import control.Control;

import java.awt.*;

/**
 * Created by ROOT on 04.10.2016.
 */
public class LocalPlayer implements Action {

    private Stone stone;
    private LocalPlayer oponent;

    public LocalPlayer(Stone stone){
        this.stone=stone;
        this.oponent=oponent;
    }

    public void action(GameMap mp,int x,int y) {
        if(checkEmptyCell(mp, x, y)){
            setStone(mp,x,y);
            Control.setGm(mp);
            Control.setLp(oponent);
        }
    }


    public boolean checkEmptyCell(GameMap m,int x, int y) {
        return (m.isCellFree(x,y));
    }

    public Stone getStone() {
        return stone;
    }


    public void setStone(GameMap m,int x, int y) {
        m.setCell(x,y,stone);
    }

    public LocalPlayer getOponent() {
        return oponent;
    }

    public void setOponent(LocalPlayer oponent) {
        this.oponent = oponent;
    }
}
