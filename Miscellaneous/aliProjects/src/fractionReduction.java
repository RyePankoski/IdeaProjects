import java.util.Random;

public class fractionReduction {

    public static void main(String[] args) {

        Random ran = new Random();

        int numerator = ran.nextInt(1,100);
        int denominator = ran.nextInt(1,100);
        int quotient;
        int remainder;

        System.out.println("Raw fraction: " + numerator + "/" + denominator);

        for (int i = 1; i < 10; ++i) {

            if (numerator % i == 0 && denominator % i == 0) {
                numerator = numerator / i;
                denominator = denominator / i;

                if (numerator % 2 == 0) {
                    i = 1;
                }
            }
        }
        if (numerator > denominator) {

            if (numerator % denominator == 0) {
                System.out.println("Reduced: " + numerator);
            } else {
                quotient = numerator / denominator;
                remainder = numerator % denominator;
                System.out.println("Reduced fraction: " + numerator + "/" + denominator);
                System.out.println("Mixed fraction: " + quotient + " " +  "&" + " " + remainder + "/" + denominator);
            }
        } else {
            System.out.println("Reduced fraction: " + numerator + "/" + denominator);
        }
    }
}
