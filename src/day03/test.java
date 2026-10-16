package day03;

public class test {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        System.out.println("空: " + list);           // []
        System.out.println("size = " + list.size()); // 0

        list.addFirst("A");
        list.addFirst("B");
        list.addLast("C");
        list.addLast("D");
        System.out.println("内容: " + list);          // [B, A, C, D]
        System.out.println("size = " + list.size());  // 4

        // 测试 get
        System.out.println("get(0): " + list.get(0)); // B
        System.out.println("get(3): " + list.get(3)); // D

        // 测试 remove：删头、删尾、删中间
        String r1 = list.remove(0);   // 删 B
        System.out.println("删头: " + r1 + " → " + list);   // B → [A, C, D]

        String r2 = list.remove(2);   // 删 D（尾部）
        System.out.println("删尾: " + r2 + " → " + list);   // D → [A, C]

        String r3 = list.remove(0);   // 删 A
        String r4 = list.remove(0);   // 删 C
        System.out.println("删空: " + list);           // []
        System.out.println("isEmpty: " + list.isEmpty()); // true

        // 删空后再加，验证 dummy 是否仍正常
        list.addFirst("X");
        System.out.println("重新加: " + list);         // [X]







    }
}