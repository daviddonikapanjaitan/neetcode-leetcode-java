package Practice.C11Graphs.P8CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        int numCourse = 2;
        int[][] prerequisites = new int[][]{{1, 0}};

        // int numCourse = 2;
        // int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};

        boolean result = canFinish(numCourse, prerequisites);
        System.out.println(result);
    }

    public boolean canFinish(int numCourse, int[][] prerequisites) {
        int[] indegree = new int[numCourse];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourse; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites) {
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourse; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int finish = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            finish++;
            for(int nei: adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        return finish == numCourse;
    }
}
