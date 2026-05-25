package LinkedList.A02_SInglyLL_Without_Tail;

// Singly Linked List without tail...

public class LinkedListNoTail {

    private Node head;
    private int size;

    public LinkedListNoTail(){
        this.size = 0;
    }

    private class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }


    // Inserting at the front...
    public void insertFirst(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Display...
    public void display(){
        if(head == null){
            System.out.println("The list is empty.");
        }
        else{
            Node tempNode = head;
            for(int i=0; i<size ; i++){
                System.out.print(tempNode.data + " -> ");
                tempNode = tempNode.next;
            }
            System.out.println("null");
        }
    }

    // Inserting at the end...
    public void insertEnd(int val){
        Node newNode = new Node(val);
        Node tempNode = head;
        if(head == null){
            head = newNode;
        }
        else{
            while(tempNode.next != null){
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        size++;
    }

    // Inserting at a certain position...(index starting from 0)
    public void insertAtPosition(int pos, int val){
        if(pos < 0 || pos > size){
            throw new IndexOutOfBoundsException("Position out of bounds.");
        }
        else if (pos == 0){
            insertFirst(val);
        }
        else if(pos == size){
            insertEnd(val);
        }
        else{
            Node newNode = new Node(val);
            Node tempNode = head;
            for(int i=0;i<pos-1;i++){
                tempNode = tempNode.next;
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
        else if(head.next == null){
            head = null;
            size--;
        }
        else{
            head = head.next;
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
            size--;
        }
        else{
            Node tempNode = head;
            while(tempNode.next.next != null){
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            size--;
        }
    }

    // Deleting at position...
    public void deleteAtPosition(int pos){
        if(pos < 0 || pos > size - 1){
            throw new IndexOutOfBoundsException("Position out of bounds");
        }
        else if(pos == 0){
            deleteFirst();
            return;
        }
        else if(pos == size-1){
            deleteEnd();
            return;
        }
        else {
            Node tempNode = head;
            for(int i = 0 ; i < pos-1 ; i++){
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }


    public static void main(String[] args) {
        LinkedListNoTail list = new LinkedListNoTail();
        System.out.println();

        list.insertFirst(1992);
        list.insertFirst(2006);
        list.insertFirst(2009);
        list.insertFirst(2011);
        list.insertFirst(2015);
        list.display();
        System.out.println();

        list.insertEnd(1889);
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
    }
}
