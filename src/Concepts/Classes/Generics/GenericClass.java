package Concepts.Classes.Generics;

// Generic Class with Type parameter: T
public class GenericClass<T> {// if more than one type: <T1, T2, T3..>

    // Bounded Class
    // T can be of type Number or childClass of Number(Integer, Long, BigInt, ...)
    // T can be of type Interface(ex: ??)
    public static class BoundedClass<T extends Number>{

    }

    // MultiBounded Class
    // Multibounded class where 1st is always concrete class, then 2nd, 3rd ... can be interfaces
    public static class MultiBoundedClass<T extends Number & Comparable<T>>{

    }

    public T element;

    public void printElement() {
        System.out.println(element + " className:" + element.getClass());
    }

    public void setElement(T val) {
        element = val;
    }
}
