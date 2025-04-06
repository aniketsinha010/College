package Exam_DAA;

import java.util.*;

public class Assignment23 {

    // Binary Search Tree Node
    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    // Stores nodes on the path, and nodes to the left and right of path
    static List<Integer> path = new ArrayList<>();
    static List<Integer> leftOfPath = new ArrayList<>();
    static List<Integer> rightOfPath = new ArrayList<>();

    // Search and record the path, left and right side nodes
    static boolean search(Node root, int key) {
        if (root == null) return false;

        path.add(root.key);

        if (key < root.key) {
            if (root.right != null)
                rightOfPath.add(root.right.key);
            return search(root.left, key);
        } else if (key > root.key) {
            if (root.left != null)
                leftOfPath.add(root.left.key);
            return search(root.right, key);
        } else {
            // key found (leaf node assumed)
            return true;
        }
    }

    public static void main(String[] args) {
        // Construct the counterexample BST:
        //       10
        //         \
        //         15
        //        /
        //       7

        Node root = new Node(10);
        root.right = new Node(15);
        root.right.left = new Node(7);

        int keyToSearch = 7;
        boolean found = search(root, keyToSearch);

        if (found) {
            System.out.println("Search Path (B): " + path);
            System.out.println("Left of Path (A): " + leftOfPath);
            System.out.println("Right of Path (C): " + rightOfPath);

            // Show a counterexample triple
            if (!leftOfPath.isEmpty() && !rightOfPath.isEmpty()) {
                int a = leftOfPath.get(0);
                int b = path.get(1); // 15 in this example
                int c = rightOfPath.get(0);
                System.out.printf("Counterexample: a = %d, b = %d, c = %d%n", a, b, c);
                System.out.printf("Does a ≤ b ≤ c? %b%n", a <= b && b <= c);
            } else {
                System.out.println("Couldn't extract full counterexample triple.");
            }
        } else {
            System.out.println("Key not found.");
        }
    }
}
