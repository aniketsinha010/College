package Trees.BinarySearchTrees;

// in case of normal Binary Search Tree , 'height' can be ignored. It is required for AVL trees...

public class BST {

    private Node root;

    public BST(){

    }

    private static class Node{
        int value;
        Node left;
        Node right;
        int height;

        public Node(int val){
            this.value = val;
        }
    }


    // method to find height of current node...here this method is made private because public method can't take node
    // as parameter as Node class is also defined private.
    private int findHeight(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }


    // method to check if tree is empty...
    public boolean isEmpty(){
        return root == null;
    }


    // display...
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


    // insert...(different from populate method in BinaryTree), here inserting one element at a time...
    public void insert(int val){
        root = insertRec(root,val);
    }
    private Node insertRec(Node node,int val){ // this method returns the root of the updated subtree...
        if(node == null){
            return new Node(val);
        }
        if(val < node.value){
            node.left = insertRec(node.left,val);
        }
        if(val > node.value){
            node.right = insertRec(node.right,val);
        }
        // updating height...
        node.height = Math.max(findHeight(node.left),findHeight(node.right))+1;
        // insertRec() goes down to find the insertion spot, and then on the way back up, it visits every parent
        // node on that path and updates its height...

        return node;
    }


    // method to check if the tree is balanced...
    public boolean isBalanced(){
        return isBalancedRec(root);
    }
    private boolean isBalancedRec(Node node){
        if(node == null){
            return true; // An empty tree is always balanced...
        }
        if(Math.abs(findHeight(node.left)-findHeight(node.right)) > 1){
            return false;
        }
        return isBalancedRec(node.left) && isBalancedRec(node.right);
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
        BST tree = new BST();
        System.out.println(tree.isEmpty());
        System.out.println(tree.isBalanced()); // empty tree is balanced...
        System.out.println();

        tree.insert(7);
        tree.insert(5);
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.insert(11);
        tree.display();
        System.out.println();

        System.out.println(tree.isBalanced());

        tree.preOrderTraversal();
        tree.inOrderTraversal();
        tree.postOrderTraversal();
    }
}
