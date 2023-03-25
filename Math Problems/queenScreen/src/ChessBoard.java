public class ChessBoard {
    static Queen[][] queens;


    public static int size(){

        int x = 0;
        while (x < queens.length){
            ++x;
        }
        return x;
    }
    public static boolean hasQueen(int i, int j){
        if (queens[i][j]instanceof Queen){
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String printString = "";
        for (int i = 0; i < queens.length; ++i) {
            for (int j = 0; j < queens.length; ++j) {
                if (queens[i][j] != null){
                    printString += "Q" + "  ";
                } else {
                    printString += "-" + "  ";
                }
            }
            printString += "\n";
        }
        return printString;
    }
    public ChessBoard(int size){

        this.queens = new Queen[size][size];

    }
}
