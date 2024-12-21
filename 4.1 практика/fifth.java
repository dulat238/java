class Animal {
    public void makeSound() {
        System.out.println("Animal is making a sound");
    }

    public static void main(String[] args) {
        Animal[] animals = new Animal[4];

        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Dog();
        animals[3] = new Cat();

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}


class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows: Meow!");
    }
}
