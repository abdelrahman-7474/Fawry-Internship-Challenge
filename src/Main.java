import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 200, 1000, LocalDate.of(2026, 1, 1), 0.2);
        Product biscuits = new Product("Biscuits", 150,
                10, LocalDate.of(2027, 12, 1), 0.7);
        Product scratchCard = new Product("Mobile Scratch Card",
                5, 100, null, 0.0); // null means not expire and 0.0 in weight means has not shipping

        Customer customer = new Customer("Abdelrahman Tamer", 1000);

        Cart cart = new Cart();
        try {
            cart.add(cheese, 1);
            cart.add(biscuits, 1);
            cart.add(scratchCard, 1);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

try {
    Checkout.calculator_Checkout(customer, cart);

} catch (Exception e) {
    System.out.println(e.getMessage());
}
    }
}