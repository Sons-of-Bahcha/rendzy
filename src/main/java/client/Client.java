package client;


import gameObjects.stone.Stone;
import not_name.OnlinePlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

/**
 * Класс {@code Client} устанавливает соединение с сервером игры Rendzy
 * через главный конструкор {@link Client#Client(String, int)}
 * <p>
 * Клиент отправляет данные на серв, через метод {@link Client#send(String)}
 * И принимает данные через метод {@link Client#receive()}
 *
 * Для идентификации игрока в игре, нужно обратиться к методу {@link Client#getPlayer()}
 * после установления соединения с сервером.
 * @author Viteker
 * @version 1.0
 */
public class Client {
    /**
     *  Входной поток сервера, через который получаем данные с сервера
     */
    private final DataInputStream read;
    /**
     * Выходной поток сервера, через который отправляем данные на сервера
     */
    private final DataOutputStream write;

    /**
     * Конструктор для соединения с сервером, с указаным адресом и портом,
     * Здесь же получаем входной и выходной поток сервера, чтобы получать
     * и отправлять данные серверу.
     *
     * @param address - адрес сервера
     * @param port - порт сервера
     * @throws IOException - ошибка если что-то невозможно считать что-то с сервера
     */
    public Client(final String address, final int port) throws IOException {
        Socket sc = new Socket(address, port);
        System.out.println("Connection -- true");

        write = new DataOutputStream(sc.getOutputStream());
        read = new DataInputStream(sc.getInputStream());
    }

    /**
     * Считываем с сервера игрока. Сервер возвращает 55,
     * если текущий клиент, это первый игрок, тогда ему
     * устанавливается зеленый цвет камушек {@link  Stone}.
     * В противном случае, если с сервера пришел ответ 44,
     * значит это второй игрок и цвет его камушка {@link Stone}
     * становится красным.
     * @return {@link OnlinePlayer} игрока с сервера
     */
    public OnlinePlayer getPlayer() {
        try {
            byte[] b = new byte[2];
            read.read(b);
            String line = new String(b);
            System.out.println("Line=|" + line + "|");
            System.out.println("Boolean ==" + line.equals("55") + "/");

            if (line.equals("55")) {
                System.out.println("U're first player");
                return new OnlinePlayer(new Stone(Color.GREEN), this);

            } else if (line.equals("44")) {
                System.out.println("U're second player");
                return new OnlinePlayer(new Stone(Color.RED), this);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * этот метод отправляет данные на серв
     * @param s - строка, которую нужно отправить
     * @throws IOException
     */
    public void send(String s) throws IOException {
        write.write(s.getBytes());
        System.out.println("I sent: " + s);
        write.flush();

    }

    /**
     * Этот метод возвращает в виде строки данные полученные с сервера
     * @return строку типа {@code String} с сервера
     * @throws IOException
     */
    public String receive() throws IOException {
        byte[] b = new byte[10];
        int len = read.read(b);
        String s = new String(b, 0, len);
        System.out.println("I received: " + s);
        return s;
    }
    /*
    public static void main(String[] args){

        try {
            BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("русский текст");
            Socket sc=new Socket(address,port);
            System.out.println("Connect");

            DataInputStream read=new DataInputStream(sc.getInputStream());
            DataOutputStream write=new DataOutputStream(sc.getOutputStream());

            System.out.println("have created streams");


            byte[] b=new byte[1024];
            while(true){
                int len = read.read(b);
                String line=new String(b,0,len);
                System.out.println("I received: "+line);

                line=keyboard.readLine();
                write.write(line.getBytes());
                write.flush();
                System.out.println("I sent: "+line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
