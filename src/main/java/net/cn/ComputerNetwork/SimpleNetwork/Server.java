package net.cn.ComputerNetwork.SimpleNetwork;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server has started.");

            System.out.println("Waiting for a client.");

            socket = server.accept();
            System.out.println("Client has been accepted.");

            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            while (!line.equals("Over")) {
                try {
                    line = input.readUTF();
                    System.out.println(line);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Closing connection.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String args[]) {
        Server server = new Server(5000);
    }
}
