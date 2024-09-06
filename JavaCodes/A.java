public class A {
    public void display() {
        System.out.println("I am a method from class A");
    }
}

// B is inheriting display method of A
class B extends A {
    public void print() {
        System.out.println("I am a method from class B");
    }

    public static void main(String[] args) {
        B objB = new B();
        objB.display(); // Reusing the method of A named display
        objB.print();    
    }
}