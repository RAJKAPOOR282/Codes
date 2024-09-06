public class PrintNIT {
    public static void main(String[] args) {
        printNIT();
    }

    public static void printNIT() {
        // Define the patterns for each letter
        String[] nPattern = {"*   *", "**  *", "* * *", "*  **", "*   *"};
        String[] iPattern = {"*****", "  *  ", "  *  ", "  *  ", "*****"};
        String[] tPattern = {"*****", "  *  ", "  *  ", "  *  ", "  *  "};

        // Print each letter in the desired order
        for (int row = 0; row < 5; row++) {
            System.out.print(nPattern[row] + "   ");
            System.out.print(iPattern[row] + "   ");
            System.out.println(tPattern[row]);
        }
    }
}
