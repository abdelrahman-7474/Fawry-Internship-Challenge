import java.time.LocalDate;
import java.util.Optional;

public class Product {
    String name;
    double price;
    int quantity;
    LocalDate expiryDate;
    Double weight;

    public Product(String name, double price, int quantity, LocalDate expiryDate, Double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.weight = weight;
    }
    public boolean is_Expired() {
        if(expiryDate!=null) {
            return expiryDate.isBefore(LocalDate.now());
        }else
            return false;
    }
    public boolean is_shipped()
    {
        return weight!=0;
    }


}
