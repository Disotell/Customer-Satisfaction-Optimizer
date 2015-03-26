package edu.fgcu.cso;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by William on 3/22/2015.
 */
public class SatisfactionOptimizerTest {

    SatisfactionOptimizer satisfactionOptimizer;
    int[][] testMatrix= new int[][]{{1,2,3},{3,2,1},{3,2,1}};
    private int[][] testReverseMatrix= new int[][]{{2,1,0},{0,1,2},{0,1,2}};


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
    public void testReverseMinMax(){
        int[][] afterReverse = satisfactionOptimizer.reverseMinMax(testMatrix);
        for(int i=0;i<afterReverse.length;i++){
            for (int j=0; j < afterReverse[i].length ; j++){
                assertSame(testReverseMatrix[i][j],afterReverse[i][j]);
            }
        }


    }

    @Test
    public void testReduceMatrixRowAndCol(){
        throw new RuntimeException();
    }

    @Test
    public void testReduceMatrixRow(){

        throw new RuntimeException();
    }

    @Test
    public void testReduceMatrixCol(){
        throw new RuntimeException();
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
    public void testCheckForSolutionMultipleSolutions(){
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
