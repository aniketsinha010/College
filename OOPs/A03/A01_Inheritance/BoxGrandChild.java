package OOPs.A03.A01_Inheritance;


// this is a child class of 'BoxChild' class...
public class BoxGrandChild extends BoxChild{

    double cost;

    // constructor...
    public BoxGrandChild(double length, double breadth, double height, double weight, double cost) {
        super(length, breadth, height, weight);
        this.cost = cost;
    }

    // another constructor without any arguments...
    public BoxGrandChild(){
        this.cost = -100;
    }

    // adding the cost variable to the display method...
    public void display(){
        System.out.println(this.length+"  "+this.breadth+"  "+this.height+"  "+this.weight+"  "+this.cost);
    }
}
