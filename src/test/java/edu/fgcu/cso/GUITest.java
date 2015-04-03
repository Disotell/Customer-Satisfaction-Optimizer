package edu.fgcu.cso;


import org.fest.swing.data.TableCell;
import org.fest.swing.data.TableCellByColumnId;
import org.fest.swing.data.TableCellFinder;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.ColorFixture;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JTableFixture;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.accessibility.AccessibleContext;
import javax.swing.*;

import static org.junit.Assert.*;
import static edu.fgcu.cso.GUI.TABLE_NAME;

import java.awt.*;
import java.awt.event.WindowEvent;


public class GUITest {

    int[][] knownDataInFile = {
            {1,   2,  3,  4,  5},
            {6,   7,  8,  9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}};

    int[] fakeSolution = {3,   0,  2,  1,  4};


    GUI gui;
    FrameFixture window;


    @Before
    public void setup() {
        gui = new GUI();
    }

    @After
    public void tearDown() {
        if(window != null){
            window.cleanUp();
        }
    }

    public GUITest() {

    }


    @Test
    public void testBuildGUI() {
        gui.buildGUI(knownDataInFile, fakeSolution);

        Frame[] runningFrames = JFrame.getFrames();

        assertNotNull("Running frames returned null", runningFrames);
        assertEquals("Running JFrames is not equal to 1", 1, runningFrames.length);
        assertNotNull("Expected window is null",runningFrames[0]);

        window = new FrameFixture(runningFrames[0]);

        JTableFixture tableFixture = window.table(TABLE_NAME);

        assertNotNull("TableFixture retrieved is null",tableFixture);

        String[][] values = tableFixture.contents();

        assertNotNull("Table contents came back null",values);
        assertEquals("Table number of rows does not match expected", knownDataInFile.length,values.length);

        for(int i = 0; i < values.length; i++){
            assertEquals("Columns in row " + i + " of retrieved do not match expected",knownDataInFile[i].length,values[i].length);
            for(int j = 0; j < values[i].length; j++){
                assertEquals("Value in matrix not as expected", Integer.toString(knownDataInFile[i][j]), values[i][j]);
            }
        }

        for(int i = 0; i < knownDataInFile.length; i++){
            for(int j = 0; j < knownDataInFile.length; j++){
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
        throw new RuntimeException();
    }

    @Test
    public void testBuildGUINullSolution() {
        throw new RuntimeException();
    }

    @Test
    public void testBuildGUIEmptyMatrix() {
        throw new RuntimeException();
    }

    @Test
    public void testBuildGUIEmptySolution() {
        throw new RuntimeException();
    }

    @Test
    public void testShowError() {
        throw new RuntimeException();
    }

    @Test
    public void testShowErrorNullString() {
        throw new RuntimeException();
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