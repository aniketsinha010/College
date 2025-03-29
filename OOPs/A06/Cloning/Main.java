package OOPs.A06.Cloning;

// Not Complete...See Again... Not very clear...

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        Human aniket = new Human(21,"Aniket Sinha");
        Human aniket2 = new Human(aniket);
        System.out.println(aniket.name + " is " + aniket.age);
        System.out.println(aniket2.name + " is " + aniket2.age);
        // so here basically we are creating a copy of 'aniket'. But there is a
        // problem here, it takes a lot  of processing time because we are again using
        // the 'new' keyword. Instead of doing this we can use the clone method or
        // Object Cloning.
        System.out.println();

        Human aniket3 = (Human) aniket.clone();
        // have to mention throws CloneNotSupportedException at main method...
        System.out.println(aniket3.name + " is " + aniket3.age);
    }
}

/*
Cloning in Java is the process of creating an exact duplicate of an existing object. Java
provides built-in support for cloning using the clone() method in the Object class.
*/
