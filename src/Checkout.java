import java.util.ArrayList;
import java.util.List;

public class Checkout {

    public static void calculator_Checkout(Customer customer, Cart cart)
    {
        if(cart.getItems().isEmpty())
            throw  new RuntimeException(" card is empty");
        float subtotal=0;
        float shipping_fees=0;
        List<ShippableItem> itemsToShip = new ArrayList<ShippableItem>();

        for (CartItem item : cart.getItems()) {
            Product p = item.product;
            if (p.quantity < item.buied_quantity) {
                throw new RuntimeException("out of stock: " + p.name);
            }
            if (p.is_Expired()) {
                throw new RuntimeException("expired product: " + p.name);
            }
            subtotal += p.price * item.buied_quantity;

            if (p.is_shipped()) {
                    ShippableItem shippableItem= new ShippableItem_Implement(item.buied_quantity,item.product.name,item.product.weight);
                    itemsToShip.add(shippableItem);
                    shipping_fees += 10;// let product shipping = 10

            }
            p.quantity -= item.buied_quantity;
        }

        double total = subtotal + shipping_fees;
        try {
            customer.deduct(total);
        }catch (Exception e)
        {
            for (CartItem item : cart.getItems()) {
                item.product.quantity+=item.buied_quantity;
            }
            System.out.println(e.getMessage());
            return ;
        }
        if (!itemsToShip.isEmpty()) {
            ShippingService.Shipment_notice(itemsToShip);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f\n", item.buied_quantity, item.product.name, item.product.price);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.1f\n", subtotal);
        System.out.printf("Shipping %.1f\n", shipping_fees);
        System.out.printf("Amount %.1f\n", total);
        System.out.printf("customer balance %.1f\n", customer.balance);
    }

}
