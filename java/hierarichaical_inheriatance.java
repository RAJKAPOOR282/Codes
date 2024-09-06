/* hierarchical inheritance program */

class A {
  void print() {
    System.out.println("enter your name");
  }
}

class B extends A {
  void disp() {
    System.out.println("my name is sumnat mishra");
  }
}

class C extends A {
  void display() {
    System.out.println("my name is hemant kumar");
  }
}
class hierarichaical_inheriatance {
  public static void main(String... args) {
    B r = new B();
    C r2 = new C();
    r.print();
    r.disp();
    r2.print();
    r2.display();
  }
}