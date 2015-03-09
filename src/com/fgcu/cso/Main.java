package com.fgcu.cso;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Main extends Application {

    public static Window primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Customer Satisfaction Optimizer ");
        primaryStage.setScene(new Scene(root, 700, 550));
        FileManager.getFile("34");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
