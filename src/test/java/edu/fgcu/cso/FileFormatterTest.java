package edu.fgcu.cso;

import edu.fgcu.cso.FileFormatter;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Colin on 3/12/2015.
 */
public class FileFormatterTest {

    final static String TEST_FILE_DIRECTORY = "";

    FileFormatter fileFormatter;
    File goodData;
    File blankData;
    File charData;
    File nonSquareData;
    File doesNotExist;

    @Before
    public void setup(){
        fileFormatter = new FileFormatter();
        goodData = new File(TEST_FILE_DIRECTORY + "goodTestData.txt");
        blankData = new File(TEST_FILE_DIRECTORY + "blankTestData.txt");
        charData = new File(TEST_FILE_DIRECTORY + "charTestData.txt");
        nonSquareData = new File(TEST_FILE_DIRECTORY + "nonSquareTestData.txt");
        doesNotExist = new File("ThisIsANameIMadeUp.txt");
    }

    public FileFormatterTest(){

    }

    @Test
    public void testGetData(){
        throw new RuntimeException();
    }

    @Test
    public void testGetDataNullFile(){
        throw new RuntimeException();
    }

    @Test
    public void testGetDataFileNotFound(){
        throw new RuntimeException();
    }

    @Test
    public void testReadData(){
        String[][] dataRead = null;

        try {
            dataRead = fileFormatter.readData(goodData);
        } catch (IOException e) {
            fail("An IOException was thrown");
        }

        assertNotNull("String array returned was null", dataRead);

        int expectedValue = 1;
        for(String[] array : dataRead){
            for(String data : array){
                assertEquals("data read from file does not match expected data from file",Integer.toString(expectedValue),data);
                expectedValue++;
            }
        }
    }

    @Test
    public void testReadDataError(){
        try {
            fileFormatter.readData(doesNotExist);
            fail("Expected exception was not thrown");
        } catch (IOException ignored) {}
    }

    @Test
    public void testReadDataBlank(){
        String[][] dataRead = null;

        try {
            dataRead = fileFormatter.readData(blankData);
        } catch (IOException e) {
            fail("An IOException was thrown");
        }

        assertNull(dataRead);
    }

    @Test
    public void testParseData(){
        throw new RuntimeException();
    }

    @Test
    public void testParseDataError(){
        throw new RuntimeException();
    }

    @Test
    public void testCheckSquareTrue(){
        throw new RuntimeException();
    }

    @Test
    public void testCheckSquareFalse(){
        throw new RuntimeException();
    }

}