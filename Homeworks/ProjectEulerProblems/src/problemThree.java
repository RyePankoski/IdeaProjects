import java.util.Scanner;

public class problemThree {
    public static void main(String[] args) {

        Scanner skan = new Scanner(System.in);
        System.out.println("Enter number to find its largest prime factor.");

        long number = skan.nextLong();

        if (number <= 2L) {
            System.out.println("There exists no prime factorization of this number");
        }

        long prime = 0L;
        long testNumber = 2L;

        while (number > 2L) {

            if (number % testNumber == 0L) {

                number = number / testNumber;
                prime = testNumber;
                testNumber = 2;

            } else {
                ++testNumber;
            }
        }
        System.out.println("Largest prime factor: " + prime);
    }
}

