package pointofsaleproject;

/**
 *
 * @author tdornak
 */
public class FakeDatabase implements InventoryStrategy{

    private Product[] products = {new Product("A001", "Chips", 2.00, new QuantityDiscount()),
        new Product("B001", "Cheese", 8.00, new PercentDiscount()),
        new Product("C001", "Pizza", 5.00, new NoDiscount())};

    
    
    @Override
    public Product getProduct(String prodId) {
        Product product = null;
        boolean flag = true;
        if (prodId == null || prodId.isEmpty()) {
            System.out.println("Error at FakeDatabase.getProduct");
        } else {
            for (Product prod : products) {
                if (prodId.equalsIgnoreCase(prod.getProductId())) {
                    product = prod;
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("Product Not Found");
        }
        return product;
    }
}
