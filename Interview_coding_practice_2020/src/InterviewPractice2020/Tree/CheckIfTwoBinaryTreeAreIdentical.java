package InterviewPractice2020.Tree;

public class CheckIfTwoBinaryTreeAreIdentical {

    // A class to store a binary tree node
    static class Node {
        int key;
        Node left = null, right = null;

        Node(int key) {
            this.key = key;
        }
    }

    // Recursive function to check if two given binary trees are identical or not
    public static boolean isIdentical(Node x, Node y) {
        // if both trees are empty, return true
        if (x == null && y == null) {
            return true;
        }

        // if both trees are non-empty and the value of their root node matches,
        // recur for their left and right subtree
        return (x != null && y != null) && (x.key == y.key) &&
                isIdentical(x.left, y.left) &&
                isIdentical(x.right, y.right);
    }

    public static void main(String[] args) {
        // construct the first tree
        Node x = new Node(15);
        x.left = new Node(10);
        x.right = new Node(20);
        x.left.left = new Node(8);
        x.left.right = new Node(12);
        x.right.left = new Node(16);
        x.right.right = new Node(25);

        // construct the second tree
        Node y = new Node(15);
        y.left = new Node(10);
        y.right = new Node(20);
        y.left.left = new Node(8);
        y.left.right = new Node(12);
        y.right.left = new Node(16);
        y.right.right = new Node(25);

        if (isIdentical(x, y)) {
            System.out.println("The given binary trees are identical");
        } else {
            System.out.println("The given binary trees are not identical");
        }
    }
}
