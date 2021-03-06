/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ax.ha.it.mortgageplan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is responible for file management
 * 
 * @author jennie
 */
public class FileHandler {    

    /**
     * This method is used to remove quotation marks and comma sign from a string 
     * and replace the comma sign with a space
     * 
     * @param line This is a string of a row that has been read from the file
     * @return A string 
     */
    public String clean_strings(String line) {
        
        //Regexpression that matches strings with this format: "name,surname"
        String reg = "\"(.+),(.+)\"";
        //Regexpression that replaces strings to this format: name surname
        String replacement = "$1 $2";
        line = line.replaceAll(reg, replacement);
        
        return line;
    }
    
    /**
     * This method reads text from a file into a list
     * 
     * @param filename
     * @return A list of String arrays 
     * @throws java.io.IOException 
     */
    public ArrayList<String[]> read_data(String filename) throws IOException{
        //BufferedReader br = null;
        ArrayList<String[]> data_strings = new ArrayList<>();
        
        //Try with resources -> file closes automatically
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            //Remove the first line
            String line = br.readLine();
          
            while ((line = br.readLine()) != null) {                
                //Stop reading if line is empty
                if(line.isEmpty()) {
                    break;
                }
                else {
                    //Reformatting strings 
                    line = this.clean_strings(line);

                    //strings are separated by comma signs 
                    String[] data = line.split(",");
                    data_strings.add(data);

                }   
            }
        } 
        return data_strings;
    }
}
