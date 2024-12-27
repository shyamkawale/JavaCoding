package Collections.MyCollections.MyMapCollection;

public interface IMyMap<K,V> {
    public V put(K key, V value);
    
    public V get(K key);

    public V getOrDefault(K key, V value);

    public V remove(K key);

    public int size();

    public boolean isEmpty();

    public boolean containsKey(K key);

    public void printMap();

    public interface Entry<K, V> {
        public K getKey();

        public V getValue();

        public void setValue(V newValue);

        public boolean equalNode(int hashCode, K key);
    }

}
