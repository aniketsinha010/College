package OOPs.A03.A03_Encapsulation;

public class Person {

    // Data Hiding :  Making the instance variables private....
    private String name;
    private int age;


    // set ...////////
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        if(age<0){
            System.out.println("Invalid Age!!!!!");
        }
        else{
            this.age = age;
        }
    }


    // get...////////
    public void getName(){
        System.out.println(this.name);
    }

    public void getAge() {
        if (age > 0) {
            System.out.println(this.age);
        }
    }
}


/*
Here the private fields 'name' and 'age' are not directly accessible from outside the class...
The public getter and setter methods (like getName(), setName(), getAge(), and setAge()) are used to access and modify
the private variables...
*/