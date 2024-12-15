package OOPS;

public class Parent {
    public String commonProp;
    public String parentProp;

    public Parent(){
        this.commonProp = "Parent_Common";
        this.parentProp = "Parent_Pvt";
    };

    public void commonMethod(){
        System.out.println("This is (Parent)'s commonMethod");
    }

    public void parentMethod(){
        System.out.println("This is (Parent)'s' parentMethod");
    }

}
