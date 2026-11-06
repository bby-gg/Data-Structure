package day12;


import day02.MyLinkedList;
import day05.MyLinkedQueue;

//今天写的无向表
public class Graph {
    private int V;
    private MyLinkedList<Integer>[] adj;
    @SuppressWarnings("unchecked")
    public Graph(int V){
        this.V = V;
        adj = (MyLinkedList<Integer>[]) new MyLinkedList[V];
        for(int i = 0;i<V;i++){
            adj[i] = new MyLinkedList<>();
        }
    }
    public int getV(){
        return V;
    }
    public void addEdge(int u,int v){
        adj[u].addLast(v);
        adj[v].addLast(u); // 无向：反向也加
    }

    //深度优先搜索
    public void dfs(int s){
        boolean[] visited = new boolean[V];
        dfs(s,visited);
    }
    private void dfs(int v,boolean[] visited){
        visited[v] = true;
        System.out.print(v + " ");
        for(int i = 0;i<adj[v].size();i++){
            int nei = adj[v].get(i);
            if(!visited[nei]){
                dfs(nei,visited);
            }
        }
    }
    //BFS 不需要“公开 + 私有”的递归模板
    public void bfs(int s){
        boolean[] visited = new boolean[V];
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
        visited[s] = true;
        queue.enqueue(s);
        while(!queue.isEmpty()){
            int v = queue.dequeue();
            System.out.print(v + " ");
            //  遍历 v 的邻居，未访问的：先标记，后入队
            for(int i = 0;i<adj[v].size();i++){
                int nei = adj[v].get(i);
                if(!visited[nei]){
                    visited[nei] = true;
                    queue.enqueue(nei);
                }
            }
        }
    }









    public void print(){
        for(int i = 0;i<V;i++){
            System.out.println(i + ":" + adj[i]);
        }
    }
}
