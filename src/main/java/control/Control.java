package control;

import GameObjects.GameMap;
import GameObjects.stone.EmptyCell;
import not_name.LocalPlayer;

/**
 * Created by 123 on 06.10.2016.
 */
public class Control {
    public static LocalPlayer lp;
    private static GameMap gameMap;
    public Control(LocalPlayer lp){
        this.lp=lp;
    }
    public static void setGm(GameMap gm)
    {
        gameMap=gm;
    }
    public LocalPlayer getLp() {
        return lp;
    }
    /*
    Как работают эти злоебучие методы?
    Первый метод просто вызывает метод isFiveInRow(), Для каждой НЕПУСТОЙ клетки поля, если хоть один вернёт тру, значит нашли победителя.
    isFiveInRow(i,j,"direction"), принимает как аргументы координаты той точки которую мы проверяем и строку, которая указывает нам
    направление запуска проверяющего луча, который проверяет каждую следующую клетку от текущей в поисках похожих елементов
    там карочи творится магия, я не могу её объяснить. Работает и ладно?! Она слишком очевидная
     */
    private static void isPlayerWinner() throws Exception {
        for(int i=0;i<15;i++)
            for(int j=0;j<15;j++)
            {
                if(!(gameMap.getCell(i,j).getStone() instanceof EmptyCell))
                    if(isFiveInRow(i,j,"right-down") || isFiveInRow(i,j,"up")||isFiveInRow(i,j,"down") || isFiveInRow(i,j,"left")||isFiveInRow(i,j,"right")
                            ||isFiveInRow(i,j,"left-down") || isFiveInRow(i,j,"right-up") || isFiveInRow(i,j,"left-up"))
                        throw new Exception("Winner is found. Winner color is "+lp.getOponent().getStone().getColor());
            }

    }
    private static boolean isFiveInRow(int x,int y, String direction)
    {
        int flag=0;   // переменная нужная для того чтобы проверять насколько мы должны были сместиться во время проверки и насколько реально сместились
        int isInRow=0; // счетчик подряд идущих элементов
        int dx=0;   // смещение по Х
        int dy=0;// смещение по У
        for(int i=1;i<5;i++)
        {

            if(direction.contains("down"))// если наша строка содержит, что надо идти вниз, значит заходим в иф
            {
                flag++;//раз мы зашли в иф, то инкрементируем, чтобы не получилось говняшек всяких из-за следующего ифа
                if(x<15 && x>=0 && y>=0 && y+5<15)//этот иф проверяет не вылезем ли мы со своими ебучими проверками за поле и получим outofboundsexception
                    dy++; // все заебись, дошли до этой строки? инкрементируем смещение по У
                        // следующие ифы аналогично
            }
            if(direction.contains("up"))
            {
                flag++;
                if(x<15 && x>=0 && y-5>=0 && y<15)
                    dy--;
            }
            if(direction.contains("left"))
            {
                flag++;
                if(x<15 && x-5>=0 && y>=0 && y<15)
                    dx--;
            }

            if(direction.contains("right"))
            {
                flag++;
                if(x+5<15 && x>=0 && y>=0 && y<15)
                    dx++;
            }
            if(flag==Math.abs(dx)+Math.abs(dy))// проверяем, совпадает ли то сколько мы должны были пройти, с правдой?
                if(gameMap.getCell(dx+x,dy+y).getStone()==gameMap.getCell(x,y).getStone())// сверяем текущий камешек со следующим
                    isInRow++;//пиздато? ++

        }
        return (isInRow==4);
    }

    public static void setLp(LocalPlayer lpr) {
        lp = lpr;
        try {
            isPlayerWinner();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
