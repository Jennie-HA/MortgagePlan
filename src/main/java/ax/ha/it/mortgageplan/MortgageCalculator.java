/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ax.ha.it.mortgageplan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;


/**
 *
 * @author jennie
 */
public class MortgageCalculator {

//Readme of how to start the application
//Unit test for testing application logic

    
    public double calc_pow(double base, double exponent) {
        double result = 1;
        for (;exponent > 0; --exponent)
        {
            result *= base;
        }
        return result;
    }
    
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
        
        String filename = "prospects.txt";
        ArrayList<String[]> data_list = fh.read_data(filename);
        
        for (String[] data : data_list) {
            String customer = data[0];  
            double total_loan = Double.parseDouble(data[1]);                    
            double interest = Double.parseDouble(data[2]);
            int years = Integer.parseInt(data[3]);    

            Loan loan = new Loan(customer, total_loan, interest, years);
            double monthly_payment = mc.calc_monthly_payment(loan);
            loan.setMonthly_payment(monthly_payment);

            loans.add(loan);
        }
        mc.print_loan_data(loans);
    
    }

  
    
}   
