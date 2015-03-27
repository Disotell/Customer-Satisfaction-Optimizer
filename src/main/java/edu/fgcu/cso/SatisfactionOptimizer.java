package edu.fgcu.cso;

import java.util.Arrays;

/**
 * Created by William on 3/11/2015.
 */
public class SatisfactionOptimizer {

    public SatisfactionOptimizer() {

    }

    public int[] calcCSO(int[][] costmatrix) {
        int[][] cM = new int[costmatrix.length][costmatrix.length];
        cM = reverseMinMax(costmatrix);


        // subtract minumum value from rows and columns to create lots of zeroes
        reduceMatrix(cM);
        // 1s mean covered, 0s mean not covered
        int[] mRows = new int[cM.length];
        int[] mCols = new int[cM[0].length];


        return null;

    }

    /**
     * Converts the data so Min and Max are inverted
     *
     * @param data Original Matrix
     * @return Formatted Matrix
     */
    int[][] reverseMinMax(int[][] data) {
        int[][] nData;
        if (data != null && data.length > 0) {
            int max = Integer.MIN_VALUE;
            nData = new int[data.length][data.length];

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
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return nData;
    }

    /**
     * Copies Array a to b
     *
     * @param a
     * @return b
     */
    int[][] copy2DArray(int[][] a) {
        int[][] b;
        if (a != null && a.length > 0) {
            b = new int[a.length][];
            for (int i = 0; i < a.length; i++) {
                if (i != 0) {
                    b[i] = Arrays.copyOf(a[i], a[i].length);
                } else {
                    b[i] = new int[a[i].length];
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return b;
    }

    /**
     * Finds the smallest element in each row
     * and subtract it's values from all elements
     * in that row
     *
     * @param cM costMatrix
     */
    void reduceMatrix(int[][] cM) {

        if (cM != null && cM.length > 0) {
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
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    void markTheZeroRows(int[][] cM, int[] mRows, int[] mCols) {
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

    int[][] adjustElements(int[][] p, int[][] t) {
        return null;
    }


}

