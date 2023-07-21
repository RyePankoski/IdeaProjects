import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        String asura = " █████╗ ███████╗██╗   ██╗██████╗  █████╗ \n" +
                "██╔══██╗██╔════╝██║   ██║██╔══██╗██╔══██╗\n" +
                "███████║███████╗██║   ██║██████╔╝███████║\n" +
                "██╔══██║╚════██║██║   ██║██╔══██╗██╔══██║\n" +
                "██║  ██║███████║╚██████╔╝██║  ██║██║  ██║\n" +
                "╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═";

        ArrayList<Character> asuraArray = new ArrayList<>();
        
        for (int i = 0; i < asura.length(); i++) {
            asuraArray.add(asura.charAt(i));
        }

        //42
        int newline = 0;
        String print = "";

        for (int i = 0; i < asuraArray.size(); i++) {

            print += asuraArray.get(i);
            newline++;

            if(newline == 42){
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println(print);
                System.out.println("\n");
                newline = 0;
            }
        }
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.println("Automated Systems, Unified Radial Architecture tm.");
    }
}