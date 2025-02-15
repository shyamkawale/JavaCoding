# ENUM CLASS

- It has a collection of CONSTANTS (variables which values can not be changed)
- Its CONSTANTS are static and final implicitly (we do not have to write it).
- It can not extend any class, as it internally extends java's ```java.lang.Enum``` class
- It can implement interfaces.
- It can have variables, constructor, methods.
- It can not be initiated (as its constructor will be private only, even you give default, in bytecode
it make it private)
- No other class can extend Enum class
- It can have abstract method, and all the constant should implement that abstract method.

## 1.  Normal Enum Class

```java
// Internally for any comstant we define in enum, a value is assigned starhing from 0. So Monday=0, Tuesday=1,...
public enum EnumSample{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THRUSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}
```

### Methods

1. **_values()_**
    - return a list of all constants present in the Enum.
2. **_name()_**
    - returns name of constant.
3. **_ordinal()_**
    - return value associated to the constant.
4. **_valueOf(str)_**
    - returns constant which will match exactly with the given string.

```java
public static void main(){

    for(EnumSample enum: EnumSample.values()){
        System.out.println(enum.name() + " " + enum.ordinal());
    }

    EnumSample enumVar = EnumSample.valueOf("FRIDAY");
}
```

## 2. Enum with Custom Values

1. Each of the varable we define in enum class will be applicable for every constant in th class. In a way each constant is an object of enum class having defined variables.
2. We also need to define parameterized constructor which will be invoked for every constants.
3. To define a method for the whole class(enum) we need to make it static, otherwise it will be applicable for all constants

```java
public enum EnumWithCustomValues {
    MONDAY(101, "1st Day Of the Week"),
    TUESDAY(102, "2nd Day Of the Week"),
    WEDNESDAY(103, "3rd Day Of the Week"),
    THRUSDAY(104, "4th Day Of the Week"),
    FRIDAY(105, "5th Day Of the Week"),
    SATURDAY(106, "6th Day Of the Week"),
    SUNDAY(107, "7th Day Of the Week");

    private int value;
    private String comment;

    EnumWithCustomValues(int value, String comment) {
        this. value = value;
        this. comment = comment;
    }

    public int getValue () {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this. comment = comment;
    }

    public static EnumWithCustomValues getEnumFromValue(int value){
        for(EnumWithCustomValues enumWithCustomValue : EnumWithCustomValues.values()){
            if(enumWithCustomValue.value == value){
                return enumWithCustomValue;
            }
        }
        return null;
    }
}
```

## 3. Method overriding by constants

```java
public enum EnumMethodOverrideByConstant {
    MONDAY{
        @Override
        public void dummyMethod(){
            System. out.println("Monday Dummy Method");
        }
    },
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public void dummyMethod(){
        System.out.println("Default Dummy Method");
    }
}
```

## 4. Enum with Abstract Method

```java
public enum EnumWithAbstractMethod {
    MONDAY{
        public void dummyMethod(){
            System.out.println("In Monday Dummy Method");
        }
    },
    TUESDAY{
        public void dummyMethod(){
            System.out.println("In Tuesday Dummy Method");
        }
    },
    WEDNESDAY{
        public void dummyMethod(){
            System.out.println("In Wednesday Dummy Method");
        }
    };
    public abstract void dummyMethod();
}
```

## 5. Enum inplements Interface

```java
public interface MyInterface{
    public String toLowerCase();
}

public enum EnumImplementInterface implements MyInterface{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THRUSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    @Override
    publid String toLowerCase(){
        return this.name().toLowerCase();
    }
}
```

### Benefits of using Enum Class over Constant with static and final?

1. Better Readability.
2. Enum has control on what value we can passin parameter.

```java
public class WeekConstant {
    public static final int MONDAY = 0;
    public static final int SATURDAY = 1;
    public static final int SUNDAY = 2;
}
public enum EnumSample{
    MONDAY,
    SATURDAY,
    SUNDAY;
}

public static void main(String args[]){
    isWeekend(2);
    isWeekend(EnumSample.SUNDAY);
}

public static boolean isWeekend(int day){
    if(day == WeekConstant.SATURDAY || day == WeekConstant.SUNDAY){
        return true;
    }
    return false;
}
public static boolean isWeekend(EnumSample day){
    if(day == WeekConstant.SATURDAY || day == WeekConstant.SUNDAY){
        return true;
    }
    return false;
}
```
