/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ax.ha.it.mortgageplan;

import java.util.ArrayList;


/**
 * This class prints calculated mortgage data for customers
 * 
 * @author jennie
 */
public class Main {
    /**
     * This method prints out prospects for each customer
     * 
     * @param loans
     */
    public static void print_prospects(ArrayList<MortgageCalculator> prospects) {
        for (int i = 0; i < prospects.size(); i++) {
            String mp = String.format("%.02f", prospects.get(i).getMonthly_payment());
            System.out.print("Prospect " + (i+1) + " : " + prospects.get(i).getCustomer() + " wants to borrow " +
                    prospects.get(i).getTotal_loan() + " € for a period of " + prospects.get(i).getLoan_years()
                    + " years and pay " + mp + " € each month \n"); 
        }
        
    }
    
    public static void main(String arg[]) {
      
        FileHandler fh = new FileHandler();
        final String filename = "prospects.txt";
        //Reads text from file to a list
        ArrayList<String[]> data_list = fh.read_data(filename);
        ArrayList <MortgageCalculator> prospects = new ArrayList<>();
        
        //Saves data from file to MortgageCalculator objects
        for (String[] data : data_list) {
            String customer = data[0];  
            double total_loan = Double.parseDouble(data[1]);                    
            double interest = Double.parseDouble(data[2]);
            int years = Integer.parseInt(data[3]);    
            MortgageCalculator mc = new MortgageCalculator(customer, total_loan, interest, years);
            
            //Calculates fixed monthly payment
            double monthly_payment = mc.calc_monthly_payment();
            mc.setMonthly_payment(monthly_payment);
            
            //Adds all prospects to a list
            prospects.add(mc);
        }
        //Prints loan data for each customer
        print_prospects(prospects);
    
    }

  
    
}   
