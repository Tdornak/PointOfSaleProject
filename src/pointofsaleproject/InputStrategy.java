package pointofsaleproject;

/**
 *
 * @author Tim
 */
public interface InputStrategy {
    public abstract void addPurchaseToSale(String prodId, double qty);
    public abstract void completeSale(PaymentStrategy payment);
}
