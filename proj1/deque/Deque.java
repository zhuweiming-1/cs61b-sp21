package deque;

public interface Deque<T> {
    /**
     * 将一个类型为 T 的元素添加到双端队列的前端。你可以假设 item 永远不会为 null 。
     *
     * @param item
     */
    void addFirst(T item);

    /**
     * 将一个类型为 T 的元素添加到双端队列的尾端。你可以假设 item 永远不会为 null 。
     *
     * @param item
     */
    void addLast(T item);

    /**
     * 若双端队列为空，则返回 true ；否则返回 false 。
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 返回双端队列中元素的数量。
     *
     * @return
     */
    int size();

    /**
     * 从双端队列头部到尾部依次打印所有元素，元素之间以空格分隔。所有元素打印完毕后，输出一个换行符。
     */
    void printDeque();

    /**
     * 移除并返回双端队列前端的元素；若双端队列为空，则返回 null 。
     *
     * @return
     */
    T removeFirst();

    /**
     * 移除并返回双端队列尾部的元素；若队列为空，则返回 null 。
     *
     * @return
     */
    T removeLast();

    /**
     * 获取指定索引位置的元素，其中索引 0 表示队首，索引 1 表示下一个元素，依此类推；
     * 若该索引位置无对应元素，则返回 null 。此方法不得修改双端队列！
     *
     * @param index
     * @return
     */
    T get(int index);

}
