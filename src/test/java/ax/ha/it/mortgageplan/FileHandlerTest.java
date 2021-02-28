/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ax.ha.it.mortgageplan;

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
     /**
     * Test of clean_strings method, of class FileHandler.
     */
    @Test
    public void testClean_strings() {
        System.out.println("clean_strings");
        String line1 = "\"Jennie,Eriksson\"";
        String line2 = "Jennie Eriksson";
        String line3 = "Jennie";
        FileHandler instance = new FileHandler();
        String expResult12 = "Jennie Eriksson";
        String expResult3 = "Jennie";
        String result1 = instance.clean_strings(line1);
        String result2 = instance.clean_strings(line2);
        String result3 = instance.clean_strings(line3);
        assertEquals(expResult12, result1);
        assertEquals(expResult12, result2);
        assertEquals(expResult3, result3);
    }

    
}
