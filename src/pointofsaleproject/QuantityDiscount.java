package pointofsaleproject;

/**
 *
 * @author Tim
 */
public class QuantityDiscount implements DiscountStrategy {
    
    private double percent = .10;
    private double min_Qty = 5;

    public QuantityDiscount(double percent, double min_Qty) {
        this.setPercent(percent);
        this.setMin_Qty(min_Qty);
    }


    @Override
    public double getAmtSaved(double price, int qty) {
        double amtSaved = 0;
        if (qty >= min_Qty) {
            amtSaved = price * qty * percent;
        }
        return amtSaved;
    }
    
    @Override
    public double getDiscountedTotal(double price, int qty) {
        double discountedTotal = price * qty;
        if (qty >= min_Qty) {
            discountedTotal = price * qty - this.getAmtSaved(price, qty);
        }
        return discountedTotal;
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

    public double getMin_Qty() {
        return min_Qty;
    }

    public final void setMin_Qty(double min_Qty) {
        if (min_Qty > 0) {
            this.min_Qty = min_Qty;
        } else {
            System.out.println("Invalid entry");
        }
        
    }
    
    
}

