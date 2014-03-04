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
public interface OutputStrategy {

    public abstract void addPurchaseToOutput(String prodId, int qty);

    public abstract void createOutput(double amtPaid);

    //getters
    public abstract long getCurrentDate();

    public abstract String getStoreName();
    
    public abstract double getTotal();

    //setters
    public abstract void setStoreName(String storeName);
    
}
