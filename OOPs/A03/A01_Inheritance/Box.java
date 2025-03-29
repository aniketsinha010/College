package OOPs.A03.A01_Inheritance;

public class Box {
    double length;
    double breadth;
    double height;

    // constructor : when no argument is passed then this constructor will be called(already seen in method overloading)
    Box(){
        this.length = -1;
        this.breadth = -1;
        this.height = -1;
    }

    // for cube : constructor : when only one argument is passed then this constructor will be called...
    Box(double side){
        this.length = side;
        this.breadth = side;
        this.height = side;
    }

    // for cuboid : constructor : when three arguments are passed then this constructor will be called...
    Box(double length,double breadth,double height){
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    // passing constructor as argument itself...
    Box(Box old){
        this.length = old.length;
        this.breadth = old.breadth;
        this.height = old.height;
    }

    public void display(){
        System.out.println(this.length + "  " + this.breadth + "  " + this.height);
    }
}
