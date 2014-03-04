package pointofsaleproject;

/**
 *
 * @author Tim
 */
public class LineItem {
    
    private Product product;
    private InventoryStrategy inventory;
    private double qty;

    public LineItem(String productID, InventoryStrategy inventory, double qty) {
        this.setInventory(inventory);
        this.setProduct(inventory.getProduct(productID));
        this.setQty(qty);
    }

    public double getAmtSaved(double qty) {
        return product.getAmtSaved(qty);
    }
    
    public double getDiscountedTotal(double qty) {
        return product.getDiscountedTotal(qty);
    }
    
    
    
    //setters
    public final void setProduct(Product product) {
        this.product = product;
    }

    public final void setInventory(InventoryStrategy inventory) {
        this.inventory = inventory;
    }

    public final void setQty(double qty) {
        this.qty = qty;
    }
    

    //getters
    public Product getProduct() {
        return product;
    }

    public InventoryStrategy getInventory() {
        return inventory;
    }

    public double getQty() {
        return qty;
    }

    
}
