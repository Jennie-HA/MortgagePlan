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
public class MortgageCalculatorTest {
    
    public MortgageCalculatorTest() {
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
     * Test of calc_pow method, of class MortgageCalculator.
     */
    @Test
    public void testCalc_pow() {
        System.out.println("calc_pow");
        MortgageCalculator instance = new MortgageCalculator();
        double base1 = 2.5;
        int exponent1 = 2;
        double expResult1 = 6.25;
        double result1 = instance.calc_pow(base1, exponent1);
        assertEquals(expResult1, result1, 0.001);

        double base3 = 2;
        int exponent3 = 0;
        double expResult3 = 1;
        double result3 = instance.calc_pow(base3, exponent3);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of calc_monthly_payment method, of class MortgageCalculator.
     */
    @Test
    public void testCalc_monthly_payment() {
        System.out.println("calc_monthly_payment");
        Loan loan1 = new Loan("Jennie", 1500, 6, 1);
        MortgageCalculator mc1 = new MortgageCalculator();
        double expResult1 = 129.10;
        double result1 = mc1.calc_monthly_payment(loan1);
        assertEquals(expResult1, result1, 0.001);
        
        Loan loan2 = new Loan("John", 10000, 3.5, 8);
        MortgageCalculator mc2 = new MortgageCalculator();
        double expResult2 = 119.58;
        double result2 = mc2.calc_monthly_payment(loan2);
        assertEquals(expResult2, result2, 0.001);
    }

   
}
