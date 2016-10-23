package client;


import GameObjects.stone.Stone;
import not_name.LocalPlayer;
import not_name.OnlinePlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Client implements ActionListener{
    static final int port=1234;
    static final String addres="7.54.240.130";

    DataInputStream read;
    DataOutputStream write;

    public Client(){
        try{
            Socket sc=new Socket(addres,port);
            System.out.println("Connection -- true");
            read=new DataInputStream(sc.getInputStream());
            write=new DataOutputStream(sc.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OnlinePlayer getPlayer(){
        try{
            byte[] b=new byte[2];
            read.read(b);
            String line=new String(b);
            System.out.println("Line=|"+line+"|");
            System.out.println("Boolean =="+line.equals("55")+"/");

            if(line.equals("55")){
                System.out.println("U're first player");
                return new OnlinePlayer(new Stone(Color.GREEN),this);

            }else if(line.equals("44")){
                System.out.println("U're second player");
                return new OnlinePlayer(new Stone(Color.RED),this);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
    }

    public String send(String s) throws IOException {
        byte[] b=new byte[1024];

        write.write(s.getBytes());
        System.out.println("I sent: "+s);
        write.flush();

        read.read(b);
        s=new String(b);
        System.out.println("I received: "+s);
        return s;
    }
    public static void main(String[] args){

        try {
            BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("русский текст");
            Socket sc=new Socket(addres,port);
            System.out.println("Connect");

            DataInputStream read=new DataInputStream(sc.getInputStream());
            DataOutputStream write=new DataOutputStream(sc.getOutputStream());

            System.out.println("have created streams");

            String line;
            byte[] b=new byte[1024];
            while(true){
                read.read(b);
                line=new String(b);
                System.out.println("I received: "+line);

                line=keyboard.readLine();
                write.write(line.getBytes());
                write.flush();
                System.out.println("I sent: "+line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
