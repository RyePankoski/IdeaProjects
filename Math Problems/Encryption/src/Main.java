import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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
    public static int[] factors(String stringToNumbers) {

        int[] numbers = new int[stringToNumbers.length()];
        char[] stringToChars = stringToNumbers.toCharArray();
        for (int i = 0; i < numbers.length; ++i) {
            int toBeConverted = stringToChars[i];
            toBeConverted = (toBeConverted % 96);
            numbers[i] = toBeConverted;
        }
        return numbers;
    }
    public static String Encrypt(String toBeEncrypted, ArrayList<String> userKeys) {

        int[] message = numFromLetters(toBeEncrypted);
        char[] messageChars = new char[toBeEncrypted.length()];
        int index = -1;
        int factor;
        int ascii;
        int changedAscii;
        int localIndex = 0;

        for (String ignored : userKeys) {

            index++;
            int[] key = factors(userKeys.get(index));

            if (key.length > message.length) {
                for (int j : key) {
                    factor = j;
                    ascii = message[localIndex];

                    if (ascii > 31 && ascii < 127) {
                        changedAscii = (ascii + factor);

                        if (changedAscii > 126) {
                            int offset = (changedAscii - 126);
                            changedAscii = (30 + offset);
                        }
                        if (changedAscii < 32) {
                            int offset2 = (32 - changedAscii);
                            changedAscii = (127 - offset2);
                        }
                    } else
                        changedAscii = 0;

                    char charToArray = (char) changedAscii;
                    message[localIndex] = changedAscii;
                    messageChars[localIndex] = charToArray;

                    ++localIndex;
                    if (localIndex > message.length - 1) {
                        localIndex = 0;
                    }
                }

            } else {
                for (int i = 0; i < message.length; ++i) {
                    factor = key[localIndex];
                    ascii = message[i];
                    if (ascii > 31 && ascii < 127) {
                        changedAscii = (ascii + factor);

                        if (changedAscii > 126) {
                            int offset = (changedAscii - 126);
                            changedAscii = (32 + offset);
                        }
                        if (changedAscii < 32) {
                            int offset2 = (32 - changedAscii);
                            changedAscii = (127 - offset2);
                        }
                        //this catches any characters that slip through that don't meet the above conditions and eliminates it, to prevent it corrupting the data that is present.
                    } else
                        changedAscii = 0;

                    char charToArray = (char) changedAscii;
                    message[i] = changedAscii;
                    messageChars[i] = charToArray;

                    ++localIndex;
                    if (localIndex > key.length - 1) {
                        localIndex = 0;
                    }
                }
            }
        }
        return new String(messageChars);
    }
    public static String Decrypt(String toBeDecrypted, ArrayList<String> userKeys){

        int[] message = numFromLetters(toBeDecrypted);
        char[] messageChars = new char[toBeDecrypted.length()];
        int index = -1;
        int factor;
        int ascii;
        int changedAscii;
        int localIndex = 0;

        for (String ignored : userKeys) {

            index++;
            int[] key = factors(userKeys.get(index));

            if (key.length > message.length) {
                for (int j : key) {
                    factor = j;
                    ascii = message[localIndex];

                    if (ascii > 31 && ascii < 127) {
                        changedAscii = (ascii - factor);

                        if (changedAscii > 126) {
                            int offset = (changedAscii - 126);
                            changedAscii = (30 + offset);
                        }
                        if (changedAscii < 32) {
                            int offset2 = (32 - changedAscii);
                            changedAscii = (127 - offset2);
                        }
                    } else
                        changedAscii = 0;

                    char charToArray = (char) changedAscii;
                    message[localIndex] = changedAscii;
                    messageChars[localIndex] = charToArray;

                    ++localIndex;
                    if (localIndex > message.length - 1) {
                        localIndex = 0;
                    }
                }

            } else {
                for (int i = 0; i < message.length; ++i) {
                    factor = key[localIndex];
                    ascii = message[i];
                    if (ascii > 31 && ascii < 127) {
                        changedAscii = (ascii - factor);

                        if (changedAscii > 126) {
                            int offset = (changedAscii - 126);
                            changedAscii = (32 + offset);
                        }
                        if (changedAscii < 32) {
                            int offset2 = (32 - changedAscii);
                            changedAscii = (126 - offset2);
                        }
                        //this catches any characters that slip through that don't meet the above conditions and eliminates it, to prevent it corrupting the data that is present.
                    } else
                        changedAscii = 0;

                    char charToArray = (char) changedAscii;
                    message[i] = changedAscii;
                    messageChars[i] = charToArray;

                    ++localIndex;
                    if (localIndex > key.length - 1) {
                        localIndex = 0;
                    }
                }
            }
        }
        return new String(messageChars);
    }

    public static void main(String[] args)  {

        Scanner skan = new Scanner(System.in);
        skan.useDelimiter("\n");

        System.out.println("Encrypt:1 or Decrypt:2?");
        int choice = skan.nextInt();

        if (choice == 1){
            System.out.println("Enter String to be encoded.");
            String userMessage = skan.next();

            ArrayList<String> userKeys = keys();
            String encodedMessage = Encrypt(userMessage, userKeys);
            System.out.println(encodedMessage);
        }
        if (choice == 2){
            System.out.println("Enter String to be encoded.");
            String userMessage = skan.next();
            ArrayList<String> userKeys = keys();
            String encodedMessage = Decrypt(userMessage, userKeys);
            System.out.println(encodedMessage);
        }
        if (choice != 1 && choice != 2){
            System.out.println("Not a valid input.");
            System.exit(1);
        }
    }
}