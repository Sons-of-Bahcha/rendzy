package not_name;

import GameObjects.Cell;
import GameObjects.GameMap;
import GameObjects.stone.Stone;

/**
 * Created by Viteker on 23.10.2016.
 */
public class OnlinePlayer extends Player implements Action{
    public OnlinePlayer(Stone stone){
        super(stone);
    }

    /**
     * Пока этот метод использует только класс {@link LocalPlayer} при своем ходе
     *
     * @param mp - Игровое поле {@link GameMap}
     * @param x  - координата x ячейки {@link Cell} игрового поля {@link GameMap}
     * @param y  - координата y ячейки {@link Cell} игрового поля {@link GameMap}
     */
    public void action(GameMap mp, int x, int y) {

    }
}
