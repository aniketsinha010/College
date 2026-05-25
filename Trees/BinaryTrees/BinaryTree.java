package Trees.BinaryTrees;

import java.util.Scanner;


public class BinaryTree {

    private Node root;

    // BinaryTree Constructor...
    public BinaryTree(){

    }

    private static class Node{
        int value;
        Node left;
        Node right;

        // node constructor...
        public Node(int value){
            this.value = value;
        }
    }


    // insert elements...'populate' method along with recursive helper function 'populateRec', populates the whole
    // tree based on user input rather than single insertion seen in case of linkedlist, stack & queue...
    public void populate(Scanner sc){
        System.out.print("Enter the Root Node : ");
        int value = sc.nextInt();
        root = new Node(value); // creates a new node with the input value and sets it to 'root'...
        populateRec(sc,root); // calling the recursive function on the root node...
    }
    // recursive helper method...
    private void populateRec(Scanner sc,Node node){
        System.out.printf("Do you want to enter left of %d ? : ",node.value);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.printf("Enter the value of the left of %d : ",node.value);
            int value = sc.nextInt();
            node.left = new Node(value); // creating a new node and connecting it to the current node's left pointer
            populateRec(sc,node.left); // calling the recursive function on the newly added left child...
        }
        System.out.printf("Do you want to enter right of %d ? : ",node.value);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.printf("Enter the value of the right of %d : ",node.value);
            int value = sc.nextInt();
            node.right = new Node(value);
            populateRec(sc,node.right);
        }
    }


    // display...
    public void display(){
        displayRec(root,"");
    }
    private void displayRec(Node node,String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + "└── " + node.value);
        displayRec(node.left,indent + "\t");
        displayRec(node.right,indent + "\t");
    }// problem with this display method is that it is not clear whether a child is a left child or right.


    // prettyDisplay...(90 degrees anticlockwise, showing hierarchy)...
    public void prettyDisplay(){
        prettyDisplayRec(root,0);
    }
    private void prettyDisplayRec(Node node,int level){
        if(node == null){
            return;
        }
        prettyDisplayRec(node.right,level+1);
        for(int i=0;i<level;i++){
            System.out.print("    ");
        }
        System.out.println(node.value);
        prettyDisplayRec(node.left,level+1);
    }


    ////// traversal methods...//////
    // 1. Preorder : root -> left -> right
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

    // 2. Inorder : left -> root -> right
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

    // 3. Inorder : left -> right -> root
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
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        tree.populate(sc);
        tree.display();
        System.out.println();
        System.out.println();

        tree.prettyDisplay();
        System.out.println();

        tree.preOrderTraversal();
        tree.inOrderTraversal();
        tree.postOrderTraversal();
    }
}
