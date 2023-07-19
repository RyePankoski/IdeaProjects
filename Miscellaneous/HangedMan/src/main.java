import java.util.Scanner;

public class main {
    public static void wordReveal(char[] secretWord, char[] persistentArray, char userGuess) {

        char[] revealedArray = new char[secretWord.length];


        for (int i = 0; i < secretWord.length; i++) {

            if (secretWord[i] == userGuess) {
                revealedArray[i] = userGuess;
                persistentArray[i] = revealedArray[i];
            }
        }

        String revealedArrayString = new String(persistentArray);
        System.out.println(revealedArrayString);

    }

    public static void hangManGame(char[] secretWord)   {

        System.out.println("Game on!");

        Scanner skan = new Scanner(System.in);
        boolean foundLetter;
        int severity = 0;
        int winState = secretWord.length;
        int state;
        char[] persistentArray = new char[secretWord.length];


        while (true) {

            foundLetter = false;
            System.out.println("guess a letter.");
            char userGuess = skan.next().charAt(0);

            for (int i = 0; i < secretWord.length;++i) {
                if (userGuess == secretWord[i]) {
                    wordReveal(secretWord, persistentArray, userGuess);
                    foundLetter = true;
                    break;
                }
            }

            if (!foundLetter) {
                severity++;
                hangedManPrintStatements(severity);
            }

            state = 0;
            for (int i = 0; i < secretWord.length; ++i) {
                if (secretWord[i] == persistentArray[i]) {
                    state++;
                }
            }

            if (state == winState) {
                System.out.println("You win!");
                System.exit(0);
            }

            if (severity == 6) {
                hangedManPrintStatements(severity);
                System.out.println("Game over!!!!!");
                System.exit(0);
            }
        }
    }

    public static char[] arrayMaker(String secretWord) {

        char[] secretWordArray = new char[secretWord.length()];

        for (int i = 0; i < secretWord.length(); i++) {
            secretWordArray[i] = secretWord.charAt(i);
        }
        return secretWordArray;
    }
    public static void hangedManPrintStatements(int severity) {

        String top = "--------------";
        String side = "           |";
        String head = "     o     |";
        String bodyNoArms = "     |     |";
        String bodyLeftArm = "   - |     |";
        String bodyBothArms = "   - | -   |";
        String leftLeg = "    /      |";
        String bothLegs = "    / \\    |";
        String bottom = "          --- ";


        switch (severity) {
            case 1 -> {
                String firstIteration = top + "\n" + head + "\n" + side + "\n" + side + "\n" + bottom;
                System.out.println(firstIteration);
            }
            case 2 -> {
                String secondIteration = top + "\n" + head + "\n" + bodyNoArms + "\n" + bottom;
                System.out.println(secondIteration);
            }
            case 3 -> {
                String thirdIteration = top + "\n" + head + "\n" + bodyLeftArm + "\n" + bottom;
                System.out.println(thirdIteration);
            }
            case 4 -> {
                String fourthIteration = top + "\n" + head + "\n" + bodyBothArms + "\n" + bottom;
                System.out.println(fourthIteration);
            }
            case 5 -> {
                String fifthIteration = top + "\n" + head + "\n" + bodyBothArms + "\n" + leftLeg + "\n" + bottom;
                System.out.println(fifthIteration);
            }
            case 6 -> {
                String sixthIteration = top + "\n" + head + "\n" + bodyBothArms + "\n" + bothLegs + "\n" + bottom;
                System.out.println(sixthIteration);
            }
            default -> throw new IllegalStateException("Unexpected value: " + severity);
        }
    }
    public static void main(String[] args) {

        Scanner skan = new Scanner(System.in);

        System.out.println("Choose your secret word!");
        String secretWord = skan.next();

        char[] secretWord2 = arrayMaker(secretWord);

        hangManGame(secretWord2);

    }
}



