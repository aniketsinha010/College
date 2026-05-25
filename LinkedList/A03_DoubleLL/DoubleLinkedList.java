package LinkedList.A03_DoubleLL;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList(){
        this.size = 0;
    }

    private class Node{
        Node previous;
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    // Inserting at front...
    public void insertFirst(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    // Display...
    public void display(){
        if(head == null){
            System.out.println("The list is empty.");
            return;
        }
        Node tempNode = head;
        System.out.print("null -> ");
        while(tempNode != null){
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println("null");
    }

    // Reverse Display...
    public void reverseDisplay(){
        if(head == null){
            System.out.println("The list is empty.");
            return;
        }
        Node tempNode = tail;
        System.out.print("null -> ");
        while(tempNode != null){
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.previous;
        }
        System.out.println("null");
    }

    // Inserting at last position...
    public void insertEnd(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    // Inserting at a particular index...
    public void insertAtPosition(int pos, int val){
        if(pos < 0 || pos > size){
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        else if (pos == 0){
            insertFirst(val);
            return;
        }
        else if (pos == size){
            insertEnd(val);
            return;
        }
        else {
            Node tempNode = head;
            Node postNode; // this is the node after the inserted newNode...
            Node newNode = new Node(val);
            for(int i = 0; i < pos - 1 ; i++){
                tempNode = tempNode.next;
            }
            postNode = tempNode.next;
            newNode.next = postNode;
            postNode.previous = newNode;
            tempNode.next = newNode;
            newNode.previous = tempNode;
            size++;
        }
    }

    // Inserting after a given value...
    public void insertAfterValue(int given, int val){
        if (head == null) { // Check if the list is empty
            System.out.println("List is empty. Cannot insert after " + given);
            return;
        }
        Node newNode = new Node(val);
        Node tempNode = head;
        Node postNode;
        boolean bool = search(given);
        if(!bool){
            System.out.println("Value " + given + " not found in the list, so "+val+" can't be inserted.");
            return;
        }
        while(tempNode.data != given){
            tempNode = tempNode.next;
        }
        postNode = tempNode.next;
        newNode.next = postNode;
        tempNode.next = newNode;
        newNode.previous = tempNode;
        // If postNode is not null, update its previous pointer
        if (postNode != null) {
            postNode.previous = newNode;
        } else {
            // If postNode is null, it means we are inserting at the end
            tail = newNode; // Update the tail to the new node
        }
        size++;
    }

    // Deleting from the front...
    public void deleteFirst(){
        if(head == null){
            System.out.println("The list is empty.");
        }
        else if(head.next == null){
            head = null;
            tail = null;
            size--;
        }
        else{
            head = head.next;
            head.previous = null;
            size--;
        }
    }

    // Deleting from the end...
    public void deleteEnd(){
        if(head == null){
            System.out.println("The list is empty.");
        }
        else if(head.next == null){
            head = null;
            tail = null;
            size--;
        }
        else{
            tail = tail.previous;
            tail.next = null;
            size--;
        }
    }

    // Deleting from a certain position...
    public void deleteAtPosition(int pos){
        if (pos < 0 || pos > size-1) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        else if(pos == 0){
            deleteFirst();
            return;
        }
        else if(pos == size -1 ){
            deleteEnd();
            return;
        }
        else{
            Node tempNode = head;
            Node postNode;
            for(int i = 0; i < pos-1 ; i++){
                tempNode = tempNode.next;
            }
            postNode = tempNode.next.next;
            tempNode.next = postNode;
            postNode.previous = tempNode;
            size--;
        }
    }

    // Deleting after a value...
    public void deleteAfterValue(int given){
        if(head == null){
            System.out.println("The list is empty.");
            return;
        }
        boolean bool = search(given);
        if(!bool){
            System.out.println("Value " + given + " not found in the list.");
            return;
        }
        if(head.next == null){
            System.out.println("Can't delete after " + given + " as it is the last node.");
            return;
        }
        Node tempNode = head;
        Node postNode;
        while(tempNode.data != given){
            tempNode = tempNode.next;
        }
        postNode = tempNode.next.next;
        tempNode.next = postNode;
        if(postNode != null){
            postNode.previous = tempNode;
        }
        else {
            tail = tempNode;
        }
        size--;
    }

    // Searching for an element in the list...
    public boolean search(int given){
        Node tempNode = head;
        for(int i = 0; i< size ; i++){
            if(tempNode.data == given){
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }





    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        System.out.println();

        list.insertFirst(1992);
        list.insertFirst(2006);
        list.insertFirst(2009);
        list.insertFirst(2011);
        list.insertFirst(2015);
        list.display();
        list.reverseDisplay();
        System.out.println();

        list.insertEnd(1899);
        list.display();
        System.out.println();

        list.insertAtPosition(0,100);
        list.insertAtPosition(list.size, 200);
        list.insertAtPosition(5, 2003);
        list.display();
        list.reverseDisplay();
        System.out.println();

        list.insertAfterValue(500,600);
        list.insertAfterValue(2003 , 2000);
        list.display();
        System.out.println();

        list.deleteFirst();
        list.display();
        System.out.println();

        list.deleteEnd();
        list.display();
        System.out.println();

        list.deleteAtPosition(4);
        list.display();
        System.out.println();

        list.deleteAfterValue(2);
        list.deleteAfterValue(2006);
        list.display();
    }
}

