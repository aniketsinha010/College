package Trees.SegmentTrees;

////////////////////////////////// not very clear////////////////////////

// Segment trees are Binary Trees used to answer range-based queries efficiently on an array.
// ST is a full Binary Tree i.e, every node except the leaf node has exactly 2 children.
// Here, each node represents a range and stores the result of the query for that range.

public class SegmentTree {

    private Node root;

    private static class Node{
        int data;
        int startIndex;
        int endIndex;
        Node left;
        Node right;

        public Node(int start,int end){
            this.startIndex = start;
            this.endIndex = end;
        }
    }

    // The segment tree constructor takes an array argument. We need to construct a tree using that array...
    public SegmentTree(int[] arr){
        this.root = constructTree(arr,0,arr.length-1);
    }

    // method to construct the tree...
    private Node constructTree(int[] arr,int start,int end){
        // Every time the function is called, it creates a new Node...
        // This node represents a specific range (from start to end) of the original array...
        Node node = new Node(start,end);

        if(start == end){ //leaf node...
            node.data = arr[start]; // storing value of the start index...
            return node;
        }

        // Find mid to split segment...
        int mid = start + (end - start) / 2;

        // Recursively construct left & right subtrees...
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        // Each node stores sum of children...
        node.data = node.left.data + node.right.data;

        return node;
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
            System.out.print("              ");
        }
        System.out.println("[" + node.startIndex + "," + node.endIndex + "] = " + node.data);
        displayRec(node.left,level+1);
    }


    // method to find query...(taking Sum in this case)
    public int querySum(int qs,int qe){
        return querySumRec(root,qs,qe);
    }
    private int querySumRec(Node node,int qs,int qe){
        // Case 1 : Complete Overlap i.e, node is completely within query interval...
        if(node.startIndex >= qs && node.endIndex <= qe){
            return node.data;
        }
        // Case 2 : No Overlap i.e, node is completely outside query interval...
        if(node.startIndex > qe || node.endIndex < qs){
            return 0;
        }
        // Case 3 : Partial Overlap, check both children...
        return querySumRec(node.left,qs,qe) + querySumRec(node.right,qs,qe);
    }


    // updating any value of the tree...
    public void update(int index,int newValue){
        updateRec(root,index,newValue);
    }
    private void updateRec(Node node,int index,int newValue){
        // Base Case : leaf node...
        if(node.startIndex == node.endIndex){
            node.data = newValue;
            return;
        }
        int mid = node.startIndex + (node.endIndex - node.startIndex) / 2;

        if(index <= mid){
            updateRec(node.left,index,newValue);
        }else{
            updateRec(node.right,index,newValue);
        }
        // updating current node values...
        node.data = node.left.data + node.right.data;
    }



    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        SegmentTree tree = new SegmentTree(array);
        tree.display();
        System.out.println();

        System.out.println("-----------------------------------------------------");
        System.out.println(tree.querySum(0,3));
        System.out.println("-----------------------------------------------------");
        System.out.println();

        tree.update(0,10);
        tree.display();
    }
}