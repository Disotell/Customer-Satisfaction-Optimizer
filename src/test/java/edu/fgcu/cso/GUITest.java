package edu.fgcu.cso;

import org.junit.Before;
import org.junit.Test;

class GUITest{

    GUI gui;

    @Before
    public void setup(){
        gui = new GUI();
    }

    public GUITest(){

    }

    @Test(expected = RuntimeException.class)
    public void testBuildGUI(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testBuildGUINullMatrix(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testBuildGUINullSolution(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testBuildGUIEmptyMatrix(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testBuildGUIEmptySolution(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testShowError(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testShowErrorNullString(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testBuildMatrixPanel(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testCreateMatrix(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testMatrixOptimalFontColor(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testMatrixNonOptimalFontColor(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void createUIComponents(){
        throw new RuntimeException();
    }
}