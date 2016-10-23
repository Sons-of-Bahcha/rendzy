package not_name;

import GameObjects.GameMap;
import GameObjects.stone.Stone;
import control.Control;
import gui.Window;

import java.awt.*;


/**
 * Класс игрока для игры на одном компьютере. В этом классе только один главный метод action() от которого происходят действие игрока (расстановка камушка).
 *
 * Created by ROOT on 04.10.2016.
 * @author Viteker
 * @version 1.3
 */
public class LocalPlayer extends Player {

    /**
     * так как в игру Rendzy могут играть только двое, то у одного из игрока обязательно должен быть опонент,
     * А вот может ли он меняться, остается под вопрос. Но если судить по логике, то вовремя игры опонент обычно никогда не меняется
     * поэтому это поле тоже лучше сделать final
     */
    private final LocalPlayer oponent;

    /**
     * Коструктор первого игрока. Этот конструктор предназначет для создания первого иигрока
     * Он же в свою очередь создает себе опонента и второму игроку следует просто обратиться к
     * методу getOponent() первого игрока
     * @param stone - камень первого игрока
     */
    public LocalPlayer(Stone stone){
        super(stone);
        Stone stonePlayer2= stone.getColor()== Color.RED ? new Stone(Color.GREEN) : new Stone(Color.RED);
        this.oponent=new LocalPlayer(stonePlayer2,this);
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
    private LocalPlayer(Stone stone, LocalPlayer oponent){
        super(stone);
        this.oponent=oponent;
    }

    /**
     * Ход игрока. Здесь проверяется, пуста ли клетка в которую игрок хочет положить камушек
     * Если да, то камушек ставится и управление передается следующему игроку,
     * Если нет, то управление не передается и просто ждем, когда игрок выберет пустое поле
     *
     * @param w - игровое поле на которм проверяем пустое поле {@link gui.Window}
     * @param x - координата x проверяющей ячейки {@link GameObjects.Cell} игрового поля {@link GameMap}
     * @param y - координата y проверяющей ячейки {@link GameObjects.Cell} игрового поля {@link GameMap}
     */
    public void action(Window w, int x, int y) {
        if(checkEmptyCell(w.getBg(), x, y)){
            w.getBg().setCell(x,y,stone);
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
     * @return - возвращает второго игрока, первому игроку нет мысла вызывать этот метод
     */
    public LocalPlayer getOponent() {
        return oponent;
    }
}
