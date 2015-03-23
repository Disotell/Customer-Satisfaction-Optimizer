package edu.fgcu.cso;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * Created by William on 3/11/2015.
 */
public class Main {

    private void start(FileFormatter fileFormatter, HungarianAlgorithm hungAlgo, GUI gui) {
        File file = getFile();

        int[][] initialMatrix = fileFormatter.getData(file);
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
    private int[][] reverseMinMax(int[][] data) {
        int max = Integer.MIN_VALUE;
        int[][] nData = new int[data.length][data.length];

        //Get Max Value and negate Values
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (data[i][j] > max) {
                    max = data[i][j];
                }
                nData[i][j] = -data[i][j];
            }
        }

        //Add max Value to all Elements
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                nData[i][j] = nData[i][j] + max;
            }
        }
        return nData;
    }

    public static void main(String[] args){
        Main main = new Main();
        main.start(new FileFormatter(), new HungarianAlgorithm(), new GUI());
    }
}
