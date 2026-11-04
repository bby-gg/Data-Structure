package day10;

public class test {
    public static void main(String[] args) {
        // 1. 默认是小顶堆
        MyPriorityQueue<Integer> minPQ = new MyPriorityQueue<>();
        minPQ.push(10);
        minPQ.push(5);
        minPQ.push(20);
        minPQ.push(2);

        System.out.print("默认小顶堆弹出: ");
        while (!minPQ.isEmpty()) {
            System.out.print(minPQ.pop() + " "); // 预期: 2 5 10 20
        }
        System.out.println();


        // 2. 传入 Comparator 变成大顶堆
        MyPriorityQueue<Integer> maxPQ = new MyPriorityQueue<>((a, b) -> b.compareTo(a));
        maxPQ.push(10);
        maxPQ.push(5);
        maxPQ.push(20);
        maxPQ.push(2);

        System.out.print("大顶堆弹出: ");
        while (!maxPQ.isEmpty()) {
            System.out.print(maxPQ.pop() + " "); // 预期: 20 10 5 2
        }
        System.out.println();
    }
}