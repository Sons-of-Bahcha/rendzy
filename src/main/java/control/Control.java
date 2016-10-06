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

    private static void isPlayerWinner() throws Exception {
        for(int i=0;i<15;i++)
            for(int j=0;j<15;j++)
            {
                if(!(gameMap.getCell(i,j).getStone() instanceof EmptyCell))
                    if(isFiveInRow(i,j,"up")||isFiveInRow(i,j,"down") || isFiveInRow(i,j,"left")||isFiveInRow(i,j,"right"))
                        throw new Exception("Winner is found. Winner color is "+lp.getOponent().getStone().getColor());
            }

    }
    private static boolean isFiveInRow(int x,int y, String direction)
    {
        int isInRow=0;

        for(int i=0;i<5;i++)
        {
            if(direction=="down")
            {
                if(x<15 && x>=0 && y>=0 && y+5<15)
                if(gameMap.getCell(x,i+y).getStone()==gameMap.getCell(x,y).getStone())
                    isInRow++;
            }
            if(direction=="up")
            {
                if(x<15 && x>=0 && y-5>=0 && y<15)
                    if(gameMap.getCell(x,y-i).getStone()==gameMap.getCell(x,y).getStone())
                        isInRow++;
            }
            if(direction=="left")
            {
                if(x<15 && x-5>=0 && y>=0 && y<15)
                    if(gameMap.getCell(x-i,y).getStone()==gameMap.getCell(x,y).getStone())
                        isInRow++;
            }

            if(direction=="right")
            {
                if(x+5<15 && x>=0 && y>=0 && y<15)
                    if(gameMap.getCell(x+i,y).getStone()==gameMap.getCell(x,y).getStone())
                        isInRow++;
            }

        }
        return (isInRow==5);
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
