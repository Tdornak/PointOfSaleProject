/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pointofsaleproject;

/**
 *
 * @author Tim
 */
public class NoDiscount implements DiscountStrategy {
    

    @Override
    public double getAmtSaved(double price, double qty) {
        return 0;
    }
    
    @Override
    public double getDiscountedTotal(double price, double qty) {
        return 0;
    }
     
    
}

