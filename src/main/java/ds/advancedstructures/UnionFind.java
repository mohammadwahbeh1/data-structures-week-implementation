package ds.advancedstructures;

public class UnionFind {
    private int[] parent; // stores parent of each node
    private int[] rank;   // used for balancing trees

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        // initially, each node is its own parent
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    // find the root of x, compress path along the way
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    // combine two sets
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return; // already in same set

        // attach smaller tree under bigger tree
        if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    // check if x and y are in the same set
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
