package edu.fgcu.cso;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Colin on 3/12/2015.
 */
public class FileFormatterTest {

    final static String TEST_FILE_DIRECTORY = ".\\src\\test\\resources\\";

    FileFormatter fileFormatter;
    File goodData;
    File blankData;
    File charData;
    File nonSquareData;
    File doesNotExist;

    @Before
    public void setup() {
        fileFormatter = new FileFormatter();
        goodData = new File(TEST_FILE_DIRECTORY + "goodTestData.txt");
        blankData = new File(TEST_FILE_DIRECTORY + "blankTestData.txt");
        charData = new File(TEST_FILE_DIRECTORY + "charTestData.txt");
        nonSquareData = new File(TEST_FILE_DIRECTORY + "nonSquareTestData.txt");
        doesNotExist = new File("ThisIsANameIMadeUp.txt");
    }

    public FileFormatterTest() {

    }

    @Test
    public void testGetData() {
        int[][] dataRead = null;

        try {
            dataRead = fileFormatter.getData(goodData);
        } catch (IOException e) {
            fail("An IOException was thrown");
        }

        assertNotNull("int array returned was null", dataRead);

        int[][] knownDataInFile =
                {{1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25}};

        assertEquals("outer dimensions of input do not match dimensions of output", knownDataInFile.length, dataRead.length);
        for (int i = 0; i < knownDataInFile.length; i++) {
            assertEquals("inner dimensions of input do not match dimensions of output", knownDataInFile[i].length, dataRead[i].length);
            assertArrayEquals("Array values expected does not match array returned", knownDataInFile[i], dataRead[i]);
        }
    }

    @Test
    public void testGetDataNullFile() {
        int[][] dataRead = null;
        try {
            dataRead = fileFormatter.getData(null);
        } catch (IOException e) {
            fail("An IOException was thrown");
        }
        assertNull("data array returned from null file not null", dataRead);
    }

    @Test
    public void testGetDataNonSquare() {
        int[][] dataRead = null;
        try {
            dataRead = fileFormatter.getData(nonSquareData);
        } catch (IOException e) {
            fail("An IOException was thrown");
        }
        assertNull("data array returned from non-square file not null", dataRead);
    }

    @Test
    public void testGetDataFileNotFound() {
        try {
            fileFormatter.getData(doesNotExist);
            fail("Expected exception was not thrown");
        } catch (IOException ignored) {
        }
    }

    @Test
    public void testReadData() {
        String[][] dataRead = null;

        try {
            dataRead = fileFormatter.readData(goodData);
        } catch (IOException e) {
            fail("An IOException was thrown");
        }

        assertNotNull("String array returned was null", dataRead);

        int expectedValue = 1;
        for (String[] array : dataRead) {
            for (String data : array) {
                assertEquals("data read from file does not match expected data from file", Integer.toString(expectedValue), data);
                expectedValue++;
            }
        }
    }

    @Test
    public void testReadDataError() {
        try {
            fileFormatter.readData(doesNotExist);
            fail("Expected exception was not thrown");
        } catch (IOException ignored) {
        }
    }

    @Test
    public void testReadDataBlank() {
        String[][] dataRead = null;

        try {
            dataRead = fileFormatter.readData(blankData);
        } catch (IOException e) {
            fail("An IOException was thrown");
        }

        assertNull(dataRead);
    }

    @Test
    public void testParseData() {
        String[][] initialData =
                {{"1", "2", "3", "4", "5"},
                        {"6", "7", "8", "9", "10"}};

        int[][] targetData =
                {{1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10}};

        int[][] dataRead = fileFormatter.parseData(initialData);

        assertNotNull("int array returned was null", dataRead);

        assertEquals("outer dimensions of input do not match dimensions of output", initialData.length, dataRead.length);
        for (int i = 0; i < initialData.length; i++) {
            assertEquals("inner dimensions of input do not match dimensions of output", initialData[i].length, dataRead[i].length);
            assertArrayEquals("Array values expected does not match array returned", targetData[i], dataRead[i]);
        }


    }

    @Test
    public void testParseDataError() {
        String[][] initialData =
                {{"1", "2", "c", "4", "5"},
                        {"6", "7", "8", "9", "10"}};

        int[][] dataRead = fileFormatter.parseData(initialData);

        assertNull("int array returned was not null", dataRead);
    }

    @Test
    public void testCheckSquareTrue() {
        String[][] initialData =
                {{"1", "2", "3"},
                        {"4", "5", "6"},
                        {"7", "8", "9"}};

        assertTrue("square matrix, does not return true", fileFormatter.checkSquare(initialData));
    }

    @Test
    public void testCheckSquareFalse() {
        String[][] initialData =
                {{"1", "2", "3"},
                        {"4", "5"},
                        {"6", "7", "8"}};

        assertFalse("Non-square matrix, returns true", fileFormatter.checkSquare(initialData));
    }

}