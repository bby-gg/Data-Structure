package day14;

public class Test {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        // 1. 顺序插入 1 到 100（最极端的退化场景）
        for (int i = 1; i <= 100; i++) {
            avl.insert(i);
        }

        // 2. 验证高度
        System.out.println("插入 100 个节点后，树的高度: " + avl.getTreeHeight());
        // 普通 BST 高度是 100，你的 AVL 树高度应该只有 7 左右（因为 2^7 = 128）

        // 3. 验证平衡性
        System.out.println("这棵树是完美的 AVL 平衡树吗？ " + avl.checkBalance());
        // 必须输出 true

        // 4. 验证中序遍历（保证节点没丢失，且有序）
        day01.MyArrayList<Integer> list = avl.inorderByStack();
        System.out.println("中序遍历前 10 个元素: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("...");

        // 5. 测试 search 方法
        System.out.println("找 50: " + avl.search(50)); // true
        System.out.println("找 101: " + avl.search(101)); // false
    }
}