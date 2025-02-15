package Concepts.Classes.Generics;

import java.util.ArrayList;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        GenericClass<String> strObj = new GenericClass<>();
        strObj.setElement("shyam");
        strObj.printElement();

        // Raw type object => passes Object
        @SuppressWarnings("rawtypes")
        GenericClass obj = new GenericClass();
        obj.setElement(45);
        obj.printElement();
        obj.setElement("kawale");
        obj.printElement();


        ChildClass<Integer> chObj = new ChildClass<>();
        chObj.setElement("from child ELement");
        chObj.printElement();

        GenericMethod genMethod = new GenericMethod();
        genMethod.print(new Pair<Integer, String>(5, "five"), new Pair<String, String>("five", "yes five"));
        genMethod.printUpperBoundedElements(new ArrayList<Number>(), 5);
        genMethod.printLowerBoundedElements(new ArrayList<Number>(), 7);
    }
}
