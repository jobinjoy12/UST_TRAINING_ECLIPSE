public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        }
    }

    public void decreaseQuantity(int amount) {
        if (amount > 0 && amount <= this.quantity) {
            this.quantity -= amount;
        } else {
            System.out.println("Error: Insufficient stock to decrease by " + amount);
        }
    }


    public void setPrice(double newPrice) {
        if (newPrice >= 0) {
            this.price = newPrice;
        }
    }
}