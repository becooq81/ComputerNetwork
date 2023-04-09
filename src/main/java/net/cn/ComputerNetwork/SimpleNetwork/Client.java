package net.cn.ComputerNetwork.SimpleNetwork;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    public Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            input = new DataInputStream(System.in);

            output = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String line = "";

        while (!line.equals("Over")) {
            try {
                line = input.readUTF();
                output.writeUTF(line);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void main(String args[]) {
        Client client = new Client("127.0.0.1", 5000);
    }
}
