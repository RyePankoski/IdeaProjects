import java.util.Arrays;
import java.util.Random;
public class radix {
    public static int[] randomNumbers(int size) {

        Random rnd = new Random();
        int[] nums = new int[size];

        for (int i = 0; i < size; i++) {
            nums[i] = rnd.nextInt(999);
        }

        return nums;
    }
    public static int[] addedPlaces(int[] indexes) {

        int previous = 0;

        for (int current = 1; current < indexes.length;current++){
            indexes[current] = indexes[previous] + indexes[current];
            previous++;
        }
        return indexes;
    }
    public static int[] indexReAllocate(int[] input,int[] indices,int pass){

        int[] output = new int[input.length];
        for (int i = input.length - 1; i > -1; i--){

            int check = input[i];

            int one = (check / 1) % 10;
            int tens = (check / 10) % 10;
            int hundred = (check / 100) % 10;

            if (pass == 3) {
                output[indices[one] - 1] = check;
                if (indices[one] != 0){
                    indices[one]--;
                }
            }
            if (pass == 2) {
                output[indices[tens] - 1] = check;
                if (indices[tens] != 0){
                    indices[tens]--;
                }
            }
            if (pass == 1) {
                output[indices[hundred] - 1] = check;
                if (indices[hundred] != 0){
                    indices[hundred]--;
                }
            }
        }
        return output;
    }
    public static int[] emptyArray(int[] array){

        for (int i = 0; i < array.length;i++){
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
        int pass = 3;

        while (pass > 0) {
            for (int i = 0; i < numbers.length; i++) {


                int check = numbers[i];

                int one = (check / 1) % 10;
                int tens = (check / 10) % 10;
                int hundred = (check / 100) % 10;

                if (pass == 3) {
                    places[one]++;
                }
                if (pass == 2) {
                    places[tens]++;
                }
                if (pass == 1) {
                    places[hundred]++;
                }

            }

            places = addedPlaces(places);
            numbers = indexReAllocate(numbers,places,pass);
            emptyArray(places);
            pass--;
        }
        return numbers;
    }

    public static void main(String[] args)  {
        Random rnd = new Random();
        int[] pass = randomNumbers(rnd.nextInt(50));
        System.out.println(Arrays.toString(pass));
        int[] pass1 = new int[pass.length];
        pass1 = pass;
        System.out.println(Arrays.toString(radixSort(pass)));
        int[] sorted = radixSort(pass);
        System.out.println("contains same elements:" + containsSame(sorted,pass1));
    }
}
