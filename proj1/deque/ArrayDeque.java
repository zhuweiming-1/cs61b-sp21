package deque;

import java.util.StringJoiner;

public class ArrayDeque<T> implements Deque<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    @Override
    public void addFirst(T item) {
        autoResize();
        items[nextFirst] = item;
        nextFirst = correctIndexPosition(nextFirst - 1);
        size++;
    }

    private static final double THRESHOLD = 0.25;

    public void autoResize() {
        if (size == items.length) {
            resize(size * 2);
        } else {
            int len = items.length;
            double threshold = size * 1.0 / len;
            if (len >= 16 && threshold < THRESHOLD) {
                len = len / 2;
                while (threshold < THRESHOLD && len >= 16) {
                    len = len / 2;
                    threshold = size * 1.0 / len;
                }
                resize(len);
            }
        }
    }

    public void resize(int len) {
        T[] tmp = (T[]) new Object[len];
        for (int i = 0; i < size; i++) {
            tmp[i] = get(i);
        }
        items = tmp;
        nextFirst = len - 1;
        nextLast = size;
    }

    private int correctIndexPosition(int index) {
        int len = items.length;
        if (index < 0) {
            return index % len + len;
        }
        return index % len;
    }

    @Override
    public void addLast(T item) {
        autoResize();
        items[nextLast] = item;
        nextLast = correctIndexPosition(nextLast + 1);
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
        if (size <= 0) {
            return null;
        }
        autoResize();
        int next = correctIndexPosition(nextFirst + 1);
        T result = items[next];
        nextFirst = next;
        size--;
        return result;
    }

    @Override
    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        autoResize();
        int next = correctIndexPosition(nextLast - 1);
        T result = items[next];
        nextLast = next;
        size--;
        return result;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[correctIndexPosition(nextFirst + 1 + index)];
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < size; i++) {
            sj.add(items[correctIndexPosition(nextFirst + 1 + i)].toString());
        }
        return sj.toString();
    }
}
