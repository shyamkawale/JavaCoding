package Collections.MyCollections.MySetCollection;

import Collections.MyCollections.MyMapCollection.MyTreeMap;

public class MyTreeSet<E> {
    private static final Object PRESENT = new Object();
    private MyTreeMap<E, Object> treeMap;

    public MyTreeSet() {
        treeMap = new MyTreeMap<E, Object>();
    }

    public boolean add(E elem) {
        return treeMap.put(elem, PRESENT) == null;
    }

    public boolean remove(E elem) {
        return treeMap.remove(elem) == PRESENT;
    }

    public int size() {
        return treeMap.size();
    }

    public boolean isEmpty() {
        return treeMap.isEmpty();
    }

    public boolean contains(E elem) {
        return treeMap.containsKey(elem);
    }
}
