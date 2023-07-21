import java.util.ArrayList;
public class problemTwelve {
    public static void main(String[] args) {

       long triangle = 3L;
        int position = 2;
        long divisor = 0L;
        long testNumber;

        ArrayList<Long> numbers = new ArrayList<>();
        numbers.add(1L);

        while (true) {
            while (true) {
                //Increment divisor.
                divisor++;
                //If the divisor * 2 is larger than our triangle, then we know we can break.
                if(divisor * 2 > triangle){
                    break;
                }
                //If our divisor is equal to the most recently added element, then we know we have found all factors.
                if (divisor == numbers.get(numbers.size() - 1)  && divisor != 1) {
                    break;
                }
                //test for factor
                testNumber = triangle % divisor;
                if (testNumber == 0) {
                    //this checks for the case when there is an even number of factors.
                    if (triangle / divisor == divisor) {
                        numbers.add(divisor);
                        break;
                    }
                    //this adds the divisor, and it's quotient from the triangle, since they are both factors.
                    numbers.add(divisor);
                    numbers.add(triangle / divisor);
                }
            }
            //In order for the program to work, I had to add 1 to the array each iteration, then remove it
            //at the end
            numbers.remove(0);

            if (numbers.size() > 500) {
                System.out.println(triangle);
                System.exit(0);
            }
            //reset some values, so I can search again.
            divisor = 0;
            position++;
            triangle += position;
            numbers.clear();
            numbers.add(1L);
        }
    }
}


