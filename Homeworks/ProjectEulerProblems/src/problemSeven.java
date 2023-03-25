public class problemSeven {


    public static void main(String[] args) {

        long calcnum = 1l;
        int primeCounter = 0;
        int mainCounter = 0;

        while (true) {

            calcnum++;

            //check if calcNum is prime.
            for (int i = 2; i < calcnum; ++i){
                if (calcnum % i == 0){
                    break;
                } else {
                    primeCounter++;
                }
            }

            //double checks if its prime, if so, increments the main counter, counting up to 10001.
            if (primeCounter == calcnum - 2){
                mainCounter++;
            }

            //if its 10001, print the 10001st prime.
            if(mainCounter == 10001){
                System.out.println(calcnum);
                System.exit(0);
            } else {
                primeCounter = 0;
            }












        }


    }
}
