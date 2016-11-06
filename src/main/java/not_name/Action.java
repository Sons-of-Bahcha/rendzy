package not_name;

import gameObjects.GameMap;
import gui.Window;

/**
 * Любой класс реализующий этот метод, означает, что он входит в разряд
 * игровых моделей, которые могут повлиять на игру.
 * В другом смысле это означает, что класс Controller {@link controller.Controller}
 * обращается к методам этого класса, в ходе своего игрового цикла
 * Created by Viteker on 03.10.2016.
 * @autor Viteker
 * @version 1.1
 */
public interface Action {
    /**
     * @param w - Игровое поле {@link gui.Window}
     * @param x - координата x ячейки {@link gameObjects.Cell} игрового поля {@link GameMap}
     * @param y - координата y ячейки {@link gameObjects.Cell} игрового поля {@link GameMap}
     */
    void action(Window w, int x, int y);
}
