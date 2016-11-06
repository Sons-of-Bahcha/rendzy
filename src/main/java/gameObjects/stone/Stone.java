package gameObjects.stone;

import java.awt.*;

/**
 * Класс "Нолик". Этот класс ничего не делает, кроме того, что сам себя рисует в нужном месте
 * Created by Viteker on 03.10.2016.
 * @author Viteker
 * @version 1.0
 *
 * !!! Замечание - класс полностью не тестировался.
 */
public class Stone implements DrawStone {
    private final Color color;

    /**
     *
     * @param color - цвет текущего камня, который не изменяется в течении игры
     */
    public Stone(Color color) {
        this.color = color;
    }

    /**
     * Метод в котором рисуется нолик, причем цвет устанавливается по умолчанию устанавливается красным
     *
     * @param g    - Графический объект на котором рисуем данную фигуру
     * @param x    - Координата x {@link gameObjects.GameMap}
     * @param y    - Координата y {@link gameObjects.GameMap}
     * @param size - Размер этой самой фигуры учитываем, что width=height
     *
     * !!! Замечание - метод не тестировался. Должен отрисоваться нолик в гр. объекте, в нужном месте и с нужными размерами
     */
    public void draw(Graphics g, int x, int y, int size) {
        Color c=g.getColor();//Сохраняем текущий цвет в гр. объекте
        g.setColor(color);// Устанавливаем нужным нас цвет
        g.fillOval(x,y,size,size);
        g.setColor(c);//Возвращаем старый цвет
    }

    /**
     *
     * @return возвращает ссылку на Color ячейки
     */
    public Color getColor() {
        return color;
    }
}
