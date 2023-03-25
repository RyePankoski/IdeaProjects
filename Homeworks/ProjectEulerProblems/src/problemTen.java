import java.util.LinkedList;

public class problemTen {
    public static void main(String[] args) {

        long test = 8L;
        boolean prime;
        long primeSum = 17L;
        LinkedList<Long> primeList = new LinkedList<>();
        primeList.add(0, 2L);
        primeList.add(1, 3L);
        primeList.add(2, 5L);
        primeList.add(3, 7L);

        while (test < 2000000) {

            prime = true;

            for (int i = 0; i < primeList.size(); ++i) {

                if (test - primeList.get(i) * 3 < primeList.get(i)){
                    break;
                }
                //if the difference between the test-number, and the (test-prime x 2) is less than the test-prime itself, we know that no prime(n) greater than the test-prime will be a multiple of the test-number.
                if (test - primeList.get(i) * 2 < primeList.get(i)){
                    break;
                }

                //back-up to catch primes which might slip through the catch above.
                if (test % primeList.get(i) == 0) {
                    prime = false;
                    break;
                }
            }

            //if prime, add to list and iterate sum.
            if (prime) {
                primeList.add(test);
                System.out.println(test);
                primeSum += test;
            }
            test++;
        }
        System.out.println(primeSum);
    }
}

