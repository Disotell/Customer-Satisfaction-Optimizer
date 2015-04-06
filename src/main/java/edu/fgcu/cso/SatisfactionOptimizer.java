package edu.fgcu.cso;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Finds the Optimal Customer Satisfaction
 * from a Weighted Square Matrix
 */
public class SatisfactionOptimizer {

    public int[] calcCSO(int[][] costmatrix) {
        //Initializes Arrays

        int[][] costMatrix = copy2DArray(costmatrix);
        int[][] cM = reverseMinMax(costMatrix);

        // 1s mean covered, 0s mean not covered
        int[] mRows = new int[cM.length];
        int[] mCols = new int[cM[0].length];


        int[] zerosByRow = new int[costMatrix.length];
        int[] zerosByCol = new int[costMatrix[0].length];
        int[] onlyZeroByRow = new int[costmatrix.length];

        //Fill Arrays with -1
        Arrays.fill(zerosByCol, -1);
        Arrays.fill(zerosByRow, -1);
        Arrays.fill(onlyZeroByRow, -1);

        // subtract minumum value from rows and columns to create lots of zeroes
        reduceMatrix(cM);

        markTheZeroRows(cM, mRows, mCols);

        return null;
    }

    /**
     * Copies Array a to b
     *
     * @param a Original Array
     * @return b Copy of Array a
     */
    int[][] copy2DArray(int[][] a) {
        int[][] b;
        if (a != null && a.length > 0) {
            b = new int[a.length][];
            for (int i = 0; i < a.length; i++) {
                b[i] = Arrays.copyOf(a[i], a[i].length);
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return b;
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
     * Finds the smallest element in each row
     * and subtract it's values from all elements
     * in that row
     *
     * @param cM costMatrix Cost Matrix
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
                for (int[] aCM : cM) {
                    if (minColVal > aCM[i]) {
                        minColVal = aCM[i];
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

    /**
     * Identifys the rows and columns with Zeros
     *
     * @param cM    cost Matrix
     * @param mRows row with zero
     * @param mCols column with zero
     */ 
    void markTheZeroRows(int[][] cM, int[] mRows, int[] mCols) {

        if (cM != null && cM.length > 0
                && mRows != null && mRows.length > 0
                && mCols != null && mCols.length > 0) {

            // find the minimum uncovered value
            int minUncoveredValue = Integer.MAX_VALUE;
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
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Checks to see if all the columns have a match
     *
     * @param mCols column with zero
     * @return true = solution found | false = solution not found
     */
    boolean checkForSolution(int[] mCols) {
        if (mCols != null && mCols.length > 0) {
            for (int m : mCols) {
                if (0 == m) 
                    return false;
            }
            return true;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    /**
     * 
     * 
     * @param solZero
     * @param zerosByRow
     * @param zerosByCol
     * @param onlyZeroByRow
     */
    void adjustElements(int[] solZero, int[] zerosByRow, int[] zerosByCol, int[] onlyZeroByRow) {
        if (solZero != null && solZero.length > 0
                && zerosByRow != null && zerosByRow.length > 0
                && zerosByCol != null && zerosByCol.length > 0
                && onlyZeroByRow != null && onlyZeroByRow.length > 0) {

            int i;
            int j = solZero[1];

            Set<int[]> zeroSequence = new LinkedHashSet<int[]>();
            zeroSequence.add(solZero);

            boolean matched = false;
            do {
                i = zerosByCol[j];
                matched = -1 != i && zeroSequence.add(new int[]{i,j});
                if (!matched) break;

                j = onlyZeroByRow[i];
                matched = -1 != j && zeroSequence.add(new int[]{ i, j });

            } while (matched);

            for (int[] zero : zeroSequence) {
                if (zerosByCol[zero[1]] == zero[0]) {
                    zerosByCol[zero[1]] = -1;
                    zerosByRow[zero[0]] = -1;
                }
                if (onlyZeroByRow[zero[0]] == zero[1]) {
                    zerosByRow[zero[0]] = zero[1];
                    zerosByCol[zero[1]] = zero[0];
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

}//End of SatisfactionOptimizer

