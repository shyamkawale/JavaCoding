# INTERFACE

- Interfaces helps 2 system to interact between each other, without one system to know details of other.(i.e it helps to acheive Abstraction)
- only *public* and *default* are allowed access modifiers.

## Why we need interfaces

1) Abstraction
2) Polymorphism
3) Multiple Inheritence.

## Methods in Interface

- only *public*.
- by default methods are *public abstract*.
- *final method* is not allowed. (duh!)

## Fields in Interface

- only *public*.
- by default fields are *public static final* (i.e CONSTANT)

## Interface Implementation

- Overriding method cannot have restrictive access specifier.
- Concrete class must override all methods declared in interface.
- Abstract classes are not forced to override all methods.
- A class can implement multiple interfaces.

## Nested Interface

- Nested Interface within interface.
- Use: group logically related interface.
- Nested interface within Interface must be *public*.
- Nested interface within class can have any access modifiers.
- when any class implements nested interface then outer interface Implementation is not required.
- when any class implements outer interface then nested interface Implementation is not required.

## Abstract Classes vs Interfaces

| S.No  | Abstract Class | Interface |
|-------|----------------|-----------|
| 1     | Keyword used here is **"abstract"** | Keyword used here is **"interface"** |
| 2     | Child classes need to use the keyword **"extends"** | Child classes need to use the keyword **"implements"** |
| 3     | It can have both abstract and non-abstract methods | It can have only abstract methods (From Java 8 onwards, it can have **default**, **static**, and **private** methods too, where we can provide implementation) |
| 4     | It can extend from another class and multiple interfaces | It can only extend from other interfaces |
| 5     | Variables can be **static**, **non-static**, **final**, or **non-final** | Variables are by default **constants** |
| 6     | Variables and methods can be **private**, **protected**, **public**, or **default** | Variables and methods are by default **public** (In Java 9, **private methods** are supported) |
| 7     | Multiple inheritance is **not supported** | Multiple inheritance is **supported** with interfaces in Java |
| 8     | It can provide the implementation of the interface | It **cannot provide** implementation of any other interface or abstract class |
| 9     | It can have a constructor | It **cannot have** a constructor |
| 10    | To declare a method abstract, we use the **"abstract"** keyword, and it can be **protected**, **public**, or **default** | No keyword is needed to make a method abstract. Methods are **public** by default |

# Java 8/9 features

> Before Java8, Interface can have only Abstract methods, and all child classes has to provide those abstract method's implementation.
>
> But if we wanted to add new method in interface then we needed to change in all its implementation(imagine 50+ classes implementing any interface.!!)

> that's when **Default Methods, Static Methods, Private Methods, Private Static Methods** comes in picture....

## 1. Default methods [Java 8]

```java
public interface IBird{
    default boolean canFly(){
        return true;
    }
}

public class Sparrow implements IBird{

}

public class Main{
    public static void main(String[] args){
        IBird sparrow = new Sparrow();
        sparrow.canFly();
    }
}
```

- *Non abstract method* in interface.
- used generally when all its implementation will be having same implementation of any method. (i.e common method)
- ex: stream() method in Collection interface.

#### Default Methods and Multitple inheritance

- If class implemements 2 interface with same default method then it must write its own implementation.

## 2. Static Method [Java 8]

```java
public interface IBird{
    static boolean canFly(){
        return true;
    }
}

public class Sparrow implements IBird{
    public void seeIfBirdCanFly(){
        if(IBird.canFly()){
            System.out.println("Every Bird can fly");
        }
    }
}
```

- *Non abstract method* in interface.
- Static so cannot be overridden by classes that implements interface
- we can access it using interface name itself.
- if you try to normally override it, it will just be treated as new method in class.
  - You cannot add `@Override` annotation it will throw compilation error.

## 3. Private Method [Java 9]

```java
public interface IBird{
    default boolean canFly(){
        // do something...
        doSomething();

        return true;
    }

    private void doSomething(){
        System.out.println("Do something common from Default methods");
    }
}
```

- *Non abstract method* in interface with *private* access modifier.
- It is called from *Default method*.
- Solves problem of duplication of code of Default methods.

## 4. Private Static Method [Java 9]

```java
public interface IBird{
    static boolean canFly(){
        // do something...
        doSomething();

        return true;
    }

    private static void doSomething(){
        System.out.println("Do something common from Default or Static methods");
    }
}
```

- *Non abstract method* in interface with *private* access modifier and *static* keyword.
- Can be called from *Default method* and *Static method*.
- Solves problem of duplication code of static method.

# Functional Interface

- Interface with only 1 abstract method..
- Also know as SAM interface(Single Abstract Method).
- `@FunctionInterface` annotation can be used at the top of the interface(But its optional).
- Only 1 abstract method is allowed but we can have other methods like *Default method*, *Static method* or *methods inherited from Object class(toString(), hashCode(), etc)*.

## Lambda Expression

- Lambda Expression is a way of implementing Functional Interfaces.

## Different ways to implement functional interface

### 1. Using implemements (normal)

```java
@FunctionInterface
public interface Bird{
    void canFly(String val);
}

public class Eagle implements Bird{

    @Override
    public void canFly(String val){
        System.out.println("Eagle Bird Implementation");
    }
}

public class Main {
    public static void main(String[] args){
        Bird eagle = new Eagle();
        eagle.canFly();
    }
}
```

### 2. Using Anonymous Class

```java
@FunctionInterface
public interface Bird{
    void canFly(String val);
}

public class Main{
    public static void main(String[] args){
        Bird eagle = new Bird(){
            @Override
            public void canFly(String val){
                System.out.println("Eagle Bird Implementation");
            }
        };

        eagle.canFly("vertically");
    }
}
```

### 3. Using Lambda Expression

```java
@FunctionInterface
public interface Bird{
    void canFly(String val);
}

public class Main{
    public static void main(String[] args){
        Bird eagle = (String val) -> {
            System.out.println("Eagle Bird Implementation");
        }

        eagle.canFly("vertically");
    }
}
```

## Example of Lambda Expression (Comparator)

```java
List<Integer> list = new ArrayList<Integer>();

// Way 1 (Custom Comparator Class)
class ListComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2){
        return o1-o2;
    }
}
Collections.sort(list, new ListComparator());

// Way 2 (Anonymous Inner Class for Comparator)
Comparator<Integer> listComparator = new Comparator<Integer>(){
    @Override
    public int compare(Integer o1, Integer o2){
        return o1-o2;
    }
};
Collections.sort(list, listComparator);

// Way 3 (Lambda Expression assigned to a Comparator)
Comparator<Integer> listComparator = (Integer o1, Integer o2) -> {
    return o1-o2;
}
Collections.sort(list, listComparator);

// Way 4 (Direct Lambda Expression)
Collections.sort(list, (o1,o2) -> o1-o2);
```

## Types of Functional Interface

> present in `java.util.function;` pkg

### 1. Consumer

- Represents an operation, that accepts single input parameter and returns no output.
- UseCase:
    1. Iteration over a collection,
    2. Event Handling

```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}

public class Main {
    public static void main(String args[]) {
        Consumer<Integer> loggingObject = (Integer val) -> {
            if(val>10) {
                System.out.println("Logging");
            }
        };
        loggingObject.accept(11);
    }
}
```

Example:
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(name -> System.out.println(name.toUpperCase()));
```

### 2. Supplier

- Represent the supplier of the result that accepts no Input parameter but produce a result
- UseCase
    1. Factory Methods: To generate objects withour requiring inputs.
    2. Lazy Initialization: to delay computation or suppy a value only when needed.
    3. Random number generation: Returning random numbers.

```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}

public class Main {
    public static void main(String args[]) {
        // first way (i.e without curly bracket)
        Supplier<String> isEvenNumber1 = () -> "this is the data i am returning";

        // second way (i.e with curly bracket)
        Supplier<String> isEvenNumber2 = () -> {
            return "this is the data i am returning";
        };

        System.out.println(isEvenNumber1.get());
        System.out.println(isEvenNumber2.get());
    }
}
```

Example: 
```java
Supplier<String> supplier = () -> "Hello, World!";
System.out.println(supplier.get());  // Output: Hello, World!
```

### 3. Function

- Represent function, that accepts one argument, processes it and produces a result.
- UseCase:
    1. Mapping a value: Converting between different data types or structures, like from String to Integer.
    2. Data processing pipelines: Applying functions to data in a sequense, like in streams.

```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}

public class Main {
    public static void main(String args[]) {
        Function<Integer, String> integerToString = (Integer num) -> {
            String output = num.toString();
            return output;
        };
        
        System.out.println(integerToString.apply(64));
    }
}
```

Example:
```java
Function<String, Integer> stringLength = str -> str.length();
System.out.println(stringLength.apply("Hello"));  // Output: 5
```

### 4. Predicate

- Represent function, that accept one argument and return the boolean.
- UseCase:
    1. Filtering data: Filtering collections or streams bases on conditions.
    2. Conditional checks: Checking if an object satisfies condition(ex: isvalid, isEven)

```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}

public class Main {
    public static void main(String args[]) {
        Predicate<Integer> isEven = (Integer val) -> {
            if(val%2 == 0){
                return true;
            } 
            else {
                return false;
            }
        }
        System.out.println(isEven.test(19));
    }
}
```

Example:
```java
Predicate<Integer> isEven = num -> num % 2 == 0;
System.out.println(isEven.test(4));  // Output: true
System.out.println(isEven.test(5));  // Output: false
```

### Where are these Funtional Interfaces types used

1. **Streams API**
2. **Comparator**
3. **Event Handling**: Consumer Functional Interfaces are commonly used in event-driven systems where actions(like button clicks, user inputs, etc) need to be handled without complex boilerplate code.

### Why we need Functional Interfaces

1. Improved readability (with lambda exp)
2. Short and Concise Code (with lambda exp)
3. Decoupling behavior from data.. no need to couple the behavior to specific code.
