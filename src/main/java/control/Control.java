package control;

import GameObjects.GameMap;
import GameObjects.stone.EmptyCell;
import not_name.Player;

/**
 * Created by 123 on 06.10.2016.
 */
public class Control {
    public static Player lp;
    private static GameMap gameMap;
    public Control(Player lp){
        this.lp=lp;
    }
    public Player getLp() {
        return lp;
    }


    public static void setLp(Player lpr) {
        lp = lpr;
    }
}
