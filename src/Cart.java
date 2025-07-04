import java.util.ArrayList;
import java.util.List;

public class Cart {
        private List<CartItem> card;

        public Cart() {
            this.card = new ArrayList<>();
        }

        public boolean add(Product product, int quantity) {
            CartItem existingItem = null;

            for (CartItem item : card) {
                if (item.product.name.equals(product.name)) {
                    existingItem = item;
                    card.remove(existingItem);
                    quantity+= existingItem.buied_quantity;
                    break;
                }
            }

            if (product.quantity < quantity) {
                System.out.println(" no enough stock for " + product.name);
                return false;
            }

            card.add(new CartItem(product, quantity));
            return true;
        }

        public List<CartItem> getItems() {
            return card;
        }



}
