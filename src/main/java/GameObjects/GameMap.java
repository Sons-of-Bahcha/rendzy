package GameObjects;

import GameObjects.stone.DrawStone;
import GameObjects.stone.EmptyCell;
import GameObjects.stone.Stone;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Предлагаю вместо одного непонятного класса в котором содержится массив интов,
 * заменить на массив ячеек игрового поля, т.е. чтобы этот массив хранился здесь, а не там
 * {@link Cell} - Вот этот класс, в нем будет храниться текущая фигура, которая сама себя рисует.
 * То что, она сама себя рисует - это удобно. Но с подсчетом количества нужно будет подумать
 *
 * Changed by Viteker on 03.10.2016. 9:38
 * Сорян нечаяно стер, когда ты созда этот класс) добавь потом
 * @author ROOT
 * @version 1.2
 */
public class GameMap extends BufferedImage {
    private final int sizeCell;//размер ячейки поля
    private Cell[][] cells; // Создаем массив ячеек поля
    private int x,y;

    /**
     * главный конструктор для создания Image
     * @param typeIntRgb - тип цветовой модели
     */
    public GameMap(int x,int y, int typeIntRgb, int sizeCell) {
        super(sizeCell*15,sizeCell*15,typeIntRgb);
        this.sizeCell=sizeCell;
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
