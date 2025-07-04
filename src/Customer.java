class Customer {
    String name;
    double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void deduct(double amount) {
        if (amount > balance) throw new RuntimeException("insufficient balance");
        balance -= amount;
    }
}