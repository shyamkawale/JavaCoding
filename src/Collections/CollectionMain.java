package Collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

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

        //Deque
        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.offerFirst(10);
        deque.addLast(20);
        int dQFront = deque.peekFirst();
        int dQLast = deque.peekLast();
        int dqFrontPolled = deque.pollFirst();
        int dqLastPolled = deque.pollLast();

        // Types of Map
        // HashMap
        Map<Integer, String> hashMap = new HashMap<Integer, String>();
        Set<Map.Entry<Integer, String>> entrySet = hashMap.entrySet();
        Set<Integer> keySet = hashMap.keySet();
        Collection<String> valuesCollection = hashMap.values();

        // LinkedHashMap
        Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(); // HashMap + insertion order/ access order
        Set<Map.Entry<Integer, String>> entryllSet = linkedHashMap.entrySet();
        Set<Integer> keyllSet = linkedHashMap.keySet();
        Collection<String> valuesllCollection = linkedHashMap.values();

        // TreeMap
        Map<Integer, String> treeMap = new TreeMap<Integer, String>(); // sorted order
        Set<Map.Entry<Integer, String>> entrytreeSet = treeMap.entrySet();
        Set<Integer> keytreeSet = treeMap.keySet();
        Collection<String> valuestreeCollection = treeMap.values();

        // Hashtable
        Map<Integer, String> hashTable = new Hashtable<Integer, String>(); // HashMap + thread-safe
        //ConcurrentHashMap
        Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<Integer, String>(); // HashMap + thread-safe(highly-concurrent implementation)


        // Types of Set
        // HashSet
        Set<Integer> hashSet = new HashSet<Integer>();

        // LinkedHashSet
        Set<Integer> linkedHashSet = new LinkedHashSet<Integer>(); // insertion order

        // TreeSet
        Set<Integer> treeSet = new TreeSet<Integer>(); // sorted order

    }
}
