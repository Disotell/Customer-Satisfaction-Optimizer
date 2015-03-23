package edu.fgcu.cso;

import java.io.File;

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
     *
     * @return
     */
    protected int[][] getData(File file){
        String[][] stringMatrix = readData(file);

        checkSquare(stringMatrix);

        int[][] matrix = parseData(stringMatrix);

        return matrix;
    }

    /**
     * Read Data from file and convert to String Array
     */
    private String[][] readData(File file){

        return  new String[2][2];
    }

    /**
     * Converts String data array to int array
     */
    private int[][] parseData(String[][] stringMatrix){
        int[][] row = new int[stringMatrix.length][stringMatrix[0].length];
        //TODO parse out tokens
        return  row;
    }

    /**
     * Checks if the rows and column are equal
     */
    private boolean checkSquare(String[][] matrix){
        //TODO return based on matrix
        return  false;
    }



}
