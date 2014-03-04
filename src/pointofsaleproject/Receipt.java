package pointofsaleproject;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tdornak
 */
public class Receipt implements OutputStrategy {
    
    private LineItem[] lineItems  = new LineItem[0];
    private final Date currentDate = new Date();
    private final SimpleDateFormat df = new SimpleDateFormat("E MM/dd/yyyy 'at' hh:mm:ss a zzz");
    private String storeName = "A Food Store";
    private final NumberFormat money = NumberFormat.getCurrencyInstance();
    private NumberFormat qtyFormat = NumberFormat.getIntegerInstance();
    
    
    
    @Override
    public void addPurchaseToOutput(String prodId, double qty) {
        
        LineItem l = new LineItem(prodId, new FakeDatabase(), qty);
        addToArray(l);
    }
    
    @Override
    public void createOutput(double amtPaid) {  // not formated completely
        System.out.println("Thank you for shopping at: " + this.getStoreName() + "\n"
                            + "Time of sale: " + df.format(currentDate) + "\n\n\n"
          + "ID       Item                   Price      Qty          SubTotal           Discount \n"
        + "-----------------------------------------------------------------------------------");
        for (LineItem items : lineItems) {
            System.out.println(items.getProduct().toString() + "      " + qtyFormat.format(items.getQty()) + "            "
                    + money.format(items.getProduct().getPrice() * items.getQty()) + "              "
                    + money.format(items.getAmtSaved(items.getQty())));
            //System.out.print();
        }
        System.out.println("                                                                         ----------\n"
                         + "                                                             Net Total:      " + money.format(getNetTotal()) + "\n" 
                         + "                                                             You Saved:       " + money.format(getAmtSavedTotal()) + "\n" //not formated 
                         + "                                                             Total Due:      " + money.format(getTotal()) + "\n"
                         + "                                                           Amount Paid:      " + money.format(amtPaid) + "\n"
                         + "                                                            Change due:       " + money.format(amtPaid - getTotal()) + "\n");
    }
    
    @Override
    public double getTotal() {
        return this.getNetTotal() - this.getAmtSavedTotal();
    }
    
    private double getAmtSavedTotal() {
        double saved = 0;
        for (LineItem item : lineItems){
            saved += item.getProduct().getAmtSaved(item.getQty()); 
        }
        return saved;
    }
    
    private double getNetTotal() {
        double netTotal = 0;
        for (LineItem item : lineItems){
            netTotal += item.getProduct().getPrice() * item.getQty(); 
        }
        return netTotal;
    }
    
    private void addToArray(final LineItem item) {
        if (item == null) {
            System.out.println("addToArray() failed");
        } else {
            LineItem[] tempItems = new LineItem[lineItems.length + 1];
            System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
            tempItems[lineItems.length] = item;
            lineItems = tempItems;
        } 
    }
    
    
    //setters
    @Override
    public void setStoreName(String storeName) {
        if (storeName == null || storeName.isEmpty()) {
            System.out.println("Invalid Name");
        } else {
            this.storeName = storeName;
        }
    }

    //getters
    @Override
    public long getCurrentDate() {
        return currentDate.getTime();
    }

    @Override
    public String getStoreName() {
        return storeName;
    }
    
}
