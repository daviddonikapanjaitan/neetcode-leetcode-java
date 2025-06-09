package Practice.C15AdvancedGraphs.P3MinCostToConnectAllPoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int[][] input = new int[][]{
                {0, 0}, {2, 2}, {3, 10},
                {5, 2}, {7, 0}
        };

//        int[][] input = new int[][]{
//                {3, 12}, {-2, 5}, {-4, 1}
//        };

        int result = minConstConnectPoints(input);
        System.out.println(result);
    }

    public int minConstConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{dist, i, j});
            }
        }

        edges.sort((a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;

        for(int[] edge: edges) {
            if(dsu.union(edge[1], edge[2])) {
                res += edge[0];
            }
        }

        return res;
    }

    public static class DSU {
        int[] Parent, Size;

        public DSU(int n) {
            Parent = new int[n + 1];
            Size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                Parent[i] = i;
            }
            Arrays.fill(Size, 1);
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
            Size[pu] += Size[pv];
            Parent[pv] = pu;
            return true;
        }
    }
}
