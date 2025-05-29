package Practice.C11Graphs.P2MaxAreaOfIsland;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution(){
//        int[][] input = new int[][]{
//                {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0}
//        };

        int[][] input = new int[][]{
                {0,0,0,0,0,0,0,0}
        };

        int result = maxAreaOfIsland(input);
        System.out.println(result);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        DSU dsu = new DSU(ROWS * COLS);

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int area = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if(grid[r][c] == 1) {
                    for(int[] d: directions) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if(nr >= 0 && nc >= 0 && nr < ROWS &&
                                nc < COLS && grid[nr][nc] == 1){
                            dsu.union(r * COLS + c, nr * COLS + nc);
                        }
                    }

                    area = Math.max(area, dsu.getSize(r * COLS + c));
                }
            }
        }

        return area;
    }

    public static class DSU {
        private int[] Parent, Size;

        public DSU(int n) {
            Parent = new int[n + 1];
            Size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                Parent[i] = i;
                Size[i] = 1;
            }
        }

        public int find(int node) {
            if(node != Parent[node]) {
                Parent[node] = find(Parent[node]);
            }
            return Parent[node];
        }

        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return false;
            if(Size[pu] >= Size[pv]) {
                Size[pu] += Size[pv];
                Parent[pv] = pu;
            } else {
                Size[pv] += Size[pu];
                Parent[pu] = pv;
            }

            return true;
        }

        public int getSize(int node) {
            return Size[find(node)];
        }
    }
}
