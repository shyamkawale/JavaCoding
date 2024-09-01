package OOPS;

public class Parent {
    public String Name;
    public String SurName;
    public String HusbandName;
    public int Age;

    public Parent(){ };
    public Parent(String name, String surName, int age){
        this.Name = name;
        this.SurName = surName;
        this.Age = age;
    }

    public void getAddress(){
        System.out.println("This is (Parent) " + this.Name +"'s Address");
    }

    public void getHusbandName(){
        System.out.println("This is (Parent) " + this.Name + "'s Husband name");
    }


}
