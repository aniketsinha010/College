package OOPs.A02;

// See Again...

// Outside classes can never be static but inner classes can be static...
/*
A static inner class behaves more like a regular class within the outer class, meaning it is not tied to an instance
of the outer class. As a result, it can be instantiated without needing an outer class object...
*/

public class InnerClass {

    // creating an inner class...
    class Test{
        String name;

        // constructor...
        public Test(String name) {
            this.name = name;
        }
    }

    // creating an inner class with 'static'...
    static class Test2{
        String name;

        // constructor...
        public Test2(String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) {
        // Test one = new Test("First Person"); // this gives error because :::::
        /*
        In A01.Introduction we saw that we could create objects from 'Student' class where 'Student' is an outer class
        and is not defined with 'static' keyword. Here 'Test' is also not defined with 'static' keyword but we cant
        create any object from it because it is an inner class. Hence, to use it we have to use 'static' ...
        */

        Test2 two = new Test2("Second Person");
        System.out.println(two.name); // this works...
    }
}
