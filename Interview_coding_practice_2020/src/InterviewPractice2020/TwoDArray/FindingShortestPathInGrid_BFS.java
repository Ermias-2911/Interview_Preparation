package InterviewPractice2020.TwoDArray;

import java.util.*;

public class FindingShortestPathInGrid_BFS {

		final static int[][] dir = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
		public static int findingTheShortestPath(char[][] ch) {
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[]{0, 0});
			int counter = 1;

			while (!q.isEmpty()) {
				int qSize = q.size();

				for (int i = 0; i < qSize; i++) {
					int[] pos = q.poll();

					for (int[] di : dir) {
						int row = pos[0] + di[0];
						int col = pos[1] + di[1];

						if (row < 0 || row > ch.length || col < 0 || col > ch[0].length - 1 || ch[row][col] == 'D') {
							continue;
						}

						if (ch[row][col] == 'X') {
							return counter;
						}

						ch[row][col] = 'D';
						q.add(new int[]{row, col});
					}
				}
				counter++;
			}
			return 0;
		}

		public static void main(String[] args) {
			char[][] testcase = {{'O', 'O', '0', 'O'},
					{'O', 'O', 'X', 'O'},
					{'O', 'O', 'O', 'O'},
					{'O', 'D', 'D', 'O'}};
			System.out.println( " Result: " + findingTheShortestPath(testcase));
		}
	}
