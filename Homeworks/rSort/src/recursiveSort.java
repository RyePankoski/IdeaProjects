import java.util.Arrays;
import java.util.Random;

public class recursiveSort {

    public static int[] randomNumbers() {

        Random rnd = new Random();
        int[] numbers = new int[rnd.nextInt(20)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rnd.nextInt(100);
        }
        return numbers;
    }

    public static int[] rSort(int[] sortie) {

        for (int top = 0; top < sortie.length; top++) {
            int swap = 0;
            int[] smaller = new int[sortie.length / 2];

            if (smaller.length > 2) {
                for (int i = 0; i < smaller.length; i++) {
                    smaller[i] = sortie[i];
                }
            }
            for (int i = 0; i < smaller.length; i++) {
                if (smaller[i] > smaller[i + 1]) {
                    swap = smaller[i];
                    smaller[i] = smaller[i + 1];
                    smaller[i + 1] = swap;
                }
            }
            for (int j = 0;j < smaller.length; j++){
                sortie[j] = smaller[j];
            }
            rSort(smaller);
        }
        return sortie;
    }

    public static void main(String[] args) {

        int[] ints = randomNumbers();
        System.out.println(Arrays.toString(ints));
        rSort(ints);
        System.out.println(Arrays.toString(ints));

    }
}
