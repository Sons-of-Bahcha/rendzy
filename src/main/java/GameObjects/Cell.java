package GameObjects;

import GameObjects.stone.DrawStone;
import GameObjects.stone.EmptyCell;

/**
 * Класс Cell, это просто ячейка на игровом поле. Эта ячейка будет восприниматься, как точка, без ширины и длины.
 * Тоесть она будет содеражать свои координаты x и y, отличные от координат игрового поля(GameMap)
 * Чтобы перевести координаты Cell в координаты GameMap, достаточно будет просто каждую координату умножить на размер ячейки
 * Тоесть x=x*size, y=y*size;
 * Это сделано для того, чтобы потом было удобней рисовать грани ячеейки, если на нее наведен курсор.
 * Типа как в веселой ферме, когда наводим на грядку, она выделяется курсивом, тут тоже самое
 *
 * Поле size (размер всех ячеек) пусть хранится в классе GameMap, чтобы для всех Cell был один размер, а не для каждого свой
 *
 * Ну вроде все
 *
 * @Changed by Maks
 * @autor Viteker
 * @version 1.1
 *
 * !!! Замечание - Вроде тест не нужен и так все понятно
 */

public class Cell {
    private final int x,y;
    private DrawStone stone=new EmptyCell();

    /**
     * Единственный нужный конструктор, который устанавливает неизменные координаты ячейки поля
     * @param x - координата x ячеейки, с учетом, что она уже преобразованна в  координату Cell, а не GameMap
     * @param y- координата y ячеейки, с учетом, что она уже преобразованна в  координату Cell, а не GameMap
     */
    public Cell(int x, int y){
        this.x=x; this.y=y;
    }

    /**
     *
     * @return Возвращает данную фигуру в этой ячейке, тоесть либо нолик, либо крестик
     */
    public DrawStone getStone() {
        return stone;
    }
    /**
     *
     * @param figure - устанавливаем в этой фигуре либо ноль, либо крестик
     */
    public void setStone(DrawStone figure) {
        this.stone = figure;
    }

    /**
     * @return координата x
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return координата y
     */
    public int getY() {
        return y;
    }
}
