/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ax.ha.it.mortgageplan;

/**
 *
 * @author jennie
 */
public class Loan {
    private String customer;
    private double total_loan;
    private double yearly_interest;
    private int loan_years;
    private double monthly_payment;
    

    public Loan(String customer, double total_loan, double yearly_interest, int loan_years) {
        this.customer = customer;
        this.total_loan = total_loan;
        this.yearly_interest = yearly_interest;
        this.loan_years = loan_years;
    }
    

    public void setMonthly_payment(double monthly_payment) {
        this.monthly_payment = monthly_payment;
    }
   

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
