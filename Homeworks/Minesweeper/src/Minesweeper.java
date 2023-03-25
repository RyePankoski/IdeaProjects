/*
 * CS2050 - Computer Science II - Fall 2022
 * Instructor: Thyago Mota
 * Student(s) Name(s):
 * Description: prg_02 - Minesweeper
 */

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

//Rye Pankoski CS2

public class Minesweeper {

    private boolean map[][];   // true if it's mined; false otherwise
    private char board[][]; // control the game's board
    private int size;
    private int mines;
    private static final int MIN_SIZE = 6;
    private static final int MIN_MINES = 1;

    // TODO #1: finish the implementation of the constructor according to the instructions
    public Minesweeper(int size, int mines) {

        this.board = new char[size][size];
        this.map = new boolean[size][size];
        this.mines = mines;
        this.size = size;

        for (int i = 0; i < size;i++) {
            for (int ii = 0; ii < size; ii++) {
                board[i][ii] = '?';
            }
        }

        int num = 0;
        while (num < mines) {
            if (hideMine()) {
                num++;
            }
        }
    }

    public boolean validIndex(int x, int y) {

        if (x < 0 || y < 0 || x >= size || y >= size) {
            return false;
        } else {
            return true;
        }
    }

    // displays the board
    @Override
    public String toString() {
        String str = "x\\y\t";
        for (int i = 0; i < this.size; i++)
            str += i + "\t";
        str += "\n";
        for (int i = 0; i < this.size; i++) {
            str += i + "\t";
            for (int j = 0; j < this.size; j++)
                str += board[i][j] + "\t";
            str += "\n";
        }

        return str;
    }

    // tries to hide a mine at a random location; returns true if attempt was successful; false otherwise
    private boolean hideMine() {
        Random rnd = new Random();
        int x = rnd.nextInt(size);
        int y = rnd.nextInt(size);
        if (!map[x][y]) {
            map[x][y] = true;
            return true;
        }
        return false;
    }

    // returns true if the location is valid and mined, false otherwise
    private boolean isMined(int x, int y) {
        if (x < 0 || x > size - 1 || y < 0 || y > size - 1)
            return false;
        return map[x][y];
    }

    // returns true if the location is valid and flagged, false otherwise
    private boolean isFlagged(int x, int y) {
        if (x < 0 || x > size - 1 || y < 0 || y > size - 1)
            return false;
        return board[x][y] == '+';
    }

    // returns the number of hidden mines
    public int getMines() {
        return mines;
    }

    // TODOd #2: this method should return the number of mines (immediately) around the given location
    private int minesAround(int x, int y) {

        int counter = 0;
        for (int xInc = -1; xInc <= 1; xInc++) {
            for (int yInc = -1; yInc <= 1; yInc++) {
                int checkX = x + xInc;
                int checkY = y + yInc;
                if (validIndex(checkX, checkY)) {
                    counter += isMined(checkX, checkY) ? 1 : 0;
                }
            }
        }
        return counter;
    }

    // TODO #3: this method should return true if there is at least one tile in the board that reveals a mine
    public boolean isMineDetonated() {

        for (int i = 0; i < size; i++) {
            for (int ii = 0; ii < size; ii++) {
                if (board[i][ii] != '?' && board[i][ii] != '+' && map[i][ii] == true) {
                    return true;
                }
            }
        }
        return false;
    }

    // TODO #4: this method should return true if ALL non-mined tiles were revealed OR a mine was detonated; false otherwise
    // hint: check if the number of tiles marked with '?' matches the number of mines; also look for a "detonated" mine
    public boolean isGameOver() {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (board[i][j] == '?' || board[i][j] == '+') {
                    counter++;
                }
            }
        }

        if (counter == mines) {
            return true;
        }
        return false;
    }

    // same as reveal but with flag set to false
    public void reveal(int x, int y) {
        reveal(x, y, false);
    }

    public void removeFlag(int x, int y){
        board[x][y] = '?';
    }

    // TODO #5: this method should reveal the board tile based on the given location;
    // you must use the char conventions detailed in the README file
    // if you are not implementing the flag feature (bonus points) just ignore parameter "flag"
    void reveal(int x, int y, boolean flag) {
        // check if it's a valid index

        if (!validIndex(x, y)) {
            return;
        }
        // Already revealed
        if (board[x][y] != '?') {
            return;
        }
        if(flag){
            board[x][y] = '+';
            return;
        }
        // It has not been revealed and is valid

        // Are there mines around it (including itself)
        if (minesAround(x, y) > 0) {
            board[x][y] = (char) (minesAround(x, y) + '0');
            return;
        } else {
            board[x][y] = ' ';
        }

        reveal(x, y + 1);
        reveal(x - 1, y);
        reveal(x + 1, y);
        reveal(x, y - 1);

    }
}