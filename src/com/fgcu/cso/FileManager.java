package com.fgcu.cso;

import javafx.stage.FileChooser;

/**
 * Created by William on 3/8/2015.
 */
public class FileManager {

    static double[][] getFile(String filename){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.showOpenDialog(Main.primaryStage);
        return null;
    }

}
