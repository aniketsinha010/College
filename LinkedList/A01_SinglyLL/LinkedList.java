package LinkedList.A01_SinglyLL;

public class LinkedList {

    private Node head; // Node class is made below...
    private Node tail; // tail points to last element of the list...
    private int size;

    // constructor with no argument....
    public LinkedList(){
        this.size = 0;
    }

    // creating inner 'Node' Class...
    private static class Node{
        // we don't anyone to access these directly, i.e, they are made private...
        private int data;
        private Node next;

        // constructor...
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        // constructor with no 'next'...
        public Node(int data){
            this.data = data;
        }
    }

    // Insertion at beginning...
    public void insertFirst(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;

        if(tail == null){
           // 'tail == null' means that the list is empty...
           tail = newNode; // so tail is now pointing to the last and only element of the list...
        }

        size++; // Increment the size of the list...
    }

    // Display...
    public void display(){
        if(head == null){
            System.out.println("The list is empty.");
        }
        else{
            Node tempNode = head;
            while(tempNode != null){
                System.out.print(tempNode.data + " -> ");
                tempNode = tempNode.next;
            }
            System.out.println("null"); // indicating the end of the list...
        }
    }

    // Insertion at the end...
    public void insertEnd(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Inserting at a certain position...(index starting from 0)
    public void insertAtPosition(int pos,int val){
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        else if(pos == 0){
            insertFirst(val);
        }
        else if (pos == size) {
            insertEnd(val);
        }
        else {
            int count = 0;
            Node tempNode = head;
            Node newNode = new Node(val);
            while (count < pos - 1) {
                tempNode = tempNode.next;
                count++;
            }
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            size++;
        }
    }

    // Deleting from first...
    public void deleteFirst(){
        if(head == null){
            System.out.println("The list is empty.");
        }
        else{
            head = head.next;
            if(head == null){ // when the list empties after deletion...
                tail = null;  // setting tail to null...
            }
            size--;
        }
    }


    // Delete last element...
    public void deleteEnd(){
        if(head == null){
            System.out.println("The list is empty.");
        }
        else if(head.next == null){ // when there is only one element
            head = null;
            tail = null;
            size--;
        }
        else{
            Node tempNode = head;
            while(tempNode.next.next != null){
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        }
    }

    // Deleting from a certain position...(index starting from 0)
    public void deleteAtPosition(int pos){
        if (pos < 0 || pos > size-1) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        else if(pos == 0){
            deleteFirst();
        }
        else if(pos == size -1 ){
            deleteEnd();
        }
        else {
            Node tempNode = head;
            for(int i=0; i<= pos-2 ; i++){  // (int i=0; i< pos-1 ; i++) does the same job...
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    // Searching for a value in the list...
    public void findValue(int val){
        Node tempNode = head;
        while(tempNode != null){
            if(tempNode.data == val){
                System.out.println(val + " is present in list.");
                return; // Exits the method if value is found
            }
            tempNode = tempNode.next;
        }
        System.out.println(val + " is not present in list.");
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println();

        list.insertFirst(1992);
        list.insertFirst(2006);
        list.insertFirst(2009);
        list.insertFirst(2011);
        list.insertFirst(2015);
        list.display();
        System.out.println();

        list.insertEnd(1899);
        list.display();
        System.out.println();

        list.insertAtPosition(0,100);
        list.insertAtPosition(list.size, 200);
        list.insertAtPosition(5, 2003);
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

        list.findValue(2009);
        list.findValue(2003);
    }
}
