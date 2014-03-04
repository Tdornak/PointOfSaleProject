package pointofsaleproject;

/**
 *
 * @author tdornak
 */
public class CashRegister implements InputStrategy {
    
    private OutputStrategy output;
    private boolean saleInProgress;

    
    public void startSale() {
        saleInProgress = true;
        OutputStrategy r = new PaperReceipt();
        this.output = r;
    }
    
    @Override
    public void addPurchaseToSale(String prodId, int qty) {
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
