package day06;


public class MyHashSet<E> {
    private static final Object PRESNT = new Object();
    private final MyHashMap<E,Object> map;

    public MyHashSet(){
        map = new MyHashMap<>();
    }
    public boolean add(E e){
        boolean existed = contains(e);
        map.put(e, PRESNT);
        return !existed;
    }
    public boolean contains(E e){
        return map.get(e) != null;
    }
    public boolean remove(E e){
        return map.remove(e) != null;
    }
    public int size(){
        return map.size();
    }
    public boolean isEmpty(){
        return map.isEmpty();
    }

}
