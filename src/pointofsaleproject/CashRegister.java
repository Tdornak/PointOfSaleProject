package pointofsaleproject;

/**
 *
 * @author tdornak
 */
public class CashRegister implements InputStrategy {
    
    private OutputStrategy output;
    private PaymentStrategy payment;
    private boolean saleInProgress;

    
    public void startSale() {
        saleInProgress = true;
        OutputStrategy r = new Receipt();
        this.output = r;
    }
    
    @Override
    public void addPurchaseToSale(String prodId, double qty) {
        if (!saleInProgress) {
            startSale();
        }
        output.addPurchaseToOutput(prodId, qty);
    }
    
    @Override
    public void completeSale(PaymentStrategy payment) {
        payment.setAmtPaid(output.getTotal());
        output.createOutput(payment.getAmtPaid());
        saleInProgress = false;
    }
    
}
