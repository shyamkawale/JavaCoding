package Collections.MyCollections.MyMapCollection;

import java.util.HashSet;
import java.util.Set;

// HashMap implementation without treeify
@SuppressWarnings("unchecked")
public class MyHashMap<K, V> implements IMyMap<K, V> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static class Node<K, V> implements IMyMap.Entry<K, V> {
        private final int hashCode;
        private final K key;
        private V value;
        public Node<K, V> next;

        public Node(K key, V value) {
            this.hashCode = hash(key);
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final void setValue(V newValue) {
            this.value = newValue;
        }

        public boolean equalNode(int hashCode, K key) {
            return this.hashCode == hashCode && (key == this.getKey() || (key != null && key.equals(this.getKey())));
        }
    }

    private Node<K, V>[] table;
    private int size;
    private final float loadFactor;
    private int thresholdCapacity;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        if (loadFactor < 0 || loadFactor > 1) {
            throw new IllegalArgumentException("Illegal LoadFactor: " + loadFactor);
        }
        this.table = new Node[initialCapacity]; // new Node<K, V>[DEFAULT_CAPACITY]; why generics not allowed here?
        this.loadFactor = loadFactor;
        this.thresholdCapacity = (int) (initialCapacity * loadFactor); // see variables video
        this.size = 0;
    }

    private static int hash(Object key) {
        int h = key == null ? 0 : key.hashCode();
        return h ^ (h >>> 16);
    }

    @Override
    public V put(K key, V value) {
        int hash = hash(key);
        int index = hash % table.length; // (hash & (table.length - 1));
        Node<K, V> newNode = new Node<K, V>(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node<K, V> currNode = table[index];
            while (currNode.next != null) {
                if (currNode.equalNode(hash, key)) {
                    currNode.setValue(value);
                    return value;
                }
                currNode = currNode.next;
            }
            if (currNode.equalNode(hash, key)) {
                currNode.setValue(value);
                return value;
            }
            currNode.next = newNode;
        }
        size++;

        if (size > thresholdCapacity) {
            resize();
        }
        return value;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = getNode(key);
        return node == null ? null : node.getValue();
    }

    @Override
    public V getOrDefault(K key, V defaultValue) {
        Node<K, V> node = getNode(key);
        return node == null ? defaultValue : node.getValue();
    }

    private Node<K, V> getNode(K key){
        int hash = hash(key);
        int index = hash % table.length;
        Node<K, V> currNode = table[index];

        while (currNode != null) {
            if (currNode.equalNode(hash, key)) {
                return currNode;
            }
            currNode = currNode.next;
        }

        return null;
    }

    @Override
    public V remove(K key) {
        int hash = hash(key);
        int index = hash % table.length;
        Node<K, V> currNode = table[index];
        Node<K, V> prevNode = null;

        while (currNode != null) {
            if (currNode.equalNode(hash, key)) {
                if (prevNode == null) {
                    table[index] = currNode.next;
                } else {
                    prevNode.next = currNode.next;
                }
                size--;
                return currNode.getValue();
            }
            prevNode = currNode;
            currNode = currNode.next;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public Set<Node<K, V>> entrySet() {
        Set<Node<K, V>> set = new HashSet<Node<K, V>>();

        for (int i = 0; i < thresholdCapacity; i++) {
            Node<K, V> currNode = this.table[i];
            while (currNode != null) {
                set.add(currNode);
                currNode = currNode.next;
            }
        }
        return set;
    }

    public void printMap() {
        for (Node<K, V> m : entrySet()) {
            System.out.print("{ " + m.getKey() + " => " + m.getValue() + " } ");
        }
        System.out.println();
    }

    private void resize() {
        Node<K, V>[] oldTable = this.table;
        int newCapacity = oldTable.length * 2;
        Node<K, V>[] newTable = new Node[newCapacity];

        for (Node<K, V> currNode : oldTable) {
            while (currNode != null) {
                int newIndex = currNode.hashCode % newCapacity;

                // adding currNode at start of newTable[newIndex] node
                Node<K, V> nextNode = currNode.next;
                currNode.next = newTable[newIndex];
                newTable[newIndex] = currNode;

                currNode = nextNode;
            }
        }

        this.table = newTable;
        thresholdCapacity = (int) (newCapacity * loadFactor);
    }

    public static class Main {
        @SuppressWarnings("unused")
        public static void main(String[] args) {
            IMyMap<Integer, String> map = new MyHashMap<Integer, String>();

            map.put(0, "zero");
            map.put(1, "one");
            map.put(2, "two");
            map.put(null, "null");
            map.put(10, "ten");
            map.put(null, "anothernull");
            map.put(0, "anotherzero");
            map.put(10, "tenmodified");

            boolean isKeyPresent = map.containsKey(2);
            String val = map.get(2);
            String val1 = map.get(null);
            map.remove(2);

            map.printMap();
        }
    }
}