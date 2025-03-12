public class Practical10 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide grid size as a command-line argument.");
            return;
        }

        int size = Integer.parseInt(args[0]);
        int[][] fullGrid = new int[size][size];
        int[][] puzzleGrid = new int[size][size];

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                fullGrid[row][col] = (row + col) % size + 1;
            }
        }

    
        boolean[][] masked = new boolean[size][size];
        int cellsToHide = (size * size) / 3;

        while (cellsToHide > 0) {
            int i = (int) (Math.random() * size);
            int j = (int) (Math.random() * size);
            if (!masked[i][j]) {
                puzzleGrid[i][j] = 0;
                masked[i][j] = true;
                cellsToHide--;
            }
        }

    
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!masked[i][j]) {
                    puzzleGrid[i][j] = fullGrid[i][j];
                }
            }
        }


        for (int row = 0; row < size * 2 + 1; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < size; col++) {
                    System.out.print(" -----");
                }
            } else {
                int actualRow = row / 2;
                for (int col = 0; col < size; col++) {
                    if (col == 0) System.out.print("|");
                    if (puzzleGrid[actualRow][col] == 0) {
                        System.out.print("     |");
                    } else {
                        System.out.printf("  %d  |", puzzleGrid[actualRow][col]);
                    }
                }
            }
            System.out.println();
        }
    }
}
