package edu.fgcu.cso;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by William on 3/11/2015.
 */
public class SatisfactionOptimizer {

    private int[][] CM;  // the N-by-N weight matrix


    public SatisfactionOptimizer() {

    }

    public int[] calcCSO(int[][] costmatrix) {
        int[][] cM = new int[costmatrix.length][costmatrix.length];
        cM = reverseMinMax(costmatrix);


        // subtract minumum value from rows and columns to create lots of zeroes
        reduceMatrix(cM);
        // 1s mean covered, 0s mean not covered
        int[] coveredRows = new int[cM.length];
        int[] coveredCols = new int[cM[0].length];


        return null;

    }


    /**
     * Converts the data so Min and Max are inverted
     *
     * @param data Original Matrix
     * @return Formatted Matrix
     */
    public int[][] reverseMinMax(int[][] data) {
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

    /**
     * Copies Array a to b
     *
     * @param a
     * @param b
     * @param dim
     */
   public void copy2DArray(int[][] a, int[][] b, int dim) {
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

    /**
     * Finds the smallest element in each row
     * and subtract it's values from all elements
     * in that row
     *
     * @param cM costMatrix
     */
    private void reduceMatrix(int[][] cM) {
        for (int i = 0; i < cM.length; i++) {
            // find the min value in the row
            int minRowVal = Integer.MAX_VALUE;
            for (int j = 0; j < cM[i].length; j++) {
                if (minRowVal > cM[i][j]) {
                    minRowVal = cM[i][j];
                }
            }
            // subtract it from all values in the row
            for (int j = 0; j < cM[i].length; j++) {
                cM[i][j] -= minRowVal;
            }
        }

        // find the min value in the col
        for (int i = 0; i < cM[0].length; i++) {
            int minColVal = Integer.MAX_VALUE;
            for (int j = 0; j < cM.length; j++) {
                if (minColVal > cM[j][i]) {
                    minColVal = cM[j][i];
                }
            }
            // subtract it from all values in the col
            for (int j = 0; j < cM.length; j++) {
                cM[j][i] -= minColVal;
            }
        }
    }


    private void markTheZeroRows(int[][] cM, int[] mRows, int[] mCols) {

        // find the minimum uncovered value
        float minUncoveredValue = Integer.MAX_VALUE;
        for (int i = 0; i < cM.length; i++) {
            if (0 == mRows[i]) {
                for (int j = 0; j < cM[i].length; j++) {
                    if (0 == mCols[j] && cM[i][j] < minUncoveredValue) {
                        minUncoveredValue = cM[i][j];
                    }
                }
            }
        }

        // add the min value to all covered rows
        for (int i = 0; i < mRows.length; i++) {
            if (1 == mRows[i]) {
                for (int j = 0; j < cM[i].length; j++) {
                    cM[i][j] += minUncoveredValue;
                }
            }
        }

        // subtract the min value from all uncovered columns
        for (int i = 0; i < mCols.length; i++) {
            if (0 == mCols[i]) {
                for (int j = 0; j < cM.length; j++) {
                    cM[j][i] -= minUncoveredValue;
                }
            }
        }

    }


    int[] checkForSolution(int[][] p) {
        return null;
    }

    int[][] markTheZeroRows(int[][] p) {
        return null;
    }

    int[][] adjustElements(int[][] p, int[][] t) {
        return null;
    }


}

