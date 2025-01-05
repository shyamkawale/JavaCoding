package Collections.MyCollections;

import java.util.Arrays;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class MyDeque<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int start, end, size;

    public MyDeque() {
        elements = new Object[DEFAULT_CAPACITY];
        start = end = -1;
        size = 0;
    }

    public MyDeque(int initialCapacity) {
        if(initialCapacity < 0){
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        elements = new Object[initialCapacity];
        start = end = -1;
        size = 0;
    }

    public boolean addFirst(E elem){
        if (elem == null) throw new NullPointerException("Null elements are not allowed");
        ensureCapacity();
        if(size == 0){
            start = end = 0;
        }
        else{
            start = (start - 1 + elements.length)%elements.length;
        }

        elements[start] = elem;
        size++;
        return true;
    }

    public boolean addLast(E elem){
        if (elem == null) throw new NullPointerException("Null elements are not allowed");
        ensureCapacity();
        if(size == 0){
            start = end = 0;
        }
        else{
            end = (end + 1)%elements.length;
        }

        elements[end] = elem;
        size++;
        return true;
    }

	public E peekFirst(){
        if(size == 0){
            throw new NoSuchElementException("Queue is empty");
        }
        return (E) elements[start];
    }

    public E peekLast(){
        if(size == 0){
            throw new NoSuchElementException("Queue is empty");
        }
        return (E) elements[end];
    }

    public E removeFirst(){
        if(size == 0){
            throw new NoSuchElementException("Queue is empty");
        }
        E startElem = (E) elements[start];
        elements[start] = null;
        if(size == 1){
            start = end = -1;
        }
        else{
            start = (start + 1)%elements.length;
        }
        size--;
        return startElem;
    }

    public E removeLast(){
        if(size == 0){
            throw new NoSuchElementException("Queue is empty");
        }
        E lastElem = (E) elements[end];
        elements[end] = null;
        if(size == 1){
            start = end = -1;
        }
        else{
            end = (end - 1 + elements.length)%elements.length;
        }
        size--;
        return lastElem;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity(){
        if(size >= elements.length){
            int newCapacity = 2 * elements.length;
            elements = Arrays.copyOf(elements, newCapacity);
            Object[] newElements = new Object[newCapacity];

            for(int i=0; i<size; i++){
                newElements[i] = elements[(start+i)%elements.length];
            }

            elements = newElements;
            start = 0;
            end = size - 1;
        }
    }
}

