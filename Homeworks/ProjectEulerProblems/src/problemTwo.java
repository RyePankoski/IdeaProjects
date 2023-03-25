public class problemTwo {
    public static void main(String[] args){

        int x = 1;
        int y= 0;
        int z = 0;
        int total = 0;

        while (z < 4000000) {

            z = x + y;
            x = y;
            y = z;

            if (z % 2 == 0){
                total += z;
            }
        }
        System.out.println(total);
    }
}
