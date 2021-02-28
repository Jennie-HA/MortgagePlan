/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ax.ha.it.mortgageplan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jennie
 */
public class CustomerTest {

    /**
     * Test of calc_monthly_payment method, of class Customer
     */
    @Test
    public void get_monthly_payment() {
        System.out.println("calc_monthly_payment");
        Customer mc1 = new Customer("Jennie", 1500, 6, 1);
        double expResult1 = 129.10;
        double result1 = mc1.get_monthly_payment();
        assertEquals(expResult1, result1, 0.001);
        
        Customer mc2 = new Customer("John", 10000, 3.5, 8);
        double expResult2 = 119.58;
        double result2 = mc2.get_monthly_payment();
        assertEquals(expResult2, result2, 0.001);
    }
    
    
    /**
     * Test of getters
     */
    @Test
    public void testGetName() {
        System.out.println("getCustomer");
        Customer instance = new Customer("Jennie", 3000, 5, 2);
        String expResult = "Jennie";
        String result = instance.getName();
        assertEquals(expResult, result);
       
    }

    @Test
    public void testGetTotal_loan() {
        System.out.println("getTotal_loan");
        Customer instance = new Customer("Jennie", 3000, 5, 2);
        double expResult = 3000;
        double result = instance.getTotal_loan();
        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testGetLoan_years() {
        System.out.println("getLoan_years");
        Customer instance = new Customer("Jennie", 3000, 5, 2);
        double expResult = 2;
        double result = instance.getLoan_years();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMonthly_payment() {
        System.out.println("getMonthly_payment");
        Customer instance = new Customer("Jennie", 3000, 5, 2);
        double expResult = 0.0;
        double result = instance.getMonthly_payment();
        assertEquals(expResult, result, 0.001);
    }    
}
