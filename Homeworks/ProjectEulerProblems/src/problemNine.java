public class problemNine {


//    A Pythagorean triplet is a set
//    of three natural numbers, a < b < c, for which,
//    a^2 + b^2 = c^2
//
//    For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
//
//    There exists exactly one Pythagorean
//    triplet for which a + b + c = 1000.
//    Find the product abc.

    public static void main(String[] args) {

        //declare a,b,c as doubles since we plan to use Math.pow
        double a;
        double b;
        double c;
        int product;

        //we use three loops to create the terms for a,b,c
        for (int i = 1; i < 1000; ++i) {

            for (int j = 1; j < 1000; ++j) {

                for (int k = 1; k < 1000; ++k) {

                    a = i;
                    b = j;
                    c = k;

                    //check if a^2 + b^2 == c^2, then verify if c > b > a,
                    //essentially generating a pythagorean triplet
                    if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && c > b && b > a) {

                        //save computation time by breaking
                        if (a + b + c > 1000) {
                            break;
                        }
                        //if it's a triplet, see if the terms a,b,c add to 1000.
                        // If they do, find the product of a,b,c.
                        if (a + b + c == 1000) {

                            product = (int) (a * b * c);
                            System.out.println("The triplet is: " + a + " " + b + " " + c + "\n" + "The product abc is " + product);

                        }
                    }
                }
            }
        }
    }
}
