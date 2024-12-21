import java.util.*;

class MenuItem {
    private String name;
    private double price; 
    private String category; 

    public MenuItem(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + price + " tg"; 
    }

    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        cafe.addMenuItem(new MenuItem("Coffee", 950.0, "Drinks"));
        cafe.addMenuItem(new MenuItem("Sandwich", 1900.0, "Food"));
        cafe.addMenuItem(new MenuItem("Cheesecake", 1230.0, "Dessert"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the cafe!");
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter client phone number: ");
        String phone = scanner.nextLine();
        Customer customer = new Customer(name, phone);
        List<MenuItem> orderItems = new ArrayList<>();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\nMenu:");
            for (MenuItem item : cafe.getMenuItems()) {
                System.out.println(item);
            }
            System.out.print("Enter the name of the dish to add to the order (or 'ready' to complete): ");
            String itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("ready")) {
                ordering = false;
            } else {
                for (MenuItem item : cafe.getMenuItems()) {
                    if (item.getName().equalsIgnoreCase(itemName)) {
                        orderItems.add(item);
                        System.out.println(itemName + " added to order.");
                        break;
                    }
                }
            }
        }
        
        Order order = cafe.createOrder(customer, orderItems);
        System.out.println("\nOrder ID: " + order.getOrderId());
        System.out.println("Ordered dishes:");
        for (MenuItem item : order.getItems()) {
            System.out.println(item);
        }
        System.out.printf("Total cost (tg): %.2f%n", order.calculateTotal());
        scanner.close();
    }
}

class Order {
    private static int orderCounter = 1; 
    private final int orderId; 
    private final Date orderDate; 
    private final List<MenuItem> items;

    public Order(List<MenuItem> items) {
        this.orderId = orderCounter++;
        this.orderDate = new Date();
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

class Customer {
    private String name;
    private String phone;
    private List<Order> orderHistory; 

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.orderHistory = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }
}

interface ICafe {
    void addMenuItem(MenuItem item);
    void removeMenuItem(String name);
    List<MenuItem> getMenuItems();
    Order createOrder(Customer customer, List<MenuItem> items);
}

class Cafe implements ICafe {
    private final List<MenuItem> menuItems = new ArrayList<>(); 

    @Override
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    @Override
    public void removeMenuItem(String name) {
        menuItems.removeIf(item -> item.getName().equalsIgnoreCase(name));
    }

    @Override
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public Order createOrder(Customer customer, List<MenuItem> items) {
        Order order = new Order(items);
        customer.addOrder(order); 
        return order;
    }
}
