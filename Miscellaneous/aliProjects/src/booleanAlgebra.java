import java.util.Arrays;
import java.util.Random;

public class booleanAlgebra {

    public static void main(String[] args) {

        Random ran = new Random();

        int sizeOfBinaryNumber = ran.nextInt(20);
        int[] binaryNumber = new int[sizeOfBinaryNumber];
        int[] binaryNumber2 = new int[sizeOfBinaryNumber];
        int[] binaryResult = new int[sizeOfBinaryNumber + 1];
        int carryBit = 0;
        int shift = 1;

        for (int i = 0; i < binaryNumber.length; ++i) {
            binaryNumber[i] = ran.nextInt(0, 2);
            binaryNumber2[i] = ran.nextInt(0, 2);
        }

        for (int i = binaryNumber.length - 1; i > -1; --i) {

            if (binaryNumber[i] == 0 && binaryNumber2[i] == 0) {

                if (carryBit == 1) {
                    binaryResult[i + shift] = 1;
                    carryBit = 0;
                } else {
                    binaryResult[i + shift] = 0;
                }
            }
            if (binaryNumber[i] == 1 && binaryNumber2[i] == 0) {

                if (i == 0 && carryBit == 1){
                    shift = 0;
                }

                if (carryBit == 1) {
                    binaryResult[i + shift] = 0;
                    carryBit = 1;
                } else {
                    binaryResult[i + shift] = 1;
                }
            }

            if (binaryNumber[i] == 0 && binaryNumber2[i] == 1) {

                if (i == 0 && carryBit == 1){
                    shift = 0;
                }

                if (carryBit == 1) {
                    binaryResult[i + shift] = 0;
                    carryBit = 1;
                } else {
                    binaryResult[i + shift] = 1;
                }
            }
            if (binaryNumber[i] == 1 && binaryNumber2[i] == 1) {

                if (i == 0){
                    shift = 0;
                }

                if (carryBit == 1) {
                    binaryResult[i + shift] = 1;
                    carryBit = 1;
                } else {
                    binaryResult[i + shift] = 0;
                    carryBit = 1;
                }
            }
        }
        System.out.println("   " + Arrays.toString(binaryNumber) + "\n" + "   " + Arrays.toString(binaryNumber2) + "\n" + Arrays.toString(binaryResult));
    }
}