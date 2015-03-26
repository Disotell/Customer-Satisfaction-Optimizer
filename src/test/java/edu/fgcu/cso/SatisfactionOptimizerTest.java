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

    @Test
    public void testCalcCSO(){
        throw new RuntimeException();
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
