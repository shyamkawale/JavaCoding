package OOPS;

public class Child extends Parent {
    public String Name;
    public String SurName = "Kawale";
    public MaritalStatus MaritalStatus;
    public int Age;


    public Child(String name, String surName, int age, MaritalStatus maritalStatus){
        super(name, surName, age);
        this.Name = name;
        this.Age = age;
        this.MaritalStatus = maritalStatus;
    }

    public void getAddress(){
        System.out.println("This is (Child) " + this.Name +"'s Address");
    }

    public void getSchoolName(){
        System.out.println("This is (Child) " + this.Name +"'s SchoolName");
    }
}
