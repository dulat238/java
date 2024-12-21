import java.util.ArrayList;
import java.util.List;

class Car{
    String licensePlate, model;
    boolean isRented;

    public Car(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.isRented = false;
    }

    public void rent() { isRented = true; }
    public void returnCar() { isRented = false; }

    public void displayInfo() {
        System.out.printf("Model: %s\nLicense plate: %s\nAvailable: %s\n", model, licensePlate, !isRented ? "Yes" : "No");
    }

    public static void main(String[] args) {
        CarPark carPark = new CarPark();
        Driver driver = new Driver("Mahmet");

        carPark.addCar(new Car("747ABC", "Toyota Camry"));
        carPark.addCar(new Car("668AID", "Honda Accord"));

        carPark.displayAvailableCars();
        driver.rentCar(carPark.cars.get(0)); 
        driver.displayInfo();
        carPark.displayAvailableCars();

        driver.returnCar(); 
        driver.displayInfo();
        carPark.displayAvailableCars();
    }
}

class Driver {
    String name;
    Car rentedCar;

    public Driver(String name) {
        this.name = name;
    }

    public void rentCar(Car car) {
        if (!car.isRented) {
            rentedCar = car;
            car.rent();
        }
    }

    public void returnCar() {
        if (rentedCar != null) {
            rentedCar.returnCar();
            rentedCar = null;
        }
    }

    public void displayInfo() {
        System.out.printf("Driver: %s\nRented car:\n", name);
        if (rentedCar != null) {
            rentedCar.displayInfo();
        } else {
            System.out.println("No rental car.");
        }
        System.out.println(); 
    }
}

class CarPark {
    List<Car> cars = new ArrayList<>();

    public void addCar(Car car) { cars.add(car); }

    public void displayAvailableCars() {
        System.out.println("Available cars:");
        for (Car car : cars) {
            if (!car.isRented) car.displayInfo();
        }
        System.out.println(); 
    }
}
