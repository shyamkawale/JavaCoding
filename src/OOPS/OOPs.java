package OOPS;

public class OOPs {
    public static void main(String[] args) {
        Child shyam = new Child();
        System.out.println("Shyam's commonProp: "+shyam.commonProp);
        System.out.println("Shyam's parentProp: "+shyam.parentProp);
        System.out.println("Shyam's childProp: "+shyam.childProp);
        shyam.commonMethod();
        shyam.parentMethod();
        shyam.childMethod();

        // Child abc = new Parent(); // not possible(why??)
    
        System.out.println("**************************************************************");

        Parent kalpana = new Parent();

        //Upcasting
        //pallavi **is a reference** --> to Parent class. it can **hold object of type Parent or any child of Parent**.

        // Object Type/Data Type/Variable Type
        //  Parent <-- (Pallavi's Reference) everything will be used from here BUT methods are overridden by Child class
        //    |
        //    |
        //   \|/
        //  Child <-- (Pallavi's Object)
        //  REFERENCE in Heap Memory
        Parent pallavi = new Child(); 
        System.out.println("Pallavi's commonProp: "+pallavi.commonProp);
        System.out.println("Pallavi's parentProp: "+pallavi.parentProp);
        // System.out.println("Shyam's childProp: "+pallavi.childProp); //Compile Time Error (Child's property)
        pallavi.commonMethod();
        pallavi.parentMethod();
        // pallavi.childMethod(); //Compile Time Error (Child's method)
    }
}
