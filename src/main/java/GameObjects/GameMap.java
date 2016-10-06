package GameObjects;

import GameObjects.stone.EmptyCell;
import GameObjects.stone.Stone;

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
    //Здесь я заебеню анонимный конструктор и рандомный размер массива поставлю, потом сам поставь сколько тебе нужно будет
    {
        cells=new Cell[15][15];
        //заполняем массив стартовыми ячейками, причем текущая фигура в ней = null, тоесть ни крестик, ни нолик
        for (int y=0;y<cells.length;y++) {
            for(int x=0;x<cells[y].length;x++){
                cells[y][x]=new Cell(x,y);
            }
        }
    }
    /**
     * главный конструктор для создания Image
     * @param width - ширина image
     * @param height - высота image
     * @param typeIntRgb - тип цветовой модели
     */
    public GameMap(int width, int height, int typeIntRgb, int sizeCell) {
        super(width,height,typeIntRgb);
        this.sizeCell=sizeCell;
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
    public void setCell(int x,int y,Stone s) {
        cells[y][x].setStone(s);
    }

}
