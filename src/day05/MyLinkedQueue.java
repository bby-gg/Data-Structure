package day05;

public class MyLinkedQueue<E> {
    private static class Node<E>{
        E data;
        Node<E> next;
        Node(E data){
            this.data = data;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int size;
    public MyLinkedQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void enqueue(E e){
        Node<E> newNode = new Node<>(e);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public E dequeue(){
        if(size == 0){
            throw new RuntimeException("队列为空");
        }
        E oldValue = head.data;
        head = head.next;
        if(size == 1){
            tail = null;
        }
        size--;
        return oldValue;
    }
    public E peek(){
        if(size == 0){
            throw new RuntimeException("队列为空");
        }
        return head.data;
    }
}
