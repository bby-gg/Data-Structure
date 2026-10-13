package day01;


public class MyArrayList<E> {
    //底层用整数类型
    private Object[] data;

    //当前元素个数
    private int size;

    //默认初始容量为16
    private static final int DEFAULT_CAPACITY = 16;

    //无参构造
    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }
    // 指定容量构造
    public MyArrayList(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException("容量不能为负" + initialCapacity);
        }
        data = new Object[initialCapacity];
        size = 0;
    }
    public int size(){
        return  this.size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void add(E e){
        if(size == data.length){
            resize(data.length * 2);
        }
        data[size] = e;
        size ++ ;
    }
    private void resize(int newCapacity){  //newCapacity新数组的长度。
        Object[] newData = new Object[newCapacity];
        for(int i = 0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }
    public E get(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }else {
            return (E)data[index];
        }
    }
    public E set(int index,E element){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        E oldValue = (E) data[index];
        data[index] = element;
        return oldValue;
    }
    public E remove(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        E oldValue = (E) data[index];
        for(int i = index;i<size - 1;i++){
            data[i] = data[i+1];
        }
        data[size - 1] = null;
        size --;
        return oldValue;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0;i<size;i++){
            sb.append(data[i]);
            if(i<size - 1 ){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
