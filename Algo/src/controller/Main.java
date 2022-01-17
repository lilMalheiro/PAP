package controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage ) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/sample.fxml"));
        primaryStage.setTitle("MaxMusic");
        primaryStage.setScene(new Scene(root, 300, 275));
        Image image = new Image("/img/iconic2.png");
        primaryStage.getIcons().add(image);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent arg0) {

                Platform.exit();
                System.exit(0);
            }
        });

    }



    public static void main(String[] args) {
        launch(args);
    }
}

