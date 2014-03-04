package pointofsaleproject;

import java.util.Scanner;

/**
 *
 * @author Tim
 */
public class CheckPayment implements PaymentStrategy {
    
    private double amtPaid;

    @Override
    public void setAmtPaid(double total) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(total);
        System.out.println("Enter payment amount");
        amtPaid = keyboard.nextDouble();
        while (amtPaid < 0 || amtPaid > total + 25) {
            System.out.println("Payment must be greater then 0 and cannot exceed total by over $25");
            System.out.println("Enter payment amount");
            amtPaid = keyboard.nextDouble();
        }
    }
    
    @Override
    public double getAmtPaid() {
        return amtPaid;
    }

    
    
    
}
