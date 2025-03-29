package OOPs.A01;


// Wrapper Class // not completed wrapper class....see from another video...

/*
'final'  is a keyword that prevents the content to be modified...
*/


public class Wrapper {
    public static void main(String[] args){
        int a=10;
        int b=20;
        swap(a,b);
        System.out.println(a + "  " + b); // seen earlier that any change made in the method does not implement the change anywhere else...

        // while using final keyword the variable is always written in all capitals...since we cannot modify a final variable so the final variable
        // should always be initialized when it is declared...
        final int FIRST = 10;
        // FIRST = 20; // this will give error...

        //final on non primitives...
        // when a non primitive is final you cannot reassign it but you can modify the variables...
    }

    static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }
}

