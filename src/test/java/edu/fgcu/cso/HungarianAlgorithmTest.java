package edu.fgcu.cso;

import org.junit.Before;
import org.junit.Test;


public class HungarianAlgorithmTest {

    HungarianAlgorithm hungarianAlgorithm;

    @Before
    public void setup(){
        hungarianAlgorithm = new HungarianAlgorithm();
    }

    public HungarianAlgorithmTest(){

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
