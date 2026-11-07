package day13;

import day03.MyLinkedList;

public class WeightedGraph {
    public static class Edge{
        public int to;  // 这条边的终点节点编号（指向哪个节点)
        public int weight;// 这条边的权重（也就是距离/代价）
        public Edge(int to,int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    private int V;
    private MyLinkedList<Edge>[] adj;
    private boolean directed;
    public WeightedGraph(int V,boolean directed) {
        this.V = V;
        this.directed = directed;
        adj = (MyLinkedList<Edge>[]) new MyLinkedList[V];
        for (int i = 0;i<V;i++){
            adj[i] = new MyLinkedList<>();
        }
    }
    public void addEdge(int u,int v,int w){
        adj[u].addLast(new Edge(v,w));
        if(!directed){
            adj[v].addLast(new Edge(u,w));// 无向图才反向加
        }
    }
    public MyLinkedList<Edge> getNeighbors(int v){
        return adj[v];
    }
    public int getV(){
        return V;
    }
}
