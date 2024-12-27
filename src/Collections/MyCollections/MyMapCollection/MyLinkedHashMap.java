package Collections.MyCollections.MyMapCollection;

@SuppressWarnings("unchecked")
public class MyLinkedHashMap<K, V> implements IMyMap<K, V> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static class Node<K, V> implements IMyMap.Entry<K, V> {
        private final int hashCode;
        private final K key;
        private V value;
        public Node<K, V> next;
        public Node<K, V> prevLinked;
        public Node<K, V> nextLinked;

        public Node(K key, V value) {
            this.hashCode = hash(key);
            this.key = key;
            this.value = value;
            this.next = null;
            this.prevLinked = null;
            this.nextLinked = null;
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
    private Node<K, V> head;
    private Node<K, V> tail;

    private boolean isAccessOrder;

    public MyLinkedHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR, false);
    }

    public MyLinkedHashMap(boolean isAccessOrder){
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR, isAccessOrder);
    }

    public MyLinkedHashMap(int initialCapacity, float loadFactor, boolean isAccessOrder) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        if (loadFactor <= 0 || loadFactor > 1) {
            throw new IllegalArgumentException("Illegal LoadFactor: " + loadFactor);
        }
        this.table = new Node[initialCapacity];
        this.loadFactor = loadFactor;
        this.thresholdCapacity = (int) (initialCapacity * loadFactor);
        this.size = 0;
        this.head = null;
        this.tail = null;

        this.isAccessOrder = isAccessOrder;
    }

    private static int hash(Object key) {
        int h = key == null ? 0 : key.hashCode();
        return h ^ (h >>> 16);
    }

    @Override
    public V put(K key, V value) {
        int hash = hash(key);
        int index = hash % table.length;
        Node<K, V> newNode = new Node<>(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node<K, V> currNode = table[index];
            while (currNode.next != null) {
                if (currNode.equalNode(hash, key)) {
                    currNode.setValue(value);
                    if(isAccessOrder){
                        afterNodeAccess(currNode);
                    }
                    return value;
                }
                currNode = currNode.next;
            }
            if (currNode.equalNode(hash, key)) {
                currNode.setValue(value);
                if(isAccessOrder){
                    afterNodeAccess(currNode);
                }
                return value;
            }
            currNode.next = newNode;
        }

        addToLinkedList(newNode);
        size++;

        if (size > thresholdCapacity) {
            resize();
        }
        return value;
    }

    private void addToLinkedList(Node<K, V> node) {
        if (tail == null) {
            head = tail = node;
        } else {
            tail.nextLinked = node;
            node.prevLinked = tail;
            node.nextLinked = null;
            tail = node;
        }
    }

    @Override
    public V get(K key) {
        Node<K, V> node = getNode(key);
        if(isAccessOrder && node != null){
            afterNodeAccess(node);
        }

        return node == null ? null : node.getValue();
    }

    @Override
    public V getOrDefault(K key, V defaultValue) {
        Node<K, V> node = getNode(key);
        if(isAccessOrder && node != null){
            afterNodeAccess(node);
        }
        
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

    // for maintaining Access order if isAccess = true
    private void afterNodeAccess(Node<K, V> node){
        removeFromLinkedList(node);

        addToLinkedList(node);
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
                removeFromLinkedList(currNode);
                size--;
                return currNode.getValue();
            }
            prevNode = currNode;
            currNode = currNode.next;
        }

        return null;
    }

    private void removeFromLinkedList(Node<K, V> node) {
        if (node.prevLinked == null) {
            head = node.nextLinked;
        } else {
            node.prevLinked.nextLinked = node.nextLinked;
        }

        if (node.nextLinked == null) {
            tail = node.prevLinked;
        } else {
            node.nextLinked.prevLinked = node.prevLinked;
        }
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

    public void printMap() {
        Node<K, V> current = head;
        while (current != null) {
            System.out.print(current.key + "=" + current.value + " -> ");
            current = current.nextLinked;
        }
        System.out.println("null");
    }

    private void resize() {
        Node<K, V>[] oldTable = this.table;
        int newCapacity = oldTable.length * 2;
        Node<K, V>[] newTable = new Node[newCapacity];

        for (Node<K, V> currNode : oldTable) {
            while (currNode != null) {
                int newIndex = currNode.hashCode % newCapacity;

                Node<K, V> nextNode = currNode.next;
                currNode.next = newTable[newIndex];
                newTable[newIndex] = currNode;

                currNode = nextNode;
            }
        }

        this.table = newTable;
        thresholdCapacity = (int) (newCapacity * loadFactor);
    }

    public static class Main{
        public static void main(String[] args) {
            MyLinkedHashMap<Integer, String> insertionOrderMap = new MyLinkedHashMap<Integer, String>();
    
            insertionOrderMap.put(1, "One");
            insertionOrderMap.put(2, "Two");
            insertionOrderMap.put(3, "Three");
    
            System.out.println("InsertionOrder Map:");
            insertionOrderMap.printMap(); // 1=One -> 2=Two -> 3=Three -> null
    
            insertionOrderMap.get(2); // Access key 2
            System.out.println("After accessing key 2:");
            insertionOrderMap.printMap(); // 1=One -> 2=Two -> 3=Three -> null
    
            insertionOrderMap.remove(1);
            System.out.println("After removing key 1:");
            insertionOrderMap.printMap(); // 2=Two -> 3=Three -> null

            insertionOrderMap.put(4, "Four");
            System.out.println("After adding key: 4"); // 2=Two -> 3=Three -> 4=Four -> null
            insertionOrderMap.printMap();

            insertionOrderMap.put(2, "TwoNew");
            System.out.println("After updating key: 2"); // 2=TwoNew -> 3=Three -> 4=Four -> null
            insertionOrderMap.printMap();



            System.out.println("****************************************************************");

            MyLinkedHashMap<Integer, String> accessOrderMap = new MyLinkedHashMap<Integer, String>(true);
    
            accessOrderMap.put(1, "One");
            accessOrderMap.put(2, "Two");
            accessOrderMap.put(3, "Three");
    
            System.out.println("AccessOrder Map:");
            accessOrderMap.printMap(); // 1=One -> 2=Two -> 3=Three -> null
    
            accessOrderMap.get(2); // Access key 2
            System.out.println("After accessing key 2:");
            accessOrderMap.printMap(); // 1=One -> 3=Three -> 2=Two -> null
    
            accessOrderMap.remove(1);
            System.out.println("After removing key 1:");
            accessOrderMap.printMap(); // 3=Three -> 2=Two -> null

            accessOrderMap.put(4, "Four");
            System.out.println("After adding key: 4"); // 3=Three -> 2=Two -> 4=Four -> null
            accessOrderMap.printMap();

            accessOrderMap.put(2, "TwoNew");
            System.out.println("After updating key: 2"); // 3=Three -> 4=Four -> 2=Two -> null
            accessOrderMap.printMap();
        }
    }
}

