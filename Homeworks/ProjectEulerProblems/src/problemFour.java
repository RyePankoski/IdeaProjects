import java.util.ArrayList;
import java.util.List;

public class problemFour {
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
    public static boolean palindrome(Integer[] numberList){

        int lastIndex = numberList.length - 1;

        for (int i = 0; i < numberList.length;i++){

            if (numberList[i] != numberList[lastIndex]){
                return false;
            }
            lastIndex--;
        }
        return true;
    }

    public static void main(String[] args){

        int testNumber = 0;
        int finalNum = 0;

        for (int i = 100;i < 999;i++){
            for (int j = 100; j < 999;j++){

                testNumber = i * j;
                Integer[] digits = getDigits(testNumber);

                if (palindrome(digits) && testNumber > finalNum){
                    finalNum = testNumber;
                }

            }
        }
        System.out.println(finalNum);
    }

}
