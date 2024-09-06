// Grandparent class
class Animal {
    void eat() {
        System.out.println("Animal is eating.");
    }
}

// Parent class inheriting from Animal
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking.");
    }
}

// Child class inheriting from Dog
class Labrador extends Dog {
    void swim() {
        System.out.println("Labrador is swimming.");
    }
}

public class MultiLevelInheritanceDemo {
    public static void main(String[] args) {
        // Create an object of the child class (Labrador)
        Labrador myLabrador = new Labrador();

        // Call methods from all levels of the inheritance hierarchy
        myLabrador.eat();  // Inherited from Animal class
        myLabrador.bark(); // Inherited from Dog class
        myLabrador.swim(); // Specific to Labrador class
    }
}
