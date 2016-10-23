package control;

import GameObjects.GameMap;
import not_name.LocalPlayer;
import not_name.Player;

/**
 * Created by Viteker on 06.10.2016.
 * @author Viteker
 * @version 1.4
 */
public class Control {
    public static Player lp;//игрок который ходит
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
