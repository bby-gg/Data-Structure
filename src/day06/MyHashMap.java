package day06;

public class MyHashMap<K,V> {
    private static class Node<K,V>{
        K key;
        V value;
        Node<K,V> next;
        Node(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    private Node<K,V>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;


    @SuppressWarnings("unchecked")
    public MyHashMap(){
        table = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];//它创建了一个长度为 16 的“空数组”，数组里面的每个格子都是 null
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    //AI给出的，我不会
    private int hash(K key){
        if(key == null){
            return 0;
        }
        int h = key.hashCode();
        return  h ^ (h >>> 16);
    }
    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }
    public void put(K key,V value){
        int index = indexFor(hash(key), table.length);
        Node<K,V> cur = table[index];
        if(cur == null){
            Node<K,V> newNode = new Node<>(key,value);
            table[index] = newNode;
            size++;
            if(size > table.length * LOAD_FACTOR){
                resize();
            }
            return;
        }
        while(cur!=null){
            // 【关键修改】用 equals 比较内容
            if(cur.key == null ? key == null :cur.key.equals(key)){
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        Node<K,V> newNode = new Node<>(key,value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
        if(size > table.length * LOAD_FACTOR){
            resize();
        }
    }
    public V get(K key){
        int index = indexFor(hash(key), table.length);
        Node<K,V> cur = table[index];
        while(cur != null){
            if(cur.key == null ? key == null :cur.key.equals(key)){
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    private void resize(){
        Node<K,V>[] oldTable = table;
        int newCapacity = oldTable.length << 1;
        Node<K,V>[] newTable = (Node<K, V>[]) new Node[newCapacity];
        for(int i = 0;i<oldTable.length;i++){
            Node<K,V> cur = oldTable[i];
            while(cur != null){
                Node<K,V> next = cur.next;
                int newIndex = indexFor(hash(cur.key),newCapacity);
                cur.next = newTable[newIndex];
                newTable[newIndex] = cur;
                cur = next;
            }
        }
        table = newTable;
    }
    public V remove(K key){
        int index = indexFor(hash(key),table.length);
        Node<K,V> cur = table[index];
        Node<K,V> prev = null;
        while(cur != null){
            if(sameKey(key,cur.key)){
                if(prev == null){
                    table[index] = cur.next;
                }else {
                    prev.next = cur.next;
                }
                size--;
                return cur.value;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;

    }

    private static boolean sameKey(Object a,Object b){
        if(a == b){
            return true;
        }
        if(a == null || b == null){
            return false;
        }
        return a.equals(b);
    }
}
