package day06;

public class TestSet {
    public static void main(String[] args) {
        MyHashSet<String> set = new MyHashSet<>();

        System.out.println("add a: " + set.add("a"));      // true
        System.out.println("add a again: " + set.add("a")); // false（重复）
        System.out.println("add b: " + set.add("b"));      // true
        System.out.println("size: " + set.size());          // 2
        System.out.println("contains a: " + set.contains("a")); // true
        System.out.println("contains c: " + set.contains("c")); // false
        System.out.println("remove a: " + set.remove("a")); // true
        System.out.println("remove a again: " + set.remove("a")); // false
        System.out.println("contains a: " + set.contains("a")); // false
        System.out.println("size: " + set.size());          // 1
        System.out.println("isEmpty: " + set.isEmpty());    // false

        // 测 null 元素（Set 允许 null）
        set.add(null);
        System.out.println("contains null: " + set.contains(null)); // true
        set.remove(null);
        System.out.println("contains null after remove: " + set.contains(null)); // false

        // 测大量元素触发扩容 + 去重
        MyHashSet<Integer> nums = new MyHashSet<>();
        for (int i = 0; i < 1000; i++) {
            nums.add(i % 500);   // 0~499 各加两次
        }
        System.out.println("nums.size: " + nums.size()); // 500（去重了）
        System.out.println("contains 499: " + nums.contains(499)); // true
    }
}