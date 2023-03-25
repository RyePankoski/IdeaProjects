import java.util.Arrays;
import java.util.Random;


public class recursiveSort {

    public static int[] randomNumbers() {

        Random rnd = new Random();
        int[] numbers = new int[rnd.nextInt(4, 20)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rnd.nextInt(100);
        }
        return numbers;
    }

    public static boolean containsSame(int[] first, int[] second) {

        int check = 0;
        int trueElements = 0;
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first.length; j++) {

                if (first[i] == second[j]) {
                    trueElements += 1;
                    break;
                }
            }
        }
        if (trueElements == first.length) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] copyElements(int[] ints) {

        int[] first = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            first[i] = ints[i];
        }
        return first;
    }

    public staticzint[] sort(int[] sortie, int factor) {

        int lastIndex = sortie.length - 1;
        int firstIndex = 0;

        firstIndex += factor;
        lastIndex -= factor;

        int max = sortie[firstIndex];
        int min = sortie[firstIndex];
        int maxSwapLocal = firstIndex;
        int minSwapLocal = firstIndex;

        for (int i = firstIndex; i < lastIndex + 1; i++) {


            if (sortie[i] > max) {
                max = sortie[i];
                maxSwapLocal = i;
            }
            if (sortie[i] < min) {
                min = sortie[i];
                minSwapLocal = i;
            }
        }


        sortie[minSwapLocal] = sortie[firstIndex];

        sortie[maxSwapLocal] = sortie[lastIndex];


        sortie[firstIndex] = min;
        sortie[lastIndex] = max;
        factor++;

        if (factor < lastIndex) {
            sort(sortie, factor);
        }

        return sortie;
    }

    public static void main(String[] args) {

        int[] ints = randomNumbers();
        int[] first = copyElements(ints);

        System.out.println(Arrays.toString(ints));
        int[] second = sort(ints, 0);
        System.out.println(Arrays.toString(ints));
        System.out.println(containsSame(first, second));

    }
}
