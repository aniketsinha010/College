package Trees.Practice;

////////// SEGMENT TREES ///////////

public class Tree{

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

    // tree constructor...
    public Tree(int[] arr){
        root = constructTree(arr,0,arr.length-1);
    }

    private Node constructTree(int[] arr,int start,int end){
        Node node = new Node(start, end);
        if(start == end){
            node.data = arr[start];
            return node;
        }
        int mid = (start+end)/2;
        node.left = constructTree(arr,start,mid);
        node.right = constructTree(arr,mid+1,end);
        node.data = node.left.data + node.right.data;
        return node;
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
    }
}