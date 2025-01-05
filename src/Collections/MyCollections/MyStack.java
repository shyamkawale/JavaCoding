package Collections.MyCollections;

import java.util.Arrays;
import java.util.EmptyStackException;

@SuppressWarnings("unchecked")
public class MyStack<E>{
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int top = -1;

    public MyStack(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyStack(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        elements = new Object[initialCapacity];
    }

    public E peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return (E) elements[top];
    }

    public E push(E item){
        ensureCapacity();
        elements[++top] = item;
        return item;
    }

    public E pop(){
        E elem = peek();
        elements[top--] = null;
        return elem;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int size(){
        return top+1;
    }

    private void ensureCapacity(){
        if(top + 1 >= elements.length){
            int newCapacity = 2 * elements.length;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
}
