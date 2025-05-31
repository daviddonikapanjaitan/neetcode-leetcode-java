package Practice.C11Graphs.P10GraphValidTree;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int n = 5;
        int[][] edges = new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 4}
        };

        // int n = 5;
        // int[][] edges = new int[][]{
        //         {0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}
        // };

        boolean result = validTree(n, edges);
        System.out.println(result);
    }

    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n - 1) {
            return false;
        }

        DSU dsu = new DSU(n);
        for(int[] edge: edges) {
            if(!dsu.union(edge[0], edge[1])){
                return false;
            }
        }

        return dsu.components() == 1;
    }

    public static class DSU {
        int[] Parent, Size;
        int comps;

        public DSU(int n) {
            comps = n;
            Parent = new int[n + 1];
            Size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                Parent[i] = i;
                Size[i] = 1;
            }
        }

        public int find(int node) {
            if(Parent[node] != node) {
                Parent[node] = find(Parent[node]);
            }
            return Parent[node];
        }

        public boolean union(int u, int v) {
            int pu = find(u), pv = find(v);
            if(pu == pv) return false;
            if(Size[pu] < Size[pv]) {
                int temp = pu;
                pu = pv;
                pv = temp;
            }
            comps--;
            Size[pu] += Size[pv];
            Parent[pv] = pu;
            return true;
        }

        public int components() {
            return comps;
        }
    }
}
