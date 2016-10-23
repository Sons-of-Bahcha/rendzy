package control;

import GameObjects.GameMap;
import not_name.LocalPlayer;

/**
 * Created by 123 on 06.10.2016.
 */
public class Control {
    public static LocalPlayer lp;//первый игрок который ходит
    private static GameMap gameMap;

    public Control(LocalPlayer lp){
        this.lp=lp;
    }
    public LocalPlayer getLp() {
        return lp;
    }


    public static void setLp(LocalPlayer lpr) {
        lp = lpr;
    }
}
