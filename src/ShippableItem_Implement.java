public class ShippableItem_Implement implements ShippableItem{
   private String name;
    private double weight;
    private int quantity;
    ShippableItem_Implement(int quantity,String name,double weight)
    {
        this.quantity=quantity;
        this.name=name;
        this.weight=weight;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public int get_quantity() {
        return this.quantity;
    }
}
