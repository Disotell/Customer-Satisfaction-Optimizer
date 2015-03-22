package edu.fgcu.cso;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class Main {

    private void start(FileFormater fileFormater, HungarianAlgorithm hungAlgo, GUI gui){
        File file = getFile();

        int[][] initialMatrix = fileFormater.getData(file);
        int[][] reversedMatrix = reverseMinMax(initialMatrix);
        int[] solution = hungAlgo.calcCSO(reversedMatrix);

        gui.buildGUI(initialMatrix,solution);
    }

    private File getFile(){

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Please choose a a file containing a Satisfaction Matrix");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Comma Separated Values (.csv)","csv"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        else{
            return null;
        }
    }

    /**
     * Converts the data so Min and Max are inverted
     */
    private int[][] reverseMinMax(int[][] matrix){

        return new int[2][2];
    }

    public static void main(String[] args){
        Main main = new Main();
        main.start(new FileFormater(),new HungarianAlgorithm(), new GUI());
    }
}
