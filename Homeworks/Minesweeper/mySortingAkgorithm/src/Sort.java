import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static int[] randomNumbers() {

        Random rnd = new Random();
        int[] numbers = new int[rnd.nextInt(20)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rnd.nextInt(100);
        }
        return numbers;
    }

    public static int[] sort(int[] sortie) {
        int swap = 0;
        int steps = 0;

        //'i' is the front, 'j' is the back.
        for (int i = 0; i < sortie.length; i++) {
            steps += 1;
            for (int j = (i + 1); j < sortie.length; j++) {
                if (sortie[j] < sortie[i]) {
                    swap = sortie[i];
                    sortie[i] = sortie[j];
                    sortie[j] = swap;
                    steps += 3;
                } else
                    steps += 1;
            }
        }
        System.out.println(steps);
        return sortie;
    }

    public static void main(String[] args) {

        int[] ints = randomNumbers();
        System.out.println(Arrays.toString(ints));
        ints = sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
