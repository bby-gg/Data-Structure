package day04;

public class MyArrayStack<E> {
    private Object[] data;
    private  int size;
    private static final int DEFAULT_CAPACIY = 16;

    public MyArrayStack(){
        data = new Object[DEFAULT_CAPACIY];
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return this.size;
    }
    public void push(E e){
        if(size == data.length){
            resize(data.length * 2);
        }
        data[size] = e;
        size++;
    }
    public void resize(int newCapacity){
        Object[] newdata = new Object[newCapacity];
        for(int i = 0;i<size;i++){
            newdata[i] = data[i];
        }
        data = newdata;
    }
    public E peek(){
        if(size == 0){
            throw new RuntimeException("栈为空");
        }
        return (E)data[size - 1];
    }
    public E pop(){
        if(size == 0){
            throw new RuntimeException("栈为空");
        }
        E value = (E) data[size -1];
        data[size - 1] = null;
        size--;
        return value;
    }

}
