package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private class BSTNode {
        int size;
        K key;
        V value;
        BSTNode left;
        BSTNode right;

        public BSTNode(K k, V v) {
            key = k;
            value = v;
        }
    }

    private BSTNode root;

    public BSTMap() {
        root = null;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        BSTNode node = containsKey(root, key);
        if (node == null) {
            return false;
        }
        return true;
    }

    private BSTNode containsKey(BSTNode node, K key) {
        if (node == null) {
            return null;
        }
        int com = key.compareTo(node.key);
        if (com < 0) {
            return containsKey(node.left, key);
        } else if (com > 0) {
            return containsKey(node.right, key);
        } else {
            return node;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        BSTNode node = get(root, key);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    private BSTNode get(BSTNode node, K key) {
        if (node == null) {
            return null;
        }
        int com = key.compareTo(node.key);
        if (com < 0) {
            return get(node.left, key);
        } else if (com > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }


    @Override
    public int size() {
        return size(root);
    }

    private int size(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + size(node.right) + 1;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private BSTNode put(BSTNode node, K key, V value) {
        if (node == null) {
            return new BSTNode(key, value);
        }
        int com = key.compareTo(node.key);
        if (com < 0) {
            node.left = put(node.left, key, value);
        } else if (com > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }


    public void printInOrder() {

    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }


    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
