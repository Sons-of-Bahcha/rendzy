package not_name;

import GameObjects.Cell;
import GameObjects.GameMap;
import GameObjects.stone.Stone;
import client.Client;
import control.Control;

import java.awt.*;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Viteker on 23.10.2016.
 */
public class OnlinePlayer extends Player{
    private final Client client;
    private final Stone oponentStone;
    private String[] s;
    public OnlinePlayer(Stone stone,Client client){
        super(stone);
        this.client=client;
        oponentStone=stone.getColor()== Color.RED ? new Stone(Color.GREEN) : new Stone(Color.RED);
    }

    /**
     *
     * @param mp - Игровое поле {@link GameMap}
     * @param x  - координата x ячейки {@link Cell} игрового поля {@link GameMap}
     * @param y  - координата y ячейки {@link Cell} игрового поля {@link GameMap}
     */
    public void action(GameMap mp, int x, int y) {
        if(checkEmptyCell(mp, x, y)){
            try {
                s=client.send("0 "+x+" "+y).split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            mp.setCell(x,y,stone);

            int opX=Integer.parseInt(s[1]);
            int opY=Integer.parseInt(s[2]);

            System.out.println("opx="+opX+" opy="+opY);

            mp.setCell(opX,opY,oponentStone);
        }
    }

    /**
     *  Проверка пустая ли ячейка поля. И можно ли туда положить камушек
     *
     * @param m - игровое поле, в котором проверяем пустое поле {@link GameMap}
     * @param x - координата x проверяющей ячейки {@link GameObjects.Cell} игрового поля {@link GameMap}
     * @param y - координата y проверяющей ячейки {@link GameObjects.Cell} игрового поля {@link GameMap}
     * @return возвращает true, если ячейка поля пуста и false  в противном случае
     */
    private boolean checkEmptyCell(GameMap m,int x, int y) {
        return (m.isCellFree(x,y));
    }
}
