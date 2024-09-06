// Parent class (superclass)
class Animal {
    void eat() {
        System.out.println("Animal is eating.");
    }
}

// Child class (subclass) inheriting from Animal
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking.");
    }
}

public class SingleInheritanceDemo {
    public static void main(String[] args) {
        // Create an object of the subclass (Dog)
        Dog myDog = new Dog();

        // Call methods from both the superclass (Animal) and subclass (Dog)
        myDog.eat(); // Inherited from Animal class
        myDog.bark(); // Specific to Dog class
    }
}
