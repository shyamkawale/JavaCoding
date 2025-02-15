# Reflection

- This is used to examine the Classes, Methods, Fields, Interfaces at runtime and also possibly change the behavior of the Class too.
- Reflection in Java is a feature that allows a program to inspect, analyze, and modify its own behavior at runtime.
- Information we get using reflection about any class:
    1. What all methods present in the class.
    2. What all fields present in the class.
    3. What is the return type of the method.
    4. What is the Modifier of the Class
    5. What all interfaces class has implemented
    6. Change the value of the public and private fields of the Class etc.
- How to do reflection of Classes?
  - To reflect the class, we need object of class **Class**

## class Class

- represents classes during runtime.
- JVM creates one Class object for each classes which is loaded during runtime.
- class Class object has meta data information about the particular class like its method, fields, constructor etc.

### How to create class Class object?

#### 1st way: using formName() method

```java
class Bird {}
Class birdClass = Class.forName("Bird");
```

#### 2nd way: using .class

```java
class Bird {}
Class birdClass = Bird.class;
```

#### 3rd way: using getClass() method

``` java
class Bird {}
Bird birdObj = new Bird();
Class birdClass = birdObj.getClass();
```

## Different Types of Reflections

Eagle Class:

``` java
public static class Eagle {
    public String breed;
    private String name;

    Eagle(){

    }

    private Eagle(String name){
        System.out.println("Pvt Ctor");
    }

    public void fly(int intArg, String strArg){
        System.out.println("fly");
    }

    private void eat(){
        System.out.println("eat");
    }
}
```

### 1. Reflection of Classes

```java
import java.lang.reflect.*; // for Modifier class

public class Main {
    public static void main(String[] args){
        Class eagleClass = Eagle.class;

        System.out.println(eagleClass.getName()); // Eagle
        System.out.println(Modifier.toString(eagleClasss.getModifiers())); // public static
    }
}
```

- All methods available in Class Object are getters..

### 2. Reflection of Methods

```java
public class Main {
    public static void main(String[] args){
        Class eagleClass = Eagle.class;

        // to get public methods from this class
        Method[] publicMethods = eagleClass.getMethods(); // fly

        // to all methods
        Method[] allMethods = eagleClass.getDeclaredMethods(); // fly, eat

        for(Method method: publicMethods){
            System.out.println(method.getNames()); // fly
            System.out.println(method.getReturnTypes()); // void
            System.out.println(method.getDeclaringClassNames()); // Eagle
        }

        // Invoking method in runtime
        Method flyMethod = eagleClass.getMethod("fly", int.class, String.class);
        flyMethod.invoke(new Eagle(), 7, "hello");
    }
}
```

### 3. Reflection of Fields

```java
public class Main {
    public static void main(String[] args){
        Class eagleClass = Eagle.class;

        // to get public fields from this class
        Field[] publicFields = eagleClass.getFields(); // breed

        // to all fields
        Field[] allFields = eagleClass.getDeclaredFields(); // breed, name

        for(Field field: publicFields){
            System.out.println(field.getNames()); // breed
            System.out.println(field.getType()); // String
            System.out.println(Modifier.toString(field.getModifiers())); // default
        }

        // Setting value of PUBLIC field in runtime
        Eagle eagleObj = new Eagle();
        Field breedField = eagleClass.getField("breed");
        breedField.set(eagleObj, "eagleNewBreed");
        System.out.println(eagleObj.breed); // eagleNewBreed

        // Setting value of PRIVATE field in runtime
        Field nameField = eableClass.getDeclaredFiels("name");
        nameField.setAccessible(true);
        nameField.set(eagleObj, "eagleNewName");
        System.out.println(eagleObj.name); // eagleNewName
    }
}
```

### 4. Reflection of Constructor

```java
public class Main {
    public static void main(String[] args){
        Class eagleClass = Eagle.class;

        // to get public Ctors
        Constructor[] publicCtors = eableClass.getConstructors();

        // to get all Ctors
        Constructor[] allCtors = eableClass.getDeclaredConstructors();

        for(Constructor ctor: allCtors){
            System.out.println(Modifier.toString(ctor.getModifiers()));
        }

        // Invoking constructor
        Constructor privateConstructor = eagleClass.getDeclaredConstructor(String.class);
        privateConstructor.setAccessible(true);
        Eagle secretEagle = privateConstructor.newInstance("SecretEagle"); // Pvt Ctor
    }
}
```

## UseCases of Reflection

1. Runtime Inspection:
    - Analyze classes, methods, and fields during program execution.
    - Useful in development tools like debuggers, IDEs, and testing frameworks.
2. Dynamic Object Creation:
    - Create instances of classes dynamically when the class is not known at compile time.
    - Example: Dependency injection in frameworks like Spring.
3. Frameworks and Libraries:
    - Many frameworks like Spring, Hibernate, and JUnit use reflection for dependency injection, ORM mapping, and testing.
4. Access Private Members:
    - Bypass access modifiers to interact with private fields or methods.
5. Plugins and Extensibility:
    - Load and execute classes dynamically (e.g., for plugin systems).
6. Annotations Processing:
    - Read and process annotations at runtime for metadata-driven programming.
7. Serialization:
    - Inspect object properties and serialize/deserialize data dynamically.

## Limitations and Risks of Reflection

1. Performance Overhead:
    - Reflection is slower than direct method or field access because it bypasses compile-time optimizations.
2. Security Risks:
    - Accessing private members or bypassing access restrictions can lead to security vulnerabilities.
3. Complexity:
    - Reflection code is harder to read and maintain, as it operates dynamically.
4. Runtime Errors:
    - Issues like `ClassNotFoundException` or `NoSuchMethodException` may only appear at runtime.
