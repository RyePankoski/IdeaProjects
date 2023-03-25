public class Main {
    public static void main(String[] args) {


        //: ͞
        String notQString = "!Q: ";
        String qString = "Q:  ";
        int clock = -1;
        int qOut = -1;
        boolean waveNull = false;

        int[] sData = {0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0};
        int[] rData = {0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0};


        for (int i = 0; i < sData.length; ++i) {

            if (clock == 1) {

                if (sData[i] == 0 && rData[i] == 0) {
                    qOut = -1;
                    waveNull = false;
                }
                if (sData[i] == 0 && rData[i] == 1) {
                    qOut = -1;
                    waveNull = false;
                }
                if (sData[i] == 1 && rData[i] == 0) {
                    qOut = 1;
                    waveNull = false;
                }
                if (sData[i] == 1 && rData[i] == 1) {
                    waveNull = true;
                }
            }
            clock *= -1;

            if (qOut == 1) {
                qString += (" ͞ " + "|");
                notQString += (" _ " + "|");
            }
            if (qOut == -1) {
                qString += (" _ " + "|");
                notQString += (" ͞ " + "|");
            }
            if(waveNull == true){
                qString += "X ";
                notQString += "X ";
            }
        }
        System.out.println(qString);
        System.out.println(notQString);
    }


}
