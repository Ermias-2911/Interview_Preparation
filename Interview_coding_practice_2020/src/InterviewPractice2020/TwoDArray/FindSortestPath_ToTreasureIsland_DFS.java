package InterviewPractice2020.TwoDArray;

// Find a shortest route to the treasure island X.
// Grid marked with D are lands or blocks
public class FindSortestPath_ToTreasureIsland_DFS {


	 int distance = Integer.MAX_VALUE;

	public int  findShortestRoute(char[][] grid) {
		int i = 0, j = 0;
	      DFS(grid, i, j,  0);
		  return distance;
	}


	public  void DFS(char[][] grid, int row, int col, int level) {

		if (col < 0 || col >= grid[0].length || row < 0 || row >= grid.length || grid[row][col] == 'D') {
			return;
		}

		if (grid[row][col] == 'X') {
			distance = Math.min(distance, level);
			return;
		}

			// Make the current index visited
			grid[row][col] = 'D';

			DFS(grid, row, col + 1, level + 1);
			DFS(grid, row - 1, col, level + 1);
			DFS(grid, row, col - 1, level + 1);
			DFS(grid, row + 1, col, level + 1);

			grid[row][col] = 'O';
	}

	public static void main(String[] args) {
		char[][] ch = {{'O', 'O', 'O', 'O'},
				       {'D', 'O', 'D', 'O'},
				       {'O', 'O', 'O', 'O'},
				       {'X', 'D', 'D', 'O'}};
		FindSortestPath_ToTreasureIsland_DFS ob = new FindSortestPath_ToTreasureIsland_DFS();
		int result = ob.findShortestRoute(ch);
		System.out.println(" Shortest path to island X is: ===>  " + result );
	}
}
