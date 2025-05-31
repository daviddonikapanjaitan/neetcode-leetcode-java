package C11Graphs.P9CourseScheduleII;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
//        int[][] prerequisites = new int[][]{
//                {1, 0}
//        };
//        int numCourses = 2;

        int[][] prerequisites = new int[][]{
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        int numCourses = 4;

        int[] result = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(result));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        for(int[] pair: prerequisites) {
            prereq.computeIfAbsent(pair[0],
                    k-> new ArrayList<>()).add(pair[1]);
        }

        List<Integer> output = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for(int course = 0; course < numCourses; course++) {
            if(!dfs(course, prereq, visit, cycle, output)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = output.get(i);
        }

        return result;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> prereq,
                        Set<Integer> visit, Set<Integer> cycle,
                        List<Integer> output) {
        if(cycle.contains(course)){
            return false;
        }
        if(visit.contains(course)){
            return true;
        }
        cycle.add(course);
        for(int pre: prereq.getOrDefault(course, Collections.emptyList())){
            if(!dfs(pre, prereq, visit, cycle, output)) {
                return false;
            }
        }
        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;
    }
}
