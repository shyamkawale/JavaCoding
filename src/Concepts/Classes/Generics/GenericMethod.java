package Concepts.Classes.Generics;

import java.util.List;

public class GenericMethod {

    // before return type mention all types that this method will work with
    public <K, V, A, B> void print(Pair<K, V> obj1, Pair<A, B> obj2) {
        System.out.println(obj1.key + " " + obj1.val);
        System.out.println(obj2.key + " " + obj2.val);
    }

    // Wrong Syntax => type bounds are specified when declaring and not when using it.
    // public <T> void printElements(List<T extends Number> list) {
    //     System.out.println(list);
    // }

    // Correct Syntax
    public <T extends Number> void printElements(List<T> list, T val) {
        list.add(val);
        for(T obj: list){
            System.out.println(obj);
        }
        System.out.println(list);
    }

    // WildCards (? inside parameter declaration)
    // Unbounded WildCards
    public void displayItems(List<?> items) {
        for (Object item : items) {
            System.out.println(item);
        }
    }
    //                         --> Go down -->
    // Upper-Bounded WildCards (Number, Integer, Double, Float,... )
    public void printUpperBoundedElements(List<? extends Number> list, Integer val) {
        // list.add(val); // doesnot allow adding new elements
        for(Number obj: list){ // above Number and equal ** 💡
            System.out.println(obj);
        }
        System.out.println(list);
    }

    //                          <--- Go Up <---
    // Lower-Bounded WildCards (..., Object, Number)
    public void printLowerBoundedElements(List<? super Number> list, Number val) {
        list.add(val); // allow adding below Number --> Integer, Double ** 💡(Number ke upar wale rahenge so for safety it can contains(added) all that are below Number)
        for(Object obj: list){ // above Number  >💡
            System.out.println(obj);
        }
        System.out.println(list);
    }

    // Difference between Wildcard and Generic Type
    // WildCard : we can use Lowerbound(super), Generic Type: We cannot use super
    // Generic Type: we can use generic type(T) inside method, WildCard: We don't have any type(T)

}
