package day13;

import day03.MyLinkedList;
import day10.MyPriorityQueue;

public class Dijkstra {
    private static class NodeDist{
        int id;
        int dist;
        public NodeDist(int id,int dist){
            this.id = id;
            this.dist = dist;
        }
    }
    private static void printResult(int[] dist,int start){
        System.out.println("起点 "+start+" 到各点的最短距离 ");
        for(int i = 0;i<dist.length;i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("节点 "+ i + ": 无法到达");
            }else{
                System.out.println("节点 "+ i + ": "+dist[i]);
            }
        }
    }
    private static void initDist(int[] dist,int start){
        for(int i = 0;i<dist.length;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
    }
    public static void shortestPath(WeightedGraph graph,int start){
        int V = graph.getV();
        int[] dist = new int[V]; // 开辟了装距离的数组

        initDist(dist,start);
        // 建优先队列，按当前距离 dist 升序排（小顶堆）
        MyPriorityQueue<NodeDist> pq = new MyPriorityQueue<>((a,b)->a.dist -b.dist);
        pq.push(new NodeDist(start,0));
        //循环探索，直到队列为空
        while(!pq.isEmpty()){
            NodeDist cur = pq.pop();
            int u = cur.id;
            //懒惰删除
            if(cur.dist > dist[u]){
                continue;
            }
            MyLinkedList<WeightedGraph.Edge> neighbors = graph.getNeighbors(u);
            for(int i = 0;i<neighbors.size();i++){
                WeightedGraph.Edge e = neighbors.get(i);
                int v = e.to;
                int w = e.weight;

                // 拿“起点到 u 的总距离” + “u 到 v 的距离”
                if(cur.dist + w < dist[v]){
                    //更新总账本（把新发现的最短距离记录在 v 的名下）
                    dist[v] = cur.dist + w;
                    //把 v 和它的新距离打包，扔进优先队列（等待以后去探索 v 的邻居）
                    pq.push(new NodeDist(v,dist[v]));
                }
            }
        }
        printResult(dist,start);
    }

}
