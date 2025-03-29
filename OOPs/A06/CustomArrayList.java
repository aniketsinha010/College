package OOPs.A06;

// Creating my own custom ArrayList...

/*
How ArrayList works behind the scene??

The ArrayList class in Java internally uses an array to store elements. This array is dynamically resized when needed.
If the array is full and a new element is added, a new larger array is created. The old elements are copied into the
new array. The new capacity is 1.5 times (or 50% more) than the old capacity.
*/


public class CustomArrayList {
    // creating an array...we don't want others to directly make changes in the array.
    // Changes should only be made through some certain methods...
    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // size initially is zero...


    // constructor...
    public CustomArrayList(){
        this.data = new int[DEFAULT_SIZE];
    }


    // add method...
    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    // creating isFull, should be private...
    private boolean isFull(){
        return size == data.length;
    }

    // resize...
    private void resize(){
        // creating a temp array which is double the size of the original array...
        int[] temp = new int[data.length * 2];

        // copy the current items in the new array...
        for(int i=0;i< data.length;i++){
            temp[i] = data[i];
        }

        data = temp;
    }

    // remove method...
    public int remove(){
        int removed = data[size];
        size--;
        return removed;
    }

    // get method...
    public void get(int index){
        System.out.println(data[index]);
    }

    // size method...
    public void size(){
        System.out.println(size);
    }

    // set method...
    public void set(int index, int value){
        data[index] = value;
    }

    // display method (in reality there is no display method in ArrayList)...
    public void display(){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i] + "  ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.display();

        list.remove(); // it removes one of the zeroes from the end rather than 20...
        list.display();
    }
}

/*
Problems with this ArrayList : Here only integer values can be added. We want to create a ArrayList just like the
original one where the datatype of entries would be specified and only elements of that datatype would be allowed
to be entered. We will do that using 'Generics'.
*/
