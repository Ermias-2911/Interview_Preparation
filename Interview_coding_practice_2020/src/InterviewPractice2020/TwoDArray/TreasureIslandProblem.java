package InterviewPractice2020.TwoDArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreasureIslandProblem {

     int i = 0;
	 int distance = Integer.MAX_VALUE;

	static List<List<Integer>>  list = new ArrayList<>();
	public void findShortestRoute(char[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		//int[][] arr = new int[grid.length][2];

//		for(int i = 0; i < grid.length; i++){
//			for (int j = 0; j < grid[0].length; j++){
//                  if (grid[i][j] == 'O'){
//
//
//				  }
//			}
//		}
		int i = 0, j = 0;
		List<List<Integer>> re = DFS(grid, i, j,  0);

		// For test purpose
		for (List<Integer> l : re) {
			System.out.print(l);
		}
	}

    int count = 0;
	public  List<List<Integer>> DFS(char[][] grid, int row, int col, int level) {

		if (col < 0 || col >= grid[0].length || row < 0 || row >= grid.length  || grid[row][col] == 'D') {
			return list;
		}

        list.add(i, new ArrayList<>(Arrays.asList(row, col)));
		i++;
		count++;

		if (grid[row][col] == 'X') {

			distance = Math.min(distance, level);
			System.out.println(" Count " + count + " Distance: " + distance);
			return list;
		}
			grid[row][col] = 'D';

			DFS(grid, row, col + 1, level + 1);
			DFS(grid, row - 1, col, level + 1);
			DFS(grid, row, col - 1, level + 1);
			DFS(grid, row + 1, col, level + 1);

			grid[row][col] = 'O';

		return list;
	}

	public static void main(String[] args) {
		char[][] ch = {{'O', 'O', 'O', 'O'},
				       {'D', 'O', 'D', 'O'},
				       {'O', 'O', 'O', 'O'},
				       {'X', 'D', 'D', 'O'}};
		TreasureIslandProblem ob = new TreasureIslandProblem();
		ob.findShortestRoute(ch);
		//System.out.println(result);
	}
}
