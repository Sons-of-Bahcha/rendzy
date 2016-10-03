package not_name;

/**
 * Класс игрока, его главные действия должны вызываться в методе action.
 * А метод action в свою очередь вызывается каждую итерацию игрого цикла
 *
 * Итак, когда чувак ходит, он выбирает ячейку(клетку) куда походить.
 *
 * Сначала нужно проверить верно ли он передал координаты, тоесть не кликнул ли он за пределы поля.
 * Пусть это будет метод checkKoordinates(int x,int y);
 * Причем координаты x и y - координаты {@link GameObjects.Field}
 * а не координаты класса {@link GameObjects.GameMap}
 *
 * Потом перед тем, как поставить нужно проверить, свободна ли эта ячейка, пусть это будет метод checkEmptyCell(int x,int y);
 * Допустим, можешь называть подругому.
 *
 * Затем ставить, вызывая в классе {@link GameObjects.Field} setFigure(new Stone(Color.BLACK || Color.WHITE));
 * Соответсвующий камушек, для соответствующего игрока. Пусть это будет в методе setStone(int x,int y);
 *
 * А проверку на вигрыш попробуй сделать в отдельном классе, чтобы там проверялся выигрыш или проигрыш. А не занимался этим игрок.
 * Так будет потом на сервер легче поставить проверялку.
 *
 * Created by 123 on 03.10.2016.
 * @author Viteker
 * @version 1.0
 */
public interface Player extends Action{
    boolean checkKoordinates(int x,int y);
    boolean checkEmptyCell(int x,int y);
    void setStone(int x,int y);
}
