package day09;

public class MyMinHeap <E extends Comparable<? super E>>{
    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public MyMinHeap(){
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void push(E val){
        if(data.length == size){
            resize(data.length * 2);
        }
        data[size] = val;
        size++;
        siftUp(size - 1);
    }
    private void siftUp(int index){
        while(index > 0){
            int parent = (index - 1) / 2;
            E currentEmp = (E) data[index];
            E bossEmp = (E) data[parent];
            int cmp = currentEmp.compareTo(bossEmp);
            if(cmp >= 0){
                break;
            }
            swap(index,parent);
            index = parent;
        }
    }

    private void resize(int newCapacity){  //newCapacity新数组的长度。
        Object[] newData = new Object[newCapacity];
        for(int i = 0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    private void swap(int i,int j){
        Object temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    public E pop(){
        if(size == 0){
            throw new RuntimeException("堆为空");
        }
        E result = (E) data[0];
        size--;
        data[0] = data[size];
        data[size] =null;
        if(size > 0){
            siftDown(0);
        }
        return  result;
    }
    private void siftDown(int index){
        int half = size / 2;
        // 只要当前节点还有孩子（非叶子节点），就继续往下比
        while(index < half){
            int left = 2 * index + 1;
            int right = left + 1;
            int smaller = left;

            if (right < size) {
                E leftVal = (E)data[left];
                E rightVal = (E)data[right];
                if(rightVal.compareTo(leftVal) < 0){
                    smaller = right;
                }
            }

            // 【第三块：拿自己跟最小的孩子比】
            E current = (E)data[index];
            E smallerChild = (E) data[smaller];

            if(current.compareTo(smallerChild) <= 0){
                break;
            }
            swap(index,smaller);
            index = smaller;
        }

    }
}
