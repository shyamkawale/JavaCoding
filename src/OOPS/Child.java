package OOPS;

public class Child extends Parent {
    public String commonProp;
    public String childProp;

    public Child(){
        this.commonProp = "Child_Common";
        this.childProp = "Child_Pvt";
    };

    public void commonMethod(){
        System.out.println("This is (Child)'s commonMethod");
    }

    public void childMethod(){
        System.out.println("This is (Child)'s' childMethod");
    }
}
