package not_name;

import gameObjects.Cell;
import gameObjects.GameMap;
import gameObjects.stone.Stone;
import client.Client;
import gui.Window;

import java.awt.*;
import java.io.IOException;

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
     * @param w - Игровое поле {@link gui.Window}
     * @param x  - координата x ячейки {@link Cell} игрового поля {@link GameMap}
     * @param y  - координата y ячейки {@link Cell} игрового поля {@link GameMap}
     */
    public void action(Window w, int x, int y) {
        if(checkEmptyCell(w.getBg(), x, y)){
            w.getBg().setCell(x,y,stone);
            w.repaint();
            System.out.println("I drawed");
            try {
                client.send("0 "+x+" "+y);
                s=client.receive().split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }


            int opX=Integer.parseInt(s[1]);
            int opY=Integer.parseInt(s[2]);

            System.out.println("opx="+opX+" opy="+opY);

            w.getBg().setCell(opX,opY,oponentStone);
            //w.repaint();
        }
    }

    /**
     *  Проверка пустая ли ячейка поля. И можно ли туда положить камушек
     *
     * @param m - игровое поле, в котором проверяем пустое поле {@link GameMap}
     * @param x - координата x проверяющей ячейки {@link gameObjects.Cell} игрового поля {@link GameMap}
     * @param y - координата y проверяющей ячейки {@link gameObjects.Cell} игрового поля {@link GameMap}
     * @return возвращает true, если ячейка поля пуста и false  в противном случае
     */
    private boolean checkEmptyCell(GameMap m,int x, int y) {
        return (m.isCellFree(x,y));
    }
}
