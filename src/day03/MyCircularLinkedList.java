package day03;

public class MyCircularLinkedList<E> {
    private static class Node<E>{
        E data;
        Node<E> prev;
        Node<E> next;
        Node(E data){this.data = data;}
    }
    private Node<E> dummy;
    private int size;

    public MyCircularLinkedList(){
        dummy = new Node<>(null);
        dummy.prev = dummy;
        dummy.next = dummy;
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
        Node<E> oldFirst = dummy.next;
        newNode.prev = dummy;
        newNode.next = oldFirst;
        dummy.next = newNode;
        oldFirst.prev = newNode;
        size++;
    }
    public void addLast(E e){
        Node<E> newNode = new Node<>(e);
        Node<E> oldLast = dummy.prev;
        newNode.prev = oldLast;
        newNode.next = dummy;
        oldLast.next = newNode;
        dummy.prev = newNode;
        size++;
    }


    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        Node<E> cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        Node<E> cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        E removed = cur.data;
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
        return removed;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> cur = dummy.next;
        while (cur != dummy) {       // ← 回到 dummy 停
            sb.append(cur.data);
            if (cur.next != dummy) {
                sb.append(", ");
            }
            cur = cur.next;
        }
        return sb.append("]").toString();
    }
}
