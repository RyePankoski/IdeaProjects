public class problemOne {
    public static boolean isMutliple(int number) {

        if (number % 3 == 0 || number % 5 == 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        int number = 0;
        int total = 0;

        while (number < 1000) {

            if (isMutliple(number)) {
                total += number;
            }
            number++;
        }
        System.out.println(total);
    }
}
