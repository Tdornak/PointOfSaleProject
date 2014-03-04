
package pointofsaleproject;


public class StartUp {

    
    public static void main(String[] args) {
        InputStrategy cr = new CashRegister();
            
        cr.addPurchaseToSale("A001", 5);
        cr.addPurchaseToSale("B001", 2);
        cr.addPurchaseToSale("C001", 2);
        cr.addPurchaseToSale("A001", 2);
        
        PaymentStrategy payment = new CheckPayment();
        
        cr.completeSale(payment);
        
    }
 
}
