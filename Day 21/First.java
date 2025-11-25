public class First{
    private String productId;
    private String name ;
    private double price;
    private Integer quantityInStock;

    public First(){};

    public First(String productId , String name , double price, Integer quantityInStock){
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "First [productId=" + productId + ", name=" + name + ", price=" + price + ", quantityInStock="
                + quantityInStock + "]";
    }

        
    
}