# VARIABLES

### Types of Variables

- **Primitive Type**
  - char, byte, short, int, long, float, double, boolean
- **Non-Primitive/Reference Type**
  - Class, Interface, Array, String

# Primitive Types

| Type      | Size      | Range                                | Default Value |
|---------  |-----------|--------------------------------------|---------------|
| `char`    | 2 bytes   | 0 to 65535                           | `\u0000`      |
| `byte`    | 1 byte    | -128 to 127                          | `0`           |
| `short`   | 2 bytes   | -32,768 to 32,767                    | `0`           |
| `int`     | 4 bytes   | -2^31 to 2^31-1 (-10^9 to 10^9)      | `0`           |
| `long`    | 8 bytes   | -2^63 to 2^63-1 (-10^18 to 10^18)    | `0L`          |
| `float`   | 4 bytes   | -3.4*10^38 to 3.4*10^38              | `0.0f`        |
| `double`  | 8 bytes   | -1.7*10^308 to 1.7*10^308            | `0.0d`        |
| `boolean` | 1 bit     | true or false                        | `false`       |

---

## Types of Conversions

### 1. **Widening/Automatic/Upcasting Conversion**

- Lower to higher datatype conversion.
- happens automatically.
  > (byte->short->int->long), (float->double)
- Example:
  ```java
  int var = 10;
  long varLong = var;  // Automatically converts int to long
  ```

### 2. **Narrowing/Explicit/DownCasting Conversion**

- Higher to Lower Datatype conversion
- Requires manual casting.
  > (byte<-short<-int<-long), (float<-double)
- Example:
  ```java
  int integerVariable = 10;
  byte byteVariable = (byte) integerVariable;
  ```

### 3. **Promotion During Expressions**

- Small types (`byte`, `short`) promote to `int` in expressions.
- Example:
  ```java
  byte a = 10, b = 127;
  int sum = a + b;  // Result promoted to int
  ```

### 4. Upcasting during expression

- Higher type casted to Lower type in expression.
- Example:
  ```java
  int a = 10;
  double b = 60.5;
  double res = a + b; // here a auto casted to double.
  ```

---

## Types of Variables

1. **Instance/Member Variable**
    - Exists as part of an object.
2. **Static/Class Variable**
    - One copy shared among objects, accessed via class name.
3. **Local Variable**
    - Defined within methods, destroyed when the method exits.
4. **Method Parameters**
    - Variables passed to methods.
5. **Constructor Parameters**
    - Variables passed to constructors.
6. **CONSTANT**
    - Constants (*static final*)

---

# Non-Primitive/Reference Types

1. **Class**
2. **Interface**
3. **Array**
    - int[] nums = new int[5];
        - `nums` holds a reference to the array in heap memory, but `nums[idx]` holds a value.
4. **String**
    - string pool and heap memory.

### Wrapper Class

- For each primitive type we have Reference type.
  - *Character, Byte, Short, Integer, Long, Float, Double, Boolean.*
- Why needed?
  1. Usefull for pass by reference.
  2. Used in collections.

#### Autoboxing

> int -> Integer (going in BOX)

- Converts Primitive to Reference type variables.
- Example:
  ```java
  int primitive = 20;
  Integer ref = primitive;
  ```

#### Unboxing

> int <- Integer (out of BOX)

- Converts Reference to Primitive type variables.
- Example:
  ```java
  Integer ref = 20;
  int primitive = ref;
  ```
