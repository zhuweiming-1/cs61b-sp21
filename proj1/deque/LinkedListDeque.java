package deque;

import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedListDeque<T> implements Deque<T> {


    private class Node {
        Node pre;
        T value;
        Node next;

        Node(Node pre, T value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }


    @Override
    public void addFirst(T item) {
        Node next = sentinel.next;
        Node node = new Node(sentinel, item, next);
        sentinel.next = node;
        next.pre = node;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node pre = sentinel.pre;
        Node node = new Node(pre, item, sentinel);
        sentinel.pre = node;
        pre.next = node;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        String deque = toString();
        System.out.println(deque);
    }

    @Override
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        Node curr = sentinel.next;
        Node next = curr.next;
        sentinel.next = next;
        next.pre = sentinel;
        size--;
        return curr.value;
    }

    @Override
    public T removeLast() {
        if (sentinel.pre == sentinel) {
            return null;
        }
        Node curr = sentinel.pre;
        Node pre = curr.pre;
        sentinel.pre = pre;
        pre.next = sentinel;
        size--;
        return curr.value;
    }

    @Override
    public T get(int index) {
        Node curr = sentinel.next;
        int c = 0;
        while (curr != sentinel && c < size) {
            if (c == index) {
                return curr.value;
            }
            curr = curr.next;
            c++;
        }
        return null;
    }

    public T getRecursive(int index) {
        return getRecursiveHelp(sentinel.next, index);
    }

    private T getRecursiveHelp(Node curr, int index) {
        if (curr == sentinel) {
            return null;
        }
        if (index == 0) {
            return curr.value;
        }
        return getRecursiveHelp(curr.next, index - 1);
    }

    @Override
    public String toString() {
        Node curr = sentinel.next;
        StringJoiner sj = new StringJoiner(" ");

        while (curr != sentinel) {
            sj.add(curr.value.toString());
            curr = curr.next;
        }
        return sj.toString();
    }

    public Iterator<T> iterator() {
        return null;
    }

    public class LinkedListDequeIterator implements Iterator<T> {
        Node curr = sentinel.next;

        @Override
        public boolean hasNext() {
            return curr != sentinel;
        }

        @Override
        public T next() {
            T result = curr.value;
            curr = curr.next;
            return result;
        }
    }

}
