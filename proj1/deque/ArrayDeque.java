package deque;

import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

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
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = correctIndexPosition(nextFirst - 1);
        size++;
    }

    private static final double THRESHOLD = 0.25;
    private static final int LEN_THRESHOLD = 16;

    private void autoResize() {
        int len = items.length;
        double threshold = size * 1.0 / len;
        if (len >= LEN_THRESHOLD && threshold < THRESHOLD) {
            len = len / 2;
            while (threshold < THRESHOLD && len >= LEN_THRESHOLD) {
                len = len / 2;
                threshold = size * 1.0 / len;
            }
            resize(len);
        }

    }

    private void resize(int len) {
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
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = correctIndexPosition(nextLast + 1);
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
        if (size <= 0) {
            return null;
        }
        int next = correctIndexPosition(nextFirst + 1);
        T result = items[next];
        items[next] = null;
        nextFirst = next;
        size--;
        autoResize();
        return result;
    }

    @Override
    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        int next = correctIndexPosition(nextLast - 1);
        T result = items[next];
        items[next] = null;
        nextLast = next;
        size--;
        autoResize();
        return result;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[correctIndexPosition(nextFirst + 1 + index)];
    }

/*    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < size; i++) {
            sj.add(items[correctIndexPosition(nextFirst + 1 + i)].toString());
        }
        return sj.toString();
    }*/

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Deque) {
            Deque d = (Deque) obj;
            if (d.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!d.get(i).equals(get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayQueryIterator();
    }

    public class ArrayQueryIterator implements Iterator<T> {
        int curr = correctIndexPosition(nextFirst + 1);
        int c = 0;

        @Override
        public boolean hasNext() {
            return c < size;
        }

        @Override
        public T next() {
            T result = items[curr];
            curr = correctIndexPosition(curr + 1);
            c++;
            return result;
        }
    }
}
