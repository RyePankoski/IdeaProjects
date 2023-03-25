import java.util.Arrays;

public class problemTenSieve {
    public static void main(String[] args) {

        boolean[] primeSieve = new boolean[2000000];
        Arrays.fill(primeSieve, true);

        int test = 2;
        int mutator = 2;
        boolean firstPass;
        long primeSum = 0L;

        for (int i = 0; i < 2000000; ++i) {

            //we need to not include the first pass for each mutator, because hypothetically if that number is prime,
            // we don't want to set it to false. If it is not prime, it will have been set to false on a previous iteration.
            firstPass = true;

            while (test < 2000000) {

                //set the composite number of each test-number to false.
                if (!firstPass) {
                    primeSieve[test] = false;
                }

                //update the test-number
                firstPass = false;
                test += mutator;
            }
            //update the mutator and the test-number
            mutator++;
            test = mutator;
        }

        //if the value at n index is true, that index is prime, and we add the index number to the sum.
        for (int i = 0; i < primeSieve.length; ++i){
            if (primeSieve[i] == true){
                primeSum += i;
                System.out.println(i);
            }
        }
        //we subtract 1 because 1 is not is prime, and our solution includes 1 as if it were prime.
        System.out.println(primeSum - 1);
    }
}
