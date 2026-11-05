package day11;

public class UnionFind {
    private int[] parent;
    private int[] rank; // 记录每棵树的高度（秩）
    private int count;// 记录连通分量的个数（帮派数量）

    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        count = n;
        for(int i = 0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int x){
        if(parent[x] == x){
            return x;
        }else {
            return parent[x] = find(parent[x]);
        }
    }
    public void union(int x,int y){
        int rootx = find(x);
        int rooty = find(y);
        if(rootx != rooty){
            if(rank[rootx]<rank[rooty]){
                parent[rootx] = rooty;
            }else if(rank[rootx]>rank[rooty]){
                parent[rooty] = rootx;
            }else {
                parent[rootx] = rooty;
                rank[rooty]++;
            }
            count--;
        }
    }
    public boolean connected(int x,int y){
        return find(x) == find(y);
    }
    public int getCount(){
        return count;
    }
}
