package day07;

import day01.MyArrayList;

public class Test {
    public static void main(String[] args) {
        System.out.println("能跑");
        TreeNode n1 = new TreeNode(1);
        System.out.println(n1.getVal());
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.println(n1.getVal() + " 的左孩子是 " + n1.left.getVal());
        System.out.println(n1.getVal() + " 的右孩子是 " + n1.right.getVal());
        System.out.println(n2.getVal() + " 的左孩子是 " + n2.left.getVal());
        System.out.println(n2.getVal() + " 的右孩子是 " + n2.right.getVal());

        BinaryTree tree = new BinaryTree();
        System.out.println("刚建好，是空树吗？" + tree.isEmpty());  // 期望 true

        tree.setRoot(n1);
        System.out.println("塞了根之后，是空树吗？" + tree.isEmpty());  // 期望 false

        // 1. 调用方法，把返回的列表装进一个变量里
        MyArrayList<Integer> result = tree.preorder();

// 2. 直接把变量打印出来（因为你的 MyArrayList 重写了 toString）
        System.out.println("遍历结果是：" + result); // 打印出：[1, 2, 4, 5, 3]

// 3. 或者你可以直接用下标取值（这就是自己写数据结构的爽感）
        int firstValue = result.get(0); // 拿到第 0 个元素，就是 1
        System.out.println("第一个元素是：" + firstValue);


        System.out.println("迭代前序：" + tree.preorderByStack());
        System.out.println("迭代中序：" + tree.inorderByStack());
        System.out.println("迭代后序：" + tree.postorderBystack());
    }
}