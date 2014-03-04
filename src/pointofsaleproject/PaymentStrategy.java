package pointofsaleproject;

/**
 *
 * @author Tim
 */
public interface PaymentStrategy {
    
    public abstract void setAmtPaid(double total);
    public abstract double getAmtPaid();
    
}
