public class TableBmiPro {

    private static final String LINE_SEP = "^".repeat(63);


    public static void main(String[] args) {
        loop();
    }

    /**
     * Print the program header.
     * Made to be identical to the example, as required by part (1)(5).
     */
    private static void printHeader() {
        System.out.println(LINE_SEP);
        System.out.println("^ Welcome to:");
        System.out.println("^    BODY MASS INDEX (BMI) Computation PRO");
        System.out.println("^               by Mos");
        System.out.println("^");
        System.out.println(LINE_SEP);
    }

    /**
     * Run the program loop.
     */
    private static void loop() {
        printHeader();
    }
}
