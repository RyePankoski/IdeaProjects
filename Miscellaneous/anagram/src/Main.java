public class Main {
    public static void main(String[] args) {

        String anagramOne = "binary";
        String anagramTwo = "brainy";

        char[] anagramOneArray = anagramOne.toCharArray();
        char[] anagramTwoArray = anagramTwo.toCharArray();
        int matchScore = 0;

        if (anagramOneArray.length != anagramTwoArray.length){
            System.out.println(anagramOne + " & " + anagramTwo + " " + "are NOT anagrams");
            System.exit(0);
        }

        for (int i = 0; i < anagramOneArray.length;++i){
            for (int j = 0; j < anagramTwoArray.length;++j){

                if(anagramOneArray[i] == anagramTwoArray[j]){
                    matchScore++;
                }
            }
        }

        if(matchScore == anagramOneArray.length){
            System.out.println(anagramOne + " & " + anagramTwo + " " +  "are anagrams");
        } else {
            System.out.println(anagramOne + " & " + anagramTwo + " " + "are NOT anagrams");
        }
    }
}