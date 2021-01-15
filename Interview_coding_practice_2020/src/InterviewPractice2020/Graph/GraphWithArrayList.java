package InterviewPractice2020.Graph;

import java.util.*;

// data structure to store graph edges
class Edge {
	int src, dest;

	Edge(int source, int dest) {
		this.src = source;
		this.dest = dest;
	}
}

// Graph represents Adjacency List
public class GraphWithArrayList {

	// A list of lists  to represent adjacency list
	List<List<Integer>> adjList = new ArrayList<>();

	public GraphWithArrayList(List<Edge> edges, int n) {
		// allocate memory for adjacency list
		for (int i = 0; i < n; i++)
			adjList.add(i, new ArrayList<>());

		// add edges to the undirected graph
		for (int i = 0; i < edges.size(); i++) {

			int src = edges.get(i).src;
			int dest = edges.get(i).dest;

			// allocate new node in adjacency List from src to dest
			adjList.get(src).add(dest);
			adjList.get(dest).add(src);
		}
		System.out.println("edges added into addjList: " + adjList.toString() + " ");
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// print adjacency list representation of graph
	private static void printGraph(GraphWithArrayList graphWithArrayList) {
		int src = 0;
		int n = graphWithArrayList.adjList.size();

		while (src < n) {
			// print current vertex and all its neighboring vertices
			for (int dest : graphWithArrayList.adjList.get(src))
				System.out.print("(" + src + " --> " + dest + ")\t");

			System.out.println();
			src++;
		}
	}
// edges added into addjList: [[], [2, 3, 4], [1, 5, 6], [1], [1, 7, 8], [2, 9, 10], [2], [4, 11, 12], [4], [5], [5], [7], [7], [], []]

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Perform BFS on graph starting from vertex v
	// Perform BFS recursively on graph
	public static void BFS(GraphWithArrayList graphWithArrayList, Queue<Integer> q, boolean[] discovered) {

		if (q.isEmpty())
			return;

		// pop front node from queue and print it
		int v = q.poll();
		System.out.print(v + " ");

		// do for every edge (v -> u)
		for (int u : graphWithArrayList.adjList.get(v)) {
			if (!discovered[u]) {
				// mark it discovered and push it into queue
				discovered[u] = true;
				q.add(u);
			}
		}

		BFS(graphWithArrayList, q, discovered);
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Directed Graph Implementation in Java
	public static void main(String[] args) {

    /*
		                                         1
			                    	         *   *   *
			                              2 	 3     4
			                    	   *  *			   *  *
		                             5    6			   7    8
	                               * *                 *  *
		                         9   10                11  12
	*/

		// List of graph edges as per above diagram
		List<Edge> edges = Arrays.asList(
				new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
				new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
				new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
				new Edge(7, 11), new Edge(7, 12)
				// vertex 0, 13 and 14 are single nodes
		);


		// Set number of vertices in the graph
		final int N = 15;
		// create a graph from edges
		GraphWithArrayList graphWithArrayList = new GraphWithArrayList(edges, N);

		// stores vertex is discovered or not
		boolean[] discovered = new boolean[N];

		// create a queue used to do BFS
		Queue<Integer> q = new ArrayDeque<>();

		// Do BFS traversal from all undiscovered nodes to
		// cover all unconnected components of graph
		for (int i = 0; i < N; i++) {
			if (discovered[i] == false) {
				// mark source vertex as discovered
				discovered[i] = true;

				// push source vertex into the queue
				q.add(i);

				// start BFS traversal from vertex i
				BFS(graphWithArrayList, q, discovered);
			}
		}

		// print adjacency list representation of the graph
		printGraph(graphWithArrayList);
	}
}

