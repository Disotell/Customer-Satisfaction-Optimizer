package edu.fgcu.cso;


import org.fest.swing.data.TableCell;

import org.fest.swing.fixture.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static edu.fgcu.cso.GUI.MAIN_WINDOW_NAME;
import static edu.fgcu.cso.GUI.TABLE_NAME;
import static edu.fgcu.cso.GUI.ERROR_LABEL;

import java.awt.*;


public class GUITest {

    int[][] fakeDataSet = {
            {1,   2,  3,  4,  5},
            {6,   7,  8,  9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}};

    int[] fakeSolution = {3,   0,  2,  1,  4};

    String guiSolutionError = "Multiple or no solution found for matrix";
    String guiMatrixError = "Error parsing data matrix from file";

    GUI gui;
    FrameFixture window;

    @Before
    public void setup() {
        gui = new GUI();
    }

    @After
    public void tearDown() {
        if(gui != null && gui.frame != null) {
            gui.frame.dispose();
        }

        if(window != null){
            window.cleanUp();
        }
    }


    public GUITest() {

    }

    private FrameFixture createFrameFixture(){
        assertNotNull("Gui frame not created or set", gui.frame);
        return new FrameFixture(gui.frame);
    }

    /**
     * This method tests GUI::buildGUI() under with fake arrays of data and an
     * example solution. The expected result is a JFrame being displayed to the user
     * with the solution indices given being red
     */
    @Test
    public void testBuildGUI() {
        gui.buildGUI(fakeDataSet, fakeSolution);

        window = createFrameFixture();

        JTableFixture tableFixture = window.table(TABLE_NAME);

        assertNotNull("TableFixture retrieved is null",tableFixture);

        String[][] values = tableFixture.contents();

        assertNotNull("Table contents came back null", values);
        assertEquals("Table number of rows does not match expected", fakeDataSet.length, values.length);

        for(int i = 0; i < values.length; i++){
            assertEquals("Columns in row " + i + " of retrieved do not match expected", fakeDataSet[i].length,values[i].length);
            for(int j = 0; j < values[i].length; j++){
                assertEquals("Value in matrix not as expected", Integer.toString(fakeDataSet[i][j]), values[i][j]);
            }
        }

        for(int i = 0; i < fakeDataSet.length; i++){
            for(int j = 0; j < fakeDataSet.length; j++){
                ColorFixture foreground = tableFixture.foregroundAt(TableCell.row(i).column(j));
                assertNotNull("foreground at index " + i + " " + j + " has returned null",foreground);
                if(fakeSolution[i] == j){
                    foreground.requireEqualTo(Color.red);
                }
                else {
                    foreground.requireEqualTo(Color.black);
                }
            }
        }


    }

    @Test
    public void testBuildGUINullMatrix() {
        gui.buildGUI(null, fakeSolution);

        window = createFrameFixture();

        JLabelFixture jLabelFixture = window.label(ERROR_LABEL);

        assertNotNull("error label returned null", jLabelFixture);

        jLabelFixture.requireText(guiMatrixError);
    }

    @Test
    public void testBuildGUINullSolution() {
        gui.buildGUI(fakeDataSet, null);

        window = createFrameFixture();

        JLabelFixture jLabelFixture = window.label(ERROR_LABEL);

        assertNotNull("error label returned null", jLabelFixture);

        jLabelFixture.requireText(guiSolutionError);
    }

    @Test
    public void testBuildGUIEmptyMatrix() {
        gui.buildGUI(new int[0][0], fakeSolution);

        window = createFrameFixture();

        JLabelFixture jLabelFixture = window.label(ERROR_LABEL);

        assertNotNull("error label returned null", jLabelFixture);

        jLabelFixture.requireText(guiMatrixError);
    }

    @Test
    public void testBuildGUIEmptySolution() {
        gui.buildGUI(fakeDataSet, new int[0]);

        window = createFrameFixture();

        JLabelFixture jLabelFixture = window.label(ERROR_LABEL);

        assertNotNull("error label returned null", jLabelFixture);

        jLabelFixture.requireText(guiSolutionError);
    }

    @Test
    public void testShowError() {
        String errorMessage = "Testing Error Message";
        String errorTitle = "Testing Error Title";
        gui.showError(errorMessage, errorTitle);

        window = createFrameFixture();

        JLabelFixture jLabelFixture = window.label(ERROR_LABEL);

        assertNotNull("error label returned null", jLabelFixture);

        jLabelFixture.requireText(errorMessage);
    }

    @Test
    public void testShowErrorNullString() {
        gui.showError(null,"title");
        assertNull("Gui frame is not null",gui.frame);
    }

    @Test
    public void testShowErrorNullTitle() {
        gui.showError("Error", null);
        assertNull("Gui frame is not null", gui.frame);
    }

    @Test
    public void testBuildMatrixPanel() {
        throw new RuntimeException();
    }

    @Test
    public void testCreateMatrix() {
        throw new RuntimeException();
    }

    @Test
    public void testMatrixOptimalFontColor() {
        throw new RuntimeException();
    }

    @Test
    public void testMatrixNonOptimalFontColor() {
        throw new RuntimeException();
    }

    @Test
    public void createUIComponents() {
        throw new RuntimeException();
    }
}