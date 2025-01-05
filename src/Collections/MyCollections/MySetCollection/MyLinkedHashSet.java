package Collections.MyCollections.MySetCollection;

import Collections.MyCollections.MyMapCollection.MyLinkedHashMap;

public class MyLinkedHashSet<E> {
    private static final Object PRESENT = new Object();
    private MyLinkedHashMap<E, Object> linkedHashMap;

    public MyLinkedHashSet() {
        linkedHashMap = new MyLinkedHashMap<E, Object>();
    }

    public MyLinkedHashSet(int initialCapacity, float loadFactor) {
        linkedHashMap = new MyLinkedHashMap<E, Object>(initialCapacity, loadFactor, false);
    }

    public boolean add(E elem) {
        return linkedHashMap.put(elem, PRESENT) == null;
    }

    public boolean remove(E elem) {
        return linkedHashMap.remove(elem) == PRESENT;
    }

    public int size() {
        return linkedHashMap.size();
    }

    public boolean isEmpty() {
        return linkedHashMap.isEmpty();
    }

    public boolean contains(E elem) {
        return linkedHashMap.containsKey(elem);
    }
}
