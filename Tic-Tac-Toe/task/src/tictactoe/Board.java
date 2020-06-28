package tictactoe;

import java.util.Arrays;

public class Board {
    char[][] field;
    int numberOfEmptyCells = 9;

    public Board() {
        this.field = new char[3][3];
        fill();
    }

    private void fill() {
        for (char[] chars : field) {
            Arrays.fill(chars, '_');
        }
    }

    public void printField() {
        System.out.println("---------");
        for (char[] arr : field) {
            System.out.print("| ");
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private boolean hasPlayerWon(char c) {
        int x = 0;
        int y = 2;
        int z = 0;
        int diagonalDescCounter = 0;
        int diagonalAscCounter = 0;
        for (int i = 0; i < field.length; i++, x++, y--, z++) {
            int rowCounter = 0;
            int columnCounter = 0;
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == c) {
                    rowCounter++;
                }
                if (field[j][i] == c) {
                    columnCounter++;
                }
            }
            if (rowCounter == 3 || columnCounter == 3) {
                return true;
            }
            if (field[x][y] == c) {
                diagonalAscCounter++;
            }
            if (field[x][z] == c) {
                diagonalDescCounter++;
            }
        }
        return diagonalAscCounter == 3 || diagonalDescCounter == 3;
    }

    public boolean printResult() {
        boolean result = false;
        boolean xWon = hasPlayerWon('X');
        boolean oWon = hasPlayerWon('O');
        if (xWon) {
            System.out.println("X wins");
            result = true;
        } else if ((oWon)) {
            System.out.println("O wins");
            result = true;
        } else if (numberOfEmptyCells == 0) {
            System.out.println("Draw");
            result = true;
        }
        return result;
    }

    public boolean insertX(int x, int y) {
        boolean result;
        if (field[3 - y][x - 1] == 'X' || field[3 - y][x - 1] == 'O') {
            result = false;
        } else {
            field[3 - y][x - 1] = 'X';
            numberOfEmptyCells--;
            result = true;
        }
        return result;
    }

    public boolean insertO(int x, int y) {
        boolean result;
        if (field[3 - y][x - 1] == 'X' || field[3 - y][x - 1] == 'O') {
            result = false;
        } else {
            field[3 - y][x - 1] = 'O';
            numberOfEmptyCells--;
            result = true;
        }
        return result;
    }
}

