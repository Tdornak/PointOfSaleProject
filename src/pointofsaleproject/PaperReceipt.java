package pointofsaleproject;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tdornak
 */
public class PaperReceipt implements OutputStrategy {
    
    private LineItem[] lineItems  = new LineItem[0];
    private final Date currentDate = new Date();
    private final SimpleDateFormat df = new SimpleDateFormat("E MM/dd/yyyy 'at' hh:mm:ss a zzz");
    private String storeName = "A Food Store";
    private final NumberFormat money = NumberFormat.getCurrencyInstance();
    
    
    
    @Override
    public void addPurchaseToOutput(String prodId, int qty) {
        
        LineItem l = new LineItem(prodId, new FakeDatabase(), qty);
        addToArray(l);
    }
    
    @Override
    public void createOutput(double amtPaid) {  // Mass Formatting
        System.out.println("Thank you for shopping at: " + this.getStoreName() + "\n"
                            + "Time of sale: " + df.format(currentDate) + "\n\n\n"
          + "ID       Item                   Price      Qty          SubTotal           Discount \n"
        + "-----------------------------------------------------------------------------------");
        for (LineItem items : lineItems) {
            System.out.println(items.toString());
        }
        String string = "                                                                         ----------\n";
        StringBuilder s = new StringBuilder(string);
        s.append("                                                             Net Total:");
        if (getNetTotal() < 10) {
            s.append("     ").append(money.format(getNetTotal())).append("\n");
        } else if (getNetTotal() >= 10) {
            s.append("    ").append(money.format(getNetTotal())).append("\n");
        } else if (getNetTotal() >= 100) {
            s.append("   ").append(money.format(getNetTotal())).append("\n");
        }
        s.append("                                                             You Saved:");
        if (getAmtSavedTotal() < 10) {
            s.append("     ").append(money.format(getAmtSavedTotal())).append("\n");
        } else if (getAmtSavedTotal() >= 10) {
            s.append("    ").append(money.format(getAmtSavedTotal())).append("\n");
        } else if (getAmtSavedTotal() >= 100) {
            s.append("   ").append(money.format(getAmtSavedTotal())).append("\n");
        }
        s.append("                                                             Total Due:");
        if (getTotal() < 10) {
            s.append("     ").append(money.format(getTotal())).append("\n");
        } else if (getTotal() >= 10) {
            s.append("    ").append(money.format(getTotal())).append("\n");
        } else if (getTotal() >= 100) {
            s.append("   ").append(money.format(getTotal())).append("\n");
        }
        s.append("                                                           Amount Paid:");
        if (amtPaid < 10) {
            s.append("     ").append(money.format(amtPaid)).append("\n");
        } else if (amtPaid >= 10) {
            s.append("    ").append(money.format(amtPaid)).append("\n");
        } else if (amtPaid >= 100) {
            s.append("   ").append(money.format(amtPaid)).append("\n");
        }
        s.append("                                                            Change Due:");
        if (amtPaid - getTotal() < 10) {
            s.append("     ").append(money.format(amtPaid - getTotal())).append("\n");
        } else if (amtPaid - getTotal() >= 10) {
            s.append("    ").append(money.format(amtPaid - getTotal())).append("\n");
        } else if (amtPaid - getTotal() >= 100) {
            s.append("   ").append(money.format(amtPaid - getTotal())).append("\n");
        }
        System.out.println(s);
                  
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
