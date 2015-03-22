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
    HungarianAlgorithm mockHungarianAlgorithm;

    @Before
    public void setup(){
        main = new Main();
        mockGUI = createMock("mockGUI", GUI.class );
        mockFileFormatter = createMock("mockFileFormatter", FileFormatter.class);
        mockHungarianAlgorithm = createMock("mockHungarianAlgorithm", HungarianAlgorithm.class );
    }

    public MainIT(){

    }

    @Test(expected = RuntimeException.class)
    public void testStartFileFormatterIntegration(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testStartGUIIntegration(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testStartHungarianIntegration(){
        throw new RuntimeException();
    }
}
