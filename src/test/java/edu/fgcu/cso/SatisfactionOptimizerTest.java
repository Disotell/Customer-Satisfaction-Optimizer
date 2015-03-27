package edu.fgcu.cso;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


/**
 * Created by William on 3/22/2015.
 */
public class SatisfactionOptimizerTest {

    SatisfactionOptimizer satisfactionOptimizer;
    private int[][] testMatrix= new int[][]{{1,2,3},{3,2,1},{3,2,1}};
   
    

    @Before
    public void setup(){
        satisfactionOptimizer = new SatisfactionOptimizer();
    }

    public SatisfactionOptimizerTest(){

    }

    @Test
    public void testCalcCSO(){
        throw new RuntimeException();
    }

    @Test
    public void TestCopy2DArray() {
        int[][] test = new int[testMatrix.length][testMatrix.length];
        satisfactionOptimizer.copy2DArray(testMatrix,test,testMatrix.length);
        for(int i=0;i<testMatrix.length;i++){
            for (int j=0; j <testMatrix[i].length; j++) {
                assertSame(testMatrix[i][j],test[i][j]);
            }
        }
    }


    @Test
    public void testReverseMinMax(){
        int[][] testReverseMatrix= new int[][]{{2,1,0},{0,1,2},{0,1,2}};
        int[][] afterReverse = satisfactionOptimizer.reverseMinMax(testMatrix);
        for(int i=0;i<afterReverse.length;i++){
            for (int j=0; j < afterReverse[i].length; j++) {
                assertSame(testReverseMatrix[i][j],afterReverse[i][j]);
            }
        }
    }

    @Test
    public void testReduceMatrixRowAndCol(){
       int[][] testReduceRowColMatrix= new int[][]{{0,0,2},{2,0,0},{2,0,0}};
       satisfactionOptimizer.reduceMatrix(testMatrix);
        for(int i=0;i<testMatrix.length;i++){
            for (int j=0; j <testMatrix[i].length; j++) {
                assertSame(testReduceRowColMatrix[i][j],testMatrix[i][j]);
            }
        }
    }

    @Test
    public void testReduceMatrixRow(){
        int[][]testReduceRowMatrix= new int[][]{{0,0,2},{2,0,0},{2,0,0}};
        satisfactionOptimizer.reduceMatrix(testMatrix);
        for(int i=0;i<testMatrix.length;i++){
            for (int j=0; j <testMatrix[i].length; j++) {
                assertSame(testReduceRowMatrix[i][j],testMatrix[i][j]);
            }
        }
    }

    @Test
    public void testReduceMatrixCol(){
        int[][]testReduceColMatrix= new int[][]{{0,0,2},{2,0,0},{2,0,0}};
        satisfactionOptimizer.reduceMatrix(testMatrix);
        for(int i=0;i<testMatrix.length;i++){
            for (int j=0; j <testMatrix[i].length; j++) {
                assertSame(testReduceColMatrix[i][j],testMatrix[i][j]);
            }
        }
    }
    
    @Test
    public void testReduceMatrixNoChange(){
        throw new RuntimeException();
    }

    @Test
    public void testCheckForSolutionNoSolution(){
        throw new RuntimeException();
    }

    @Test
    public void testCheckForSolutionOneSolution(){
        throw new RuntimeException();
    }
    
    @Test
    public void testMarkTheZeroRowsNoChange(){
        
        throw new RuntimeException();
        
    }

    @Test
    public void testMarkTheZeroRows(){
        throw new RuntimeException();
    }

    @Test
    public void testAdjustElementsNoChange(){
        throw new RuntimeException();
    }

    @Test
    public void testAdjustElements(){
        throw new RuntimeException();
    }
}
