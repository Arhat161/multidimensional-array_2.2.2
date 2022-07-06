package ru.netology;

import java.util.Scanner;

public class Main {
    public static final int SIZE = 5;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = 'O';

    public static void main(String[] args) {
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
            }
        }

        Scanner scanner = new Scanner(System.in);

        boolean isCrossTurn = true;

        while (true) {
            printField(field);
            System.out.println("Ходят " + (isCrossTurn ? "крестики" : "нолики") + "!");
            String input = scanner.nextLine(); // "2 3"
            String[] parts = input.split(" "); // ["2" , "3"]
            int r = Integer.parseInt(parts[0]) - 1; // 2-1 = 1
            int c = Integer.parseInt(parts[1]) - 1; // 3-1 = 2

            if (field[r][c] != EMPTY) {
                System.out.println("Сюда ходить нельзя");
                continue;
            }

            field[r][c] = isCrossTurn ? CROSS : ZERO;
            if (isWin(field, isCrossTurn ? CROSS : ZERO)) {
                printField(field);
                System.out.println("Победили " + (isCrossTurn ? "крестики" : "нолики"));
                break;
            } else {
                if (isCrossTurn) {
                    isCrossTurn = false;
                } else {
                    isCrossTurn = true;
                }
                //isCrossTurn = !isCrossTurn;
            }
        }
        System.out.println("Игра закончена!");
    }

    public static boolean isWin(char[][] field, char player) {

        for (int row = 0; row < SIZE; row++) {
            int playerRowCount = 0;
            for (int col = 0; col < SIZE; col++) {
                if (field[row][col] == player) {
                    playerRowCount++;
                }
            }
            if (playerRowCount == SIZE) {
                return true;
            }
        }

        for (int col = 0; col < SIZE; col++) {
            int playerColCount = 0;
            for (int row = 0; row < SIZE; row++) {
                if (field[row][col] == player) {
                    playerColCount++;
                }
            }
            if (playerColCount == SIZE) {
                return true;
            }
        }

        int playerMainDiagonalCount = 0;

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (col == row && field[row][col] == player) {
                    playerMainDiagonalCount++;
                }
            }
            if (playerMainDiagonalCount == SIZE) {
                return true;
            }
        }

        int playerSecondDiagonalCount = 0;
        for (int col = 0, row = (SIZE - 1) - col; row >= 0; row--, col++) {
            if (field[row][col] == player) {
                playerSecondDiagonalCount++;
            }
            if (playerSecondDiagonalCount == SIZE) {
                return true;

            }
        }

        return false;
    }
        public static void printField ( char[][] field){
            for (char[] row : field) {
                for (char cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        }
    }