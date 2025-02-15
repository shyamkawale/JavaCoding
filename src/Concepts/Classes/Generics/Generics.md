# GENERICS

Generics class helps us to write a class in a generic manner that helps to avoid the typecasting that we'll have to use with Object class.

## Generic Class with one type

```java
public class GenericClass<T> {
    public T element;

    public T getElement() {
        return element;
    }

    public void setElement(T val) {
        element = val;
    }
}
```

## Generic Class with more than one type

```java
public class Pair<K, V> {
    K key;
    V val;

    public Pair(K key, V val) {
        this.key = key;
        this.val = val;
    }
}
```

## Inheritence with Generic classes: Generic ChildClass, Generic ParentClass

```java
public class ChildClass extends GenericClass<String>{

}

public class ChildClass<T> extends GenericClass<String>{ 

}

public class ChildClass<T> extends GenericClass<T>{ 

}
```

## Generic Method

- Type Parameter should be before return type of method declaration.
- Type Parameter scope is limited to method only.

```java
// before return type mention all types that this method will work with
public <K, V, A, B> void print(Pair<K, V> obj1, Pair<A, B> obj2) {
    System.out.println(obj1.key + " " + obj1.val);
    System.out.println(obj2.key + " " + obj2.val);
}

public <T> void setValue(T obj){
    System.out.println(obj);
}
```

## Bounded Generics

- It can be used at generics class and method

### 1. Upper-Bounded Class

- Upper Bound(`<T extends Number>`) means T can be of type Number or childClass of Number(Integer, Long, BigInt, ...)
    ```java
    // T can be of type Interface(ex: ??)
    public static class UpperBoundedClass<T extends Number>{

    }
    ```

> **_There is no Lower-Bounded Class._**

### 2. Multi-Bounded Class

- 1st restrictive type is always concrete class, then 2nd, 3rd ... can be interfaces.
- uses `&` operator.
    ```java
    public static class MultiBoundedClass<T extends Number & Comparable<T>{

    }
    ```

## WildCards

- uses `?` inside parameter declaration

### 1. Unbounded WildCards

```java
public void displayItems(List<?> items) {
    for (Object item : items) {
        System.out.println(item);
    }
}
```

### 2. Upper-Bounded WildCards

```java
// Wrong Syntax 
// type bounds are specified when declaring and not when using it.
// public <T> void printElements(List<T extends Number> list) {
//     System.out.println(list);
// }

-------------------------------------------------------------------------
// Right Syntax
//                         --> Go down -->
// Upper-Bounded WildCards (Number, Integer, Double, Float,... )
public void printUpperBoundedElements(List<? extends Number> list, Integer val) {
    // list.add(val); // doesnot allow adding new elements
    for(Number obj: list){ // above Number and equal ** 💡
        System.out.println(obj);
    }
    System.out.println(list);
}
```

### 3. Lower-Bounded WildCards

```java
//                          <--- Go Up <---
// Lower-Bounded WildCards (..., Object, Number)
public void printLowerBoundedElements(List<? super Number> list, Number val) {
    list.add(val); // allow adding below Number --> Integer, Double ** 💡(Number ke upar wale rahenge so for safety it can contains(added) all that are below Number)
    for(Object obj: list){ // above Number  >💡
        System.out.println(obj);
    }
    System.out.println(list);
}
```

#### Difference between Wildcard and Generic Type

1. WildCard : we can use Lowerbound(super), Generic Type: We cannot use super.
2. Generic Type: we can use generic type(T) inside method, WildCard: We don't have any type(T).
