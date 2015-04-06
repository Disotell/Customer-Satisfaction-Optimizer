package edu.fgcu.cso;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *  Test Class For SatisfactionOptimizer.class
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

    //testCalcCSO Tests
    @Test
    public void testCalcCSO() {
         throw new RuntimeException();
    }

    // Copy2DArray Tests
    @Test
    public void TestCopy2DArray() {
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


    //ReduceMatrixRowAndCol Tests
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

    //MarkTheZeroRows Tests
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMarkTheZeroRowsNull() {

        int[] testMRows = new int[testMatrix.length];
        int[] testMCols = new int[testMatrix.length];

        satisfactionOptimizer.markTheZeroRows(null, testMRows, testMCols);
        satisfactionOptimizer.markTheZeroRows(testMatrix, null, testMCols);
        satisfactionOptimizer.markTheZeroRows(testMatrix, testMRows, null);
        satisfactionOptimizer.markTheZeroRows(null, null, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMarkTheZeroRowsZeroLength() {
        int[] testMRows = new int[testMatrix.length];
        int[] testMCols = new int[testMatrix.length];

        satisfactionOptimizer.markTheZeroRows(new int[0][0], testMRows, testMCols);
        satisfactionOptimizer.markTheZeroRows(testMatrix, new int[0], testMCols);
        satisfactionOptimizer.markTheZeroRows(testMatrix, testMRows, new int[0]);
        satisfactionOptimizer.markTheZeroRows(new int[0][0], new int[0], new int[0]);
    }


    //CheckForSolution Tests
    @Test
    public void testCheckForSolutionNoSolution() {
        int[] testNoSolution = new int[]{0, 0, 0};
        assertFalse("No Solution Input, but Solution Output ", satisfactionOptimizer.checkForSolution(testNoSolution));
    }

    @Test
    public void testCheckForSolutionHasSolution() {
        int[] testSolution = new int[]{1, 1, 1};
        assertTrue("Solution Input, but No Solution Output ", satisfactionOptimizer.checkForSolution(testSolution));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCheckForSolutionNull() {
        satisfactionOptimizer.checkForSolution(null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCheckForSolutionZeroLength() {
        satisfactionOptimizer.checkForSolution(new int[0]);
    }


    //AdjustElements Tests
    @Test
    public void testAdjustElements() {
        int[] testSolZero = new int[]{4,3};
        int[] testZerosByRow= new int[]{1,5,0,2,-1,3};
        int[] testZerosByCol=  new int[]{2,0,3,5,-1,1};
        int[] testOnlyZeroByRow= new int[]{-1,-1,-1,-1,3,4};

        satisfactionOptimizer.adjustElements(testSolZero, testZerosByRow, testZerosByCol, testOnlyZeroByRow);

        int[] testAfterSolZero = new int[]{4,3};
        int[] testAfterZerosByRow= new int[]{1,5,0,2,3,4};
        int[] testAfterZerosByCol= new int[]{2,0,3,4,5,1};
        int[] testAfterOnlyZeroByRow= new int[]{-1,-1,-1,-1,3,4};


        for (int i = 0; i < testSolZero.length; i++) {

            assertSame("Wrong Value Expected: " + testAfterSolZero[i] + " Actual: " + testSolZero[i],
                    testAfterSolZero[i], testSolZero[i]);
        }
        for (int i = 0; i < testZerosByRow.length; i++) {
            assertSame("Wrong Value Expected: " + testAfterZerosByRow[i] + " Actual: " + testZerosByRow[i],
                    testAfterZerosByRow[i], testZerosByRow[i]);

            assertSame("Wrong Value Expected: " + testAfterZerosByCol[i] + " Actual: " + testZerosByCol[i],
                    testAfterZerosByCol[i], testZerosByCol[i]);

            assertSame("Wrong Value Expected: " + testAfterOnlyZeroByRow[i] + " Actual: " + testOnlyZeroByRow[i],
                    testAfterOnlyZeroByRow[i], testOnlyZeroByRow[i]);
        }
    }

    @Test
    public void testAdjustElementsNoChange() {
        int[] testSolZero = new int[]{4,3};
        int[] testZerosByRow= new int[]{1,5,0,2,-1,3};
        int[] testZerosByCol=  new int[]{2,0,3,-1,-1,1};
        int[] testOnlyZeroByRow= new int[]{-1,-1,-1,-1,3,4};

        satisfactionOptimizer.adjustElements(testSolZero, testZerosByRow, testZerosByCol, testOnlyZeroByRow);

        int[] testAfterSolZero = new int[]{4,3};
        int[] testAfterZerosByRow= new int[]{1,5,0,2,3,3};
        int[] testAfterZerosByCol= new int[]{2,0,3,4,-1,1};
        int[] testAfterOnlyZeroByRow= new int[]{-1,-1,-1,-1,3,4};

        for (int i = 0; i < testSolZero.length; i++) {

            assertSame("Wrong Value Expected: " + testAfterSolZero[i] + " Actual: " + testSolZero[i],
                    testAfterSolZero[i], testSolZero[i]);
        }

        for (int i = 0; i < testZerosByRow.length; i++) {
            assertSame("Wrong Value Expected: " + testAfterZerosByRow[i] + " Actual: " + testZerosByRow[i],
                    testAfterZerosByRow[i], testZerosByRow[i]);

            assertSame("Wrong Value Expected: " + testAfterZerosByCol[i] + " Actual: " + testZerosByCol[i],
                    testAfterZerosByCol[i], testZerosByCol[i]);

            assertSame("Wrong Value Expected: " + testAfterOnlyZeroByRow[i] + " Actual: " + testOnlyZeroByRow[i],
                    testAfterOnlyZeroByRow[i], testOnlyZeroByRow[i]);
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdjustElementsNull() {
        int[] testSolZero = new int[testMatrix.length];
        int[] testZerosByRow= new int[testMatrix.length];
        int[] testZerosByCol= new int[testMatrix.length];
        int[] testOnlyZeroByRow= new int[testMatrix.length];

        satisfactionOptimizer.adjustElements(null, testZerosByRow, testZerosByCol, testOnlyZeroByRow);
        satisfactionOptimizer.adjustElements(testSolZero, null,testZerosByCol, testOnlyZeroByRow);
        satisfactionOptimizer.adjustElements(testSolZero, testZerosByRow, null, testOnlyZeroByRow);
        satisfactionOptimizer.adjustElements(testSolZero, testZerosByRow, testZerosByCol, null);
        satisfactionOptimizer.adjustElements(null, null, null, null);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdjustElementsLength() {
        int[] testSolZero = new int[testMatrix.length];
        int[] testZerosByRow= new int[testMatrix.length];
        int[] testZerosByCol= new int[testMatrix.length];
        int[] testOnlyZeroByRow= new int[testMatrix.length];

        satisfactionOptimizer.adjustElements(new int[0], testZerosByRow, testZerosByCol, testOnlyZeroByRow);
        satisfactionOptimizer.adjustElements(testSolZero, new int[0], testZerosByCol, testOnlyZeroByRow);
        satisfactionOptimizer.adjustElements(testSolZero, testZerosByRow, new int[0], testOnlyZeroByRow);
        satisfactionOptimizer.adjustElements(testSolZero, testZerosByRow, testZerosByCol, new int[0]);
        satisfactionOptimizer.adjustElements(new int[0], new int[0], new int[0], new int[0]);
    }

    //initZeros Tests
    @Test
    public void testInitZeros() {
        int[][] testInitZerosMatrix = new int[][]{{0, 1, 2}, {2, 1, 0}, {2, 1, 0}};
        int[] testZerosByRow= new int[]{-1,-1,-1};
        int[] testZerosByCol=  new int[]{-1,-1,-1};

        satisfactionOptimizer.initZeros(testInitZerosMatrix, testZerosByRow, testZerosByCol);

        int[][] testAfterMatrix = new int[][]{{0, 1, 2}, {2, 1, 0}, {2, 1, 0}};
        int[] testAfterZerosByRow= new int[]{0,2,-1};
        int[] testAfterZerosByCol= new int[]{0,-1,1};

        for (int i = 0; i < testZerosByRow.length; i++) {
            assertSame("Wrong Value Expected: " + testAfterZerosByRow[i] + " Actual: " + testZerosByRow[i],
                    testAfterZerosByRow[i], testZerosByRow[i]);

            assertSame("Wrong Value Expected: " + testAfterZerosByCol[i] + " Actual: " + testZerosByCol[i],
                    testAfterZerosByCol[i], testZerosByCol[i]);

            for (int j = 0; j < testInitZerosMatrix[i].length; j++) {
                assertSame("Wrong Value Expected: " + testAfterMatrix[i][j] + " Actual: " + testInitZerosMatrix[i][j],
                        testAfterMatrix[i][j], testInitZerosMatrix[i][j]);
            }

        }
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testInitZerosNull() {
        int[] testZerosByRow= new int[testMatrix.length];
        int[] testZerosByCol= new int[testMatrix.length];

        satisfactionOptimizer.initZeros(null, testZerosByRow, testZerosByCol);
        satisfactionOptimizer.initZeros(testMatrix, null, testZerosByCol);
        satisfactionOptimizer.initZeros(testMatrix, testZerosByRow, null);
        satisfactionOptimizer.initZeros(null, null, null);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testInitZerosLength() {
        int[] testZerosByRow= new int[testMatrix.length];
        int[] testZerosByCol= new int[testMatrix.length];

        satisfactionOptimizer.initZeros(new int[0][0], testZerosByRow, testZerosByCol);
        satisfactionOptimizer.initZeros(testMatrix, new int[0], testZerosByCol);
        satisfactionOptimizer.initZeros(testMatrix, testZerosByRow, new int[0]);
        satisfactionOptimizer.initZeros(new int[0][0], new int[0], new int[0]);
    }

    //UnmatchedZeroCheck Tests
    @Test
    public void testUnmatchedZeroCheckWithReturn() {
        int[][] testUnmatchedMatrix = new int[][]{{1, 1, 2}, {2, 0, 1}, {2, 2, 1}};
        int[] testZerosByRow  = new int[]{-1, -1, -1};
        int[] testMRows  = new int[]{-1, -1, -1};
        int[] testMCols  = new int[]{-1, 0, -1};

        int[] testReturn = satisfactionOptimizer.unmatchedZeroCheck( testUnmatchedMatrix, testZerosByRow, testMRows, testMCols);

        int[][] testAfterUnmatchedMatrix = new int[][]{{1, 1, 2}, {2, 0, 1}, {2, 2, 1}};
        int[] testAfterZerosByRow  = new int[]{-1, 1, -1};
        int[] testAfterMRows  = new int[]{-1, -1, -1};
        int[] testAfterMCols  = new int[]{-1, 0, -1};
        int[] testAfterReturn = new int[]{1,1};

        assertNotNull("Return was Null", testReturn);

        for (int i = 0; i < testReturn.length; i++) {
            assertSame("Wrong Value Expected: " + testAfterReturn[i] + " Actual: " + testReturn[i],
                    testAfterReturn[i], testReturn[i]);
        }

        for (int i = 0; i < testMatrix.length; i++) {
            assertSame("Wrong Value Expected: " + testAfterZerosByRow[i] + " Actual: " + testZerosByRow[i],
                    testAfterZerosByRow[i], testZerosByRow[i]);
            assertSame("Wrong Value Expected: " + testAfterMRows[i] + " Actual: " + testMRows[i],
                    testAfterMRows[i], testMRows[i]);
            assertSame("Wrong Value Expected: " + testAfterMCols[i] + " Actual: " + testMCols[i],
                    testAfterMCols[i], testMCols[i]);
            for (int j = 0; j < testUnmatchedMatrix[i].length; j++) {
                assertSame("Wrong Value Expected: " + testAfterUnmatchedMatrix[i][j] + " Actual: " + testUnmatchedMatrix[i][j],
                        testAfterUnmatchedMatrix[i][j], testUnmatchedMatrix[i][j]);
            }
        }
    }

    @Test
    public void testUnmatchedZeroCheckReturnNull() {
        int[] testZerosByRow = new int[testMatrix.length];
        int[] testMRows = new int[testMatrix.length];
        int[] testMCols = new int[testMatrix.length];

        int[] testReturn = satisfactionOptimizer.unmatchedZeroCheck(testMatrix, testZerosByRow, testMRows, testMCols);

        int[] testAfterZerosByRow = new int[]{0, 0, 0};
        int[] testAfterMRows = new int[]{0, 0, 0};
        int[] testAfterMCols = new int[]{0, 0, 0};
        int[][] testAfterMatrix = new int[][]{{1, 2, 3}, {3, 2, 1}, {3, 2, 1}};


        assertNull("Return was not Null",testReturn);

        for (int i = 0; i < testMatrix.length; i++) {
            assertSame("Wrong Value Expected: " + testAfterZerosByRow[i] + " Actual: " + testZerosByRow[i],
                    testAfterZerosByRow[i], testZerosByRow[i]);
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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnmatchedZeroCheckNull() {
        int[] testZerosByRow = new int[testMatrix.length];
        int[] testMRows = new int[testMatrix.length];
        int[] testMCols = new int[testMatrix.length];

        satisfactionOptimizer.unmatchedZeroCheck(null, testZerosByRow, testMRows, testMCols);
        satisfactionOptimizer.unmatchedZeroCheck(testMatrix, null, testMRows, testMCols);
        satisfactionOptimizer.unmatchedZeroCheck(testMatrix, testZerosByRow, null, testMCols);
        satisfactionOptimizer.unmatchedZeroCheck(testMatrix, testZerosByRow, testMRows, null);
        satisfactionOptimizer.unmatchedZeroCheck(null, null, null, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUnmatchedZeroCheckLength() {
        int[] testZerosByRow = new int[testMatrix.length];
        int[] testMRows = new int[testMatrix.length];
        int[] testMCols = new int[testMatrix.length];

        satisfactionOptimizer.unmatchedZeroCheck(new int[0][0], testZerosByRow, testMRows, testMCols);
        satisfactionOptimizer.unmatchedZeroCheck(testMatrix, new int[0], testMRows, testMCols);
        satisfactionOptimizer.unmatchedZeroCheck(testMatrix, testZerosByRow, new int[0], testMCols);
        satisfactionOptimizer.unmatchedZeroCheck(testMatrix, testZerosByRow, testMRows, new int[0]);
        satisfactionOptimizer.unmatchedZeroCheck(new int[0][0], new int[0], new int[0], new int[0]);
    }


    //UnmatchedZeroCheck Tests
    @Test
    public void testMarkMatchedColumnsZeroes() {
        int[] testZerosByCol  = new int[]{0, 0, 0};
        int[] testMCols  = new int[]{0, 0, 0};

        satisfactionOptimizer.markMatchedColumnsZeroes(testZerosByCol,testMCols);

        int[] testAfterZerosByCol  = new int[]{0, 0, 0};
        int[] testAfterMCols  = new int[]{1,1,1};

        for (int i = 0; i < testZerosByCol.length; i++) {
            assertSame("Wrong Value Expected: " + testAfterZerosByCol[i] + " Actual: " + testZerosByCol[i],
                    testAfterZerosByCol[i], testZerosByCol[i]);
            assertSame("Wrong Value Expected: " + testAfterMCols[i] + " Actual: " + testMCols[i],
                    testAfterMCols[i], testMCols[i]);
        }
    }

    @Test
    public void testMarkMatchedColumnsZeroesNOChange() {
        int[] testZerosByCol  = new int[]{-1, -1, -1};
        int[] testMCols  = new int[]{0, 0, 0};

        satisfactionOptimizer.markMatchedColumnsZeroes(testZerosByCol,testMCols);

        int[] testAfterZerosByCol  = new int[]{-1, -1, -1};
        int[] testAfterMCols  = new int[]{0,0,0};

        for (int i = 0; i < testZerosByCol.length; i++) {
            assertSame("Wrong Value Expected: " + testAfterZerosByCol[i] + " Actual: " + testZerosByCol[i],
                    testAfterZerosByCol[i], testZerosByCol[i]);
            assertSame("Wrong Value Expected: " + testAfterMCols[i] + " Actual: " + testMCols[i],
                    testAfterMCols[i], testMCols[i]);
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMarkMatchedColumnsZeroeskNull() {
        int[] testZerosByCol = new int[testMatrix.length];
        int[] testMCols = new int[testMatrix.length];

        satisfactionOptimizer.markMatchedColumnsZeroes(null, testMCols);
        satisfactionOptimizer.markMatchedColumnsZeroes(testZerosByCol, null);
        satisfactionOptimizer.markMatchedColumnsZeroes(null, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testUMarkMatchedColumnsZeroesLength() {
        int[] testZerosByCol = new int[testMatrix.length];
        int[] testMCols = new int[testMatrix.length];

        satisfactionOptimizer.markMatchedColumnsZeroes(new int[0], testMCols);
        satisfactionOptimizer.markMatchedColumnsZeroes(testZerosByCol, new int[0]);
        satisfactionOptimizer.markMatchedColumnsZeroes(new int[0], new int[0]);
    }
}


