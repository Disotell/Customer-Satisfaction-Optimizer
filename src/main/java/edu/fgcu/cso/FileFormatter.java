package edu.fgcu.cso;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by William on 3/11/2015.
 */
public class FileFormatter {

    /**
     *
     */
    protected FileFormatter() {

    }

    /**
     * @return
     */
    protected int[][] getData(File file) throws IOException{
        String[][] stringMatrix = readData(file);

        checkSquare(stringMatrix);

        int[][] matrix = parseData(stringMatrix);

        return matrix;
    }

    /**
     * Read Data from file and convert to String Array
     */
    public String[][] readData(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String[]> stringValues = new ArrayList<String[]>();

        String line = br.readLine();

        while (line != null) {
            String[] lineValues = line.split(",");
            stringValues.add(lineValues);
            line = br.readLine();
        }

        if(stringValues.size() == 0){
            return null;
        }
        else {
            String[][] toReturn = new String[stringValues.size()][];
            stringValues.toArray(toReturn);
            return toReturn;
        }
    }

    /**
     * Converts String data array to int array
     */
    public int[][] parseData(String[][] stringMatrix) {
        int[][] row = new int[stringMatrix.length][stringMatrix[0].length];
        //TODO parse out tokens
        return row;
    }

    /**
     * Checks if the rows and column are equal
     */
    public boolean checkSquare(String[][] matrix) {
        //TODO return based on matrix
        return false;
    }


}
