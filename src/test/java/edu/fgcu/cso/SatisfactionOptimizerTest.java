package edu.fgcu.cso;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;


/**
 * Created by William on 3/22/2015.
 */
public class SatisfactionOptimizerTest {

    SatisfactionOptimizer satisfactionOptimizer;
    private int[][] testMatrix = new int[][]{{1, 2, 3}, {3, 2, 1}, {3, 2, 1}};


    @Before
    public void setup() {
        satisfactionOptimizer = new SatisfactionOptimizer();
    }

    public SatisfactionOptimizerTest() {

    }

    @Test
    public void testCalcCSO() {
        throw new RuntimeException();
    }

    // Copy2DArray Tests
    @Test
    public void jTestCopy2DArray() {
        int[][] test = satisfactionOptimizer.copy2DArray(testMatrix);
        for (int i = 0; i < testMatrix.length; i++) {
            for (int j = 0; j < testMatrix[i].length; j++) {
                assertSame("Wrong Value Expected: " + test[i][j] + " Actual: " + testMatrix[i][j], test[i][j], testMatrix[i][j]);
            }
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void TestCopy2DArrayZeroLength() {
        satisfactionOptimizer.copy2DArray(new int[0][0]);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void TestCopy2DArrayNull() {
        satisfactionOptimizer.copy2DArray(null);
    }

    // ReverseMinMax Tests
    @Test
    public void testReverseMinMax() {
        int[][] testReverseMatrix = new int[][]{{2, 1, 0}, {0, 1, 2}, {0, 1, 2}};
        int[][] afterReverse = satisfactionOptimizer.reverseMinMax(testMatrix);
        for (int i = 0; i < afterReverse.length; i++) {
            for (int j = 0; j < afterReverse[i].length; j++) {
                assertSame("Wrong Value Expected: " + testReverseMatrix[i][j] + " Actual: " + afterReverse[i][j],
                        testReverseMatrix[i][j], afterReverse[i][j]);
            }
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testReverseMinMaxNull() {
        satisfactionOptimizer.reverseMinMax(null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testReverseMinMaxZeroLength() {
        satisfactionOptimizer.reverseMinMax(new int[0][0]);
    }


    @Test
    public void testReduceMatrixRowAndCol() {
        int[][] testReduceRowColMatrix = new int[][]{{0, 0, 2}, {2, 0, 0}, {2, 0, 0}};
        satisfactionOptimizer.reduceMatrix(testMatrix);
        for (int i = 0; i < testMatrix.length; i++) {
            for (int j = 0; j < testMatrix[i].length; j++) {
                assertSame("Wrong Value Expected: " + testReduceRowColMatrix[i][j] + " Actual: " + testMatrix[i][j],
                        testReduceRowColMatrix[i][j], testMatrix[i][j]);
            }
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testReduceMatrixRowAndColNull() {
        satisfactionOptimizer.reduceMatrix(null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testReduceMatrixRowAndColZeroLength() {
        satisfactionOptimizer.reduceMatrix(new int[0][0]);
    }

    @Test
    public void testReduceMatrixRow() {
        int[][] testReduceRowMatrix = new int[][]{{0, 0, 2}, {2, 0, 0}, {2, 0, 0}};
        satisfactionOptimizer.reduceMatrix(testMatrix);
        for (int i = 0; i < testMatrix.length; i++) {
            for (int j = 0; j < testMatrix[i].length; j++) {
                assertSame("Wrong Value Expected: " + testReduceRowMatrix[i][j] + " Actual: " + testMatrix[i][j],
                        testReduceRowMatrix[i][j], testMatrix[i][j]);
            }
        }
    }

    @Test
    public void testReduceMatrixCol() {
        int[][] testReduceColMatrix = new int[][]{{0, 0, 2}, {2, 0, 0}, {2, 0, 0}};
        satisfactionOptimizer.reduceMatrix(testMatrix);
        for (int i = 0; i < testMatrix.length; i++) {
            for (int j = 0; j < testMatrix[i].length; j++) {
                assertSame("Wrong Value Expected: " + testReduceColMatrix[i][j] + " Actual: " + testMatrix[i][j],
                        testReduceColMatrix[i][j], testMatrix[i][j]);
            }
        }
    }

    @Test
    public void testReduceMatrixNoChange() {
        int[][] testReduce = new int[5][5];

        satisfactionOptimizer.reduceMatrix(testReduce);

        int[][] testAfterReduce = new int[5][5];

        for (int i = 0; i < testReduce.length; i++) {
            for (int j = 0; j < testReduce[i].length; j++) {
                assertSame("Wrong Value Expected: " + testAfterReduce[i][j] + " Actual: " + testReduce[i][j],
                        testAfterReduce[i][j], testReduce[i][j]);
            }
        }
    }

    @Test
    public void testMarkTheZeroRows() {

        int[] testMRows = new int[testMatrix.length];
        int[] testMCols = new int[testMatrix.length];

        satisfactionOptimizer.markTheZeroRows(testMatrix, testMRows, testMCols);

        int[] testAfterMRows = new int[]{0, 0, 0};
        int[] testAfterMCols = new int[]{0, 0, 0};
        int[][] testAfterMatrix = new int[][]{{0, 1, 2}, {2, 1, 0}, {2, 1, 0}};

        for (int i = 0; i < testMatrix.length; i++) {
            assertSame("Wrong Value Expected: " + testAfterMRows[i] + " Actual: " + testMRows[i],
                    testAfterMRows[i], testMRows[i]);
            assertSame("Wrong Value Expected: " + testAfterMCols[i] + " Actual: " + testMCols[i],
                    testAfterMCols[i], testMCols[i]);
            for (int j = 0; j < testMatrix[i].length; j++) {
                assertSame("Wrong Value Expected: " + testAfterMatrix[i][j] + " Actual: " + testMatrix[i][j],
                        testAfterMatrix[i][j], testMatrix[i][j]);
            }
        }
    }


    @Test
    public void testCheckForSolutionNoSolution() {
        throw new RuntimeException();
    }

    @Test
    public void testCheckForSolutionOneSolution() {
        throw new RuntimeException();
    }

    @Test
    public void testMarkTheZeroRowsNoChange() {

        throw new RuntimeException();

    }


    @Test
    public void testAdjustElementsNoChange() {
        throw new RuntimeException();
    }

    @Test
    public void testAdjustElements() {
        throw new RuntimeException();
    }
}
