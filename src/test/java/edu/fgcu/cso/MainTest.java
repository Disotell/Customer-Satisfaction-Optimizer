package edu.fgcu.cso;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.createMock;


/**
 * Created by Colin on 3/12/2015.
 */
public class MainTest {

    Main2 main;
    GUI mockGUI;
    FileFormatter mockFileFormatter;
    HungarianAlgorithm mockHungarianAlgorithm;

    @Before
    public void setup(){
        main = new Main2();
        mockGUI = createMock("mockGUI", GUI.class );
        mockFileFormatter = createMock("mockFileFormatter", FileFormatter.class);
        mockHungarianAlgorithm = createMock("mockHungarianAlgorithm", HungarianAlgorithm.class );
    }

    public MainTest(){

    }

    @Test(expected = RuntimeException.class)
    public void testGetFile(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testReverseMinMax(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testStart(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testStartNullFile(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testStartNullData(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testStartNullReversed(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testStartNullSolution(){
        throw new RuntimeException();
    }

}
