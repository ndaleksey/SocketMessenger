package com.messenger.controllers;

import com.messenger.ServerListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * Created by Shishkov A.V. on 08.08.2017.
 */
public class ServerController {
    private ServerListener serverListener;

    @FXML
    private Button startServerButton;

    @FXML
    private ListView<String> logsListView;

    public ServerController() {
        serverListener = new ServerListener();
    }

    @FXML
    private void initialize() {
        startServerButton.setOnAction(e -> {
            try {
                startServerButtonClick();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void startServerButtonClick() throws InterruptedException {
        if (!serverListener.isRunning()) {
            startServer();
            startServerButton.setText("Стоп");
            System.out.println("Сервер запущен");
        } else {
            stopServer();
            startServerButton.setText("Старт");
            System.out.println("Сервер остановлен");
        }
    }

    private void startServer() {
        serverListener.startListening();
    }

    public void stopServer() throws InterruptedException {
        if (serverListener != null)
        {
            serverListener.stopListening();
        }
    }
}
