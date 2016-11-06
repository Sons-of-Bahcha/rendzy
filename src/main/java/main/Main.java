package main;

import gameObjects.stone.Stone;
import client.Client;
import control.MouseControl;
import gui.Window;
import not_name.LocalPlayer;
import not_name.OnlinePlayer;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Window w=createWindow(800,600,"");
        //initPlayers(w);
        initMultiplayer(w);
    }

    /**
     * инициализируем игрока для мультиплеерной игры
     */
    public static void initMultiplayer(Window w){
        Client c= null;
        try {
            c = new Client("192.168.0.58",1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
        OnlinePlayer p = c.getPlayer();
        System.out.println(" p =="+(p));
        System.out.println("Color="+p.getStone().getColor());
        w.addMouseListener(new MouseControl(p,w));
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
