package IO_23_10;

public class IOBasicsDemo {
    public static void main(String[] args) {
        System.out.print("Hello ");
        System.out.print("StartSteps");
        System.out.print("!\n");
        // With system.out.print it is all printed on the same line

        int x =100;
        System.out.printf("Printing simple integer x: %d\n", x );
        // Takes argument and replaces placeholder with argument, must specify argument(x)

        System.out.printf("Formatted with precision:: PI = %.2f\n", Math.PI);
        // %.2f to show 2 decimal places

        float n =5.2f;
        System.out.printf("Formatted to specific width: n = %.4f\n", n);
        //Adds the extra decimal places as requested

        n= 2324435.3f;
        System.out.printf("Formatted to right margin: n=%20.4f\n", n);
        // %20 moves 20 places to the right



    }
}
