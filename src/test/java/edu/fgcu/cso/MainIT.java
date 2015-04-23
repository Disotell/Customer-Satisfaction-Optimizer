package edu.fgcu.cso;

import org.fest.swing.data.TableCell;
import org.fest.swing.fixture.ColorFixture;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JLabelFixture;
import org.fest.swing.fixture.JTableFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;

import static edu.fgcu.cso.GUI.TABLE_NAME;
import static org.easymock.EasyMock.createMock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Colin on 3/12/2015.
 */
public class MainIT {

    final String TEST_FILE_DIRECTORY = ".\\src\\test\\resources\\";
    final String ERROR_LABEL = "errorLabel";

    Main main;
    GUI gui;
    FileFormatter fileFormatter;
    SatisfactionOptimizer satisfactionOptimizer;

    FrameFixture window;

    File badData1;

    File goodData1;
    int[] expectedSolutionForFile1 = {0, 1, 2, 3, 4};
    int[][] knownDataInFile1 = {
            {1,   2,  3,  4,  5},
            {6,   7,  8,  9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}};


    @Before
    public void setup() {
        main = new Main();
        gui = new GUI();
        fileFormatter = new FileFormatter();
        satisfactionOptimizer = new SatisfactionOptimizer();
        goodData1 = new File(TEST_FILE_DIRECTORY + "goodTestData.csv");
        badData1 = new File(TEST_FILE_DIRECTORY + "nonSquareTestData.csv");
    }

    @After
    public void tearDown() {
        if(gui != null && gui.frame != null) gui.frame.dispose();
        if(window != null) window.cleanUp();
    }

    public MainIT() {

    }

    @Test
    public void testStartIntegration(){
        main.start(fileFormatter,satisfactionOptimizer,gui,goodData1);

        assertNotNull("Gui frame not created or set", gui.frame);
        window = new FrameFixture(gui.frame);
        window.requireVisible();

        JTableFixture tableFixture = window.table(TABLE_NAME);

        assertNotNull("TableFixture retrieved is null",tableFixture);

        String[][] values = tableFixture.contents();

        assertNotNull("Table contents came back null", values);
        assertEquals("Table number of rows does not match expected", knownDataInFile1.length, values.length);

        for(int i = 0; i < values.length; i++){
            assertEquals("Columns in row " + i + " of retrieved do not match expected", knownDataInFile1[i].length,values[i].length);
            for(int j = 0; j < values[i].length; j++){
                assertEquals("Value in matrix not as expected", Integer.toString(knownDataInFile1[i][j]), values[i][j]);
            }
        }

        for(int i = 0; i < knownDataInFile1.length; i++){
            for(int j = 0; j < knownDataInFile1.length; j++){
                ColorFixture foreground = tableFixture.foregroundAt(TableCell.row(i).column(j));
                assertNotNull("foreground at index " + i + " " + j + " has returned null",foreground);
                if(expectedSolutionForFile1[i] == j){
                    foreground.requireEqualTo(Color.red);
                }
                else {
                    foreground.requireEqualTo(Color.black);
                }
            }
        }
    }

    @Test
    public void testStartIntegrationBadData() {
        main.start(fileFormatter,satisfactionOptimizer,gui,badData1);

        assertNotNull("Gui frame not created or set", gui.frame);
        window = new FrameFixture(gui.frame);
        window.requireVisible();

        JLabelFixture jLabelFixture = window.label(ERROR_LABEL);

        assertNotNull("error label returned null", jLabelFixture);

        jLabelFixture.requireText("Error parsing data matrix from file");
    }
}
