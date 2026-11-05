package day11;

public class test {
    public static void main(String[] args) {
        // 假设有 5 个人：0, 1, 2, 3, 4
        UnionFind uf = new UnionFind(5);
        System.out.println("初始帮派数: " + uf.getCount()); // 预期: 5

        // 0 和 1 交朋友，1 和 2 交朋友
        uf.union(0, 1);
        uf.union(1, 2);

        // 3 和 4 交朋友
        uf.union(3, 4);

        System.out.println("合并后帮派数: " + uf.getCount()); // 预期: 2

        // 测试连通性
        System.out.println("0和2连通吗: " + uf.connected(0, 2)); // 预期: true
        System.out.println("0和3连通吗: " + uf.connected(0, 3)); // 预期: false

        // 试试重复合并（不应该改变帮派数）
        uf.union(0, 2);
        System.out.println("重复合并后帮派数: " + uf.getCount()); // 预期: 2
    }
}