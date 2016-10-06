package main;

import GameObjects.stone.Stone;
import control.MouseControl;
import controller.Controller;
import gui.Window;
import not_name.LocalPlayer;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Window w=createWindow(800,600,"",15);
        initPlayers(w);
    }
    public static void initPlayers(Window w){
        LocalPlayer player1=new LocalPlayer(new Stone((Color.RED)));
        LocalPlayer player2=new LocalPlayer(new Stone(Color.GREEN));
        player1.setOponent(player2);
        player2.setOponent(player1);

        w.addMouseListener(new MouseControl(player1,w));
    }
    private static Window createWindow(int width, int height, String s, int size) {
        return new Window(width,height,s);
    }
}
