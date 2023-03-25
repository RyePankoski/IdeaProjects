public class problemSix {

    public static void main(String[] args) {


        double sumOfSquares = 0;
        double squareOfSums = 0;



        for (int i = 1; i < 101; ++i) {
            sumOfSquares += Math.pow(i, 2);
            squareOfSums += i;
        }

        squareOfSums = Math.pow(squareOfSums, 2);

        System.out.println(sumOfSquares);
        System.out.println(squareOfSums);
        System.out.printf("%.0f%n", (squareOfSums - sumOfSquares));

    }
}
