package Collections.MyCollections.MySetCollection;

import Collections.MyCollections.MyMapCollection.MyHashMap;

public class MyHashSet<E> {
    private static final Object PRESENT = new Object();
    private MyHashMap<E, Object> hashMap;

    public MyHashSet() {
        hashMap = new MyHashMap<E, Object>();
    }

    public MyHashSet(int initialCapacity, float loadFactor) {
        hashMap = new MyHashMap<E, Object>(initialCapacity, loadFactor);
    }

    public boolean add(E elem) {
        return hashMap.put(elem, PRESENT) == null;
    }

    public boolean remove(E elem) {
        return hashMap.remove(elem) == PRESENT;
    }

    public int size() {
        return hashMap.size();
    }

    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    public boolean contains(E elem) {
        return hashMap.containsKey(elem);
    }
}
