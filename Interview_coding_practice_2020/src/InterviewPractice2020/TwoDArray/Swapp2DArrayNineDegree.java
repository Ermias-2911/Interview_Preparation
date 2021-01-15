package InterviewPractice2020.TwoDArray;

// Author Ermias Haile
// August 27, 2020
// Rotate 2D Array 90 Degree

import org.w3c.dom.Node;

import java.util.Arrays;

public class Swapp2DArrayNineDegree {
Node jnext;
	public static void RotateNineDegree(int[][] grid) {

		// Swap Diagonally First (We assign j = i because to increment both row and column index left and right equally)
		for (int i = 0; i < grid.length; i++) {
			for (int j = i; j < grid[0].length; j++) {
				int temp = grid[i][j];
				grid[i][j] = grid[j][i];
				grid[j][i] = temp;
			}
		}
		System.out.println("\nFirst Diagonally Swaped: ");
		for (int[] loop : grid) {
			System.out.println(Arrays.toString(loop));
		}

		// Finally Swapped Horizontally to Get Clockwise 90 Degree Rotation (we assign j = 0 because as row increment column always start form 0 to swap)
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length / 2; j++) {
				int temp = grid[i][j];
				grid[i][j] = grid[i][grid[i].length - 1 - j];
				grid[i][grid[i].length - 1 - j] = temp;
			}
		}
		System.out.println("\nFinally Swapped Horizontally And Become 90 Degree Rotated 2D Array: ");
		for (int[] l : grid) {
			System.out.println(Arrays.toString(l));
		}

	}

	public static void main(String[] args) {
		int grid[][] = {{1, 2, 3, 4},
				{5, 8, 9, 10},
				{6, 11, 12, 13},
				{7, 14, 15, 16}};
		RotateNineDegree(grid);
	}
}
