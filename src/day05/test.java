package day05;

public class test {
    public static void main(String[] args) {
        // 默认容量 16，为了看扩容，我们用 16 测
        MyCircularQueue<Integer> q = new MyCircularQueue<>();

        // 1. 先塞满 16 个（0 到 15）
        for (int i = 0; i < 16; i++) {
            q.enqueue(i);
        }
        // 此时队列满了，front = 0, rear = 0

        // 2. 出队 10 个（0 到 9）
        for (int i = 0; i < 10; i++) {
            q.dequeue();
        }
        // 此时队列剩下 10 到 15。front = 10, rear = 0

        // 3. 再入队 10 个（16 到 25）
        for (int i = 16; i < 26; i++) {
            q.enqueue(i);
        }
        // 此时肯定触发扩容了！

        // 4. 全部出队，看顺序对不对
        System.out.println("出队顺序：");
        while (!q.isEmpty()) {
            System.out.print(q.dequeue() + " ");
        }
    }
}
