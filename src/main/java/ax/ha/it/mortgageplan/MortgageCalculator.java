/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ax.ha.it.mortgageplan;

/**
 * This class calculates mortgage data for a customer
 * @author jennie
 */
public class MortgageCalculator {
    private String customer;
    private double total_loan;
    private double yearly_interest;
    private int loan_years;
    private double monthly_payment;
    
    /**
     * Constructor
     * @param customer
     * @param total_loan
     * @param yearly_interest
     * @param loan_years
     */
    public MortgageCalculator(String customer, double total_loan, double yearly_interest, int loan_years) {
        this.customer = customer;
        this.total_loan = total_loan;
        this.yearly_interest = yearly_interest;
        this.loan_years = loan_years;
    }
    
    /**
     * This method calculates the power of a number
     * 
     * @param base
     * @param exponent
     * @return result 
     */
    public double calc_pow(double base, int exponent) {
        double result = 1;
        for (;exponent > 0; --exponent)
        {
            result *= base;
        }
        return result;
    }
    
    /**
     * This method calculates the fixed monthly payment of a loan
     * 
     * @return monthly payment
     */
    public double calc_monthly_payment() {
        //Interest on monthly basis
        double mi = this.yearly_interest/(100 * 12);
        //Number of payments
        int payments = this.loan_years * 12;
        //Monthly payment
        double mp = (this.total_loan * (mi * calc_pow((1 + mi), payments))) 
                / (calc_pow((1 + mi), payments) -1);
        
        return mp;
    }
    
    /**
     * Setter for monthly payment
     * @param monthly_payment
     */
    public void setMonthly_payment(double monthly_payment) {
        this.monthly_payment = monthly_payment;
    }
   
    /**
     * Getters
     */
    public String getCustomer() {
        return customer;
    }
    
    public double getTotal_loan() {
        return total_loan;
    }

    public double getYearly_interest() {
        return yearly_interest;
    }

    public int getLoan_years() {
        return loan_years;
    }

    public double getMonthly_payment() {
        return monthly_payment;
    }
      
}
