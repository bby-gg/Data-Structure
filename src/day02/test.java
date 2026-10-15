package day02;

public class test {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        System.out.println("初始: " + list);        // [A, B, C]

        String r1 = list.remove(0);
        System.out.println("删的: " + r1 + "  剩下: " + list);   // A, [B, C]

        String r2 = list.remove(1);
        System.out.println("删的: " + r2 + "  剩下: " + list);   // C, [B]

        String r3 = list.remove(0);
        System.out.println("删的: " + r3 + "  剩下: " + list);   // B, []

        System.out.println("isEmpty: " + list.isEmpty());        // true
        System.out.println("size: " + list.size());              // 0


        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        System.out.println("反转前: " + list);   // [A, B, C, D]
        list.reverse();
        System.out.println("反转后: " + list);   // [D, C, B, A]
    }
}