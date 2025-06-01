package C11Graphs.P12RedundantConnection;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
//        int[][] edges = new int[][]{
//                {1, 2}, {1, 3}, {2, 3}
//        };
//        int[] result = findRedundantConnection(edges);

        int[][] edges = new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}
        };
        int[] result = findRedundantConnection(edges);

        System.out.println(Arrays.toString(result));
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] par = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        for(int[] edge: edges) {
            if(!union(par, rank, edge[0], edge[1]))
                return new int[] {edge[0], edge[1]};
        }

        return new int[0];
    }

    private int find(int[] par, int n ) {
        int p = par[n];
        while (p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }

        return p;
    }

    private boolean union(int[] par, int[] rank, int n1, int n2) {
        int p1 = find(par, n1);
        int p2 = find(par, n2);

        if(p1 == p2) {
            return false;
        }
        if(rank[p1] > rank[p2]) {
            par[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }

        return true;
    }
}
