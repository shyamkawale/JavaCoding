# Types of Classes

1. Concrete Class
2. Abstract Class
3. Parent/Child Class, Object Class
4. Nested Class
5. Generic Class
6. POJO Class
7. Enum Class
8. Final Class
9. Singleton Class
10. Immutable Class
11. Wrapper Class

---

## 1. Concrete Class

- These are those class that we can create an instance using NEW keyword.
- All the methods in this class have implementation.
- It can also be your child class from interface or extend abstract class.
- A class access modifier can be "public" or "default" (no explicit
modifier defined)

## 2. Abstract Class

- used to do 0 to 100% abstraction.
  - Show only important features to users and hide its internal implementation.
- Class is declared as abstracted through keyword "abstract".
- It can have both abstract(method without body) and non-abstract methods.
- We can not create an instance of this class.
- We parent has some features which all child classes have in common, then this can be
used.
- Constructors can be created inside them. And with super keyword from child classes we
can access them.

## 3. Parent/Child Class

- A class that is derived from another class is called a Childclass.
- And from class through which Childclass is derived its called Parentclass.
- Object Class
  - In Java, in the absence of any other explicit superclass, every class is implicitly a child-class of Object class.
  - Object is the topmost class in Java.
  - It has some common methods like clone(), toString(), equals(), notify(), wait() etc ...

## 4. Nested Class

1. Static Nested Class
2. Non Static Nested Class(Inner Class)
    1. Local Inner Class
    2. Member Inner Class
    3. Anonymous Inner Class

## 5. Generic Class

## 6. POJO Class

- Stands for "Plain Old Java Object".
- Contains variables and its getter and setter methods.
- Class should be public.
- Public default constructor.
- No annotations should be used like @Table, @Entity, @ld etc ..
- It should not extend any class or implement any interface.
- Used as DTO/entity

## 7. Enum Class

## 8. Final Class

- It is a class which cannot be inherited.

## 9. Singleton Class

## 10. Immutable Class

- We can not change the value of an object once it is created.
- Declare class as 'final' so that it can not be extended.
- All class members should be private. So that direct access can be avoided.
- And class members are initialized only once using constructor.
- There should not be any setter methods, which is generally use to change the value.
- Just getter methods. And returns Copy of the member variable.
- Example: String, Wrapper Classes etc.

```java
final class MyImmutableClass {
    private final String name;
    private final List<Object> petNameList;

    MyImmutableClass(String name, List<Object> petNameList){
        this.name = name;|
        this.petNameList = petNameList;
    }

    public String getName(){
        return name;
    }

    public List<Object> getPetNameList(){
        //this is required, because making list final, (truely final)
        // means you can not now point it to new list, but still can add, delete values in it
        //so thats why we send the copy of it.

        return new ArrayList<>(petNameList);
    }
}
```

## 11. Wrapper Class

- Integer, Double, Character, .....
