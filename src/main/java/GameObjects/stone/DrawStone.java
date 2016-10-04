package GameObjects.stone;

import java.awt.*;

/**
 * Интерфейс в котором всего один метод, который рисует данную фигуру
 * Created by Viteker on 03.10.2016.
 * @author Viteker
 * @version 1.1
 */
public interface DrawStone {
    /**
     *  Метод в котором рисуется фигура, причем цвет устанавливается по умолчанию каждой фигуре, а не задается
     * @param g - Графический объект на котором рисуем данную фигуру
     * @param x - Координата x
     * @param y - Координата y
     * @param size - Размер этой самой фигуры учитываем, что width=height
     */
    public void draw(Graphics g, int x, int y, int size);
}
