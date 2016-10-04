package GameObjects;

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
 * @version 1.1
 */
public class GameMap extends BufferedImage {
    /*Table map;   предлагаю сделать не один объект а массив ячеек этой карты
    private Graphics g; - можно убрать, т.к. мы можем получить доступ к нему, обратившись к геттеру

    А этот метод можнои не переопределять
    @Override
    public Graphics getGraphics() {
        return super.getGraphics();
    }
    */

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
    public boolean isCellFree(int x,int y)
    {
        return (cells[y][x] == null);

    }
    public void setCell(int x,int y,Stone s) {
        cells[y][x].setFigure(s);
    }
    public GameMap(int width, int height, int imageType) {
        super(width, height, imageType);
    }
}
