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
public class Utility {
    /**
     * This method calculates the power of a number
     * 
     * @param base
     * @param exponent
     * @return result 
     */
    static double calc_pow(double base, int exponent) {
        double result = 1;
        for (;exponent > 0; --exponent)
        {
            result *= base;
        }
        return result;
    }
    
    
}
