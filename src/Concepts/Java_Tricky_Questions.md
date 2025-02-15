
# JAVA TRICKY QUESTIONS

## 1.  Java Only Supports Pass by Value?

Java always uses pass-by-value. However, what gets passed as the value differs for primitive types and reference types. Non-primitive(Reference) variables store reference by default so it acts as pass by reference..

## 2. Why Does Java Not Explicitly Use Pointers?

1. Safety and Simplicity: Pointers, as used in languages like C or C++, allow direct memory access, which increases the risk of bugs like dangling pointers, memory leaks, and buffer overflows. Java avoids these risks by disallowing explicit memory manipulation.
2. Garbage Collection: Java's automatic garbage collector handles memory management, making pointers unnecessary for freeing or allocating memory.
3. Non-primitive variables in Java (e.g., objects, arrays) do not act like traditional pointers but serve a similar purpose:
    - They store the memory address (or reference) of the actual object in the heap.
    - When you use these variables, you're working with the object via its reference.
4. While the reference variable in JAVA  feels like a pointer, you cannot access or manipulate the actual memory address (as you could with pointers in C or C++). The reference is managed by the Java Virtual Machine (JVM).

## 3. Why do we need a Wrapper class?

1. Becoz we can use them to use it like pass by reference.
2. Java Collection uses Non-Primitive variables so we need a Wrapper class.

## 4. Why main method should be in public class?

Main method is the entry point of any applicatino. SO JVM needs to access it to start execution of the program.

## 5. Why main method should be static?

So that JVM can call main method without creating an instance of the class.

## 6. Why public class name should be same as file name?

1. Java enforces this rule to ensure the compiler can locate classes correctly.
2. Logical organization.

## 7. Why 1 file can contain only 1 public class?

1. Java enforces this rule to ensure the compiler can locate concrete class associated with the file correctly.
2. Logical organization.

## 8. Why constructor name is same as class name?

So that JVM/compiler can distinguish constructor from regular methods.

## 9. Why constructor do not have return type?

Constructors do not return values (not even void), because their sole purpose is to initialize an object’s state.

## 10. Why constructor cannot be final?

Constructor cannot be overridden so final keyward is redundant here.

## 11. Why constructor cannot ber overridden?

1. Constructors are not normal methods(they are special methods).
2. Constructor is meant for object initialization and not for polymorphism.
3. If Java allowed constructor overriding, it would introduce ambiguity and violate the principle that a subclass is a specialization of its superclass. Constructors are strictly for initializing their own class’s state, and Java enforces this through its inheritance rules.

## 12. Why constructor cannot be abstract?

Becoz constructor has implementation so it cannot be abstract. Only that particular class of which constructor is part of should give implementation of its constructor.

## 13. Why constructor cannot be static?

Static methods are class-level methods, however construtors are called during object creation(instance specific).

## 14. Why no constructor in interface?

We cannot create object of Interfaces hence constructor is redundant.

## 15. Why protected and private access specifiers not allowed on concrete class?

Follow up on previous one: Why nested class can be of any access specifier??

Why we cannot create a instance of Abstract class?
we cannot instantiate an abstract class directly because it may contain abstract methods that have no implementation. Creating an instance of a class requires a complete implementation of all its methods, which an abstract class does not guarantee. Abstract classes are meant to serve as base classes for concrete subclasses that provide specific implementations of the abstract methods.
Why Abstract classes needs constructor if we cannot create an instance of Abstract Classes
Abstract classes can have constructors, and these constructors are called when a subclass object is created. The purpose of a constructor in an abstract class is to initialize common properties and perform setup tasks that can be shared by all subclasses.

Difference between 
GenClass<Integer, String> obj1 = new GenClass<>();
GenClass<Integer, String> obj1 = new GenClass<Integer, String>();  ???

Interfaces can have non-abstract methods so how multiple inheritance?

Parent can reference to child obj but not reverse why?

List<Parent> cannot reference to List<Child> why?
Why Wildcards Are Not Used in Class Declarations?
The wildcard ? represents an unknown type, which makes it unsuitable for class declarations that need a concrete type for operations.
Incorrect usage:
// This is not allowed
public class Container<?> {
    private ? item; // Invalid
}

Why protected and private are not allowed with interfaces?

Why all methods are implicit public in Interface?

Why method cannot be declared as final in interface?

Fields are public, static, final implicitly (CONSTANTS) why?? (you cannot make field private or protected)


Can we have nested class inside interface

Why nested interface inside interface can only be public?
Why static methods can call static only?
