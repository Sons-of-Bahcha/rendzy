package GameObjects.stone;

import java.awt.*;

/**
 * Created by ROOT on 04.10.2016.
 * я хочу, чтобы этот класс был соседом класса Stone. Т.е пустые ячейки тоже будут содержать объекты. Объекты этого класса.
 * Это будет просто черный крест по середине, и по итогу мы получим сетку как в реверси
 */
public class emptyCell implements DrawStone {
    /**
     * Метод в котором рисуется нолик, причем цвет устанавливается по умолчанию устанавливается красным
     *
     * @param g    - Графический объект на котором рисуем данную фигуру
     * @param x    - Координата x {@link GameObjects.GameMap}
     * @param y    - Координата y {@link GameObjects.GameMap}
     * @param size - Размер этой самой фигуры учитываем, что width=height
     *
     * !!! Замечание - метод не тестировался. Должен отрисоваться крестик в гр. объекте, в нужном месте и с нужными размерами
     */
    public void draw(Graphics g, int x, int y, int size) {
        Color c=g.getColor();
        g.setColor(Color.BLACK);
        g.drawLine(x,y,x+size,y+size);
        g.drawLine(x+size,y,x,y+size);
        g.setColor(c);
    }
}
