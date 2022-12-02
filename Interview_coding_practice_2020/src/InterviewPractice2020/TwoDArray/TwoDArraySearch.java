package InterviewPractice2020.TwoDArray;

import java.util.Arrays;

public class TwoDArraySearch {
	private static void search(int[][] mat, int n, int x) {

		int i = 0, j = n - 1; // set indexes for top right
		// element

		while (i < n && j >= 0) {
			System.out.println("n  " + mat[i][j]);
			if (mat[i][j] == x) {
				System.out.print("n Found at " + i + " " + j);
				return;
			}
			if (mat[i][j] > x)
				j--;
			else // if mat[i][j] < x
				i++;
		}

		System.out.print("n Element not found");
		return; // if ( i==n || j== -1 )
	}

	// driver program to test above function
	public static void main(String[] args) {
		int mat[][] = {{10, 20, 30, 40},
				{15, 25, 35, 45},
				{27, 29, 37, 48},
				{32, 33, 39, 50}};

		search(mat, 4, 29);
	}
}



//
//
//
//package InterviewPractice2020;
//
//		import java.util.*;
//
//
//// Amazon | OA 2019 | Treasure Island
//// https://leetcode.com/discuss/interview-question/347457/Amazon-or-OA-2019-or-Treasure-Island
//public class test {
//
//	final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//
//	public int treasureIsland(char[][] islands) {
//
//		if (islands.length == 0 || islands[0].length == 0 || islands[0][0] == 'D')
//			return -1;
//		if (islands[0][0] == 'X')
//			return 0;
//
//		int row = islands.length, col = islands[0].length;
//		Queue<int[]> queue = new LinkedList<>();
//		int steps = 1;
//		queue.add(new int[]{0, 0});
//		islands[0][0] = 'D';
//
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//
//			for (int i = 0; i < size; ++i) {
//				int[] pos = queue.poll();
//
//				for (int[] dir : dirs) {
//
//					int x = pos[0] + dir[0];
//					int y = pos[1] + dir[1];
//					if (x < 0 || x >= row || y < 0 || y >= col || islands[x][y] == 'D')
//						continue;
//
//					if (islands[x][y] == 'X')
//						return steps;
//
//					queue.add(new int[]{x, y});
//					islands[x][y] = 'D';
//				}
//			}
//			++steps;
//		}
//		return -1;
//	}
//
//	public static void main(String[] args) {
//		test main = new test();
//		char[][] testcase = {{'O', 'O', 'O', 'O'},
//				{'D', 'O', 'D', 'O'},
//				{'O', 'O', 'O', 'O'},
//				{'X', 'D', 'D', 'O'}};
//		System.out.println(main.treasureIsland(testcase));
//	}
