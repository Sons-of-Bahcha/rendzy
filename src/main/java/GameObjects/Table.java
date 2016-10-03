package GameObjects;

/**
 * Created by ROOT on 02.10.2016.
 */
public class Table {

    private int[][] table;
    public Table()
    {
        table =new int[15][15];
    }
    public void setCell(int x,int y, int status)
    {
        table[x][y]=status;
    }
    public int getStatusInCell(int x, int y)
    {
        return  table[x][y];
    }
    public int[][] getTable() {
        return table;
    }

    public void setTable(int[][] table) {
        this.table = table;
    }
}
