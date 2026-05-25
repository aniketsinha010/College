package LinkedList.Questions;

// Questions are at the end of these methods & before main...


public class Singly {

    private Node head;
    private Node tail;
    private int size;

    public Singly(){
        this.size = 0;
    }

    private class Node{
        private int data;
        private Node next;

        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

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


// -------------------------------------------------------------------------------------------------------------------

    // Question 1 : Leetcode 83 :
    public void removeDuplicates(){
        if (head == null) return;
        Node tempnode = head;
        while(tempnode!=null && tempnode.next!=null){
            if(tempnode.data == tempnode.next.data){
                tempnode.next = tempnode.next.next;
                size--;
            }else{
                tempnode = tempnode.next;
            }
        }
        tail = tempnode;
        tail.next = null;
    }
    // Remember : whenever head is given as an argument, return head...

// -------------------------------------------------------------------------------------------------------------------

    // Question 2 : Leetcode 21 : (Same logic as merge sort)
    public Singly mergeTwoLists(Singly list1,Singly list2){
        Node head1 = list1.head;
        Node head2 = list2.head;
        Singly finalList = new Singly();

        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                finalList.insertEnd(head1.data);
                head1 = head1.next;
                finalList.size++;
            }else{
                finalList.insertEnd(head2.data);
                head2 = head2.next;
                finalList.size++;
            }
        }

        while(head1 != null){
            finalList.insertEnd(head1.data);
            head1 = head1.next;
            finalList.size++;
        }
        while(head2 != null){
            finalList.insertEnd(head2.data);
            head2 = head2.next;
            finalList.size++;
        }
        return finalList;
    }

// -------------------------------------------------------------------------------------------------------------------

    // Question 3 : Leetcode141 :
    // whenever there is a cycle detection problem use the fast and slow pointer method. In each iteration the slow
    // pointer moves ahead one step and the fast pointer moves forward two steps, if the two pointers ever meet that
    // means that a cycle is present...

    /*
    Key Rule to Remember in Java:
    Never call .next (or any method/field) on a null object — it causes a NullPointerException.
    So in these kind of questions within the while loop we have to make sure that we are not calling next on
    any null...
     */

// -------------------------------------------------------------------------------------------------------------------

    // Question 4 : Length Of Linkedlist Cycle : Leetcode 142 :
    // known as Floyd's cycle detection algorithm...
    /*
    Approach: Floyd’s Cycle Detection + Finding Cycle Start
Phase 1 – Detect cycle using slow and fast pointers.
Phase 2 – Find the start of the cycle:
When slow == fast, reset one pointer (slow) to the head.
Move both slow and fast one step at a time.
The node where they meet again is the start of the cycle.
     */
    // https://www.youtube.com/watch?v=95ZfuoSAUPI (see this video)


// -------------------------------------------------------------------------------------------------------------------

    // Question 5 : Leetcode 202 : Happy Number :

// -------------------------------------------------------------------------------------------------------------------

    // Question 6 : Leetcode 876 : Middle of Linked List :

// -------------------------------------------------------------------------------------------------------------------

    // Question 7 : Leetcode 148 : Sort Linked List :
    // done with merge sort and this is the optimal soln, but also see with bubble sort.

// -------------------------------------------------------------------------------------------------------------------

    // Question 8 : Leetcode 206 : Reverse Linked List :
/* Approach :
Take 3 pointers : initially 'before' pointing to 'null', 'current' to 'head' & 'after' pointing to 'head.next'.

*/

// -------------------------------------------------------------------------------------------------------------------

    // Question 9 : Leetcode 92 : Reverse Linked List 2 : (Draw & try to visualise each solution : must)

// ------------------------------------------------------------------------------------------------------------------

    // Question 10 : Leetcode 234 : Palindrome List :
/*  Approach:
Find the middle of the linked list using the slow and fast pointer technique.
Reverse the second half of the list (starting from the middle).
Compare the first half and the reversed second half node by node.
Optionally, restore the list if modification is not allowed.
🔁 You can break the list (e.g., by setting prev.next = null) if the original list does not need to be preserved.
*/

// ------------------------------------------------------------------------------------------------------------------

    // Question 11 : Leetcode 143 : Reorder Linked List 2 :

// ------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        Singly list = new Singly();
        System.out.println();

        System.out.println("Question 1 : Leetcode 83 :");
        list.insertEnd(1);
        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(3);
        list.insertEnd(3);
        list.display();
        list.removeDuplicates();
        list.display();
        System.out.println();

        System.out.println("Question 2 : Leetcode 21 :");
        Singly first = new Singly();
        Singly second = new Singly();
        first.insertEnd(1);
        first.insertEnd(2);
        first.insertEnd(4);
        second.insertEnd(1);
        second.insertEnd(3);
        second.insertEnd(4);
        Singly answer = new Singly();
        answer = answer.mergeTwoLists(first,second);
        answer.display();
    }
}









