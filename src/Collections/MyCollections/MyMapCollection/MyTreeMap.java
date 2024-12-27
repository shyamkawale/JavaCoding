package Collections.MyCollections.MyMapCollection;

import java.util.Comparator;
import java.util.NoSuchElementException;

// Needs review
@SuppressWarnings("unchecked")
public class MyTreeMap<K, V> implements IMyMap<K, V>{
    private static class TreeMapNode<K, V> {
        K key;
        V value;
        TreeMapNode<K, V> left;
        TreeMapNode<K, V> right;
        TreeMapNode<K, V> parent;

        TreeMapNode(K key, V value, TreeMapNode<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    private TreeMapNode<K, V> root;
    private int size = 0;
    private final Comparator<? super K> comparator;

    public MyTreeMap() {
        this.comparator = null; // Natural ordering if K implements Comparable
    }

    public MyTreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    private int compare(K key1, K key2) {
        if (comparator != null) {
            return comparator.compare(key1, key2);
        }
        Comparable<? super K> cmpKey1 = (Comparable<? super K>) key1;
        return cmpKey1.compareTo(key2);
    }

    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }

        if (root == null) {
            root = new TreeMapNode<>(key, value, null);
            size++;
            return value;
        }

        TreeMapNode<K, V> current = root;
        TreeMapNode<K, V> parent;
        int cmp;

        do {
            parent = current;
            cmp = compare(key, current.key);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
        } while (current != null);

        TreeMapNode<K, V> newNode = new TreeMapNode<>(key, value, parent);
        if (cmp < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        size++;
        return null;
    }

    public V get(K key) {
        TreeMapNode<K, V> node = getNode(key);
        return node == null ? null : node.value;
    }

    public V getOrDefault(K key, V defaultValue) {
        TreeMapNode<K, V> node = getNode(key);
        return node == null ? defaultValue : node.value;
    }

    private TreeMapNode<K, V> getNode(K key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }

        TreeMapNode<K, V> current = root;
        while (current != null) {
            int cmp = compare(key, current.key);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public V remove(K key) {
        TreeMapNode<K, V> node = getNode(key);
        if (node == null) {
            return null;
        }
        V oldValue = node.value;
        deleteNode(node);
        return oldValue;
    }

    private void deleteNode(TreeMapNode<K, V> node) {
        if (node.left == null && node.right == null) {
            replaceNode(node, null);
        } else if (node.left != null && node.right != null) {
            TreeMapNode<K, V> successor = getSuccessor(node);
            node.key = successor.key;
            node.value = successor.value;
            deleteNode(successor);
        } else {
            TreeMapNode<K, V> child = (node.left != null) ? node.left : node.right;
            replaceNode(node, child);
        }
        size--;
    }

    private TreeMapNode<K, V> getSuccessor(TreeMapNode<K, V> node) {
        if (node.right != null) {
            TreeMapNode<K, V> current = node.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        } else {
            TreeMapNode<K, V> current = node;
            TreeMapNode<K, V> parent = node.parent;
            while (parent != null && current == parent.right) {
                current = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private void replaceNode(TreeMapNode<K, V> oldNode, TreeMapNode<K, V> newNode) {
        if (oldNode.parent == null) {
            root = newNode;
        } else if (oldNode == oldNode.parent.left) {
            oldNode.parent.left = newNode;
        } else {
            oldNode.parent.right = newNode;
        }

        if (newNode != null) {
            newNode.parent = oldNode.parent;
        }
    }

    public K firstKey() {
        if (root == null) {
            throw new NoSuchElementException("TreeMap is empty");
        }
        TreeMapNode<K, V> current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.key;
    }

    public K lastKey() {
        if (root == null) {
            throw new NoSuchElementException("TreeMap is empty");
        }
        TreeMapNode<K, V> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.key;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(K key) {
        return getNode(key) != null;
    }

    public void printMap() {
        if (root == null) {
            System.out.println("Map is empty.");
            return;
        }
        printInOrder(root);
        System.out.println();
    }
    
    private void printInOrder(TreeMapNode<K, V> node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.key + "=" + node.value + " -> ");
        printInOrder(node.right);
    }


    public static class Main{
        public static void main(String[] args) {
            MyTreeMap<Integer, String> treeMap = new MyTreeMap<Integer, String>();
    
            treeMap.put(5, "Five");
            treeMap.put(3, "Three");
            treeMap.put(1, "One");
            treeMap.put(2, "Two");
            
    
            System.out.println("InsertionOrder Map:");
            treeMap.printMap(); // 1=One -> 2=Two -> 3=Three -> 
    
            treeMap.remove(1);
            System.out.println("After removing key 1:");
            treeMap.printMap(); // 2=Two -> 3=Three -> null

            treeMap.put(4, "Four");
            System.out.println("After adding key: 4"); // 2=Two -> 3=Three -> 4=Four -> null
            treeMap.printMap();

            treeMap.put(2, "TwoNew");
            System.out.println("After updating key: 2"); // 2=TwoNew -> 3=Three -> 4=Four -> null
            treeMap.printMap();
        }
    }
}
