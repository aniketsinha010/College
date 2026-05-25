package Trees.BinaryTrees;

import java.util.Scanner;

// Here the difference from 'BinaryTree' is that we are taking Scanner sc as a global variable rather than
// input parameters to recursive methods that makes the code much cleaner...
// The display method is also different...


public class BinaryTreeTwo {

    private Node root;
    Scanner sc = new Scanner(System.in);

    public BinaryTreeTwo(){

    }

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int val){
            this.value = val;
        }
    }


    //// populate method ////
    public void populate(){
        System.out.print("Enter the root node : ");
        int val = sc.nextInt();
        root = new Node(val);
        populateRec(root);
    }
    private void populateRec(Node node){
        System.out.printf("Do you want to enter the left of %d ? ",node.value);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.printf("Enter the left of %d : ",node.value);
            int val = sc.nextInt();
            node.left = new Node(val);
            populateRec(node.left);
        }
        System.out.printf("Do you want to enter the right of %d ? ",node.value);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.printf("Enter the right of %d : ",node.value);
            int val = sc.nextInt();
            node.right = new Node(val);
            populateRec(node.right);
        }
    }


    //// display ////
    public void display(){
        displayRec(root,0);
    }
    private void displayRec(Node node,int level){
        if(node == null){
            return;
        }
        displayRec(node.right,level+1);
        for(int i=0;i<level;i++){
            System.out.print("    ");
        }
        System.out.println(node.value);
        displayRec(node.left,level+1);
    }


    //// Pre Order Traversal ////
    public void preOrderTraversal(){
        System.out.print("\nPre Order Traversal : ");
        preOrderTraversalRec(root);
    }
    private void preOrderTraversalRec(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value + " ");
        preOrderTraversalRec(node.left);
        preOrderTraversalRec(node.right);
    }


    //// In Order Traversal ////
    public void inOrderTraversal(){
        System.out.print("\nIn Order Traversal : ");
        inOrderTraversalRec(root);
    }
    private void inOrderTraversalRec(Node node){
        if(node == null){
            return;
        }
        inOrderTraversalRec(node.left);
        System.out.print(node.value + " ");
        inOrderTraversalRec(node.right);
    }


    //// Post Order Traversal ////
    public void postOrderTraversal(){
        System.out.print("\nPost Order Traversal : ");
        postOrderTraversalRec(root);
    }
    private void postOrderTraversalRec(Node node){
        if(node == null){
            return;
        }
        postOrderTraversalRec(node.left);
        postOrderTraversalRec(node.right);
        System.out.print(node.value + " ");
    }


    public static void main(String[] args) {
        BinaryTreeTwo tree = new BinaryTreeTwo();

        tree.populate();
        tree.display();
        System.out.println();

        tree.preOrderTraversal();
        tree.inOrderTraversal();
        tree.postOrderTraversal();
    }
}