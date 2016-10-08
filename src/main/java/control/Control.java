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
    ��� �������� ��� ��������� ������?
    ������ ����� ������ �������� ����� isFiveInRow(), ��� ������ �������� ������ ����, ���� ���� ���� ����� ���, ������ ����� ����������.
    isFiveInRow(i,j,"direction"), ��������� ��� ��������� ���������� ��� ����� ������� �� ��������� � ������, ������� ��������� ���
    ����������� ������� ������������ ����, ������� ��������� ������ ��������� ������ �� ������� � ������� ������� ���������
    ��� ������ �������� �����, � �� ���� � ���������. �������� � �����?! ��� ������� ���������
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
        int flag=0;   // ���������� ������ ��� ���� ����� ��������� ��������� �� ������ ���� ���������� �� ����� �������� � ��������� ������� ����������
        int isInRow=0; // ������� ������ ������ ���������
        int dx=0;   // �������� �� �
        int dy=0;// �������� �� �
        for(int i=1;i<5;i++)
        {

            if(direction.contains("down"))// ���� ���� ������ ��������, ��� ���� ���� ����, ������ ������� � ��
            {
                flag++;//��� �� ����� � ��, �� ��������������, ����� �� ���������� �������� ������ ��-�� ���������� ���
                if(x<15 && x>=0 && y>=0 && y+5<15)//���� �� ��������� �� ������� �� �� �� ������ ������� ���������� �� ���� � ������� outofboundsexception
                    dy++; // ��� �������, ����� �� ���� ������? �������������� �������� �� �
                        // ��������� ��� ����������
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
            if(flag==Math.abs(dx)+Math.abs(dy))// ���������, ��������� �� �� ������� �� ������ ���� ������, � �������?
                if(gameMap.getCell(dx+x,dy+y).getStone()==gameMap.getCell(x,y).getStone())// ������� ������� ������� �� ���������
                    isInRow++;//�������? ++

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
