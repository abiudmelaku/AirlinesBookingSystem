package com.AirlinesLauncher;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            boolean stop = false;
            ServerSocket server = new ServerSocket(400);
            while(!stop){
                System.out.println("Waiting for connection ...");
                Socket Servernode = server.accept();
                C2SCommunication communicate = new C2SCommunication(Servernode);
                Thread thread = new Thread(communicate);
                thread.run();

            }
//            Servernode.close();

        } catch (IOException e) {
            System.out.println("Err : " + e);
        }
    }

}
