package LinkedList.A04_CircularLL;

// Circular LL using Singly LL ......

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList(){
        this.size = 0;
    }

    private class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    // Insertion at first...
    public void insertFirst(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
            tail.next = head;
        }
        else{
            newNode.next = head;
            head = newNode;
            tail.next = head;
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
        do {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        } while (tempNode != head); // Stop when we reach back to the head...
        System.out.println("(back to head)"); // Optional: Indicate circular nature...
    }





    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        System.out.println();

        list.insertFirst(1992);
        list.insertFirst(2006);
        list.insertFirst(2009);
        list.insertFirst(2011);
        list.insertFirst(2015);
        list.display();
        System.out.println();
    }
}
