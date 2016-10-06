package not_name;

import GameObjects.GameMap;
import GameObjects.stone.Stone;

import java.awt.*;

/**
 * Created by ROOT on 04.10.2016.
 */
public class LocalPlayer implements Action {
    private Stone stone;
    private boolean play;
    private LocalPlayer oponent;

    public LocalPlayer(Stone stone){
        this.stone=stone;
    }

    public void action(GameMap mp,int x,int y) {
        if(checkEmptyCell(mp, x, y)){
            setStone(mp,x,y);
            play=false;
            oponent.play=true;
        }
    }

    public boolean checkEmptyCell(GameMap m,int x, int y) {
        return (m.isCellFree(x,y));
    }

    public void setStone(GameMap m,int x, int y) {
        m.setCell(x,y,new Stone(stone.getColor()));
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }
}
