package InterviewPractice2020.Tree;
import java.util.*;

// Author Jeremiah Haile
// Tree Manipulation
// 04/25/2020

// https://medium.com/@codingfreak/binary-tree-interview-questions-and-practice-problems-439df7e5ea1f


class Node {
	Node left, right;
	int data;

	Node(int value) {
		this.data = value;
	}
}

public class BinarySearchTreeManipulation {

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Inserting value into Binary Tree
	public static Node insert(Node root, int value) {
		if (root == null) {
			return new Node(value);
		}
		if (value < root.data) {
			System.out.println("  Inserted " + value + " to left of Node " + root.data);
			root.left = insert(root.left, value);
		} else {
			System.out.println("  Inserted " + value + " to right of Node " + root.data);
			root.right = insert(root.right, value);
		}
		return root;
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Searching in Binary tree
	public static boolean containsValue(Node root, int valueToFind) {

		if (root == null) {
			return false;
		} else if (valueToFind == root.data) {
			return true;
		} else if (valueToFind < root.data) {
			return containsValue(root.left, valueToFind);
		} else {
			return containsValue(root.right, valueToFind);
		}
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	  /*
												Successor & Predecessor
		Successor is the next upper value of node of the given node value. Predecessor is opposit of successor
    // Case 1 successor of the right most node subtree is null
	// Case 2 Node has right subtree, go deep to left most node in right subtree (find min value in right subtree)  (successor > and predecessor <)
	// Case 3 Node has no right subtree, go to the nearest ancestor (till ancestor node become left child) for which given node would be in left subtree
	      										15
	      		  							  *
	      									5 							Successor of 12 is 15 (by case 2) & Predecessor is 10
	      	  				              *   *							Successor of 6 is 9 (by case 3) & Predecessor is 5
	      	                             3       6						Successor of
	                                   *   *        *
	                                 1      4        10
	      		                                    *  *
	      			                              9      12

	  */


	static int successor, predecessor;

	// Successor and Predecessor With static variables
	public static void successorPredecessor(Node root, int val) {
		if (root != null) {
			if (root.data == val) {

				// go to the right most element in the left subtree, it will the
				// predecessor.
				if (root.left != null) {
					predecessor = rightMostNodeValue(root.left);
					//System.out.println("Predecessor of " + val + " is: " + predecessor);
				}
				if (root.right != null) {
					// go to the left most element in the right subtree, it will
					// the successor.
					successor = leftMostNodeValue(root.right);
					//System.out.println("Successor of " + val + " is: " + successor);
				}
			} else if (root.data >= val) {
				// we make the root as successor because we might have a
				// situation when value matches with the root, it wont have
				// right subtree to find the successor, in that case we need
				// parent to be the successor
				successor = root.data;
				successorPredecessor(root.left, val);
			} else {
				// we make the root as predecessor because we might have a
				// situation when value matches with the root, it wont have
				// left subtree to find the predecessor, in that case we need
				// parent to be the predecessor.
				predecessor = root.data;
				successorPredecessor(root.right, val);
			}
		}
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// InorderSuccessor With Return Node
	public static Node inorderSuccessor(Node root, Node val) {
		// Base case
		if (root == null) return null;

		if (root.data <= val.data) {
			// root and left subtree of root can't be successor
			return inorderSuccessor(root.right, val);
		} else {
			// root.val >= val.val
			// Successor can be either the root or in the left subtree of root
			Node left = inorderSuccessor(root.left, val);
			if (left != null) return left;
		}
		return root;
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// If no children - Just delete.
	// If a single child - Copy that child to the node.
	// If two children - Determine the next highest element (minimum value) in the right subtree. Replace the node to be removed with the inorder successor. Delete the inorder successor duplicate.

	// Deleting a node in Binary tree
	public static Node deleteRecursively(Node root, int value) {

		if (root == null)
			return root;

		if (value < root.data) {
			root.left = deleteRecursively(root.left, value);
		} else if (value > root.data) {
			root.right = deleteRecursively(root.right, value);
		} else {

			if (root.left == null) {
				return root.right;
			} else if (root.right == null)
				return root.left;

			root.data = leftMostNodeValue(root.right);
			root.right = deleteRecursively(root.right, root.data);
		}

		return root;
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Inserting value into Binary Tree
	public static Node insertIntoBST(Node root, int val) {
		if (root == null) {
			return new Node(val);
		}
		if (root.left == null && val < root.data) {
			root.left = new Node(val);
		}
		if (root.right == null && val > root.data) {
			root.right = new Node(val);
		}
		if (val < root.data) {
			insertIntoBST(root.left, val);
		} else {
			insertIntoBST(root.right, val);
		}
		return root;
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	//  min value in left subtree
	public static int leftMostNodeValue(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root.data;
	}

	// max value in right subtree
	public static int rightMostNodeValue(Node root) {
		while (root.right != null) {
			root = root.right;
		}
		return root.data;
	}


	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Inorder Traversal (left, root, right)
	public static void printInorder(Node root) {
		if (root == null)
			return;

		/* first recur on left child */
		printInorder(root.left);

		/* then print the data of root */
		System.out.print(root.data + " ");

		/* now recur on right child */
		printInorder(root.right);
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Preorder Traversal (root, left, right)
	public static void printPreorder(Node root) {
		if (root == null)
			return;

		/* first print data of root */
		System.out.print(root.data + " ");

		/* then recur on left subtree */
		printPreorder(root.left);

		/* now recur on right subtree */
		printPreorder(root.right);
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Postorder Traversal  (right, left, root)
	public static void printPostorder(Node root) {
		if (root == null)
			return;

		// first recur on left subtree
		printPostorder(root.left);

		// then recur on right subtree
		printPostorder(root.right);

		// now deal with the root
		System.out.print(root.data + " ");
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// BFS
	public static void bfs(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		if (root == null)
			return;
		queue.clear();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			System.out.print(node.data + " ");
			if (node.left != null) queue.add(node.left);
			if (node.right != null) queue.add(node.right);
		}
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// DFS (the same as BFS but we use stack because LIFO data structure needed and flip the recursion call right to left)
	public static void dfs(Node root) {
		Stack<Node> stack = new Stack<Node>();
		if (root == null)
			return;
		stack.clear();
		stack.add(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.print(node.data + " ");
			if (node.right != null) stack.add(node.right);
			if (node.left != null) stack.add(node.left);
		}
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


	// Print reverse level order traversal
	// first do leverl order traversal and add it to stack and print it
	public static void reverseBFS(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		Stack<Node> s = new Stack<Node>();
		q.add(root);// add the root node to the queue

		while (!q.isEmpty()) {
			// add the children to the queue
			Node n = q.remove();
			if (n.left != null) {
				q.add(n.left);
			}
			if (n.right != null) {
				q.add(n.right);
			}
			// add the extracted node to the Stack
			s.add(n);
		}
		// now print all the Node in Stack
		while (!s.isEmpty()) {
			System.out.print(s.pop().data + " ");
		}
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Checking if the tree is BST or not
	public static boolean isValidBST(Node root) {
		return isValidBST(root, null, null);
	}

	public static boolean isValidBST(Node root, Integer min, Integer max) {
		if (root == null)
			return true;
		if ((max != null && root.data >= max) || (min != null && root.data <= min))
			return false;
		return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
	}


	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Count number of nodes in BST
	public static int countNode(Node root) {

		//base case
		if (root == null)
			return 0;

		//recursive call to left child and right child an add the result of these with 1 ( 1 for counting the root)
		return 1 + countNode(root.left) + countNode(root.right);
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Recursive function to check if two given binary trees are identical or not
	public static boolean isIdentical(Node roo1, Node roo2) {

		// if both trees are empty, return true
		if (roo1 == null && roo2 == null) {
			return true;
		}

		// if both trees are non-empty and value of their root node matches, recur for their left and right sub-tree
		return (roo1 != null && roo2 != null) && (roo1.data == roo2.data) && isIdentical(roo1.left, roo2.left) && isIdentical(roo1.right, roo2.right);
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Recursive function to calculate height of given binary tree
	public static int height(Node root) {
		// Base case: empty tree has height 0
		if (root == null) {
			return 0;
		}

		// recur for left and right subtree and consider maximum depth
		return 1 + Math.max(height(root.left), height(root.right));
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Checks if a binary tree is full or not
	public static boolean isFullTree(Node root) {
		// if empty tree
		if (root == null)
			return true;

		// if leaf root
		if (root.left == null && root.right == null)
			return true;

		// if both left and right subtrees are not null recur on left and right subtree
		if ((root.left != null) && (root.right != null))
			return (isFullTree(root.left) && isFullTree(root.right));

		// if none work
		return false;
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible. See the following examples.
	// Check a binary tree is complete
	static boolean isCompleteBT(Node root) {
		// Base Case: An empty tree is complete Binary Tree
		if (root == null)
			return true;

		// Create an empty queue
		Queue<Node> queue = new LinkedList<>();

		// Create a flag variable
		boolean flag = false;

		// Do level order traversal using queue.
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp_node = queue.remove();

			/* Check if left child is present*/
			if (temp_node.left != null) {
				// If we have seen a non full node, and we see a nod with non-empty left child,
				// then the given tree is not a complete Binary Tree
				if (flag == true)
					return false;

				// Enqueue Left Child
				queue.add(temp_node.left);
			}
			// If this a non-full node, set the flag as true
			else
				flag = true;

			/* Check if right child is present*/
			if (temp_node.right != null) {
				// If we have seen a non full node, and we see a node
				// with non-empty right child, then the given tree is not a complete Binary Tree
				if (flag == true)
					return false;

				// Enqueue Right Child
				queue.add(temp_node.right);

			}
			// If this a non-full node, set the flag as true
			else
				flag = true;
		}
		// If we reach here, then the tree is complete Binary Tree
		return true;
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	//Check if a tree is subtree of another tree
	// A utility function to check whether trees with roots as root1 and root2 are identical
	static boolean areIdentical(Node root1, Node root2) {

		// base cases
		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		// Check if the data of both roots is same and data of left and right subtrees are also same
		return (root1.data == root2.data && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
	}

	// This function returns true if root2 is a subtree of root1, otherwise false
	static boolean isSubtree(Node root1, Node root2) {
		// base cases
		if (root2 == null)
			return true;

		if (root1 == null)
			return false;

		// Check the tree with root as current node
		if (areIdentical(root1, root2))
			return true;

		// If the tree with root as current node doesn't match then try left and right subtrees one by one */
		return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
	}

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Check if this BST is balanced or not
	// A tree is balanced if The difference between heights of left subtree and right subtree is not more than 1
	// Returns true if binary tree with root as root is height-balanced */
	public static boolean isBalanced(Node root)
	{
		int lh, rh;

		/* If tree is empty then return true */
		if (root == null)
			return true;

		/* Get the height of left and right sub trees */
		lh = checkHeight(root.left);
		rh = checkHeight(root.right);

		if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
			return true;

		/* If we reach here then tree is not height-balanced */
		return false;
	}

    // get height of tree
	static int checkHeight(Node node)
	{
		// base case tree is empty
		if (node == null)
			return 0;

		return 1 + Math.max(height(node.left), height(node.right));
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Find Vertical sum in BST
	// Recursive function to do a pre-order traversal of the tree and fill the map
	// Here node has 'dist' horizontal distance from the root of the tree
	public static void verticalSum(Node root, int dist, Map<Integer, Integer> map) {
		// base case: empty tree
		if (root == null)
			return;

		// update the map
		if (!map.containsKey(dist)) {
			map.put(dist, 0);
		}
		map.put(dist, map.get(dist) + root.data);

		// recur for left subtree by decreasing horizontal distance by 1
		verticalSum(root.left, dist - 1, map);

		// recur for right subtree by increasing horizontal distance by 1
		verticalSum(root.right, dist + 1, map);
	}

	// Function to print the vertical sum of given binary tree
	public static void verticalSum(Node root) {
		// create an empty TreeMap where
		// key -> relative horizontal distance of the node from root node and
		// value -> sum of all nodes present at same horizontal distance
		Map<Integer, Integer> map = new TreeMap<>();

		// do pre-order traversal of the tree and fill the map
		verticalSum(root, 0, map);

		// traverse the TreeMap and print vertical sum
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(+entry.getValue() + " ");
		}
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Find a diagonal sum in BST
	// Recursive function to do a pre-order traversal of the tree and
	// fill the map with diagonal sum of elements
	public static void diagonalSum(Node root, int diagonal, Map<Integer, Integer> map) {
		// base case: empty tree
		if (root == null) {
			return;
		}

		// update the current diagonal with node's value
		map.putIfAbsent(diagonal, 0);
		map.put(diagonal, map.get(diagonal) + root.data);

		// recur for left subtree by increasing diagonal by 1
		diagonalSum(root.left, diagonal + 1, map);

		// recur for right subtree with same diagonal
		diagonalSum(root.right, diagonal, map);
	}

	// Function to print the diagonal sum of given binary tree
	public static void diagonalSum(Node root) {
		// create an empty map to store diagonal sum for every slope
		Map<Integer, Integer> map = new HashMap<>();

		// do pre-order traversal of the tree and fill the map
		diagonalSum(root, 0, map);

		// traverse the map and print diagonal sum
		for (int i = 0; i < map.size(); i++) {
			System.out.print(map.get(i) + " ");
		}
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// Print vertical Order traversal in BST

	// Utility function to add an element to List corresponding to the given
	// key in a Map<Integer,List<Integer>>.
	public static void insertIntoMultiMap(Map<Integer, List<Integer>> map,
										  Integer key, Integer value) {
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<>());
		}
		map.get(key).add(value);
	}

	// Recursive function to do a pre-order traversal of the tree and fill map
	// Here node has 'dist' horizontal distance from the root of the tree
	public static void printVertical(Node node, int dist,
									 Map<Integer, List<Integer>> map) {
		// base case: empty tree
		if (node == null) {
			return;
		}

		// insert nodes present at current horizontal distance into the map
		insertIntoMultiMap(map, dist, node.data);

		// recur for left subtree by decreasing horizontal distance by 1
		printVertical(node.left, dist - 1, map);

		// recur for right subtree by increasing horizontal distance by 1
		printVertical(node.right, dist + 1, map);
	}

	// Function to perform vertical traversal of a given binary tree
	public static void printVertical(Node root) {
		// create an empty TreeMap where
		// key -> relative horizontal distance of the node from root node
		// value -> nodes present at same horizontal distance
		Map<Integer, List<Integer>> map = new TreeMap<>();

		// do pre-order traversal of the tree and fill the map
		printVertical(root, 0, map);

		// traverse the TreeMap and print vertical nodes
		for (Collection<Integer> collection : map.values()) {
			System.out.println(collection);
		}
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Print diagonal traversal in BST
	// Recursive function to do a pre-order traversal of the tree and
	// fill the map with diagonal elements
	public static void printDiagonal(Node node, int diagonal,
									 Map<Integer, List<Integer>> map) {
		// base case: empty tree
		if (node == null) {
			return;
		}

		// insert current node in current diagonal
		if (!map.containsKey(diagonal)) {
			map.put(diagonal, new ArrayList<>());
		}
		map.get(diagonal).add(node.data);

		// recur for left subtree by increasing diagonal by 1
		printDiagonal(node.left, diagonal + 1, map);

		// recur for right subtree with same diagonal
		printDiagonal(node.right, diagonal, map);
	}

	// Function to print the diagonal elements of given binary tree
	public static void printDiagonal(Node root) {
		// create an empty multi-map to store diagonal element in every slope
		Map<Integer, List<Integer>> map = new HashMap<>();

		// do pre-order traversal of the tree and fill the map
		printDiagonal(root, 0, map);

		// traverse the map and print diagonal elements
		for (int i = 0; i < map.size(); i++) {
			System.out.println(map.get(i));
		}
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Print corner nodes of every level in BST
	// Iterative function to print corner nodes of every level in binary tree
	public static void printCornderNodes(Node root) {
		// return if tree is empty
		if (root == null) {
			return;
		}

		// create an empty queue to store Tree nodes
		Queue<Node> q = new ArrayDeque<>();

		// enqueue root node
		q.add(root);

		// run till queue is not empty
		while (!q.isEmpty()) {
			// get size of current level
			int size = q.size();
			int n = size;

			// process all nodes present in current level
			while (n-- > 0) {
				Node node = q.poll();

				// if corner node found, print it
				if (n == size - 1 || n == 0) {
					System.out.print(node.data + " ");
				}

				// enqueue left and right child of current node
				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}
			}

			// terminate level by printing newline
			System.out.println();
		}
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// 1 Start from the root and compare it with x, if matched then we have found the node.
	// 2 Else go left and right.
	// 3 Recursively do step 2 and 3 till you find the node x.
	// 4 Now when you have found the node, stop the recursion.
	// 5 Now while going back to the root while back tracking, store the node values in the ArrayList.
	// 6 Reverse the ArrayList and print it.

	// Print path from root to given node
	public static boolean printPath(Node root, Node dest){

		if(root==null) return false;
		if(root.data == dest.data ||printPath(root.left,dest)||printPath(root.right,dest)){
			System.out.print("  " + root.data);
			return true;
		}
		return false;
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
// Find the diameter of a tree
	// The diameter of a tree is the number of nodes on the longest path between any two leaves in the tree.
	// The diameter of a tree T is the largest of the following quantities:
			// the diameter of T’s left subtree
			// the diameter of T’s right subtree
	// the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)

	public static int diameter(Node root, int[] height){
		if(root == null){
			height[0] = 0;
			return 0;
		}

		int[] leftHeight = {0}, rightHeight = {0};
		int leftDiam = diameter(root.left, leftHeight);
		int rightDiam = diameter(root.right, rightHeight);

		height[0] = Math.max(leftHeight[0],rightHeight[0])+1;

		return Math.max(Math.max(leftDiam, rightDiam), leftHeight[0]+rightHeight[0]+1);
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Mirror tree
	public static Node mirror(Node root){
		if(root != null) {
			mirror(root.left);
			mirror(root.right);

			Node temp = root.right;
			root.right = root.left;
			root.left = temp;
		}
		return root;
	}
		public static void  mirrorTree(Node root){
			Node miResult = mirror(root);
			printingMirrorTree(miResult);
		}

	public static void printingMirrorTree(Node root){
		if(root == null)
			return;

		printingMirrorTree(root.left);
		System.out.print( root.data + " ");
		printingMirrorTree(root.right);

	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public static void main(String[] args) {
		int[] arr = {15, 5, 6, 3, 1, 4, 10, 9, 20, 18, 12, 22};
		int[] arr2 = {15, 5, 6, 3, 1, 4, 10, 9, 20, 18, 12, 22};

		int valueToFind = 16;
		int valueToInsert = 25;
		int valueToDelete = 1;
		int valueToFindSuccessorPredecessor = 12;
		Node root = null;
		Node root2 = null;

		System.out.println(" ");
		System.out.println("Building tree with root value " + arr[0]);
		System.out.println("=================================");

		for (int i : arr) {
			root = insert(root, i);
		}

		for (int j : arr2) {
			root2 = insert(root2, j);
		}

		System.out.println(" ");
		System.out.print("Printing BST Inorder form before insertion and deletion: ");
		printInorder(root);
		System.out.println(" ");
		System.out.println("=================================");

		boolean isSubTree = isSubtree(root, root2);
		boolean fullTreeResul = isFullTree(root);
		boolean completeResul = isCompleteBT(root);
		boolean identical = isIdentical(root, root2);
		deleteRecursively(root, valueToDelete);
		insertIntoBST(root, valueToInsert);
		boolean contains = containsValue(root, valueToFind);
		int minValue = leftMostNodeValue(root);
		int maxValue = rightMostNodeValue(root);
		successorPredecessor(root, valueToFindSuccessorPredecessor);
		Node sucNode = new Node(10);
		Node result = inorderSuccessor(root, sucNode);
		boolean check = isValidBST(root);
		int countResutl = countNode(root);
		int heightResult = height(root);
		int[] height = {0};
		int diameterResult = diameter(root, height);

		System.out.print("Breadth First Search : ");
		bfs(root);
		System.out.println("");
		System.out.print("Debth First Search : ");
		dfs(root);
		System.out.println("");
		System.out.print("Reverse Breadth First Search : ");
		reverseBFS(root);
		System.out.println("");
		System.out.print("BST vertical sum are: ");
		verticalSum(root);
		System.out.println("");
		System.out.print("BST diagonal sum are: ");
		diagonalSum(root);
		System.out.println("");
		System.out.println("BST vertical order traversal: ");
		printVertical(root);
		System.out.println("");
		System.out.println("BST diagonal order traversal: ");
		printDiagonal(root);
		System.out.println("");
		System.out.println("BST corner nodes are: ");
		printCornderNodes(root);
		System.out.println("");
		System.out.print("BST path from root to node " + sucNode.data + " is: " );
		printPath(root,sucNode );
		System.out.println("");
		System.out.print("Printing a mirror tree: " );
		mirrorTree(root);
		System.out.println("");






		System.out.println("This BST diameter is : " + diameterResult);
		System.out.println("BST 1 is subtree of BST 2: " + isSubTree);
		System.out.println("This tree is complete: " + completeResul);
		System.out.println("This tree is full: " + fullTreeResul);
		System.out.println("This height of tree is : " + heightResult);
		System.out.println("BST X and BST Y are identical : " + identical);
		System.out.println("This BST has: " + countResutl + " nodes");
		System.out.println("This tree is BST: " + check);
		System.out.println("Successor with returning method for value of " + sucNode.data + " is: " + result.data);
		System.out.println("Successor of " + valueToFindSuccessorPredecessor + " is: " + successor + " Predecessor of " + valueToFindSuccessorPredecessor + " is: " + predecessor);
		System.out.println("This BST Contains " + valueToFind + " : " + contains);
		System.out.println("Minimum Value in BST is: " + minValue);
		System.out.println("Maximum Value in BST is: " + maxValue);
		System.out.println("Deleted value in BST is: " + valueToDelete + " Inserted value in BST is: " + valueToInsert);
		System.out.println("=================================");

		System.out.print("Printing BST Inorder form after insertion and deletion: ");
		printInorder(root);
		System.out.println(" ");

		System.out.print("Printing BST Preorder form after insertion and deletion: ");
		printPreorder(root);
		System.out.println(" ");

		System.out.print("Printing BST Postorder form after insertion and deletion: ");
		printPostorder(root);
		System.out.println(" ");

	}
}

