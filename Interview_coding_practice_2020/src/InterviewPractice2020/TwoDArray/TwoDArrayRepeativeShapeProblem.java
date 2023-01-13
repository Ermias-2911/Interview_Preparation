package InterviewPractice2020.TwoDArray;

import java.util.Arrays;

public class TwoDArrayRepeativeShapeProblem {

    public static int  getIshapeValue(int[][] grid) {

        // Swap Diagonally First (We assign j = i because to increment both row and column index left and right equally)
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int temp = grid[i][j];
                grid[i][j] = grid[j][i];
                grid[j][i] = temp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int grid[][] = {{1, 2, 3, 4},
                {5, 8, 9, 10},
                {6, 11, 12, 13},
                {7, 14, 15, 16}};
        int result = getIshapeValue(grid);
        System.out.println(" I shaped Value is: " + result);
    }
}
