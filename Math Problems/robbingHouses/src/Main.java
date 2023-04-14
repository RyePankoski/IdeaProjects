import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


        Random ran = new Random();

        int[] arrayOfRandomNumbers = new int[ran.nextInt(1,10)];

        ArrayList<Integer> oneValues = new ArrayList<>();
        ArrayList<Integer> twoValues = new ArrayList<>();

        int valueOne = 0;
        int valueTwo = 0;
        int vi = 0;
        int v2i = 0;


        for (int i = 0; i < arrayOfRandomNumbers.length; ++i) {
            arrayOfRandomNumbers[i] = ran.nextInt(99);
        }

        for (int i = 0; i < arrayOfRandomNumbers.length;++i){

            if(i % 2 == 0){
                oneValues.add(arrayOfRandomNumbers[i]);
                valueOne += arrayOfRandomNumbers[i];
                vi++;
            } else {
                twoValues.add(arrayOfRandomNumbers[i]);
                valueTwo += arrayOfRandomNumbers[i];
                v2i++;
            }
        }

        System.out.println(Arrays.toString(arrayOfRandomNumbers));

        if(valueOne > valueTwo){
            System.out.println(valueOne);
            System.out.println(oneValues);
        } else {
            System.out.println(valueTwo);
            System.out.println(twoValues);
        }
    }
}