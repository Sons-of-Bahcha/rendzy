package not_name;

import GameObjects.GameMap;
import GameObjects.stone.Stone;
import control.Control;

import java.awt.*;

/**
 * Класс игрока. В этом классе только один главный метод action() от которого происходят действие игрока (расстановка камушка).
 *
 * Created by ROOT on 04.10.2016.
 * @author Maks
 * @version 1.1 - меняй версию
 */
public class Player implements Action {
    /**
     * Каждый игрок имеет свой цвет камушка, и изменять его не желательно.
     * Поэтому это поле лучше сделать final
     */
    private final Stone stone;
    /**
     * так как в игру Rendzy могут играть только двое, то у одного из игрока обязательно должен быть опонент,
     * А вот может ли он меняться, остается под вопрос. Но если судить по логике, то вовремя игры опонент обычно никогда не меняется
     * поэтому это поле тоже лучше сделать final
     */
    private final Player oponent;

    /**
     * Коструктор первого игрока. Этот конструктор предназначет для создания первого иигрока
     * Он же в свою очередь создает себе опонента и второму игроку следует просто обратиться к
     * методу getOponent() первого игрока
     * @param stone - камень первого игрока
     */
    public Player(Stone stone){
        this.stone=stone;
        Stone stonePlayer2= stone.getColor()== Color.RED ? new Stone(Color.GREEN) : new Stone(Color.RED);
        this.oponent=new Player(stonePlayer2,this);
    }

    /**
     * Коструктор для второго игрока, который может вызываться только от первого игрока.
     * Он вызывается когда первый игрока создает себе опонента
     * Чтобы второму игроку получить себе ссылку на второго игрока, нужно у первого обратиться к методу
     * getOponent()
     *
     * @param stone - камушек для второго игрока
     * @param oponent - первый игрок
     */
    private Player(Stone stone,Player oponent){
        this.stone=stone;
        this.oponent=oponent;
    }

    /**
     * Ход игрока. Здесь проверяется, пуста ли клетка в которую игрок хочет положить камушек
     * Если да, то камушек ставится и управление передается следующему игроку,
     * Если нет, то управление не передается и просто ждем, когда игрок выберет пустое поле
     *
     * @param mp - игровое поле на которм проверяем пустое поле {@link GameMap}
     * @param x - координата x проверяющей ячейки {@link GameObjects.Cell} игрового поля {@link GameMap}
     * @param y - координата y проверяющей ячейки {@link GameObjects.Cell} игрового поля {@link GameMap}
     */
    public void action(GameMap mp,int x,int y) {
        if(checkEmptyCell(mp, x, y)){
            mp.setCell(x,y,stone);
            Control.setLp(oponent);
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

    /**
     * @return Возвращает камушек этого игрока
     */
    public Stone getStone() {
        return stone;
    }

    /**
     * @return - возвращает второго игрока, первому игроку нет мысла вызывать этот метод
     */
    public Player getOponent() {
        return oponent;
    }
}
