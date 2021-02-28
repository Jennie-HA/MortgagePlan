/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ax.ha.it.mortgageplan;

import static ax.ha.it.mortgageplan.Utility.calc_pow;

/**
 * This class calculates mortgage data for a customer
 * @author jennie
 */
public class Customer {
    private String name;
    private double total_loan;
    private double yearly_interest;
    private int loan_years;
    private double monthly_payment;
    
    /**
     * Constructor
     * @param name
     * @param total_loan
     * @param yearly_interest
     * @param loan_years
     */
    public Customer(String name, double total_loan, double yearly_interest, int loan_years) {
        this.name = name;
        this.total_loan = total_loan; 
        this.yearly_interest = yearly_interest;
        this.loan_years = loan_years;
    }
     
    /**
     * This method calculates and returns the fixed monthly payment 
     * 
     * @return monthly payment
     */
    public double get_monthly_payment() {
        //Interest on monthly basis
        double mi = this.yearly_interest/(100 * 12);
        int no_of_payments = this.loan_years * 12;
        //Monthly payment
        double mp = (this.total_loan * (mi * calc_pow((1 + mi), no_of_payments))) 
                / (calc_pow((1 + mi), no_of_payments) -1);
        
        return mp;
    }
    
    /**
     * Getters
     */
    public String getName() {
        return name;
    }
    
    public double getTotal_loan() {
        return total_loan;
    }

    public int getLoan_years() {
        return loan_years;
    }

    public double getMonthly_payment() {
        return monthly_payment;
    }
      
}
