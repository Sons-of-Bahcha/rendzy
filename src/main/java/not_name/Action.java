package not_name;

import GameObjects.GameMap;

/**
 * Любой класс реализующий этот метод, означает, что он входит в разряд
 * игровых моделей, которые могут повлиять на игру.
 * В другом смысле это означает, что класс Controller {@link controller.Controller}
 * обращается к методам этого класса, в ходе своего игрового цикла
 * Created by Viteker on 03.10.2016.
 * @autor Viteker
 * @version 1.0
 */
public interface Action {
    /**
     * Пока реализация этого метода такая,
     * какие ему понадобятся параметры, я не знаю.
     * Узнаем в ходе разработки
     */
    void action(GameMap mp,int x, int y);
}
