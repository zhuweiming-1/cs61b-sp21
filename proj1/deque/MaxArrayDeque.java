package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> com;

    public MaxArrayDeque(Comparator<T> c) {
        this.com = c;
    }

    /**
     * 根据先前指定的 Comparator ，返回双端队列中的最大元素。
     * 如果 MaxArrayDeque 为空，则直接返回 null 。
     *
     * @return
     */
    public T max() {
        return max(com);
    }

    /**
     * 根据参数 Comparator c ，返回双端队列中的最大元素。
     * 如果 MaxArrayDeque 为空，则直接返回 null 。
     *
     * @param c
     * @return
     */
    public T max(Comparator<T> c) {
        if (super.isEmpty()) {
            return null;
        }
        int maxIndex = 0;
        for (int i = 1; i < size(); i++) {
            if (c.compare(get(maxIndex), get(i)) < 0) {
                maxIndex = i;
            }
        }
        return get(maxIndex);
    }
}
