package edu.fgcu.cso;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.createMock;

/**
 * Created by Colin on 3/12/2015.
 */
public class MainIT {

    Main2 main;
    GUI mockGUI;
    FileFormater mockFileFormatter;
    HungarianAlgorithm mockHungarianAlgorithm;

    @Before
    public void setup(){
        main = new Main2();
        mockGUI = createMock("mockGUI", GUI.class );
        mockFileFormatter = createMock("mockFileFormatter ", FileFormater.class );
        mockHungarianAlgorithm = createMock("mockHungarianAlgorithm", HungarianAlgorithm.class );
    }

    public MainIT(){

    }

    @Test
    public void testStartFileFormatterIntegration(){
        throw new RuntimeException();
    }

    @Test
    public void testStartGUIIntegration(){
        throw new RuntimeException();
    }

    @Test
    public void testStartHungarianIntegration(){
        throw new RuntimeException();
    }
}
