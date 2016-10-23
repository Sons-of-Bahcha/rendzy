package main;

import GameObjects.stone.Stone;
import control.MouseControl;
import gui.Window;
import not_name.LocalPlayer;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Window w=createWindow(800,600,"");
        //initPlayers(w);
        initMultiplayer();
    }

    /**
     * инициализируем игрока для мультиплеерной игры
     */
    public static void initMultiplayer(){
        LocalPlayer p=new LocalPlayer();
    }
    /**
     *
     * @param w - игровое окно в котором
     */
    public static void initPlayers(Window w){
        LocalPlayer localPlayer1 =new LocalPlayer(new Stone((Color.RED)));
        LocalPlayer localPlayer2 = localPlayer1.getOponent();

        w.addMouseListener(new MouseControl(localPlayer1,w));
    }
    private static Window createWindow(int width, int height, String s) {
        return new Window(width,height,s);
    }
}
