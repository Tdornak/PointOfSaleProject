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

    @Override
    public double getAmtSaved(double price, double qty) {
        return price * qty * percent;
    }
    
    @Override
    public double getDiscountedTotal(double price, double qty) {
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
     
    
    public static void main(String[] args) {
        PercentDiscount p = new PercentDiscount();
        
        System.out.println("expected 2 got " + p.getAmtSaved(10, 2));
        System.out.println("expected 18 got " + p.getDiscountedTotal(10, 2));
    }
 
    
}

