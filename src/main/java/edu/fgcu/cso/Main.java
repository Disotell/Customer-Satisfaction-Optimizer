package edu.fgcu.cso;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

/**
 * Created by William on 3/11/2015.
 */
public class Main {

    public void start(FileFormatter fileFormatter, SatisfactionOptimizer hungAlgo, GUI gui, File file) {

        int[][] initialMatrix = null;
        int[] solution = null;

        try {
            initialMatrix = fileFormatter.getData(file);
            solution = hungAlgo.calcCSO(initialMatrix);
        }
        catch (IOException ignored) {}


        gui.buildGUI(initialMatrix, solution);

    }

    public File getFile() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Please choose a a file containing a Satisfaction Matrix");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Comma Separated Values (.csv)", "csv"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.start(new FileFormatter(), new SatisfactionOptimizer(), new GUI(), main.getFile());
    }
}
