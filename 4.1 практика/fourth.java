class ElectronicDevice {
    // Поля класса
    private String brand;      
    private String model;      
    private double price;      

    public ElectronicDevice(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void printDeviceInfo() {
        System.out.printf("Brand: %s, Model: %s, Price: $%.2f%n", brand, model, price);
    }

    public static void main(String[] args) {
        ElectronicDevice device = new ElectronicDevice("Samsung", "QLED TV", 1299.99);
        Smartphone smartphone = new Smartphone("Apple", "iPhone 14", 999.99, "iOS");

        System.out.println("Electronic Device Info:");
        device.printDeviceInfo();
        System.out.println();

        System.out.println("Smartphone Info:");
        smartphone.printDeviceInfo();
    }
}

class Smartphone extends ElectronicDevice{
    private String operatingSystem; 

    public Smartphone(String brand, String model, double price, String operatingSystem) {
        super(brand, model, price); 
        this.operatingSystem = operatingSystem;
    }

    @Override
    public void printDeviceInfo() {
        super.printDeviceInfo(); 
        System.out.println("Operating System: " + operatingSystem);
    }
}
