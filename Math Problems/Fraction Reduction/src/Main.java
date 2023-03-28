import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random ran = new Random();

        int numerator = ran.nextInt(1, 99);
        int denominator = ran.nextInt(1, 99);
        int testNumber = 2;
        int larger = 0;

        if(numerator > denominator){
            larger = numerator;
        }
        if(denominator > numerator){
            larger = denominator;
        }

        System.out.println("Raw fraction: " + numerator + "/" + denominator);

        while (true) {

            while (numerator % testNumber == 0 && denominator % testNumber == 0) {
                numerator /= testNumber;
                denominator /= testNumber;
                testNumber = 1;
                break;
            }
            if (testNumber == larger) {
                break;
            }
            ++testNumber;
        }

        if (numerator > denominator) {

            if (numerator % denominator == 0) {
                System.out.println("Reduced: " + numerator / denominator);
                System.exit(0);
            }
            System.out.println("Mixed fraction: " + numerator / denominator + " " + numerator % denominator + "/" + denominator);
        } else {
            System.out.println("Reduced: " + numerator + "/" + denominator);
        }

    }
}