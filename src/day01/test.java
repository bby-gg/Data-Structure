package day01;


public class test {
    public static void main(String[] args) {
        // 场景 1：删中间元素
        MyArrayList<String> list1 = new MyArrayList<>(4);
        list1.add("A"); list1.add("B"); list1.add("C"); list1.add("D");
        String r1 = list1.remove(1);   // 删 "B"
        System.out.println("删的: " + r1 + ", 剩下: " + list1.size());  // B, 3
        System.out.println(list1.get(0) + list1.get(1) + list1.get(2)); // ACD

        // 场景 2：删第一个
        MyArrayList<String> list2 = new MyArrayList<>(4);
        list2.add("A"); list2.add("B"); list2.add("C");
        list2.remove(0);   // 删 "A"
        System.out.println(list2.get(0));  // 应该是 B

        // 场景 3：删最后一个
        MyArrayList<String> list3 = new MyArrayList<>(4);
        list3.add("A"); list3.add("B"); list3.add("C");
        list3.remove(2);   // 删 "C"（最后一个）
        System.out.println(list3.size());  // 2
        System.out.println(list3.get(1));  // B

        // 场景 4：删空列表
        MyArrayList<String> list4 = new MyArrayList<>(4);
        try {
            list4.remove(0);   // 空列表删，应该抛异常
        } catch (IndexOutOfBoundsException e) {
            System.out.println("空列表 remove OK");
        }
    }
}
