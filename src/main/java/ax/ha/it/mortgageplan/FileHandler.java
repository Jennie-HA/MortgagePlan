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
public class FileHandler {
//    private String filename;

//    public FileHandler(String filename) {
//        this.filename = filename;
//    }
    
    
    public ArrayList<String[]> read_data(String filename){
        BufferedReader br = null;
        ArrayList<String[]> data_strings = new ArrayList<String[]>();
        
        try {
            br = new BufferedReader(new FileReader(filename));
        
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
                        String[] data = line.split(",");
                        data_strings.add(data);
                       
                    }
                    //Stop reading if line is empty
                    else {
                        break;
                    }   
            }
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
        return data_strings;

        
    }
}
