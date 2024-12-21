import java.util.ArrayList;
import java.util.List;

enum PetType {
    DOG, CAT
}

enum HealthStatus {
    HEALTHY, SICK
}

class Pet{
    protected String name;
    protected int age;
    protected PetType type;
    protected HealthStatus healthStatus;

    public Pet(String name, int age, PetType type, HealthStatus healthStatus){
        this.name = name;
        this.age = age;
        this.type = type;
        this.healthStatus = healthStatus;
    }
    public void displayInfo(){
        System.out.println("Имя:" + name + ", Возраст:" + age + ",Тип:" + type);
        System.out.println("Состояние:" + healthStatus);
    }
    public String getName(){
        return name;
    }
}

class Dog extends Pet{
    private String breed;

    public Dog(String name, int age, String breed, HealthStatus healthStatus){
        super(name, age, PetType.DOG, healthStatus);
        this.breed = breed;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Порода:" + breed);
    }
}

class Cat extends Pet{
    private String color;

    public Cat(String name, int age, String color, HealthStatus healthStatus){
        super(name, age, PetType.CAT, healthStatus);
        this.color = color;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Цвет:" + color);
    }
}

class PetClinic {
    private List<Pet> pets;

    public PetClinic(){
        this.pets = new ArrayList<>();
    }

    public void addPet (Pet pet) throws Exception{
        for (Pet p:pets){
            if(p.getName().equals(pet.getName())){
                throw new Exception(" Питомец с таким именем уже в клинике");
            }
        }
        pets.add(pet);
    }

    public void displayPets(){
        for (Pet pet: pets){
            pet.displayInfo();
            System.out.println();
        }
    }
}
public class second{
    public static void main(String[] args) {
        PetClinic clinic = new PetClinic();
        try{
            Dog dog1 = new Dog("Шарик", 3, "Шершавая", HealthStatus.HEALTHY);
            Cat cat1 = new Cat("Мурка", 2, "Черный", HealthStatus.SICK);
            clinic.addPet(dog1);
            clinic.addPet(cat1);

            Dog dog2 = new Dog("Бобик", 5, "Лабрадор", HealthStatus.HEALTHY);
            clinic.addPet(dog2);

            Cat cat2 = new Cat("Гарии", 2, "Рыжий", HealthStatus.SICK);
            clinic.addPet(cat2);

            clinic.displayPets();
        }
        catch(Exception e){
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}