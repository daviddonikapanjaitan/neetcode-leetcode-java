package C11Graphs.P11NumberOfConnectedComponentsInAnUndirectedGraph;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
//        int n = 3;
//        int[][] edges = new int[][]{
//                {0, 1}, {0, 2}
//        };

        int n = 6;
        int[][] edges = new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {4, 5}
        };

        int result = countComponents(n, edges);
        System.out.println(result);
    }

    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int res = n;
        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                res--;
            }
        }
        return res;
    }

    public static class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int node) {
            int cur = node;
            while (cur != parent[cur]) {
                parent[cur] = parent[parent[cur]];
                cur = parent[cur];
            }
            return cur;
        }

        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu == pv) {
                return false;
            }
            if (rank[pv] > rank[pu]) {
                int temp = pu;
                pu = pv;
                pv = temp;
            }
            parent[pv] = pu;
            rank[pu] += rank[pv];
            return true;
        }
    }
}
