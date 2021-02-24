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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;


/**
 *
 * @author jennie
 */
public class MortgageCalculator {
//    Your task is to create a Java application that reads the attached file and 
//            print out the result for each customer given the formula below.

//A build tool used to compile, build, test and run project
//Readme of how to start the application
//Unit test for testing application logic
//Usage of java.math or similar math dependencies are not allowed
    
    public static void main(String arg[]) {
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
                    if(line != null) {
                        if (Pattern.compile(reg).matcher(line).find()) {
                            line = line.replaceAll(reg, replacement); 
                        }
                        String[] array = line.split(",");
                        for(int i = 0; i < array.length; i++) {
                           System.out.println(array[i]);
                        }
                    }
                
                
                                
                
    
                
            }
            String data = sb.toString();
            //System.out.println(data);
    
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
