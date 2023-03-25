import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {



    public static int[] arrayMaker(){

        Random ran = new Random();
        int[] numbers = new int[ran.nextInt(20)];

        for (int i = 0; i < numbers.length; i++){
            numbers[i] = ran.nextInt(99);
        }
        return numbers;
    }

    public static void main(String[] args) {

        int[] numbers = arrayMaker();
        int current = 0;
        int previous = 0;

        for (int i = 0; i < numbers.length;i++){

            if(numbers[i] > current){
                current = numbers[i];
            }
            if (numbers[i] > previous && numbers[i] < current) {
                previous = numbers[i];
            }
        }

        String array = Arrays.toString(numbers);


        System.out.println(array);
        System.out.println(previous * current);

    }
}