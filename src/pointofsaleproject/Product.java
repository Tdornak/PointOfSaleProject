
package pointofsaleproject;

import java.text.NumberFormat;

/**
 *
 * @author Tim
 */
public class Product {
    
    private String productId;
    private String name;
    private double price;
    private DiscountStrategy discount;
    
    
    public Product(String productId, String name, double price, DiscountStrategy discount) {
        this.setProductId(productId);
        this.setName(name);
        this.setPrice(price);
        this.setDiscount(discount);
    }
    
    public double getAmtSaved(double qty) {
        return discount.getAmtSaved(price, qty);
    }
    
    public double getDiscountedTotal(double qty) {
        return discount.getDiscountedTotal(price, qty);
    }

    @Override 
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String string = this.getProductId() + "    " + this.getName();
        StringBuilder s = new StringBuilder(string);
        for (int counter = 0; counter < 25 - this.getName().length(); counter++) {
            s.append(" ");
        }
        s.append(fmt.format(getPrice()));
        
        return s.toString();      
    }
    
    //setters
    public final void setProductId(String productId) {
        this.productId = productId;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final void setPrice(double price) {
        if (price > 0.00) {
            this.price = price;
        } else {
            System.out.println("invalid price");
        }
    }

    public final void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }
    
    //getters
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

   public double getPrice() {
        return price;
    }
   
    public DiscountStrategy getDiscount() {
        return discount;
    }
    
}
