package day16;

public class Test {
    public static void main(String[] args) {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();

        System.out.println("正在按顺序插入 1 到 100...");
        for (int i = 1; i <= 100; i++) {
            rbt.insert(i);
        }

        // 如果输出 true，说明你的红黑树非常完美地保持了平衡和颜色规则
        System.out.println("红黑树规则校验: " + rbt.checkVaild());
    }
}