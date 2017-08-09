package com.messenger;

import com.messenger.controllers.ServerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Shishkov A.V. on 08.08.2017.
 */
public class ServerMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream("/views/main.fxml"));

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("Сервер");
        primaryStage.setResizable(false);

        primaryStage.setOnCloseRequest(e -> {
            ServerController controller = loader.getController();
            try {
                controller.stopServer();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
