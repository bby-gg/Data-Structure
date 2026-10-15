package day02;

public class MyLinkedList<E> {
    //内部类：节点
    private static class Node<E>{
        E data;
        Node<E> next;

        Node(E data){
            this.data = data;
        }
    }
    //头节点
    private Node<E> head;
    private Node<E>tail;

    //元素个数
    private int size;

    //不带哨兵版本
    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void addLast(E e){
        Node<E> newNode = new Node<>(e);
        if(size == 0){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        Node<E> cur = head;
        for(int i = 0;i<index;i++){
            cur = cur.next;
        }
        return cur.data;
    }

    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        if(index == 0){
            addFirst(e);
            return;
        }
        if(index == size){
            addLast(e);
            return;
        }
        Node<E> pre = head;
        for(int i = 0;i<index-1;i++){
            pre = pre.next;
        }
        Node<E> newNode = new Node<>(e);
        newNode.next = pre.next;
        pre.next = newNode;
        size++;
    }
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        E removed;
        if(index == 0){
            removed = head.data;
            head = head.next;
            if(size == 1){
                tail = null;
            }
        }else if(index == size - 1){
            Node<E> prev = head;
            for(int i = 0;i<size - 2;i++){
                prev = prev.next;
            }
            removed = prev.next.data;
            prev.next = null;
            tail = prev;
        }else {
            Node<E> pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            removed = pre.next.data;
            pre.next = pre.next.next;
        }
        size--;
        return removed;
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        E oldData = cur.data;
        cur.data = e;
        return oldData;
    }

    public void reverse(){
        if(head == null || head.next == null){
            return;
        }
        Node<E> prev =null;
        Node<E> cur = head;
        Node<E> next;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        tail = head;
        head = prev;

    }




    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> cur = head;
        sb.append("[");
        while(cur != null){
            sb.append(cur.data);
            if(cur.next!=null){
                sb.append(", ");
            }
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
