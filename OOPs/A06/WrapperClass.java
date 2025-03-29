package OOPs.A06;

/*
Wrapper Classes in Java :
Wrapper classes in Java are used to convert primitive data types into objects. These classes are part of the java.lang
package and provide utility methods for working with primitive values...

Q) Why Use Wrapper Classes?
->Object Representation – Java collections (e.g., ArrayList, HashSet) work with objects, not primitives.
->Utility Methods – Each wrapper class provides useful methods, such as parsing, comparing, and value conversion.
->Autoboxing & Unboxing – Java automatically converts between primitive types and wrapper classes (introduced in Java 5).

Primitive Type	       Wrapper Class
 byte	       -           Byte
 short	       -           Short
 int	       -          Integer
 long	       -           Long
 float	       -           Float
 double	       -           Double
 char	       -         Character
 boolean	   -          Boolean
*/

public class WrapperClass {
    public static void main(String[] args) {
        int a = 10; // Primitive...
        Integer b = Integer.valueOf(a); // Explicit boxing...
        int c = b.intValue(); // Explicit unboxing...

        // Autoboxing and unboxing (automatic conversion)...
        Integer autoBoxed = 20;   // Autoboxing...
        int autoUnboxed = autoBoxed; // Unboxing...


        // Wrapper classes in Java function just like their corresponding primitive types but come with many additional
        // methods that provide useful functionalities...
        System.out.println(Integer.max(5,2));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.valueOf("123")); // string to integer...

    }
}
