package OOPS;

public class OOPs {
    public static void main(String[] args) {
        Child shyam = new Child("Shyam", "Kawale", 23, MaritalStatus.Bachelor);
        //pallavi **is a reference** --> to Parent class. it can **hold object of type Parent or any child of Parent**.

        // REFERENCE
        //  Parent <-- (Pallavi's Reference) everything will be used from here BUT methods are overridden by Child class
        //   /|\
        //    |
        //    |
        //  Child <-- (Pallavi's Object)

        Parent pallavi = new Child("Pallavi", "Kewale", 27, MaritalStatus.Married);
        Parent kalpana = new Parent();
        Parent vilas = new Parent();

        shyam.getAddress();
        System.out.println("Shyam's name: "+shyam.Name);
        System.out.println("Shyam's surname: "+shyam.SurName);
        System.out.println("Shyam's Age: "+shyam.Age);
        System.out.println("Shyam's maritalStatus: "+shyam.MaritalStatus);
        shyam.getSchoolName();
        shyam.getHusbandName();

        System.out.println("*********************************************************");

        pallavi.getAddress();
        System.out.println("Pallavi's name: "+pallavi.Name);
        System.out.println("Pallavi's surname: "+pallavi.SurName);
        System.out.println("Pallavi's Age: "+pallavi.Age);
//        System.out.println("Pallavi's maritalStatus: "+pallavi.MaritalStatus); //Child's field/property
//        pallavi.getSchoolName(); //Child's method
        pallavi.getHusbandName();






    }
}
