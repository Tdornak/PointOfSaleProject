package pointofsaleproject;

import java.text.NumberFormat;

/**
 *
 * @author Tim
 */
public class LineItem {
    //private final String SPACE6 = "      ";
    private Product product;
    private InventoryStrategy inventory;
    private int qty;

    public LineItem(String productID, InventoryStrategy inventory, int qty) {
        this.setInventory(inventory);
        this.setProduct(inventory.getProduct(productID));
        this.setQty(qty);
    }

    public double getAmtSaved(int qty) {
        return product.getAmtSaved(qty);
    }
    
    public double getDiscountedTotal(int qty) {
        return product.getDiscountedTotal(qty);
    }

    @Override //formatting lineItem for receipt
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String string = product.getProductId() + "    " + product.getName();
        StringBuilder s = new StringBuilder(string);
        
        //formatting Name
        for (int counter = 0; counter < 25 - product.getName().length(); counter++) {
            s.append(" ");
        }
        s.append(fmt.format(product.getPrice()));
        
        //formatting qty
        if (qty < 10) {
            s.append("      ").append(qty);
        } else if (qty >= 10) {
            s.append("     ").append(qty);
        } else {
            s.append("    ").append(qty);
        }
        
        //formatting subTotal
        if (subTotal() < 10) {
            s.append("             ").append(fmt.format(subTotal()));
        } else if (subTotal() >= 10) {
            s.append("            ").append(fmt.format(subTotal()));
        } else {
            s.append("           ").append(fmt.format(subTotal()));
        }
        
        //formatting Discount
        if (getAmtSaved(qty) < 10) {
            s.append("             ").append(fmt.format(getAmtSaved(qty)));
        } else if (getAmtSaved(qty) >= 10) {
            s.append("            ").append(fmt.format(getAmtSaved(qty)));
        } else {
            s.append("           ").append(fmt.format(getAmtSaved(qty)));
        }
        
        return s.toString();   
    }
    
    private double subTotal() {
        return product.getPrice() * qty;
    }
    
    //setters
    public final void setProduct(Product product) {
        this.product = product;
    }

    public final void setInventory(InventoryStrategy inventory) {
        this.inventory = inventory;
    }

    public final void setQty(int qty) {
        this.qty = qty;
    }
    

    //getters
    public Product getProduct() {
        return product;
    }

    public InventoryStrategy getInventory() {
        return inventory;
    }

    public int getQty() {
        return qty;
    }

    
}
