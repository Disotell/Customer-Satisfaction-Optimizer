package edu.fgcu.cso;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Colin on 3/12/2015.
 */
class FileFormatterTest{

    FileFormatter fileFormatter;

    @Before
    public void setup(){
        fileFormatter = new FileFormatter();
    }

    public FileFormatterTest(){

    }

    @Test(expected = RuntimeException.class)
    public void testGetData(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testGetDataNullFile(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testGetDataFileNotFound(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testReadData(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testReadDataError(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testParseData(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testParseDataError(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testCheckSquareTrue(){
        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void testCheckSquareFalse(){
        throw new RuntimeException();
    }

}