package day06;

public class test {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        // ---------- 1. 基础 put/get ----------
        map.put("语文", 90);
        map.put("数学", 95);
        System.out.println("数学 = " + map.get("数学"));   // 95
        System.out.println("size = " + map.size());        // 2

        // ---------- 2. 覆盖更新（同 key 再 put，size 不该变） ----------
        map.put("数学", 100);
        System.out.println("数学(更新后) = " + map.get("数学")); // 100
        System.out.println("更新后 size = " + map.size());       // 2

        // ---------- 3. 取不存在的 key ----------
        System.out.println("英语 = " + map.get("英语"));   // null

        // ---------- 4. null key ----------
        map.put(null, 1);
        System.out.println("null key = " + map.get(null)); // 1

        // ---------- 5. 触发扩容 + 冲突：放 1000 个键 ----------
        MyHashMap<Integer, String> big = new MyHashMap<>();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            big.put(i, "v" + i);
        }
        System.out.println("\n--- 扩容/冲突测试 ---");
        System.out.println("big.size = " + big.size());    // 1000

        // 全部取一遍，数命中数
        int hit = 0;
        for (int i = 0; i < n; i++) {
            if (("v" + i).equals(big.get(i))) hit++;
        }
        System.out.println("get 命中 = " + hit + " / " + n); // 1000 / 1000

        // 抽样看几个
        System.out.println("big.get(0)   = " + big.get(0));   // v0
        System.out.println("big.get(500) = " + big.get(500)); // v500
        System.out.println("big.get(999) = " + big.get(999)); // v999

        // ---------- 6. remove 测试（等你写完 remove 再打开） ----------

        System.out.println("\n--- remove 测试 ---");
        System.out.println("删 500: " + big.remove(500));   // v500
        System.out.println("删后再取: " + big.get(500));    // null
        System.out.println("删后 size = " + big.size());    // 999
        System.out.println("删不存在: " + big.remove(12345)); // null

    }
}