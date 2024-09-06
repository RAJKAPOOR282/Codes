import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the limit for the Fibonacci series: ");
        int limit = scanner.nextInt();

        System.out.println("Fibonacci series up to " + limit + ":");
        printFibonacciSeries(limit);

        scanner.close();
    }

    // Function to generate and print Fibonacci series up to a given limit
    public static void printFibonacciSeries(int limit) {
        int first = 0, second = 1, next;

        while (first <= limit) {
            System.out.print(first + " ");

            next = first + second;
            first = second;
            second = next;
        }
    }
}
