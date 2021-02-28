/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ax.ha.it.mortgageplan;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class prints calculated mortgage data for customers
 * 
 * @author jennie
 */
public class Main {

    public static void main(String arg[]) {
      
        FileHandler fh = new FileHandler();
        final String filename = "prospects.txt";
        //Reads text from file to a list
        ArrayList<String[]> data_list;
        try {
            data_list = fh.read_data(filename);
            
            //Saves data from file to MortgageCalculator objects
            for (int i = 0; i < data_list.size(); i++) {
                String[] data = data_list.get(i);
                String name = data[0];  
                double total_loan = Double.parseDouble(data[1]);                    
                double interest = Double.parseDouble(data[2]);
                int years = Integer.parseInt(data[3]);    
                Customer customer = new Customer(name, total_loan, interest, years);

                //Prints prospects for each customer
                String monthly_payment = String.format("%.02f", customer.get_monthly_payment());
                System.out.println("Prospect " + (i+1) + " : " + customer.getName() + " wants to borrow " +
                        customer.getTotal_loan() + " € for a period of " + customer.getLoan_years()
                        + " years and pay " + monthly_payment + " € each month");
            }
        } catch (IOException ex) {
            System.out.println(filename + " not found or cannot be read");
        }   
    }
}   
