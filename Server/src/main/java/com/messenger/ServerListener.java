package com.messenger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Shishkov A.V. on 09.08.2017.
 */
public class ServerListener extends Thread {
    private static final int PORT = 4321;

    private volatile boolean isRunning;
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public ServerListener() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (clientSocket != null)
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void startListening() {
        isRunning = true;
        start();
    }

    public void stopListening() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

}
