package edu.fgcu.cso;

import java.util.Arrays;

/**
 * Created by William on 3/11/2015.
 */
public class HungarianAlgorithm {

    public HungarianAlgorithm() {

    }

    public int[] calcCSO(int[][] paraMatrix) {
        return null;
    }

    int[][] reduceMatrix(int[][] p){
        return null;
    }

    int[] checkForSolution(int[][] p){
        return null;
    }

    int[][] markTheZeroRows(int[][] p){
        return null;
    }

    int[][] adjustElements(int[][] p,int[][] t){
        return null;
    }

    /**
     * Copies Array a to b
     *
     * @param a
     * @param b
     * @param dim
     */
    private void copy2DArray(int[][] a, int[][] b, int dim) {
        //TODO Add addition Error Checking
        if (a != null && b != null && dim > 0) {
            for (int i = 0; i < dim; i++) {
                if (i < a.length) {
                    b[i] = Arrays.copyOf(a[i], dim);
                } else {
                    b[i] = new int[dim];
                }
            }
        }
    }


}