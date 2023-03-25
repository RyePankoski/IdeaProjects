import java.util.ArrayList;
import java.util.Scanner;

public class columnEncryption {


    public static ArrayList<String> keys() {

        Scanner skan = new Scanner(System.in);
        ArrayList<String> userKeys = new ArrayList<>();

        System.out.println("How many keys would you like to use?");
        int layers = skan.nextInt();

        for (int i = 0; i < layers; ++i) {
            System.out.println("Enter a key.");
            userKeys.add(skan.next());
        }
        return userKeys;
    }
    public static int[] numFromLetters(String stringToNumbers) {

        int[] numbers = new int[stringToNumbers.length()];
        char[] stringToChars = stringToNumbers.toCharArray();
        for (int i = 0; i < numbers.length; ++i) {
            numbers[i] = stringToChars[i];
        }
        return numbers;
    }

//    public static String columnEncrypt (String toBeEncrypted, ArrayList <String> keys){
//
//
//
//
//
//
//    }


    public static void main(String[] args){

        Scanner skan = new Scanner(System.in);

        System.out.println("Enter a message to encrypt.");

        String message = skan.nextLine();

        int[] messageArray = numFromLetters(message);

        ArrayList<String> userKeys = keys();








    }
}
