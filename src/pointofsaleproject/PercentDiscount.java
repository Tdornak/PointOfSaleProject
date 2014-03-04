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
public class PercentDiscount implements DiscountStrategy {
    
    private double percent = .10;

    public PercentDiscount(double percent) {
        this.setPercent(percent);
    }


    @Override
    public double getAmtSaved(double price, int qty) {
        return price * qty * percent;
    }
    
    @Override
    public double getDiscountedTotal(double price, int qty) {
        return price * qty - this.getAmtSaved(price, qty);
    }
    
    public double getPercent() {
        return percent;
    }

    public final void setPercent(double percent) {
        if (percent >= 0 && percent <= 100) {
            this.percent = percent / 100;
        } else {
            System.out.println("Invalid entry");
        }
        
    }
     
    
}

