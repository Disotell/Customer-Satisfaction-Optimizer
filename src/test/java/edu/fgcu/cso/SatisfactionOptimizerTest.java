package edu.fgcu.cso;

import org.junit.Before;
import org.junit.Test;


/**
 * Created by William on 3/22/2015.
 */
public class SatisfactionOptimizerTest {

    SatisfactionOptimizer satisfactionOptimizer;
    int[][] testMatrix= new int[][]{{1,2,3},{3,2,1},{9,2,1}};

    @Before
    public void setup(){
        satisfactionOptimizer = new SatisfactionOptimizer();
    }

    public SatisfactionOptimizerTest(){

    }

    @Test(expected = RuntimeException.class)
    public void testCalcCSO(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testReduceMatrixRowAndCol(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testReduceMatrixRow(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testReduceMatrixCol(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testReduceMatrixNoChange(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testCheckForSolutionNoSolution(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testCheckForSolutionOneSolution(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testCheckForSolutionMultipleSolutions(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testMarkTheZeroRowsNoChange(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testMarkTheZeroRows(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testAdjustElementsNoChange(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testAdjustElements(){
        throw new RuntimeException();
    }
}
