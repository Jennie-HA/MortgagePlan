/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ax.ha.it.mortgageplan;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jennie
 */
public class FileHandlerTest {
    
    public FileHandlerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of clean_strings method, of class FileHandler.
     */
    @Test
    public void testClean_strings() {
        System.out.println("clean_strings");
        String line = "";
        FileHandler instance = new FileHandler();
        String expResult = "";
        String result = instance.clean_strings(line);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read_data method, of class FileHandler.
     */
    @Test
    public void testRead_data() {
        System.out.println("read_data");
        String filename = "";
        FileHandler instance = new FileHandler();
        ArrayList expResult = null;
        ArrayList result = instance.read_data(filename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
