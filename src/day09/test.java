package day09;

public class test {
    public static void main(String[] args) {
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        // 乱序插入
        heap.push(10);
        heap.push(5);
        heap.push(20);
        heap.push(2);
        heap.push(8);
        heap.push(1);

        System.out.println("当前最小值: " + heap.pop()); // 预期 1

        System.out.print("出堆顺序(堆排序): ");
        while (!heap.isEmpty()) {
            System.out.print(heap.pop() + " ");
        }
        // 预期输出: 2 5 8 10 20
    }
}