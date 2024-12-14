package Collections.MyCollections;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unchecked")
public class MyArrayList<E> {
    private final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    public MyArrayList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyArrayList(int initialCapacity){
        if(initialCapacity >= 0){
            elements = new Object[initialCapacity];
        }
        else{
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public MyArrayList(Collection<? extends E> collection){
        elements = collection.toArray();
        size = collection.size();
    }

	public E get(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    public E add(E element){
        ensureCapacity();
        elements[size++] = element;
        return element;
    }

    public E remove(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldElement = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return oldElement;
    }

    public boolean contains(E element){
        for (int i = 0; i < size; i++) {
            if(elements[i] == element)return true;
        }
        return false;
    }

    public void ensureCapacity(){
        if(size >= elements.length){
            int newCapacity = 2 * elements.length;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static class Main{
        public static void main(String[] args) {
            MyArrayList<Integer> list = new MyArrayList<Integer>();
            System.out.println(list.getSize());
            list.add(3);
            list.add(5);
            list.add(1);

            for (int i = 0; i < list.getSize(); i++) {
                System.out.printf(list.get(i) + " ");
            }


            System.out.println("\nsize: "+ list.getSize());

            list.remove(1);

            for (int i = 0; i < list.getSize(); i++) {
                System.out.printf(list.get(i) + " ");
            }

            System.out.println("\nsize: "+ list.getSize());

            Set<Integer> set = new HashSet<Integer>();
            set.add(1);
            set.add(21);
            MyArrayList<Integer> list2 = new MyArrayList<Integer>(set);

            for (int i = 0; i < list2.getSize(); i++) {
                System.out.printf(list2.get(i) + " ");
            }

            System.out.println("\nsize of list2:" + list2.getSize());
            System.out.println(list2.contains(21));
        }
    }
}
