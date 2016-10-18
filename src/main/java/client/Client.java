package client;


import java.io.*;
import java.net.Socket;

public class Client{
    static int port=1234;
    static String addres="7.57.203.140";
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
                line=keyboard.readLine();
                write.write(line.getBytes());
                write.flush();
                System.out.println("I sent: "+line);

                read.read(b);
                line=new String(b);
                System.out.println("I received: "+line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
