package InterviewPractice2020.Graph;// BFS algorithm in Java

import java.util.*;

public class GraphWithLinkedList {

	private int vertices;
	private LinkedList<Integer> adj[];

	// Create a graph
	GraphWithLinkedList(int v) {
		vertices = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}


	// Add edges to the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
		System.out.println("added edges: 	" + Arrays.toString(adj));
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


	// BFS algorithm
	void BFS(int v) {
		boolean visited[] = new boolean[vertices];
		LinkedList<Integer> queue = new LinkedList();

		visited[v] = true;
		queue.add(v);

		while (queue.size() != 0) {
			v = queue.poll();
			System.out.print(v + " ");

			Iterator<Integer> i = adj[v].iterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// DFS algorithm
	void DFS(int v)
	{
		// Mark all the vertices as not visited (set as false by default in java)
		boolean visited[] = new boolean[vertices];

		// Call the recursive helper function to print DFS traversal
		DFSUtil(v, visited);
	}

	// A function used by DFS
	void DFSUtil(int v,boolean visited[])
	{
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v+" ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].iterator();
		while (i.hasNext())
		{
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}


	public static void main(String args[]) {
		GraphWithLinkedList g = new GraphWithLinkedList(4);
     /*
		0 - - - - > 1
	    A         /
		|       /
		|     /
		|   /
        V <
        2 - - - - > 3<
    */
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		System.out.print(" BFS traversal: ");
		g.BFS(2);
		System.out.println(" ");
		System.out.print(" DFS traversal: ");
		g.DFS(2);
	}
}