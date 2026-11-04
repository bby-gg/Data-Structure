package day10;

import java.util.Comparator;

public class MyPriorityQueue<E> {
    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private Comparator<? super E> comparator;

    public MyPriorityQueue() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
        comparator = null;
    }

    public MyPriorityQueue(Comparator<? super E> comparator) {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
        this.comparator = comparator;
    }

    //第一次写这样外面可以直接编写规则的
    @SuppressWarnings("unchecked")
    private int compare(Object a, Object b) {
        if (comparator != null) {
            return comparator.compare((E) a, (E) b);
        }
        return ((Comparable<? super E>) a).compareTo((E) b);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E val) {
        if (data.length == size) {
            resize(data.length * 2);
        }
        data[size] = val;
        size++;
        siftUp(size - 1);
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if(compare(data[index],data[parent] )>= 0){
                break;
            }
            swap(index, parent);
            index = parent;
        }
    }

    private void resize(int newCapacity) {  //newCapacity新数组的长度。
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void swap(int i, int j) {
        Object temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public E pop() {
        if (size == 0) {
            throw new RuntimeException("堆为空");
        }
        E result = (E) data[0];
        size--;
        data[0] = data[size];
        data[size] = null;
        if (size > 0) {
            siftDown(0);
        }
        return result;
    }

    private void siftDown(int index) {
        int half = size / 2;
        // 只要当前节点还有孩子（非叶子节点），就继续往下比
        while (index < half) {
            int left = 2 * index + 1;
            int right = left + 1;
            int smaller = left;

            if (right < size) {
                if (compare(data[right], data[left]) < 0) {
                    smaller = right;
                }
            }
            if (compare(data[index], data[smaller]) <= 0) {
                break;
            }
            swap(index, smaller);
            index = smaller;
        }
    }
    public E peek() {
        if (size == 0) {
            throw new RuntimeException("优先队列为空");
        }
        return (E) data[0];
    }
}