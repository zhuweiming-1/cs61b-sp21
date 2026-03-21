package cn.zhu.BST;

import java.util.NoSuchElementException;


public class Bst<Key extends Comparable<Key>, Value> {
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;

        public Node(Key k, Value v, int s) {
            key = k;
            value = v;
            size = s;
        }
    }

    private Node root;

    public Bst() {
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    // return number of key-value pairs in BST rooted at x


    /**
     * Does this symbol table contain the given key?
     *
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     * {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return contains(root, key);
    }

    private boolean contains(Node node, Key key) {
        if (node == null) {
            return false;
        }
        int com = key.compareTo(node.key);
        if (com == 0) {
            return true;
        }
        if (com < 0) {
            return contains(node.left, key);
        } else {
            return contains(node.right, key);
        }
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol table
     * and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        return get(root, key).value;
    }

    private Node get(Node node, Key key) {
        if (node == null) return null;
        int com = key.compareTo(node.key);
        if (com == 0) {
            return node;
        }
        if (com < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }


    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        root = put(root, key, val);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            if (value == null) {
                return null;
            }
            return new Node(key, value, 1);
        }
        int com = key.compareTo(node.key);
        if (com == 0) {
            if (value == null) {
                return null;
            }
            node.value = value;
            return node;
        }
        if (com < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }


    /**
     * Removes the smallest key and associated value from the symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMin() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = 1 + size(node.left) + size(node.left);
        return node;
    }


    /**
     * Removes the largest key and associated value from the symbol table.
     *
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMax() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.size = 1 + size(node.left) + size(node.left);
        return node;
    }


    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (get(key) == null) {
            return;
        }
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int com = key.compareTo(node.key);
        if (com == 0) {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            // 两个孩子
            Node nextNode = deleteMin(node.right); // 后继节点
            return nextNode;
        }
        if (com < 0) {
            node.left = delete(node.left, key);
        } else {
            node.right = delete(node.right, key);
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }


    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }


    /**
     * Returns the largest key in the symbol table.
     *
     * @return the largest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key max() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }


    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException   if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        Node node = floor(root, key);
        if (node == null) {
            throw new NoSuchElementException();
        }

        return node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int com = key.compareTo(node.key);
        if (com == 0) {
            return node;
        }
        if (com < 0) {
            return floor(node.left, key);
        }
        Node node2 = floor(node.right, key);
        if (node2 == null) {
            return node;
        }
        return node2;
    }


    public Key floor2(Key key) {
        return null;
    }


    /**
     * Returns the smallest key in the symbol table greater than or equal to {@code key}.
     *
     * @param key the key
     * @return the smallest key in the symbol table greater than or equal to {@code key}
     * @throws NoSuchElementException   if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key ceiling(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Node node = ceiling(root, key);
        if (node == null) {
            throw new NoSuchElementException();
        }
        return node.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int com = key.compareTo(node.key);
        if (com == 0) {
            return node;
        }
        if (com > 0) {
            return ceiling(node.right, key);
        }
        Node ceiling = ceiling(node.left, key);
        if (ceiling == null) {
            return node;
        }
        return ceiling;
    }


    /**
     * Return the key in the symbol table of a given {@code rank}.
     * This key has the property that there are {@code rank} keys in
     * the symbol table that are smaller. In other words, this key is the
     * ({@code rank}+1)st smallest key in the symbol table.
     *
     * @param rank the order statistic
     * @return the key in the symbol table of given {@code rank}
     * @throws IllegalArgumentException unless {@code rank} is between 0 and
     *                                  <em>n</em>–1
     */
    public Key select(int rank) {
        return null;
    }

    // Return key in BST rooted at x of given rank.
    // Precondition: rank is in legal range.


    /**
     * Return the number of keys in the symbol table strictly less than {@code key}.
     *
     * @param key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public int rank(Key key) {
        return 0;
    }


    /**
     * Returns all keys in the symbol table in ascending order,
     * as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table in ascending order
     */
    public Iterable<Key> keys() {
        return null;
    }

    /**
     * Returns all keys in the symbol table in the given range
     * in ascending order, as an {@code Iterable}.
     *
     * @param lo minimum endpoint
     * @param hi maximum endpoint
     * @return all keys in the symbol table between {@code lo}
     * (inclusive) and {@code hi} (inclusive) in ascending order
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *                                  is {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }


    /**
     * Returns the number of keys in the symbol table in the given range.
     *
     * @param lo minimum endpoint
     * @param hi maximum endpoint
     * @return the number of keys in the symbol table between {@code lo}
     * (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *                                  is {@code null}
     */
    public int size(Key lo, Key hi) {
        return 0;
    }

    /**
     * Returns the height of the BST (for debugging).
     *
     * @return the height of the BST (a 1-node tree has height 0)
     */
    public int height() {
        return 0;
    }


    /**
     * Returns the keys in the BST in level order (for debugging).
     *
     * @return the keys in the BST in level order traversal
     */
    public Iterable<Key> levelOrder() {
        return null;
    }


}
