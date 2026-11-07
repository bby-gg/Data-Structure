package day13;

import day03.MyLinkedList;
import day05.MyLinkedQueue;

public class TopoSort {
    // 把入度算好
    private void calculateInDegree(WeightedGraph graph,int[] inDegree){
        for(int u = 0;u<graph.getV();u++){
            MyLinkedList<WeightedGraph.Edge> neighbors = graph.getNeighbors(u);
            for(int i = 0;i<neighbors.size();i++){
                inDegree[neighbors.get(i).to]++;
            }
        }
    }

    //把起点塞进队列
    private void initQueue(int[] inDegree, MyLinkedQueue<Integer> queue){
        for(int i = 0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                queue.enqueue(i);
            }
        }
    }
    public int[] sort(WeightedGraph graph){
        int V = graph.getV();
        int[] inDegree = new int[V];
        calculateInDegree(graph,inDegree);

        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
        initQueue(inDegree,queue);
        // 准备一个数组用来存排好序的结果，count 用来记录已经排好了几个节点
        int[] result = new int[V];
        int count = 0;
        //只要队列不空，就说明还有节点可以处理
        while (!queue.isEmpty()){
            int u = queue.dequeue();
            result[count++] = u;

            MyLinkedList<WeightedGraph.Edge>neighbors = graph.getNeighbors(u);
            for(int i = 0;i<neighbors.size();i++){
                int v = neighbors.get(i).to;

                inDegree[v] --;

                if(inDegree[v] == 0){
                    queue.enqueue(v);
                }
            }
        }
        if(count < V){
            System.out.println("图中存在环！无法进行拓扑排序。");
            return  null;
        }
        return result;
    }
    /**
     * 外部调用的判环方法
     * @return true 表示有环，false 表示无环
     */
    public boolean hasCycle(WeightedGraph graph) {
        return sort(graph) == null;
    }
}
