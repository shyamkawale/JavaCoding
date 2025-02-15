package Concepts.Classes.Generics;

public class Pair<K, V> {
    K key;
    V val;

    public Pair(K key, V val) {
        this.key = key;
        this.val = val;
    }
}
