package GameObjects;

import GameObjects.stone.DrawStone;
import GameObjects.stone.EmptyCell;
import GameObjects.stone.Stone;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Надо добавить еще одну переменную размер поля(количество ячеек)
 *
 * Игровое поле. В этом классе хранится массив ячеек игрового поля {@link Cell}
 * Этот класс является наследником {@link BufferedImage}, а значит имеет свой графический объект,
 * который он отправляет своим ячейкам, чтобы они отрисовали камушек или ячейку пустого поля.
 * В зависимости, что сейчас находится в поле stone класса {@link Cell}
 *
 * @commenter Viteker
 * @author ROOT
 * @version 1.3
 */
public class GameMap extends BufferedImage {
    /**
     * Размер каждой ячейки. Вопрос: может ли меняться размер во время игры? По сути да, но пока пусть
     * это поле будет final
     */
    private final int sizeCell;
    /**
     * Количество ячеек в ширину игрового поля {@link GameMap}
     * рекомендуемые размеры: 15, 30, 45 (15x15 ; 30x30 ; 45x45);
     */
    private final int sizeRouds;
    /**
     * Матрица ячеек {@link Cell} игрового поля
     */
    private Cell[][] cells;
    /**
     * Координаты игрового поля, относительно главного окна {@link gui.Window}
     */
    private int x,y;

    /**
     * Главный и единственный конструктор игрового поля в котором создается
     * Игровое поле размеро
     * @param x
     * @param y
     * @param typeIntRgb
     * @param sizeCell
     */
    public GameMap(int x,int y, int typeIntRgb, int sizeCell,int sizeRouds) {
        super(sizeCell*15,sizeCell*15,typeIntRgb);
        this.sizeCell=sizeCell;
        this.sizeRouds=sizeRouds;
        this.x=x;
        this.y=y;
        prepareBackground();
        prepareCells();
    }
    /**
     * Метода который рисует игровое поле,
     * Вызывается после метода prepareBackground(), в главном конструкторе;
     */
    private void prepareCells(){
        cells=new Cell[15][15];
        //заполняем массив стартовыми ячейками, причем текущая фигура в ней = null, тоесть ни крестик, ни нолик
        for (int y=0;y<cells.length;y++) {
            for(int x=0;x<cells[y].length;x++){
                cells[y][x]=new Cell(x,y);
                setCell(x,y,new EmptyCell());//Вызывая сеттер, мы отрисовываем на поле этот крестик
            }
        }
    }
    /**
     * Подготавливаем белый фон для окна
     */
    private void prepareBackground(){
        Graphics g=getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(),getHeight());
    }
    /**
     * Метод преобразует координату x нажатия клавиши в координату x класса {@link Cell}
     * @param x - координата нажатия клавиши
     * @return преобразованная координате x класса {@link Cell}
     */
    public int transformX(int x){
        return x/sizeCell;
    }
    /**
     * Метод преобразует координату y нажатия клавиши в координату y класса {@link Cell}
     * @param y - координата нажатия клавиши
     * @return преобразованная координате y класса {@link Cell}
     */
    public int transformY(int y){
        return y/sizeCell;
    }
    /**
     *
     * @param x - координата x {@link GameMap}
     * @param y - координата y {@link GameMap}
     * @return находится
     */
    public boolean isCellFree(int x,int y)
    {
        return cells[y][x].getStone() instanceof EmptyCell;

    }
    public void setCell(int x,int y,DrawStone s) {
        cells[y][x].setStone(s);
        s.draw(getGraphics(),x*sizeCell,y*sizeCell,sizeCell);
    }

        public Cell getCell(int x,int y)
        {
            return cells[y][x];
        }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
