package day03;

//双链表
public class MyLinkedList<E> {
    private static class Node<E>{
        E data;
        Node<E> prev;
        Node<E> next;
        Node(E data){this.data = data;}
    }
    private Node<E> dummyHead;
    private Node<E> dummyTail;
    private int size;

    public MyLinkedList(){
        dummyHead = new Node<>(null);
        dummyTail = new Node<>(null);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        Node<E> oldFirst = dummyHead.next;
        newNode.prev = dummyHead;
        newNode.next = oldFirst;
        dummyHead.next = newNode;
        oldFirst.prev = newNode;
        size++;
    }
    public void addLast(E e){
        Node<E> newNode = new Node<>(e);
        Node<E> oldLast = dummyTail.prev;
        newNode.prev = oldLast;
        newNode.next = dummyTail;
        oldLast.next = newNode;
        dummyTail.prev = newNode;
        size++;
    }

    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        Node<E> cur = dummyHead.next;
        for(int i = 0;i<index;i++){
            cur = cur.next;
        }
        return cur.data;
    }

    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        Node<E> cur = dummyHead.next;
        for(int i = 0;i<index;i++){
            cur = cur.next;
        }
        E removed = cur.data;
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
        return removed;
    }




    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> cur = dummyHead.next;
        sb.append("[");
        while(cur != dummyTail){
            sb.append(cur.data);
            if(cur.next != dummyTail){
                sb.append(", ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
