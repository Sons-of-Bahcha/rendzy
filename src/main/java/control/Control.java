package control;

import GameObjects.GameMap;
import not_name.LocalPlayer;

/**
 * Created by 123 on 06.10.2016.
 */
public class Control {
    public static LocalPlayer lp;

    public Control(LocalPlayer lp){
        this.lp=lp;
    }

    public LocalPlayer getLp() {
        return lp;
    }

    public void setLp(LocalPlayer lp) {
        this.lp = lp;
    }
}
