import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class radix2 {
    public static int[] digitReborn(int[] numbers, int magnitude) {

        int[] reborn = new int[magnitude];
        int zeroes = magnitude - numbers.length;
        int numbersIndex = 0;

        for (int i = 0; i < zeroes; i++) {
            reborn[i] = 0;
        }
        for (int j = zeroes; j < reborn.length; j++) {
            reborn[j] = numbers[numbersIndex];
            numbersIndex++;
        }
        return reborn;
    }
    public static Integer[] getDigits(int num) {
        List<Integer> digits = new ArrayList<Integer>();
        collectDigits(num, digits);
        return digits.toArray(new Integer[]{});
    }
    private static void collectDigits(int num, List<Integer> digits) {
        if (num / 10 > 0) {
            collectDigits(num / 10, digits);
        }
        digits.add(num % 10);
    }
    public static int magnitude(int[] numbers) {

        int max = numbers[0];
        int magnitude = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        while (max > 0) {
            max /= 10;
            ++magnitude;
        }
        return magnitude;
    }
    public static int[] randomNumbers(int size) {

        Random rnd = new Random();
        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            nums[i] = rnd.nextInt(9999);
        }

        return nums;
    }
    public static int[] addedPlaces(int[] indexes) {

        int previous = 0;

        for (int current = 1; current < indexes.length; current++) {
            indexes[current] = indexes[previous] + indexes[current];
            previous++;
        }
        return indexes;
    }
    public static int[] indexReAllocate(int[] input, int[] indices, int pass, int totalMagnitude) {

        int[] output = new int[input.length];
        int orderOfMagnitude = 0;
        int index = 0;
        for (int i = input.length - 1; i > -1; i--) {

            int check = input[i];

            Integer[] analyze = getDigits(check);
            int[] digits = new int[analyze.length];

            for (int j = 0; j < analyze.length; j++) {
                digits[j] = analyze[j];
            }
            if (digits.length < totalMagnitude) {
                digits = digitReborn(digits, totalMagnitude);
            }
            output[indices[digits[pass - 1]] - 1] = check;
            indices[digits[pass - 1]]--;
        }
        return output;
    }
    public static int[] emptyArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
        return array;
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
    public static int[] radixSort(int[] numbers) {

        int[] places = new int[10];
        int pass = magnitude(numbers);
        final int totalMagnitude = pass;
        int orderOfMagnitude = 0;

        while (pass > 0) {

            for (int i = 0; i < numbers.length; i++) {


                int check = numbers[i];
                Integer[] analyze = getDigits(check);

                int[] digits = new int[analyze.length];
                for (int j = 0; j < analyze.length; j++) {
                    digits[j] = analyze[j];
                }

                if (digits.length < totalMagnitude) {
                    digits = digitReborn(digits, totalMagnitude);
                }

                orderOfMagnitude = digits[pass - 1];
                places[orderOfMagnitude]++;
            }
            places = addedPlaces(places);
            numbers = indexReAllocate(numbers, places, pass, totalMagnitude);
            emptyArray(places);
            pass--;
        }
        return numbers;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int[] pass = randomNumbers(rnd.nextInt(1,40));
        System.out.println(Arrays.toString(pass));
        int[] pass1 = new int[pass.length];
        pass1 = pass;
//        int[] tester = {1412, 506, 1235, 15, 2, 2000};
//        System.out.println(Arrays.toString(radixSort(tester)));
        System.out.println(Arrays.toString(radixSort(pass)));
        int[] sorted = radixSort(pass);
        System.out.println("contains same elements: " + containsSame(sorted, pass1));
    }
}
