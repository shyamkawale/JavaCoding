# SINGLETON

Objective: Create only single object.
Example: DB connection, Logger Service

## Different Ways of creating Singleton class

### 1. Eager Initialization

- We are creating and initializing the object as soon as the program starts even if it isn't being currently used by others.

    ```java
    public class DBConnection {
        // private and static object initialised/created of same class.
        private static DBConnection connObject = new DBConnection();

        // private constructor => to avoid object creation of this class.
        private DBConnection(){
        }

        // to give access to only object of this class to other classes.
        public static DBConnection getInstance(){
            return connObject;
        }
    }
    ```

- Disadvantage: We create object even if this object is not needed.

### 2. Lazy Initialization

- Object is created lazily only when someone needs it for the first time.

    ```java
    public class DBConnection {
        // private and static object declared of same class.
        private static DBConnection connObject;

        private DBConnection(){
        }

        public static DBConnection getInstance(){
            if(connObject == null){
                connObject = new DBConnection();
            }
            return connObject;
        }
    }
    ```

- Disadvantage: Two threads at the same time can create two objects for the first time.

### 3. Synchronized Method

- getInstance() method is synchronized(i.e thread safe)
- synchronized method does 2 things
  - Lock - puts a lock on the method.
  - UnLock - unlock the method.
- Example
    ```java
    public class DBConnection {
        private static DBConnection connObject;

        private DBConnection(){
        }

        // synchronized to make it thread safe.
        synchronized public static DBConnection getInstance(){
            if(connObject == null){
                connObject = new DBConnection();
            }
            return connObject;
        }
    }
    ```

-Disadvantage: Synchronization is very very slow and generally not used.

### 4. Double Check Locking

- Synchronization occurs only when the instance is null, making it efficient for subsequent calls.
- Double checking as multiple threads could potentially create multiple instances if they pass the initial null check at the same time.
    ```java
    public class DBConnection {
        private static volatile DBConnection connObject;

        private DBConnection(){
        }

        public static DBConnection getInstance(){
            if(connObject == null){
                synchronized (DBConnection.class){
                    if(connObject == null){
                        connObject = new DBConnection();
                    }
                }
            }
            return connObject;
        }
    }
    ```

#### Why we need volatile keyword?

- ### 1st problem: Visibility of changes

    > ***Concept**: Each Core uses its respective L1-Cache to cache their respective objects and periodically syncs with memory for performance.*

    **Explaination**: Now if thread T1 from core1 and thread T2 from core2 tries to get connObject, here if T1 creates an object and stores in core1's cache so before syncup to memory it will not be visible to thread T2 from core2. So T2 will end up creating new object and hence we will endup creating multiple objects of singleton class.

    **Solution**: use volatile keyword => volatile keyword will make sure that object is created in memory instead of cache. so any read/write operation happening on object happens in memory.

- ### 2nd problem: Instruction Reordering

    > **Concept**: *When creating an instance in Java, the following steps occur in memory:*
    >
    > 1. *Allocate memory for the object.*
    > 2. *Initialize the object.*
    > 3. *Assign the reference to the instance variable.*
    >
    > *However, due to optimizations performed by the Java compiler and the CPU, steps 2 and 3 may be reordered. So, without volatile, the order could be:*
    >
    > 1. *Allocate memory.*
    > 2. *Assign the reference to instance (before fully initializing the object).*
    > 3. *Initialize the object.*

    **Explaination**:

    In a multithreaded scenario:
  - Thread T1 begins creating the singleton instance and assigns the reference (step 2) before the object is fully initialized.
  - Thread T2 checks if (instance == null) and sees a non-null reference, even though the object is not yet fully constructed.
  - If Thread T2 tries to use this partially constructed object, it leads to unpredictable behavior or errors.

  **Solution**: use volatile keyword => volatile keyword prevents CPU/compiler from instruction reordering for the instance variable. It guarantees that the instance reference is not visible to other threads until the object is fully initialized.

    Volatile keyword ensures that => All write operations before the assignment to instance are completed before instance is visible to other threads.
    The reference to instance will not be assigned until the object is fully initialized. Every write to instance in one thread happens before any subsequent read of instance in another thread.

- Disadvantage: because of volatile keyword and synchronization its slow.

### 5. Bill Pugh Solution

- uses static nested class(to solve Eager initialization problem) - becoz nested class do not get loaded on rogram startup, instead it gets loaded when referred.

    ```java
    public class DBConnection {
        private DBConnection(){
        }

        private static class DBConnectionHelper{
            private static final DBConnection connObject = new DBConnection();
        }

        public static DBConnection getInstance(){
            return DBConnectionHelper.connObject;
        }
    }
    ```

### 6. Enum Class

- In Enum, all constructors are private, and only one object of enum is created per JVM. So by default enum is singelton only.

    ```java
    enum DBConnection{
        connObject;
    }
    ```
