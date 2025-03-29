package OOPs.A03.A01_Inheritance;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box();
        box1.display();
        Box box2 = new Box(10,20,30);
        box2.display();
        Box box2_1 = new Box(40);
        box2_1.display();
        Box box3 = new Box(box2);
        box3.display();
        System.out.println();

        // creating an object of child class 'BoxChild'...
        BoxChild box4 = new BoxChild(1,2,3,4);
        box4.display();
        BoxChild box4_2 = new BoxChild();
        box4_2.display();
        BoxChild box4_3 = new BoxChild(10,100);
        box4_3.display();
        System.out.println();

        // referencing child class using parent class...
        Box box5 = new BoxChild(10,20,30,40);
        box5.display();
        System.out.println(box5.length);
        // System.out.println(box5.weight);
        /*
        Here a subclass object (BoxChild) is referenced using a parent class type (Box). Here only the methods and
        fields defined in the parent class (Box) are directly accessible through the reference box5, that is why
        we cant access box5.weight but methods in 'BoxChild' that override methods in 'Box' will be executed, that
        is why box5.display() displays all four variables indicating that it was called from 'BoxChild'...
        But the reverse of this will not work...See WHy???
        */
        System.out.println();


        // creating an object of class 'BoxGrandChild'...
        BoxGrandChild box6 = new BoxGrandChild(9,8,7,6,5);
        box6.display();
        BoxGrandChild box6_2 = new BoxGrandChild();
        box6_2.display();
    }
}
