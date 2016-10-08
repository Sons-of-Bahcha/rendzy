package main;

import GameObjects.stone.Stone;
import control.MouseControl;
import gui.Window;
import not_name.Player;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Window w=createWindow(800,600,"");
        initPlayers(w);
    }
    public static void initPlayers(Window w){
        Player player1=new Player(new Stone((Color.RED)));
        Player player2=player1.getOponent();

        w.addMouseListener(new MouseControl(player1,w));
    }
    private static Window createWindow(int width, int height, String s) {
        return new Window(width,height,s);
    }
}
