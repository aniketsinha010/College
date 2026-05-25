package Trees.BinarySearchTrees;

/// AVL Tree is a self-balancing Binary Search Tree ///
/// See theory part and 4 rules from video.

/*
AVL Rotation Notes (P = parent, C = child, G = grandchild)

P is the first imbalanced node from the bottom.
The new entry lies in the subtree of G.

LL Case (P left-heavy, C = P.left, G = C.left):
→ Single Right Rotate on P

LR Case (P left-heavy, C = P.left, G = C.right):
→ Left Rotate on C, then Right Rotate on P

RR Case (P right-heavy, C = P.right, G = C.right):
→ Single Left Rotate on P

RL Case (P right-heavy, C = P.right, G = C.left):
→ Right Rotate on C, then Left Rotate on P
*/


public class AVL {

    private Node root;

    public AVL(){

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


    // display method...
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


    // method to find height...
    private int findHeight(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }


    // method to check if the tree is balanced...
    public boolean isBalanced(){
        return isBalancedRec(root);
    }
    private boolean isBalancedRec(Node node){
        if(node == null){
            return true;
        }
        if(Math.abs(findHeight(node.left)-findHeight(node.right)) > 1){
            return false;
        }
        return isBalancedRec(node.left) && isBalancedRec(node.right);
    }


    // insert method...
    public void insert(int val){
        root = insertRec(root,val);
    }
    private Node insertRec(Node node,int val){
        if(node == null){
            return new Node(val);
        }
        if(val < node.value){
            node.left = insertRec(node.left,val);
        }
        if(val > node.value){
            node.right = insertRec(node.right,val);
        }
        node.height = Math.max(findHeight(node.left),findHeight(node.right))+1;

        return rotate(node);  // this is different from normal BST...
    }


    /////////////////////////////////////////  Rotate method and its helpers  /////////////////////////////////////////

    private Node rotate(Node node){
        int balance = findHeight(node.left) - findHeight(node.right);
        // 1) If 'balance' > 1 that means the tree is left heavy. So it can be either of the two cases :
        if(balance > 1){
            // 1.1) left-left Case : [ findHeight(node.left.left) - findHeight(node.left.right) > 0 ]
            if(findHeight(node.left.left) - findHeight(node.left.right) > 0){
                return rightRotate(node);
            }
            // 1.2) left-right Case : [ findHeight(node.left.left) - findHeight(node.left.right) < 0 ]
            if(findHeight(node.left.left) - findHeight(node.left.right) < 0){
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        // 2) If 'balance' < -1 that means the tree is right heavy. So it can be either of the two cases :
        if(balance < -1){
            // 2.1) right-right Case : [ findHeight(node.right.right) - findHeight(node.right.left) > 0 ]
            if(findHeight(node.right.right) - findHeight(node.right.left) > 0){
                return leftRotate(node);
            }
            // 2.2) right-left Case : [ findHeight(node.right.right) - findHeight(node.right.left) < 0 ]
            if(findHeight(node.right.right) - findHeight(node.right.left) < 0){
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    /*  NOTE : The 'rotate' method itself is NOT recursive. It only fixes imbalance at the current node.
    However, because 'insertRec' is recursive and calls 'rotate' on the way back up, every ancestor node
    gets checked and balanced as recursion unwinds.
    */
    private Node rightRotate(Node p){ // draw the tree and visualize...
        Node c = p.left;
        Node t = c.right;

        // after rotation...
        c.right = p;
        p.left = t;

        // updating height...
        p.height = Math.max(findHeight(p.left),findHeight(p.right)) + 1;
        c.height = Math.max(findHeight(c.left),findHeight(c.right)) + 1;

        return c;
    }
    private Node leftRotate(Node p){
        Node c = p.right;
        Node t = c.left;

        // after rotation...
        c.left = p;
        p.right = t;

        // updating height...
        p.height = Math.max(findHeight(p.left),findHeight(p.right)) + 1;
        c.height = Math.max(findHeight(c.left),findHeight(c.right)) + 1;

        return c;
    }
    /* NOTE : Here in the 'rightRotate' & 'leftRotate' methods we don't make the parent of 'p' to point to 'c'
    after rotation. These rotation methods only rearrange the local subtree. 'p' is the old root of this subtree
    and 'c' becomes the new root after rotation. The method returns 'c' (the new subtree root), and because
    'insertRec' is recursive, the caller automatically assigns that returned root back to either parent.left or
    parent.right. Therefore, we do NOT manually connect the parent of 'p' to 'c' inside these rotation methods.
    */

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        AVL tree = new AVL();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        tree.display();
    }
}
