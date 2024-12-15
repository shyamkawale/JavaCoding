package OOPS;

public class OOPs {
    public static void main(String[] args) {
        Child shyam = new Child();
        System.out.println("Shyam's commonProp: "+shyam.commonProp); // Child_Common
        System.out.println("Shyam's parentProp: "+shyam.parentProp); // Parent_Pvt
        System.out.println("Shyam's childProp: "+shyam.childProp); // Child_Pvt
        shyam.commonMethod(); // This is (Child)'s commonMethod
        shyam.parentMethod(); // This is (Parent)'s' parentMethod
        shyam.childMethod();  // This is (Child)'s' childMethod

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
        System.out.println("Pallavi's commonProp: "+pallavi.commonProp); // Parent_Common
        System.out.println("Pallavi's parentProp: "+pallavi.parentProp); // Parent_Pvt
        // System.out.println("Shyam's childProp: "+pallavi.childProp);  // Compile Time Error (Child's property)
        pallavi.commonMethod();     // This is (Child)'s commonMethod
        pallavi.parentMethod();     // This is (Parent)'s' parentMethod
        // pallavi.childMethod();   // Compile Time Error (Child's method)
    }
}
