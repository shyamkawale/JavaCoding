package Collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class CollectionMain {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Types of List
        ArrayList<Integer> list = new ArrayList<Integer>(); // implementation in MyArrayList.java
        LinkedList<Integer> linkedlist = new LinkedList<Integer>(); // implementation in LinkedList.java
        Vector<Integer> vector = new Vector<Integer>(); // implementation similar to ArrayList

        // Types of Stack
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10); // Push element onto the stack
        stack.push(20);
        int top = stack.peek(); // Peek the top element (20)
        int popped = stack.pop(); // Pop the top element (20)

        LinkedList<Integer> lStack = new LinkedList<Integer>();
        lStack.addFirst(10); // Push element onto the stack
        lStack.addFirst(20);
        int ltop = lStack.peekFirst(); // Peek the top element (20)
        int lpopped = lStack.removeFirst(); // Pop the top element (20)

        Deque<Integer> dStack = new ArrayDeque<Integer>();
        dStack.push(10); // Push element onto the stack
        dStack.push(20);
        int dtop = dStack.peek(); // Peek the top element (20)
        int dpopped = dStack.pop(); // Pop the top element (20)

        // Types of Queues
        Queue<Integer> lQueue = new LinkedList<Integer>(); //uses doubly linked list
        lQueue.offer(10);
        lQueue.offer(20);
        int lfront = lQueue.peek();
        int lpolled = lQueue.poll();

        Queue<Integer> aQueue = new ArrayDeque<Integer>(); //uses circular array
        aQueue.offer(10);
        aQueue.offer(20);
        int afront = aQueue.peek();
        int apolled = aQueue.poll();

        Queue<Integer> pQueue = new PriorityQueue<Integer>(); // default is minHeap
        pQueue.offer(10);
        pQueue.offer(20);
        int pQfront = pQueue.peek();
        int pQpolled = pQueue.poll();

    }
}
