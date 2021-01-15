package InterviewPractice2020.TwoDArray;

public class TwoDArrayProblems {
//   https://youtu.be/LVlihRYfVVw
///////////////////////////////////////////////////////////////////////////////////////////////////
              // Finding Connected Adjacent Once Horizontaly or Vertically
static int countConnectedOnce;

    public static int  findConnectedOnce(int[][] grid){
    	int count = 0;
    	for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == 1){
				int result =    dfsMark(grid, i, j);
					System.out.println("There are: " + result + " Connected once ");
					countConnectedOnce = 0;
					count++;
				}
			}
		}
    	return count;
	}

	// Dfs to mark the visited vertex
	private static int  dfsMark(int[][] grid, int col, int row) {

    	// Check  all constraints boundary, left, right, up, down, and value
    	if (col < 0 || row < 0 || col > grid.length - 1 || row > grid[0].length -1 || grid[col][row] == 0){
        	return 0 ;
		}

    	// Make the current index visited
    	grid[col][row] = 0;

		countConnectedOnce++;

		dfsMark(grid, col , row + 1);
		dfsMark(grid, col, row - 1);
		dfsMark(grid, col + 1, row);
		dfsMark(grid, col - 1, row);
		return countConnectedOnce;
	}


	// driver method
	public static void main(String[] args) {
		int grid[][] = 	{{1, 1, 0, 0},
						 {1, 1, 0, 0},
						 {0, 0, 0, 0},
						 {0, 1, 0, 1}};
		int result = findConnectedOnce(grid);
		System.out.println(result);
	}
}
