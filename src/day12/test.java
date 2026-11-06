package day12;

public class test {
    public static void main(String[] args) {
        // 建一个 4 个节点的无向图
        Graph g = new Graph(4);

        // 连线：0-1, 0-2, 1-3
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);

        // 打印邻接表看看长什么样
        g.print();
        System.out.println("---------");

        System.out.print("DFS 从 0 开始: ");
        g.dfs(0); // 预期: 0 1 3 2 (因为你是 addLast 尾插法，先遍历 1，再遍历 2)
        System.out.println();

        System.out.print("BFS 从 0 开始: ");
        g.bfs(0); // 预期: 0 1 2 3
        System.out.println();
    }
}