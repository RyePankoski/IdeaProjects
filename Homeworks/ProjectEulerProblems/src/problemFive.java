public class problemFive {

    public static void main(String[] args) {


        int calcNUm = 46558511;
        int trueStates = 0;

        int[] checkList = {11, 13, 14, 16,17, 18, 19, 20};

        while (true) {

            calcNUm++;

            for (int i = 0; i < checkList.length; ++i) {

                if (calcNUm % checkList[i] == 0) {
                    trueStates++;
                } else {
                    break;
                }
            }

            if (trueStates == 8) {
                System.out.println(calcNUm);
                System.exit(0);
            } else {
                trueStates = 0;
            }
        }
    }
}
