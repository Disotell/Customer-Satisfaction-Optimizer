package edu.fgcu.cso;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.createMock;

/**
 * Created by Colin on 3/12/2015.
 */
public class MainIT {

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

    public MainIT() {

    }

    @Test
    public void testStartFileFormatterIntegration() {
        throw new RuntimeException();
    }

    @Test
    public void testStartGUIIntegration() {
        throw new RuntimeException();
    }

    @Test
    public void testStartHungarianIntegration() {
        throw new RuntimeException();
    }
}
