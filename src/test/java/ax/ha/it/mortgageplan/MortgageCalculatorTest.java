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
        MortgageCalculator mc = new MortgageCalculator("Jennie", 1500, 6, 1);
        double base1 = 2.5;
        int exponent1 = 2;
        double expResult1 = 6.25;
        double result1 = mc.calc_pow(base1, exponent1);
        assertEquals(expResult1, result1, 0.001);

        double base3 = 2;
        int exponent3 = 0;
        double expResult3 = 1;
        double result3 = mc.calc_pow(base3, exponent3);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of calc_monthly_payment method, of class MortgageCalculator.
     */
    @Test
    public void testCalc_monthly_payment() {
        System.out.println("calc_monthly_payment");
        MortgageCalculator mc1 = new MortgageCalculator("Jennie", 1500, 6, 1);
        double expResult1 = 129.10;
        double result1 = mc1.calc_monthly_payment();
        assertEquals(expResult1, result1, 0.001);
        
        MortgageCalculator mc2 = new MortgageCalculator("John", 10000, 3.5, 8);
        double expResult2 = 119.58;
        double result2 = mc2.calc_monthly_payment();
        assertEquals(expResult2, result2, 0.001);
    }
    

     /**
     * Test of setMonthly_payment method, of class MortgageCalculator.
     */
    @Test
    public void testSetMonthly_payment() {
        System.out.println("setMonthly_payment");
        double monthly_payment = 131.61;
        MortgageCalculator instance = new MortgageCalculator("Jennie", 3000, 5, 2);
        instance.setMonthly_payment(monthly_payment);
        assertEquals(monthly_payment, instance.getMonthly_payment(), 0.001);
    }
    
    /**
     * Test of getCustomer method, of class MortgageCalculator.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        MortgageCalculator instance = new MortgageCalculator("Jennie", 3000, 5, 2);
        String expResult = "Jennie";
        String result = instance.getCustomer();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getTotal_loan method, of class MortgageCalculator.
     */
    @Test
    public void testGetTotal_loan() {
        System.out.println("getTotal_loan");
        MortgageCalculator instance = new MortgageCalculator("Jennie", 3000, 5, 2);
        double expResult = 3000;
        double result = instance.getTotal_loan();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of getYearly_interest method, of class MortgageCalculator.
     */
    @Test
    public void testGetYearly_interest() {
        System.out.println("getYearly_interest");
        MortgageCalculator instance = new MortgageCalculator("Jennie", 3000, 5, 2);
        double expResult = 5;
        double result = instance.getYearly_interest();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of getLoan_years method, of class MortgageCalculator.
     */
    @Test
    public void testGetLoan_years() {
        System.out.println("getLoan_years");
        MortgageCalculator instance = new MortgageCalculator("Jennie", 3000, 5, 2);
        double expResult = 2;
        double result = instance.getLoan_years();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonthly_payment method, of class MortgageCalculator.
     */
    @Test
    public void testGetMonthly_payment() {
        System.out.println("getMonthly_payment");
        MortgageCalculator instance = new MortgageCalculator("Jennie", 3000, 5, 2);
        double expResult = 0.0;
        double result = instance.getMonthly_payment();
        assertEquals(expResult, result, 0.001);
    }    
}
