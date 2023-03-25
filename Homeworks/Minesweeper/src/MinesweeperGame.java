/*
 * CS2050 - Computer Science II - Fall 2022
 * Instructor: Thyago Mota
 * Student(s) Name(s):
 * Description: prg_02 - Minesweeper
 */

import java.util.Scanner;

//Rye Pankoski CS2

public class MinesweeperGame{

    static final int BEGINNER_LEVEL     = 1;
    static final int INTERMEDIATE_LEVEL = 2;
    static final int EXPERT_LEVEL       = 3;

    // TODO #6: finish the implementation of the game according to the instructions

    public static void main(String[] args)  {
        Scanner skan = new Scanner(System.in);

        System.out.println("Choose difficulty (EASY:1 | MEDIUM:2 | HARD:3)");
        int choice = skan.nextInt();

        Minesweeper game;

        switch (choice) {
            case 4:
                game = new Minesweeper(5,2);
                break;
            case 5:
                game = new Minesweeper(30, 80);
                break;
            case 2:
                game = new Minesweeper(15, 25);
                break;
            case 3:
                game = new Minesweeper(20,50);
                break;
            case 1:
            default:
                game = new Minesweeper(10,10);
        }

        boolean gameOn = true;

        System.out.println("Welcome to Rye(m)Sweeper. Its minesweeper. To select coordinate, use a slash before coordinate. Ex. / 2 2. Use + before coordinates to add a flag, use - before a coordinate to remove the flag. Format ex. (+ 2 2.)");

        while (gameOn){


            System.out.println(game.toString());
            System.out.println("Enter Coordinates");

            char c = skan.next().charAt(0);
            int x = skan.nextInt();
            int y = skan.nextInt();

            if (c == '+'){
                game.reveal(y,x,true);
            } else if (c == '-') {
                game.removeFlag(y,x);
            } else {
                game.reveal(y, x);
            }

            if (game.isGameOver()){
                gameOn = false;
                System.out.println("How very clever you are. You win. For an intense challenge, choose 5 next time you start the game.");
                System.out.println(game);
            }
            if (game.isMineDetonated()){
                gameOn = false;
                System.out.println("Very foolish. You lose.");
            }
        }
    }
}