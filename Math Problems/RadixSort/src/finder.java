import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class finder {

    public static Integer[] getDigits(int num) {
        List<Integer> digits = new ArrayList<Integer>();
        collectDigits(num, digits);
        return digits.toArray(new Integer[]{});
    }

    private static void collectDigits(int num, List<Integer> digits) {
        if(num / 10 > 0) {
            collectDigits(num / 10, digits);
        }
        digits.add(num % 10);
    }


    public static void main(String[] args) {

        Random rnd = new Random();

        int x = rnd.nextInt(100000);
        int y = x;
        System.out.println(x);
        int magnitude = 0;

        Integer[] digits = getDigits(x);
        System.out.println(Arrays.toString(digits));

        while (y > 0) {
            y /= 10;
            ++magnitude;
        }
        System.out.println(magnitude);




    }
}
