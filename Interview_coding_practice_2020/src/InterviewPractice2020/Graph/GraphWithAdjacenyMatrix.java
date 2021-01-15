package InterviewPractice2020.Graph;


import java.util.*;

class EdgeMatrix {
	int startVertex;
	int endVertex;

	EdgeMatrix(int startVertex, int endVertex) {
		this.startVertex = startVertex;
		this.endVertex = endVertex;
	}
}


public class GraphWithAdjacenyMatrix {

	public static void addEdges(List<EdgeMatrix> edges) {
		int vertex = 5;
		int[][] matrix = new int[vertex + 1][vertex + 1];

		ArrayList<EdgeMatrix> edgeList = new ArrayList<>();

		for (int i = 0; i < edges.size(); i++) {
			edgeList.add(new EdgeMatrix(edges.get(i).startVertex, edges.get(i).endVertex));
		}

		for (int i = 0; i < edgeList.size(); i++) {
			int startVertex = edgeList.get(i).startVertex;
			int endVertex = edgeList.get(i).endVertex;
			matrix[startVertex][endVertex] = 1;
		}

		for (int i = 1; i <= vertex; i++) {
			for (int j = 1; j <= vertex; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(" ");
		}

	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public boolean isBipartite(int[][] graph) {
		int[] color = new int[graph.length];
		Arrays.fill(color, -1);
		for (int i = 0; i < graph.length; i++)
			if ((color[i] == -1) && !bfs(i, graph, color))
				return false;
		return true;
	}

	private boolean bfs(int node, int[][] graph, int[] color) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		color[node] = 0;
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int nei : graph[curr]) {
				if (color[nei] == color[curr])
					return false;
				if (color[nei] == -1) {
					color[nei] = 1 - color[curr];
					q.add(nei);
				}
			}
		}
		return true;
	}

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public static void main(String args[]) {


		/*                       1 2 3 4 5
		         1              1 0 0 1 1 0
               /   \			2 0 0 0 1 1
		     3 ---- 4			3 1 0 0 1 1
              \      \			4 1 1 1 0 0
		       \      2			5 0 1 1 0 0
                 \  /
		           5
		*/

		List<EdgeMatrix> edges = Arrays.asList(
				new EdgeMatrix(1, 4), new EdgeMatrix(4, 1), new EdgeMatrix(4, 2),
				new EdgeMatrix(2, 4), new EdgeMatrix(2, 5), new EdgeMatrix(5, 2),
				new EdgeMatrix(3, 5), new EdgeMatrix(5, 3), new EdgeMatrix(3, 1),
				new EdgeMatrix(1, 3), new EdgeMatrix(3, 4), new EdgeMatrix(4, 3)
		);

		addEdges(edges);
	}
}
