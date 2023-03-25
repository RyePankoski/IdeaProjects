public class problemEleven {
//    In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
//
//            08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
//            49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
//            81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
//            52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
//            22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
//            24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
//            32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
//            67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
//            24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
//            21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
//            78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
//            16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
//            86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
//            19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
//            04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
//            88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
//            04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
//            20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
//            20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
//            01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
//
//    The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
//
//    What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?


    //publicly declare variables, so they can be updated regardless of which frame or context they are used in.
    public static Integer[][] theFours = new Integer[10000][4];
    public static Integer[] theFour = new Integer[4];
    static int topY = 0;
    public static int theFourIndex = 0;


    public static double fourEvaluation() {

        double product = 1;
        double store = 0;
        Integer[] theTempFour;


        for (int i = 0; i < 1000; ++i) {

            //so we don't evaluate a null.
            if (theFours[i][0] == null) {
                break;
            }

            theTempFour = theFours[i];

            for (int j = 0; j < 4; ++j) {
                product *= theTempFour[j];
            }
            if (product > store) {
                store = product;
            }
            product = 1;
        }

        return store;
    }
    public static Integer[][] arrayMaker(String string) {

        String[] splitString = string.split("\\s+");

        Integer[][] grid = new Integer[20][20];
        int stringPos = 0;

        for (int px = 0; px < 20; ++px) {
            for (int py = 0; py < 20; ++py) {
                grid[px][py] = Integer.parseInt(splitString[stringPos]);
                stringPos++;
            }
        }
        return grid;
    }
    public static void printArray(Integer[][] array) {

        int limit = array.length - 1;
        StringBuilder printString = new StringBuilder(1 + ":  ");

        for (int i = 0; i < limit; ++i) {
            for (int j = 0; j < 4; ++j) {

                printString.append(array[i][j]).append("  ");

                if (array[i][j] == null) {
                    return;
                }

            }
            System.out.println(printString);
            printString = new StringBuilder(i + 2 + ":  ");
        }
    }
    public static void variableReset() {

        //we need to make a new array so the same array doesn't get added to theFours multiple times.
        theFour = new Integer[4];
        printArray(theFours);
        System.out.println("\n");
        //reset theFour index.
        theFourIndex = 0;
    }
    public static void fourFinder(Integer[][] theGrid) {

        int hingeX = 0;
        int hingeY = 0;
        int length = theGrid.length - 1;


        //the if checks make sure we don't go out of bounds of our array, and we can skip the for since we don't need to
        //build an array for that segment of the grid.
        while (true) {
            //look right
            if (!(hingeX + 3 > length)) {
                for (int i = 0; i < 4; ++i) {
                    theFour[theFourIndex] = theGrid[hingeY][hingeX + i];
                    theFourIndex++;
                }
                theFours[topY] = theFour;
                ++topY;
            }
            variableReset();
            //look diagonal right
            if (!(hingeX + 3 > length || hingeY + 3 > length)) {
                for (int i = 0; i < 4; ++i) {
                    theFour[theFourIndex] = theGrid[hingeY + i][hingeX + i];
                    theFourIndex++;
                }
                theFours[topY] = theFour;
                ++topY;
            }
            variableReset();
            //look down
            if (!(hingeY + 3 > length)) {
                for (int i = 0; i < 4; ++i) {
                    theFour[theFourIndex] = theGrid[hingeY + i][hingeX];
                    theFourIndex++;
                }
                theFours[topY] = theFour;
                ++topY;
            }
            variableReset();
            //look diagonal left
            if (!(hingeY + 3 > length || hingeX - 3 < 0)) {
                for (int i = 0; i < 4; ++i) {
                    theFour[theFourIndex] = theGrid[hingeY + i][hingeX - i];
                    theFourIndex++;
                }
                theFours[topY] = theFour;
                ++topY;
            }
            variableReset();

            //iterate X, we are moving the hinge right. We can think of the array search as a swinging pendulum. The hinge moves right and searches to the right,
            //diagonal right, down, and diagonal left, before the hinge moves again to the right.
            hingeX++;

            //when the hinge reaches the far right boundary of the 20x20 grid, we want it to move back to the left, and
            //down 1, so we can start the search again.
            if (hingeX > length) {
                hingeX = 0;
                hingeY++;
            }
            //this is how we know when we are done searching through the grid.
            if (hingeY > length) {
                return;
            }
        }
    }

    public static void main(String[] args) {

        String gridString = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 " + "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 " + "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 " + "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 " + "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 " + "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 " + "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 " + "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 " + "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 " + "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 " + "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 " + "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 " + "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 " + "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 " + "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 " + "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 " + "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 " + "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 " + "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 " + "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";

        //make our 2d array of the numbers.
        Integer[][] gridArray = arrayMaker(gridString);
        //find all sets of adjacent four numbers, including diagonal and up and down.
        fourFinder(gridArray);
        //discover what the largest product among the fours is.
        double answer = fourEvaluation();
        //cast so you don't get some wacko number with an E in it.
        System.out.println((int) answer);

    }
}
