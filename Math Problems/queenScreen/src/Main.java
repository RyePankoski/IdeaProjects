import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    static int posY = 0;
    static int posX = 0;
    static int foundQueens = 0;
    public static int size = 4;
    static int queens = size;
    static ChessBoard board = new ChessBoard(size);
    static boolean[][] validSpotsForQueens = new boolean[size][size];
    static boolean[][] validPositionCopy = new boolean[size][size];
    static ArrayList<boolean[][]> listOfPreviousStates = new ArrayList<>();
    static ArrayList<int[]> previousQueenPositions = new ArrayList<>();
    static int[] queenPosition = new int[2];


    public static boolean[][] copyArray(boolean[][] arrayToBeCopied) {

        boolean[][] array = new boolean[arrayToBeCopied.length][arrayToBeCopied.length];

        for (int i = 0; i < size; ++i) {
            System.arraycopy(arrayToBeCopied[i], 0, array[i], 0, size);
        }
        return array;
    }
    public static void removeQueen(int column) {

        for (int i = 0; i < size; ++i) {
            if (ChessBoard.queens[i][column] != null) {
                ChessBoard.queens[i][column] = null;
                return;
            }
        }
    }

    public static void printArray(ArrayList<int[]> print) {
        int[] temp;
        StringBuilder printString = new StringBuilder();

        for (int[] ints : print) {
            temp = ints;
            for (int i : temp) {
                printString.append(i).append(" ");
            }
            System.out.println(printString);
            printString = new StringBuilder();
        }
    }
    public static void hellishPermutation() {
        while (true) {

            int[] temp;

            if (validSpotsForQueens[posY][posX]) {
                return;
            } else {
                posY++;
            }

            if (posY == size) {

                //grab data from the list.
                temp = previousQueenPositions.get(previousQueenPositions.size() - 1);

                validSpotsForQueens = listOfPreviousStates.get(listOfPreviousStates.size() - 1);

                //remove junk data. In a failed condition, none of the data at the end of the list is applicable anymore
                previousQueenPositions.remove(previousQueenPositions.size() - 1);
                listOfPreviousStates.remove(listOfPreviousStates.size() - 1);

                posX--;
                foundQueens--;
                posY = 0;
                removeQueen(posX);

                validSpotsForQueens[temp[0]][temp[1]] = false;

                hellishPermutation();
            }
        }
    }
    public static void decideValidity(int size, int posY, int posX) {

        int tempX;
        int tempY = posY;

        //left-right
        Arrays.fill(validSpotsForQueens[posY], false);
        //down
        while (tempY < size) {
            validSpotsForQueens[tempY][posX] = false;
            tempY++;
        }
        tempY = posY;
        //up
        while (tempY > -1) {
            validSpotsForQueens[tempY][posX] = false;
            tempY--;
        }
        tempY = posY;
        tempX = posX;
        //diagonal down right
        while ((tempY < size) && (tempX < size)) {
            validSpotsForQueens[tempY][tempX] = false;
            tempY++;
            tempX++;
        }
        tempY = posY;
        tempX = posX;
        //diagonal down left
        while ((tempY < size) && (tempX > -1)) {
            validSpotsForQueens[tempY][tempX] = false;
            tempY++;
            tempX--;
        }
        tempY = posY;
        tempX = posX;
        //diagonal up right
        while ((tempY > -1) && (tempX < size)) {
            validSpotsForQueens[tempY][tempX] = false;
            tempY--;
            tempX++;
        }
        tempY = posY;
        tempX = posX;
        //diagonal up left
        while ((tempY > -1) && (tempX > -1)) {
            validSpotsForQueens[tempY][tempX] = false;
            tempY--;
            tempX--;
        }
    }
    public static void printBoard(boolean[][] theBoard) {

        StringBuilder row = new StringBuilder();

        for (boolean[] booleans : theBoard) {
            for (int j = 0; j < theBoard.length; ++j) {
                if (booleans[j]) {
                    row.append("O" + "  ");
                } else {
                    row.append("X" + "  ");
                }
            }
            row.append("\n");
        }
        System.out.println(row);
    }

    public static void main(String[] args) {

        //fill the arrays with true
        for (boolean[] row : validSpotsForQueens) {
            Arrays.fill(row, true);
        }

        Queen newQueen = new Queen();

        while (true) {

            hellishPermutation();

            //add the previous valid state to a list
            listOfPreviousStates.add(validSpotsForQueens);
            //create a copy of the current state of the list.
            validPositionCopy = copyArray(validSpotsForQueens);
            //create a new valid states array
            validSpotsForQueens = new boolean[size][size];
            //set it equal to the copy we just made
            validSpotsForQueens = copyArray(validPositionCopy);

            decideValidity(size, posY, posX);

            foundQueens++;

            //update queenPosition.
            queenPosition[0] = posY;
            queenPosition[1] = posX;

            //add previous queen location to list
            previousQueenPositions.add(queenPosition);
            //create a new list.
            queenPosition = new int[2];

            //add the queen object to the chessboard
            ChessBoard.queens[posY][posX] = newQueen;
            //make sure that the spot the queen is on is not set
            //as valid
            validSpotsForQueens[posY][posX] = false;


            //bring the search back to the top, and move it to the next column
            posY = 0;
            posX++;

            System.out.println(board);

            //success condition
            if (foundQueens == queens) {
                System.out.println("Completed:");
                System.out.println(board);
                System.exit(0);
            }
        }
    }
}


