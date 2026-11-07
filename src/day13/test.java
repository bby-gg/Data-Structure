package day13;

import static day13.Dijkstra.shortestPath;

public class test {
    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("1. Dijkstra 最短路测试");
        System.out.println("=================================");
        // 6 个节点：a=0, b=1, c=2, d=3, e=4, f=5，有向图
        WeightedGraph g = new WeightedGraph(6, true);
        g.addEdge(0, 1, 2); // a -> b: 2
        g.addEdge(0, 2, 5); // a -> c: 5
        g.addEdge(1, 2, 1); // b -> c: 1
        g.addEdge(1, 3, 3); // b -> d: 3
        g.addEdge(2, 3, 3); // c -> d: 3
        g.addEdge(2, 4, 1); // c -> e: 1
        g.addEdge(2, 5, 1); // c -> f: 1
        g.addEdge(3, 4, 1); // d -> e: 1
        g.addEdge(3, 5, 4); // d -> f: 4
        g.addEdge(4, 5, 1); // e -> f: 1

        shortestPath(g, 0);



        System.out.println("\n=================================");
        System.out.println("2. 拓扑排序测试 (正常无环图)");
        System.out.println("=================================");
        // 有向图：true 表示有向
        // 节点：0(高数), 1(线代), 2(数据结构), 3(选修课)
        WeightedGraph dag = new WeightedGraph(4, true);
        dag.addEdge(0, 1, 1); // 0 -> 1
        dag.addEdge(1, 2, 1); // 1 -> 2
        // 3 没有前置依赖，也没有后继

        TopoSort topo = new TopoSort();
        System.out.println("图中有环吗？ " + topo.hasCycle(dag)); // 应该输出 false

        int[] order = topo.sort(dag);
        if (order != null) {
            System.out.print("拓扑排序结果(合法的学习顺序): ");
            for (int v : order) {
                System.out.print(v + " ");
            }
            System.out.println();
        }



        System.out.println("\n=================================");
        System.out.println("3. 拓扑排序测试 (成环图)");
        System.out.println("=================================");
        // 互为前提，死锁！
        WeightedGraph cycleGraph = new WeightedGraph(2, true);
        cycleGraph.addEdge(0, 1, 1);
        cycleGraph.addEdge(1, 0, 1);

        System.out.println("图中有环吗？ " + topo.hasCycle(cycleGraph)); // 应该输出 true

        int[] cycleOrder = topo.sort(cycleGraph);
        // 安全防护：如果返回 null，说明有环，我们就不遍历它了
        if (cycleOrder == null) {
            System.out.println("外部确认：确实没有排序结果（因为有环）。");
        } else {
            System.out.print("拓扑排序结果: ");
            for (int v : cycleOrder) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}