package not_name;

import GameObjects.GameMap;

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
     * Пока этот метод использует только класс {@link LocalPlayer} при своем ходе
     * @param mp - Игровое поле {@link GameMap}
     * @param x - координата x ячейки {@link GameObjects.Cell} игрового поля {@link GameMap}
     * @param y - координата y ячейки {@link GameObjects.Cell} игрового поля {@link GameMap}
     */
    void action(GameMap mp,int x, int y);
}
