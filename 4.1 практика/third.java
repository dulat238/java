class Product{
    // Поля класса
    private String name;        
    private int quantity;       
    private double price;       

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void increaseQuantity(int amount) {
        if (amount > 0) {
            quantity += amount;
            System.out.println(amount + " added to the product composition: " + name);
        } else {
            System.out.println("The quantity must be greater than 0 to increase.");
        }
    }

    public void decreaseQuantity(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
            System.out.println(amount + " removed from product quantity: " + name);
        } else {
            System.out.println("Incorrect amount to reduce.");
        }
    }

    public void changePrice(double newPrice) {
        if (newPrice > 0) {
            price = newPrice;
            System.out.println("Price changed to: " + newPrice + " for product: " + name);
        } else {
            System.out.println("The price must be greater than 0.");
        }
    }

    public void printProductInfo() {
        System.out.printf("Product: %s, Quantity: %d, Price: $%.2f%n", name, quantity, price);
    }

    public static void main(String[] args) {
        Product product = new Product("Laptop", 10, 999.99);

        product.printProductInfo();

        product.increaseQuantity(5);
        product.decreaseQuantity(3);
        product.changePrice(899.99);

        System.out.println("\nUpdated Product Information:");
        product.printProductInfo();
    }
}
