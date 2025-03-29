package OOPs.A01;


// Constructor Function //

/*
Constructor is a speacial function that runs when you create an object and it allocates some variables
*/


// Two classes in the same package cannot have same name , as there is already a 'Student' class already in the previous
// file, we have no name this 'Student2'...
// (or we could have created a new package and stored this file there...)
class Student2 {
    int roll;
    String name;
    float marks;

    // constructor function...
    Student2(int roll, String name, float marks){
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    // adding a method(or function)...
    void display(){
        System.out.printf("Hello !! I am %s , my roll number is %d and I got %f marks...\n",this.name,this.roll,this.marks);
    }

    void changeName(String name){
        this.name = name;
        display(); // calling a method within a method...
    }

    // constructor overloading...
    Student2(String name){  // 2nd Constructor...
        this.name = "Default Name";
    }

    // constructor that takes value from another object...
    Student2(Student2 other){
        this.name = other.name;
        this.roll = other.roll;
    }
}


public class Constructor {
    public static void main(String[] args) {
        Student2 aniket = new Student2(20, "Aniket Sinha", 72.8f);
        aniket.display();
        aniket.changeName("Sinha Aniket");

        // constructor overloading...
        Student2 samya = new Student2("Samya"); // here only one argument is passed so the object will be formed using the 2nd constructor...
        samya.display(); // as in the 2nd constructor there is a default name, even if we pass a name still the default name will be printed...

        // constructor that takes value from another object...
        Student2 banti = new Student2(aniket);
        banti.display();

        // if we copy one object from another object then any changes made to the previous object will also applied to the second object...
        Student2 one = new Student2("One");
        Student2 two = one;
        one.name = "Changed Name";
        System.out.println(two.name);
    }
}
