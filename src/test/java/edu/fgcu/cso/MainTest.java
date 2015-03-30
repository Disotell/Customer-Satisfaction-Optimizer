package edu.fgcu.cso;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.createMock;


/**
 * Created by Colin on 3/12/2015.
 */
public class MainTest {

    Main main;
    GUI mockGUI;
    FileFormatter mockFileFormatter;
    SatisfactionOptimizer mockSatisfactionOptimizer;

    @Before
    public void setup() {
        main = new Main();
        mockGUI = createMock("mockGUI", GUI.class);
        mockFileFormatter = createMock("mockFileFormatter", FileFormatter.class);
        mockSatisfactionOptimizer = createMock("mockHungarianAlgorithm", SatisfactionOptimizer.class);
    }

    public MainTest() {

    }

    @Test
    public void testGetFile() {
        throw new RuntimeException();
    }


    @Test
    public void testStart() {

        throw new RuntimeException();
    }

    @Test
    public void testStartNullFile() {
        throw new RuntimeException();
    }

    @Test
    public void testStartNullData() {
        throw new RuntimeException();
    }

    @Test
    public void testStartNullReversed() {
        throw new RuntimeException();
    }

    @Test
    public void testStartNullSolution() {
        throw new RuntimeException();
    }

}
