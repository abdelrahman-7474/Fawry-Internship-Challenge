import java.util.List;

public class ShippingService {

    public static void Shipment_notice(List<ShippableItem> itemsToShip)
    {
        double total_weight=0;
        System.out.println("** Shipment notice **");
        for (ShippableItem item : itemsToShip) {
            System.out.printf("%dx %s %.1f\n", item.get_quantity(), item.getName(), item.getWeight()*item.get_quantity()*1000);
            total_weight+=item.getWeight()*item.get_quantity();
        }
        System.out.println("Total package weight "+total_weight+" kg");

    }
}
