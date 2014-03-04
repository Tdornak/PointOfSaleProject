package pointofsaleproject;

/**
 *
 * @author Tim
 */
public interface InputStrategy {
    public abstract void addPurchaseToSale(String prodId, int qty);
    public abstract void completeSale(PaymentStrategy payment);
}
