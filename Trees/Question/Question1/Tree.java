package Trees.Question.Question1;

// --------------------------------------------------------------------------------------------------------------------
// Extra Question 1) Find the level Order Successor of a Node.
// --------------------------------------------------------------------------------------------------------------------

import java.util.*;

public class Tree {

    private static class TreeNode {
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
    }


    public TreeNode levelOrderSuccessor(TreeNode root,int key){
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            // We don't need the inner 'for' loop like in LeetCode 102.
            // In LeetCode 102 we needed level-wise grouping, so we processed nodes level by level.
            // Here we just want the next node in BFS order, so we process nodes continuously (normal BFS).
            TreeNode currentNode = queue.remove();
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
            if(currentNode.val == key){
                break;
            }
        }
        return queue.peek();
    }


    // Can ignore this part, not important. Copied from AI...
    public static void main(String[] args) {
        Tree tree = new Tree();

        /*
                 10
                /  \
               6    15
              / \     \
             3   8     20
        */

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(20);
        System.out.println();

        int key = 3;
        TreeNode successor = tree.levelOrderSuccessor(root, key);

        if (successor != null) {
            System.out.println("Level order successor of " + key + " is: " + successor.val);
        } else {
            System.out.println("No level order successor found for " + key);
        }
    }
}
