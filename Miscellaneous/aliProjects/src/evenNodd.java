import java.util.Arrays;
import java.util.Scanner;

public class evenNodd {


    public static void main(String[] args) {


        Scanner skan = new Scanner(System.in);
        int userNumber = skan.nextInt();

        int[] evenArray;
        int[] oddArray;

        if (userNumber % 2 == 0){
            evenArray = new int[userNumber/2 - 1];
        } else {
            evenArray = new int[userNumber/2];
        }
        oddArray = new int[userNumber/2];

        int evenIndex = 0;
        int oddIndex = 0;
        int evenCounter = 0;

        for (int i = 1; i < userNumber; i++) {

            if (i % 2 == 0) {
                evenArray[evenIndex] = i;
                evenIndex++;
                evenCounter++;
            } else {
                oddArray[oddIndex] = i;
                oddIndex++;
            }
        }

        if (evenCounter % 2 == 0) {
            System.out.println(Arrays.toString(evenArray));
        } else {
            System.out.println(Arrays.toString(oddArray));
        }
    }
}
