package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean finished = false;

    public static void main(String[] args) {
        Board board = new Board();
        board.printField();
        int index = 0;
        while (!finished){
            System.out.println("Enter the coordinates:");
            try {
                int coordinate1 = scanner.nextInt();
                int coordinate2 = scanner.nextInt();
                if (coordinate1 > 3 || coordinate1 < 1 || coordinate2 > 3 || coordinate2 < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    scanner.nextLine();
                } else {
                    if (index % 2 == 0) {
                        if (board.insertX(coordinate1, coordinate2)) {
                            board.printField();
                            index++;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            scanner.nextLine();
                        }
                    } else {
                        if (board.insertO(coordinate1, coordinate2)) {
                            board.printField();
                            index++;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            scanner.nextLine();
                        }
                    }
                }
                if (board.printResult()) {
                    finished = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }
    }
}
