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
 * Tests for Loan
 * @author jennie
 */
public class LoanTest {
    
    public LoanTest() {
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
     * Test of setMonthly_payment method, of class Loan.
     */
    @Test
    public void testSetMonthly_payment() {
        System.out.println("setMonthly_payment");
        double monthly_payment = 131.61;
        Loan instance = new Loan("Jennie", 3000, 5, 2);
        instance.setMonthly_payment(monthly_payment);
        assertEquals(monthly_payment, instance.getMonthly_payment(), 0.001);
    }
    
    /**
     * Test of getCustomer method, of class Loan.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        Loan instance = new Loan("Jennie", 3000, 5, 2);
        String expResult = "Jennie";
        String result = instance.getCustomer();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getTotal_loan method, of class Loan.
     */
    @Test
    public void testGetTotal_loan() {
        System.out.println("getTotal_loan");
        Loan instance = new Loan("Jennie", 3000, 5, 2);
        double expResult = 3000;
        double result = instance.getTotal_loan();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of getYearly_interest method, of class Loan.
     */
    @Test
    public void testGetYearly_interest() {
        System.out.println("getYearly_interest");
        Loan instance = new Loan("Jennie", 3000, 5, 2);
        double expResult = 5;
        double result = instance.getYearly_interest();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of getLoan_years method, of class Loan.
     */
    @Test
    public void testGetLoan_years() {
        System.out.println("getLoan_years");
        Loan instance = new Loan("Jennie", 3000, 5, 2);
        double expResult = 2;
        double result = instance.getLoan_years();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonthly_payment method, of class Loan.
     */
    @Test
    public void testGetMonthly_payment() {
        System.out.println("getMonthly_payment");
        Loan instance = new Loan("Jennie", 3000, 5, 2);
        double expResult = 0.0;
        double result = instance.getMonthly_payment();
        assertEquals(expResult, result, 0.001);
    }
    
}
