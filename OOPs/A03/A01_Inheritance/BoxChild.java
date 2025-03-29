package OOPs.A03.A01_Inheritance;


// this is a child class of 'Box' class...
public class BoxChild extends Box{

    double weight;

    // constructor...
    public BoxChild(double length,double breadth,double height,double weight){
        super(length,breadth,height); //The super keyword is used to call the parent class’s constructor and
        // initialize inherited attributes (length, breadth, height)...
        this.weight = weight;
        // But, 'private' members(variables,methods) of a parent class are not directly accessible to the child class...
    }

    // another constructor without any arguments...
    public BoxChild(){
        this.weight = -5;
    }

    // another constructor with only side as argument...
    public BoxChild(double side,double weight){
        super(side);
        this.weight = weight;
    }

    // adding the weight variable to the display method...
    public void display(){
        System.out.println(this.length + "  " + this.breadth + "  " + this.height + "  " + this.weight);
    }
}

