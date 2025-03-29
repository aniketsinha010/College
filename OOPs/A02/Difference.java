package OOPs.A02;

public class Difference {

    static class Test{
        String name;

        public Test(String name) {
            this.name = name;
        }
    }

    static class Test2{
        static String name;

        public Test2(String name) {
            Test2.name = name;
        }
    }

    public static void main(String[] args) {
        Test one = new Test("First Person");
        Test two = new Test("Second Person");
        System.out.println(one.name);
        System.out.println(two.name);
        System.out.println();

        Test2 three = new Test2("Third Person");
        Test2 four = new Test2("Fourth Person");
        System.out.println(three.name);
        System.out.println(four.name);
    }
}


// Explanation :
/*
In 'Test' the variable 'name' is not static so it will have different values for different objects, whereas in
'Test2' the variable 'name' is static so only the values of the last object will be printed...see chatgpt for
more explanation...
*/

/*
Static Nested Class 'Test':::::
The Test class has an "instance" variable 'name'.
Each instance of Test gets its own copy of the 'name' variable.
In the main method:
Two objects (one and two) of the Test class are created, each with a unique value for the 'name' variable.
The values of 'name' for 'one' and 'two' are printed, showing that the 'name' variable is not shared between instances.

Static Nested Class 'Test2':::::
The Test2 class has a "static" variable 'name'.
The 'name' variable is shared across all instances of Test2, as it is associated with the class rather than any
specific instance.
In the main method:
Two objects (three and four) of the Test2 class are created. The 'name' variable is set in the constructor.
Since 'name' is static, modifying its value in one object affects the value for all objects of the class.
Both 'three.name' and 'four.name' refer to the same 'name' variable, and the final value is "Fourth Person".
*/