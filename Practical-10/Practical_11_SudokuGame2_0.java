import java.util.*;

public class Practical_11_SudokuGame2_0 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter Sudoku grid size (e.g., 1, 2, 3...): ");
        int size = scanner.nextInt();

        int[][] fullGrid = new int[size][size];
        int[][] puzzleGrid = new int[size][size];
        boolean[][] isEditable = new boolean[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                fullGrid[row][col] = random.nextInt(size) + 1;
                puzzleGrid[row][col] = fullGrid[row][col];
            }
        }

        int cellsToHide = (int) (size * size * 0.4);
        while (cellsToHide > 0) {
            int r = random.nextInt(size);
            int c = random.nextInt(size);
            if (puzzleGrid[r][c] != 0) {
                puzzleGrid[r][c] = 0;
                isEditable[r][c] = true;
                cellsToHide--;
            }
        }

        boolean gameActive = true;
        while (gameActive) {
            System.out.println("\nCurrent Sudoku Puzzle:");
            printGrid(puzzleGrid);

            System.out.println("\nChoose an option:");
            System.out.println("1. Insert a number");
            System.out.println("2. Erase a number");
            System.out.println("3. Submit solution");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter row (1 to " + size + "): ");
                    int rAdd = scanner.nextInt();
                    System.out.print("Enter column (1 to " + size + "): ");
                    int cAdd = scanner.nextInt();
                    System.out.print("Enter value (1 to " + size + "): ");
                    int value = scanner.nextInt();

                    if (isInBounds(rAdd, cAdd, size) && isEditable[rAdd - 1][cAdd - 1]) {
                        puzzleGrid[rAdd - 1][cAdd - 1] = value;
                    } else {
                        System.out.println("⚠ Invalid location or cell not editable.");
                    }
                    break;

                case 2:
                    System.out.print("Enter row (1 to " + size + "): ");
                    int rDel = scanner.nextInt();
                    System.out.print("Enter column (1 to " + size + "): ");
                    int cDel = scanner.nextInt();

                    if (isInBounds(rDel, cDel, size) && isEditable[rDel - 1][cDel - 1]) {
                        puzzleGrid[rDel - 1][cDel - 1] = 0;
                    } else {
                        System.out.println("⚠ Cannot erase from this cell.");
                    }
                    break;

                case 3:
                    System.out.println("\n🔍 Validating your answer...");
                    if (checkSolution(puzzleGrid, fullGrid)) {
                        printGrid(puzzleGrid);
                        System.out.println("Great job! You've solved the puzzle!");
                    } else {
                        System.out.println("Incorrect. Here's the correct solution:");
                        printGrid(fullGrid);
                    }
                    gameActive = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please pick between 1-3.");
            }
        }

        scanner.close();
    }

    static boolean isInBounds(int row, int col, int max) {
        return row >= 1 && row <= max && col >= 1 && col <= max;
    }

    static boolean checkSolution(int[][] userGrid, int[][] solutionGrid) {
        for (int i = 0; i < userGrid.length; i++) {
            for (int j = 0; j < userGrid.length; j++) {
                if (userGrid[i][j] != solutionGrid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void printGrid(int[][] grid) {
        int size = grid.length;
        String rowBorder = " ";
        for (int i = 0; i < size; i++) {
            rowBorder += "----";
        }

        for (int i = 0; i < size; i++) {
            System.out.println(rowBorder);
            for (int j = 0; j < size; j++) {
                System.out.print("| ");
                if (grid[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println(rowBorder);
    }
}
