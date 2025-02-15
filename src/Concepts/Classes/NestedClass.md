# NESTED CLASS

- Class within another class is called Nested Class.
- When to use?
  - If you know that, a class(A) will be used by only one another class(B), then instead of created new file(A.java) for it, we can create nested class inside B class itself.
  - Also help us to group logically related classes in one file.
- Scope: Its Scope is same as of its Outer class.
- It is of 2 types:
    1. Static Nested Class
    2. Non Static Nested Class(Inner Class)
        1. Member Inner Class
        2. Local Inner Class
        3. Anonymous Inner Class

### 1. Static Nested Class

- It do not have access to the non static instance variable and method of outer class.
- Its object can be initiated without initiating the object of outer class.
- It can be private, public, protected or package-private(default, no explicit declaration)

    ```java
    class OuterClass {
        int instanceVariable = 10;
        static int classVariable = 20;

        public static class NestedClass{
            public void print(){
                System.out.println(classVariable);
                System.out.println(instanceVariable); // Error
            }
        }

        private static class PvtNestedClass{
            
        }

        public void getPvtNestedClassObj(){
            return new PvtNestedClass();
        }
    }

    public class ObjectTest {
        public static void main(String args[]) {

            OuterClass.NestedClass nestedObj = new OuterClass.NestedClass();
            nestedObj.print();

            OuterClass outerClassObj = new OuterClass();
            PvtNestedClass pvtnestedObj = outerClassObj.getPvtNestedClassObj(); // will it work??
        }
    }
    ```

### 2. Non-Static Nested Class (Inner Class)

- It have access to all the instance variable and method of outer class.
- Its object can be initiated on after initiating the object of outer class.

### 2.1. Member Inner Class

```java
class OuterClass {
    int instanceVariable = 10;
    static int classVariable = 20;

    public class InnerClass{
        public void print(){
            System.out.println(classVariable);
            System.out.println(instanceVariable);
        }
    }
}

public class ObjectTest {
    public static void main(String args[]) {

        OuterClass outerClassObj = new OuterClass();
        OuterClass.InnerClass innerClassObj = outerClassObj.new InnerClass();
        innerClassObj.print();
    }
}
```

### 2.2 Local Inner Class

- These are those classes which are defined in any block like for loop, while loop block, If condition block, method etc.
- It can not be declared as private, protected, public. Only default(not defined explicit) access modifier is used.
- It can not be initiated outside of this block. As soon as the scope of block ends, its scope also ends.

    ```java
    class OuterClass {
        int instanceVariable = 1;
        static int classVariable = 2;

        public void display(){
            int methodLocalVariable = 3;

            class LocalInnerClass{
                int localInnerVariable = 4;

                public void print(){
                    System.out.println(instanceVariable);
                    System.out.println(classVariable);
                    System.out.println(methodLocalVariable);
                    System.out.println(localInnerVariable);
                }
            }

            LocalInnerClass localObj = new LocalInnerClass();
            localObj.print();
        }
    }
    ```

### 2.3 Anonymous Inner Class

- An inner class without a name called Anonymous class.
- Why its used:
  - When we want to override the behaviour of the method without even creating any subclass.

    ````java
    public abstract class Car {
        public abstract void pressBreak();
    }

    public class Test {
        public static void main(String args[]) {

            // Anonymous Class Audi's object
            Car audiCarObj = new Car() {

                @Override
                public void pressBreak() {
                    //my audi specific implementation here
                    System.out.println("Audi specific break changes");
                }
            }:

            audiCarObj.pressBreak();
        }
    }
    ````

#### Now we know that we cannot create an object of abstract class but here we had done it. Let's understand what happened:

So, 2 thing happened behind the scene :

- Child class is created, name decided by the compiler.
- Creates an object of child class and assigns its reference to object.

Similarly for interface also, it works in the same way.

# Inheritence in nested class

### 1. One inner class can inherit another inner class in same outer class.

```java
class OuterClass{
    int instanceVariable = 1;
    static int classVariable = 2;

    class InnerClass1{
        int innerClass1 = 3;
    }

    class InnerClass2 extends InnerClass1{
        int innerClass2 = 4;
        void display(){
            System. out.println(innerClass1 + innerClass2 + instanceVariable + classVariable);
        }
    }

}

public class ObjectTest {
    public static void main(String args[]) {
        OuterClass outerClassObj = new OuterClass();
        OuterClass.InnerClass2 innerClass2Obj = outerClassObj.new InnerClass2();
        innerClass2Obj.display();
    }
}
```

### 2. Static inner class inherited by different class

```java
class OuterClass {
    static class NestedClass {
        public void display (){
            System.out.println("inside Static Nested Class");
        }
    }
}

public class SomeOtherClass extends OuterClass.NestedClass {

    public void display1(){
        display();
    }
}
```

### 3. Non Static Inner Class inherited by different class

```java
class OuterClass {
    class InnerClass {
        public void display(){
            System.out.println("inside InnerClass");
        }
    }
}

public class SomeOtherClass extends OuterClass.InnerClass {

    SomeOtherClass(){
        new OuterClass().super();
        //as you know, when child class constructor invoked, it first invoked the constructor of parent.
        //but here the parent is Inner class, so it can only be accessed by the object of guterclass only.
    }

    public void display1(){
        display();
    }
}
```
