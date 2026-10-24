package day06;

public class TestMap {
    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        for (int i = 0; i < 1000; i++) {
            map.put(i, "v" + i);
        }
        System.out.println("size = " + map.size());   // 1000

        int hit = 0;
        for (int i = 0; i < 1000; i++) {
            if (("v" + i).equals(map.get(i))) hit++;
        }
        System.out.println("get 命中 = " + hit);       // 1000
    }
}