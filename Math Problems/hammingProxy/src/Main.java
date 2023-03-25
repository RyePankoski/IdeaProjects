import java.util.ArrayList;
import java.util.Random;

public class Main {


    public static ArrayList<Character> randomString(int size) {

        Random ran = new Random();

        char character;
        ArrayList<Character> randomString = new ArrayList<>();

        for (int i = 0; i < size; ++i) {

            character = (char) ran.nextInt(33, 127);
            randomString.add(character);
        }
        return randomString;
    }
    public static ArrayList<String> createCheckBits(ArrayList<Character> data) {

        ArrayList<String> stringV = new ArrayList<>();
        int checkBit = 0;
        int iterations = 0;

        for (Character datum : data) {
            String charString = datum.toString();
            stringV.add(charString);
        }

        for (int i = 0; i < data.size(); ++i) {

            checkBit += data.get(i);

            if (i == data.size() - 1) {
                stringV.add("C" + (checkBit));
                return stringV;
            }

            if (i % 2 == 0 && i != 0) {
                stringV.add(i + iterations, "C" + (checkBit));
                System.out.println(stringV);
                checkBit = 0;
                iterations++;
            }
        }
        return stringV;
    }
    public static ArrayList<Character> corruption(ArrayList<Character> data) {

        Random ran = new Random();
        int chanceOfCorruption = ran.nextInt(0, 2);
        int corruptionFactor;
        char primitiveChar;

        if (chanceOfCorruption == 1) {

            for (int i = 0; i < data.size(); ++i) {

                chanceOfCorruption = ran.nextInt(0, 2);
                corruptionFactor = ran.nextInt(1, 99);


                if (chanceOfCorruption == 1) {

                    primitiveChar = data.get(i);

                    primitiveChar += corruptionFactor;

                    data.add(i, primitiveChar);
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {

        int size = 10;

        ArrayList<Character> randomData = randomString(size);

        System.out.println(randomData);

        ArrayList<String> stringRandomData = createCheckBits(randomData);

        System.out.println(stringRandomData);

        corruption(randomData);

        System.out.println(randomData);


    }
}