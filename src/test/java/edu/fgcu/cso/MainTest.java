package edu.fgcu.cso;

import org.easymock.EasyMock;
import org.easymock.internal.MocksControl;
import org.easymock.internal.RecordState;
import org.fest.swing.core.BasicRobot;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiTask;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.fest.swing.fixture.*;

import java.io.File;
import java.io.IOException;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;


/**
 * Created by Colin on 3/12/2015.
 */
public class MainTest {

    Main main;
    GUI mockGUI;
    FileFormatter mockFileFormatter;
    SatisfactionOptimizer mockSatisfactionOptimizer;
    File mockFile;
    File chosenFile;

    int[][] exampleArray =
            {{1,   2,  3,  4,  5},
             {6,   7,  8,  9, 10},
             {11, 12, 13, 14, 15},
             {16, 17, 18, 19, 20},
             {21, 22, 23, 24, 25}};

    int[] exampleSolution = {1, 2, 3, 4, 5};

    @Before
    public void setup() {
        main = new Main();
        mockGUI = createMock("mockGUI", GUI.class);
        mockFileFormatter = createMock("mockFileFormatter", FileFormatter.class);
        mockSatisfactionOptimizer = createMock("mockHungarianAlgorithm", SatisfactionOptimizer.class);
        mockFile = createMock("mockFile", File.class);
    }

    @After
    public void tearDown(){
        chosenFile = null;
        //If either of the mocks have not been initialized to replay for
        //verification, they must be set
        if(isRecordState(mockGUI)){
            replay(mockGUI);
        }
        if(isRecordState(mockFileFormatter)){
            replay(mockFileFormatter);
        }
        if(isRecordState(mockSatisfactionOptimizer)){
            replay(mockSatisfactionOptimizer);
        }
        if(isRecordState(mockFile)){
            replay(mockFile);
        }

        verify(mockGUI, mockFileFormatter, mockSatisfactionOptimizer, mockFile);
    }

    public MainTest() {

    }

    public boolean isRecordState(Object mock){
        return MocksControl.getControl(mock).getState() instanceof RecordState;
    }


    @Test
    public void testGetGoodFile() {
        Runnable temp = new Runnable() {
            public void run() {
                chosenFile = main.getFile();
            }
        };
        Thread thread = new Thread(temp);
        thread.start();

        org.fest.swing.core.Robot robot = BasicRobot.robotWithNewAwtHierarchy();
        JFileChooserFixture fixture = new JFileChooserFixture(robot,Main.FILECHOOSER_NAME);

        fixture.requireVisible();
        File dir = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\");
        assertTrue("File directory does not exist",dir.exists());
        fixture.setCurrentDirectory(dir);

        fixture.fileNameTextBox().enterText("goodTestData.csv");
        fixture.approve();

        assertNotNull("File returned was null", chosenFile);
        assertTrue("File found does not exist",chosenFile.exists());

        thread.interrupt();
        robot.cleanUp();
    }

    @Test
    public void testGetBadFile() {
        Runnable temp = new Runnable() {
            public void run() {
                chosenFile = main.getFile();
            }
        };
        Thread thread = new Thread(temp);
        thread.start();

        org.fest.swing.core.Robot robot = BasicRobot.robotWithNewAwtHierarchy();
        JFileChooserFixture fixture = new JFileChooserFixture(robot,Main.FILECHOOSER_NAME);

        fixture.requireVisible();

        String madeUpFileName = "ANameIMadeUp.csv";
        File file = new File(madeUpFileName);
        assertFalse("Expecting file not to exist",file.exists());

        fixture.fileNameTextBox().enterText(madeUpFileName);
        fixture.approve();

        assertNull("File returned was not null", chosenFile);

        thread.interrupt();
        robot.cleanUp();
    }

    /**
     * Method tests that when returned the correct inputs, the main.start method works correctly
     */
    @Test
    public void testStart() {
        try {
            expect(mockFileFormatter.getData(mockFile)).andReturn(exampleArray);
        }catch (IOException e) {
            e.printStackTrace();
            fail("IOException thrown when setting up expect");
        }

        expect(mockSatisfactionOptimizer.calcCSO(exampleArray)).andReturn(exampleSolution);

        mockGUI.buildGUI(exampleArray,exampleSolution);
        EasyMock.expectLastCall().once();

        replay(mockFileFormatter,mockSatisfactionOptimizer, mockGUI, mockFile);

        main.start(mockFileFormatter,mockSatisfactionOptimizer,mockGUI,mockFile);
    }

    @Test
    public void testStartNullFile() {
        try {
            expect(mockFileFormatter.getData(null)).andReturn(null);
        }catch (IOException e) {
            e.printStackTrace();
            fail("IOException thrown when setting up expect");
        }

        mockGUI.buildGUI(null, null);
        EasyMock.expectLastCall().once();
        replay(mockFileFormatter,mockSatisfactionOptimizer, mockGUI, mockFile);

        main.start(mockFileFormatter,mockSatisfactionOptimizer,mockGUI,null);
    }

    @Test
    public void testStartNullData() {
        try {
            expect(mockFileFormatter.getData(mockFile)).andReturn(null);
        }catch (IOException e) {
            e.printStackTrace();
            fail("IOException thrown when setting up expect");
        }

        mockGUI.buildGUI(null, null);
        EasyMock.expectLastCall().once();
        replay(mockFileFormatter,mockSatisfactionOptimizer, mockGUI, mockFile);

        main.start(mockFileFormatter,mockSatisfactionOptimizer,mockGUI,mockFile);
    }

    @Test
    public void testStartIOException() {
        try {
            expect(mockFileFormatter.getData(mockFile)).andStubThrow(new IOException());
        }catch (IOException e) {
            e.printStackTrace();
            fail("IOException thrown when setting up expect");
        }

        mockGUI.buildGUI(null, null);
        EasyMock.expectLastCall().once();
        replay(mockFileFormatter,mockSatisfactionOptimizer, mockGUI, mockFile);

        main.start(mockFileFormatter,mockSatisfactionOptimizer,mockGUI,mockFile);
    }

    @Test
    public void testStartNullSolution() {
        try {
            expect(mockFileFormatter.getData(mockFile)).andReturn(exampleArray);
        }catch (IOException e) {
            e.printStackTrace();
            fail("IOException thrown when setting up expect");
        }

        expect(mockSatisfactionOptimizer.calcCSO(exampleArray)).andReturn(null);

        mockGUI.buildGUI(exampleArray, null);
        EasyMock.expectLastCall().once();
        replay(mockFileFormatter,mockSatisfactionOptimizer, mockGUI, mockFile);

        main.start(mockFileFormatter,mockSatisfactionOptimizer,mockGUI,mockFile);
    }

}
