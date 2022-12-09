package InterviewPractice2020.TwoDArray;
import java.util.Arrays;

        // Given a binary grid where 0 represents water and 1 represents land. An island is surrounded by water and is formed by
        // connecting adjacent lands horizontally or vertically. Delete all islands except their borders. A border is land adjacent
        // to water. You may assume all four edges of the grid are surrounded by water.
public class DeletIlands {
    private static int[][] deleteIslands(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int[][] copyGrid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                copyGrid[i][j] = grid[i][j];
            }
        }
        DFS(grid, copyGrid, visited, 0, 0);
        return copyGrid;
    }

    private static void DFS(int[][] grid, int[][] copyGrid, boolean[][] visited, int i, int j) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= columns || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (i > 0 && grid[i - 1][j] == 1 && i < rows - 1 && grid[i + 1][j] == 1 && j > 0 && grid[i][j - 1] == 1 && j < columns - 1 && grid[i][j + 1] == 1) {
            copyGrid[i][j] = 0;
        }
        DFS(grid, copyGrid, visited, i + 1, j);
        DFS(grid, copyGrid, visited, i - 1, j);
        DFS(grid, copyGrid, visited, i, j + 1);
        DFS(grid, copyGrid, visited, i, j - 1);
    }

    public static void main(String[] args) {
        int mat[][] = 	{{1, 1, 0, 0},
                         {1, 1, 1, 1},
                         {1, 1, 0, 0},
                         {0, 1, 1, 1}};
        // Print input matrix
        System.out.println("Matrix Array before deletion");
        for (int[] rows: mat)
        {
            System.out.println(Arrays.toString(rows));
        }


        System.out.println(" ");
        int [][]copyMat =  deleteIslands(mat);

        // Print Deleted Matrix
        System.out.println("Matrix Array after deletion");
        for (int[] rows: copyMat)
        {
            System.out.println(Arrays.toString(rows));
        }





        // To loop Matix
        for(int i = 0; i < copyMat.length; ++i) {
            for(int j = 0; j < copyMat[i].length; ++j) {
                // Do whatever with grid[i][j] here
            }
        }

        // To loop Matix Using Inhansing Loop
        for (int[] row : mat)
        {
            for (int value : row)
            {
                // Do something
            }
        }


    }
}