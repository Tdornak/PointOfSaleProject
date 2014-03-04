package pointofsaleproject;

import java.util.Scanner;

/**
 *
 * @author Tim
 */
public class CashPayment implements PaymentStrategy {
    
    private double amtPaid;


    
    @Override
    public void setAmtPaid(double total) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(total);
        System.out.println("Enter payment amount");
        amtPaid = keyboard.nextDouble();
        while (amtPaid < 0) {
            System.out.println("Payment must be greater then 0");
            System.out.println("Enter payment amount");
            amtPaid = keyboard.nextDouble();
        }
        //this.amtPaid = amtPaid;
    }
    
    @Override
    public double getAmtPaid() {
        return amtPaid;
    }

    
    
    
}
