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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;


/**
 *
 * @author jennie
 */
public class MortgageCalculator {

//A build tool used to compile, build, test and run project
//Readme of how to start the application
//Unit test for testing application logic

    
    public double calc_pow(double base, double exponent) {
        double result = 1;
        for (;exponent != 0; --exponent)
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
        //Prospect 1: CustomerName wants to borrow X € for a period of Z years and pay E € each month
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
        
        BufferedReader br = null;
       
        try {
            br = new BufferedReader(new FileReader("prospects.txt"));
        
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                String reg = "\"(.+),(.+)\"";
                String replacement = "$1 $2";
                    if(! line.isEmpty()) {
                        if (Pattern.compile(reg).matcher(line).find()) {
                            line = line.replaceAll(reg, replacement); 
                        }
                        String[] array = line.split(",");
                        String customer = array[0];  
                        double total_loan = Double.parseDouble(array[1]);                    
                        double interest = Double.parseDouble(array[2]);
                        int years = Integer.parseInt(array[3]);    
                        
                        Loan loan = new Loan(customer, total_loan, interest, years);
                        double monthly_payment = mc.calc_monthly_payment(loan);
                        loan.setMonthly_payment(monthly_payment);
                        
                        loans.add(loan);
                        
                       
                    }
                    //Stop reading if line is empty
                    else {
                        break;
                    }   
            }
            
            mc.print_loan_data(loans);
    
        } catch(FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            
        }

    
    }

  
    
}   
