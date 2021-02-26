/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ax.ha.it.mortgageplan;

import java.util.ArrayList;


/**
 * This class calculates and print loan data
 * 
 * @author jennie
 */
public class MortgageCalculator {
    
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
     * @param loan
     * @return monthly payment
     */
    public double calc_monthly_payment(Loan loan) {
        //Interest on monthly basis
        double mi = loan.getYearly_interest()/(100 * 12);
        //Total loan
        double total_loan = loan.getTotal_loan();
        //Number of payments
        int payments = loan.getLoan_years() * 12;
        //Monthly payment
        double monthly_payment = (total_loan * (mi * calc_pow((1 + mi), payments))) 
                / (calc_pow((1 + mi), payments) -1);
        
        return monthly_payment;
        
    }
    
    /**
     * This method prints out loan data for each customer
     * 
     * @param loans
     */
    public void print_loan_data(ArrayList<Loan> loans) {
        for (int i = 0; i < loans.size(); i++) {
            String mp = String.format("%.02f", loans.get(i).getMonthly_payment());
            System.out.print("Prospect " + (i+1) + " : " + loans.get(i).getCustomer() + " wants to borrow " +
                    loans.get(i).getTotal_loan() + " € for a period of " + loans.get(i).getLoan_years()
                    + " years and pay " + mp + " € each month \n"); 
        }
        
    }
    
    public static void main(String arg[]) {
        MortgageCalculator mc = new MortgageCalculator();
        ArrayList <Loan> loans = new ArrayList<>();
        FileHandler fh = new FileHandler();
        
        //Reads text file to a list
        final String filename = "prospects.txt";
        ArrayList<String[]> data_list = fh.read_data(filename);
        
        //Saves data from file to Loan objects
        for (String[] data : data_list) {
            String customer = data[0];  
            double total_loan = Double.parseDouble(data[1]);                    
            double interest = Double.parseDouble(data[2]);
            int years = Integer.parseInt(data[3]);    
            Loan loan = new Loan(customer, total_loan, interest, years);
            
            //Calculates fixed monthly payment
            double monthly_payment = mc.calc_monthly_payment(loan);
            loan.setMonthly_payment(monthly_payment);
            
            //Adds all loan objects to a list
            loans.add(loan);
        }
        //Prints loan data for each customer
        mc.print_loan_data(loans);
    
    }

  
    
}   
