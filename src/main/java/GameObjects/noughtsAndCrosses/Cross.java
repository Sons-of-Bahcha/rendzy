package GameObjects.noughtsAndCrosses;

import java.awt.*;

/**
 * Класс "Крестик". Этот класс ничего не делает, кроме того, что сам себя рисует в нужном месте
 * Created by Viteker on 03.10.2016.
 * @author Viteker
 * @version 1.0
 *
 * !!!Замечание - класс полностью не тестировался.
 */
public class Cross implements  DrawFigure{
    /**
     * Метод в котором рисуется крестик, причем цвет устанавливается по умолчанию зеленый
     *
     * @param g    - Графический объект на котором рисуем данную фигуру
     * @param x    - Координата x
     * @param y    - Координата y
     * @param size - Размер этой самой фигуры учитываем, что width=height
     *
     * !!! Замечание - метод не тестировался. Ожидаемый результат - в гр. объекте рисуется крестик в нужном месте и
     *             снужными размерами
     */
    public void draw(Graphics g, int x, int y, int size) {
        Color c=g.getColor();//Сохраняем текущий цвет в гр. объекте
        g.setColor(Color.GREEN);// Устанавливаем нужным нас цвет
        g.drawLine(x,y,x+size,y+size);
        g.drawLine(x+size,y,x,y+size);
        g.setColor(c);//Возвращаем старый цвет
    }
}
