public class Main {


    public static int positive(int x) {
        return x * (-1);
    }
    public static int normalizer(int x) {
        System.out.println("Hmmmm.");
        return (x * 2);
    }
    public static int strangeFunction(int x, int y, int z) {
        return ((x * y) - z) * ((x + z) + y + 1);
    }


    public static void main(String[] args) {

        int limit = 10;

        for (int i = 0; i < limit; ++i) {

            int daNumber = strangeFunction(i, i + 1, i + 2);

            if (daNumber < 0) {
                System.out.println("This is way too strange: " + daNumber + "\n" + "but now...");
                daNumber = positive(daNumber);
            }

            if (daNumber % 2 == 0) {
                System.out.println("This number is not-so-strange: " + daNumber);
                int newNUm = normalizer(daNumber);
                System.out.println("Now it is even more normal. " + newNUm+ "\n");
            } else {
                System.out.println("This number is strange: " + daNumber);
                int newerNum = daNumber + 1;
                System.out.println("Now its okay: " + newerNum + "\n");
            }
        }
    }
}