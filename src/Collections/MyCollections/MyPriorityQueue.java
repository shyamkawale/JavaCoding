package Collections.MyCollections;

import java.util.Arrays;
import java.util.NoSuchElementException;


//Add comparable here to create maxheap
@SuppressWarnings("unchecked")
public class MyPriorityQueue<E extends Comparable<E>> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyPriorityQueue() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyPriorityQueue(int initialCapacity) {
        if(initialCapacity < 0){
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        elements = new Object[initialCapacity];
        size = 0;
    }

    public E peek(){
        if(size == 0){
            throw new NoSuchElementException("Priority queue is empty");
        }
        return (E) elements[0];
    }

    public boolean offer(E elem){
        ensureCapacity();
        int idx = size;
        elements[size++] = elem;
        while(idx>0 && getParent(idx).compareTo(elem) > 0){
            heapifyUp(idx);
            idx = (idx-1)/2;
        }

        return true;
    }

    public E poll(){
        if(size == 0){
            throw new NoSuchElementException("Priority queue is empty");
        }
        
        E topElem = (E) elements[0];

        elements[0] = elements[size-1];
        elements[size-1] = null;

        size--;
        heapifyDown(0);
        return topElem;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private E getParent(int idx){
        return (E) elements[(idx-1)/2];
    }

    private void heapifyUp(int currIdx){
        int parentIdx = (currIdx-1)/2;
        swap(parentIdx, currIdx);
    }

    private void heapifyDown(int currIdx){
        int leftChildIdx = 2*currIdx + 1;
        int rightChildIdx = 2*currIdx + 2;
        int smallestElemIdx = currIdx;

        if(leftChildIdx < size && ((E)elements[leftChildIdx]).compareTo((E)elements[smallestElemIdx]) < 0){
            smallestElemIdx = leftChildIdx;
        }
        if(rightChildIdx < size && ((E)elements[rightChildIdx]).compareTo((E)elements[smallestElemIdx]) < 0){
            smallestElemIdx = rightChildIdx;
        }

        if(smallestElemIdx != currIdx){
            swap(smallestElemIdx, currIdx);
            heapifyDown(smallestElemIdx);
        }
    }

    private void swap(int idx1, int idx2){
        E elem1 = (E) elements[idx1];
        elements[idx1] = elements[idx2];
        elements[idx2] = elem1;
    }

    private void ensureCapacity(){
        if(size >= elements.length){
            int newCapacity = 2 * elements.length;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }


    public class Main{
        public static void main(String[] args) {
            MyPriorityQueue<Integer> pq = new MyPriorityQueue<Integer>();

            pq.offer(36);
            pq.offer(45);
            pq.offer(18);
            pq.offer(27);
            pq.offer(9);
            pq.offer(50);
            System.out.println(Arrays.toString(pq.elements));

            while(!pq.isEmpty()){
                int polled = pq.poll();
                System.out.println(polled);
            }
        }
    }
}
