import java.util.Arrays;
import java.util.Random;

public class randomArray {
    public static void main(String[] args) {

        Random ran = new Random();

        int[] numberArray = new int[ran.nextInt(12)];
        int comparator = 0;


        for (int i = 0; i < numberArray.length; ++i) {
            numberArray[i] = ran.nextInt(50);
        }

        int minorator = numberArray[0];

        for (int i = 0; i < numberArray.length; ++i) {

            if (numberArray[i] > comparator) {
                comparator = numberArray[i];
            }
            if (numberArray[i] < minorator) {
                minorator = numberArray[i];
            }
        }

        System.out.println(Arrays.toString(numberArray));
        System.out.println("min: " + minorator + " " + "max: " + comparator);
        System.out.println("Product: " + minorator * comparator);

    }
}

