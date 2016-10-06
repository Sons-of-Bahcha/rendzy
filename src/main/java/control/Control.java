package control;

import GameObjects.GameMap;
import not_name.LocalPlayer;

/**
 * Created by 123 on 06.10.2016.
 */
public class Control {
    protected final GameMap gm;
    protected final LocalPlayer lp;

    public Control(GameMap gm,LocalPlayer lp){
        this.gm=gm;
        this.lp=lp;
    }
}
