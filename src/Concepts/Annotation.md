# Annotation

What is Annotation?

- It is kind of adding META DATA to the java code.
- Means, its usage is OPTIONAL.
- We can use this meta data information at runtime and can add certain logic in our code if wanted.
- How to Read Meta data information? Using Reflection as discussed in previous video.
- Annotations can be applied at anywhere like Classes, Methods, Interface, fields, parameters etc.

Types of Annotation:

1. Custom Defined(user defined)
2. Pre-Defined
    1. Used on Java Code(like classes, methods, ...)
        1. @Deprecated
        2. @Override
        3. @SuppressWarning
        4. @FunctionalInterface
        5. @SafeVarargs
    2. Used on Annotation(Meta Annotation)
        1. @Target
        2. @Retention
        3. @Documented
        4. @Inherited
        5. @Repeatable

## Preddefined Used on Java Code

### 1.  @Deprecated

```java
public class Mobile {
    @Deprecated
    public void dummyMethod(){ //warnings
        //do something
    }
}
```

- Usage of Deprecated Class or Method or fields, shows you compile time WARNING.
- Deprecation means, no further improvement is happening on this and use new alternative method or field instead.
- Can be used over: Constructor, Field, Local Variable, Method, Package, Parameter, Type(class, interface, enum).

### 2. @Override

```java
public interface Bird {
    public boolean fly();
}

public class Eagle implements Bird{
    @Override
    public boolean fly() {
        return true;
    }
}
```

- During Compile time, it will check that the method should be Overridden.
- And throws compile time error, if it do not match with the parent method.
- Can be used over: METHODS.

### 3. @SupressWarnings

```java
public class Main {
    public static void main(String args[]){

    }

    @SuppressWarnings("unused")
    public void unusedMethod(){

    }
}
```

- It will tell compiler to IGNORE any compile time WARNING.
- Use it safely, could led to Run time exception if, any valid warning is IGNORED
- Can be used over: Field, Method, Parameter, Constructor, Local Variable, Type (Class or interface or enum)

### 4. @Functionallnterface

```java
@FunctionalInterface
public interface Bird {
    public boolean fly() ;
}
```

- Restrict Interface to have only 1 abstract method.
- Throws Compilation error, if more than 1 abstract method found.
- Can be used over: Type (Class or interface or enum)

### 5. @SafeVarargs

- Used to suppress "Heap pollution warning"
- Used over methods and Constructors which has Variable Arguments as parameter.
- Method should be either static or final (i.e. methods which can not be overridden)
- In Java9, we can also use it on private methods too.

#### What is Heap Pollution?

- Object of One Type (Example String), storing the reference of another type Object (Example Integer)
- Causes of Heap Pollution
    1. Raw Types.

        ```java
        List<String> stringList = new ArrayList<>();
        List rawList = stringList;  // Unsafe assignment of raw type
        rawList.add(42);            // Adding an Integer to a List<String>

        String s = stringList.get(0);  // Causes a ClassCastException at runtime
        ```

    2. SafeVarargs

        ```java
        public class Log {

            @SafeVarargs
            public static void addToList(List<Integer>... numberList){
                Object[] objectList = numberList;

                List<String> stringList = new ArrayList<>();
                stringList.add("Hello");
                objectList[0] = stringList; // Unsafe: Type safety issue

                Integer firstElement = numberList[0].get(0); // Heap Pollution: Runtime ClassCastException
            }
        }
        ```

---

# Meta Annotations

## 1. @Target

- This meta-annotation will restrict, on which ElementType to use the annotation.

    ```java
    @Target(ElementType.METHOD) // Restricting this Annotaion on Methods.
    public @interface Override {
        
    }

    @Target({ElementType.CONSTRUCTOR, ElementType.METHOD}) // Restricting this Annotaion on Constructors & Methods.
    public @interface SafeVarargs {

    }
    ```

#### ElementType Enum

ElementType is an enum used with @Target to define the kinds of program elements the annotation can be applied to. The key constants are:

| ElementType       |Usage                                                                  |
|-------------------|-----------------------------------------------------------------------|
|TYPE               |Can be applied to classes, interfaces, or enums                        |
|FIELD              |Can be applied to fields (including constants)                         |
|METHOD             |Can be applied to methods                                              |
|PARAMETER          |Can be applied to parameters in methods or constructors                |
|CONSTRUCTOR        |Can be applied to constructors                                         |
|LOCAL_VARIABLE     |Can be applied to local variables                                      |
|ANNOTATION_TYPE    |Can be applied to other annotations                                    |
|PACKAGE            | Can be applied to packages                                            |
|TYPE_PARAMETER     | Can be applied to generic type parameters `<T>`                       |
|TYPE_USE           | Can be applied to any use of a type (like List< @annotation String>)  |

## 2. @Retention

- meta-annotation used to specify how long annotations with the annotated type are to be retained.
- It determines the visibility and lifecycle of an annotation, specifying whether it is available only at the source code level, in the compiled class files, or at runtime.

#### RetentionPolicy Enum

1. SOURCE

    - Annotations are retained only in the source code and discarded during compilation by compiler so it will not be recorded in .class file.
    - Example: @Override
    - Use Case: Compile-time checks or static analysis tools.

        ```java
        @Retention(RetentionPolicy.SOURCE)
        public @interface SourceLevelAnnotation {

        }
        ```

2. CLASS

    - Annotations are retained in the .class file by the compiler but not available at runtime(ignore by JVM).
    - Use Case: Bytecode processing tools.

        ```java
        @Retention(RetentionPolicy.CLASS)
        public @interface ClassLevelAnnotation {

        }
        ```

3. RUNTIME

    - Annotations are retained in the .class file and available at runtime through reflection.
    - Use Case: Frameworks and libraries that need to process annotations at runtime, like Spring and Hibernate.

        ```java
        @Retention(RetentionPolicy.RUNTIME)
        public @interface RuntimeLevelAnnotation {

        }
        ```

we can use reflecton to access RuntimeLevelAnnotation

```java
@RuntimeLevelAnnotation
public class Example {

}

RuntimeLevelAnnotation annotation = Example.class.getAnnotation(RuntimeLevelAnnotation.class);
if (annotation != null) {
    System.out.println("Annotation is available at runtime.");
}
```

## 3. @Documented

- meta-annotation used to specify the presence of the annotation to be included in generated JavaDocs.

```java
@Documented
public @interface MyAnnotation {
    String value();
}
```

## 4. @Inherited

- It indicates that the annotation can be inherited from a parent-class by child-classes.

```java
@Inherited
public @interface MyAnnotation {
    String value();
}
```

```java
@MyAnnotation(value = "Superclass")
public class Parent {
}

public class Child extends Parent {
}

public class TestInherited {
    public static void main(String[] args) {
        if (Child.class.isAnnotationPresent(MyAnnotation.class)) { // true bcz of @Inherited annotation otherwise false.
            MyAnnotation annotation = Child.class.getAnnotation(MyAnnotation.class); // @MyAnnotation bcz of @Inherited annotation otherwise null.
            System.out.println("Child class inherits MyAnnotation with value: " + annotation.value());
        }
    }
}
```

## 5. @Repeatable

- Allows you to apply the same annotation more than once to a single element (such as a class, method, or field).
