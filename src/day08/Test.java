package day08;

import day01.MyArrayList;

public class Test {
    public static void main(String[] args) {
        MyBST<Integer> bst = new MyBST<>();

        System.out.println("========== 1. 测试插入与中序遍历 ==========");
        // 构造一棵稍微复杂的树
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // 中序遍历应该严格升序
        System.out.println("中序输出: " + bst.inorderByStack());
        System.out.println("搜索 40 存在吗? " + bst.search(40)); // 期待 true
        System.out.println("搜索 100 存在吗? " + bst.search(100)); // 期待 false

        System.out.println("\n========== 2. 测试删除叶子节点 ==========");
        // 20 是叶子节点（没有任何孩子）
        bst.delete(20);
        System.out.println("删除 20 后: " + bst.inorderByStack());
        // 期待: [30, 40, 50, 60, 70, 80]

        System.out.println("\n========== 3. 测试删除单孩子节点 ==========");
        // 30 只有一个右孩子 40，30 被删后 40 应该顶替它的位置
        bst.delete(30);
        System.out.println("删除 30 后: " + bst.inorderByStack());
        // 期待: [40, 50, 60, 70, 80]

        System.out.println("\n========== 4. 测试删除双孩子节点（最难的） ==========");
        // 50 是根节点，左右都有孩子。
        // 删除它时，应该找它右子树的最小值（60）来顶替。
        bst.delete(50);
        System.out.println("删除 50 后: " + bst.inorderByStack());
        // 期待: [40, 60, 70, 80]

        System.out.println("\n========== 5. 测试删除不存在的值 ==========");
        bst.delete(999);
        System.out.println("删除 999 后: " + bst.inorderByStack());
        // 期待: 没变化，依然是 [40, 60, 70, 80]

        System.out.println("\n测试结束！如果上面每次输出都是升序，且元素正确，说明你的 BST 完美！");
    }
}