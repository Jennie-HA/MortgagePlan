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
        
        //Reformatting strings that matches the regex
        if (Pattern.compile(reg).matcher(line).find()) {
            line = line.replaceAll(reg, replacement); 
        }
        return line;
    }
    
    /**
     * This method reads text from a file into a list
     * 
     * @param filename
     * @return A list of String arrays
     */
    public ArrayList<String[]> read_data(String filename){
        BufferedReader br = null;
        ArrayList<String[]> data_strings = new ArrayList<>();
        
        try {
            br = new BufferedReader(new FileReader(filename));
        
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                if(! line.isEmpty()) {
                    //Reformatting strings if needed
                    line = this.clean_strings(line);
                    //strings are separated by comma signs and added to an array
                    String[] data = line.split(",");
                    data_strings.add(data);

                }
                //Stop reading if line is empty
                else {
                    break;
                }   
            }
        } catch(FileNotFoundException ex){
            System.out.println("File not found");
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
        return data_strings;

        
    }
}
