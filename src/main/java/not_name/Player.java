package not_name;

import gameObjects.stone.Stone;

/**
 * Created by Viteker on 23.10.2016.
 * @author Viteker
 * @version 1.0
 */
public abstract class Player implements Action{
    /**
     * Каждый игрок имеет свой цвет камушка, и изменять его не желательно.
     * Поэтому это поле лучше сделать final
     */
    protected final Stone stone;

    public Player(Stone stone){
        this.stone=stone;
    }
    /**
     * @return Возвращает камушек этого игрока
     */
    public Stone getStone() {
        return stone;
    }
}
