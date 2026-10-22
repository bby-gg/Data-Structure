package day05;

public class MyCircularQueue<E>{
    private Object[] data;
    private int front;
    private int rear;// 队尾指针（指向下一个空位）
    private int size;

    private static  final int  DEFAULT_CAPACITY = 16;
    public MyCircularQueue(){
        data = new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    public void enqueue(E e){
        if(size == data.length){
            resize(data.length * 2);
        }
        data[rear] = e;
        rear = (rear + 1) % data.length;
        size++;
    }
    public void resize(int newCapacity){
        Object[] newData = new Object[newCapacity];
        for(int i = 0;i<size;i++){
             newData[i] = data[(front + i) % data.length];
        }
        data = newData;
    }
    public E dequeue(){
        if(size == 0){
            throw new IndexOutOfBoundsException("不能为空");
        }
        E oldValue = (E)data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return oldValue;
    }
}
