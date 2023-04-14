import java.util.Random;

public class list {

    public static void main(String[] args) {


        int[] myArray = new int[10];
        Random ran = new Random();


        for (int i = 0; i < myArray.length; ++i) {
            myArray[i] = ran.nextInt(1, 50);
        }

        int sum = 0;

        for (int j : myArray) {
            sum += j;
        }


        System.out.println(sum);


    }
}
