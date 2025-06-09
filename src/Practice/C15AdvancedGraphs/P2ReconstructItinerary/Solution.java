package Practice.C15AdvancedGraphs.P2ReconstructItinerary;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
//        List<List<String>> inputs = List.of(
//                List.of("MUC", "LHR"), List.of("JFK", "MUC"), List.of("SFO", "SJC"),
//                List.of("LHR", "SFO")
//        );

        List<List<String>> inputs = List.of(
                List.of("JFK", "SFO"), List.of("JFK", "ATL"), List.of("SFO", "ATL"), List.of("ATL", "JFK"),
                List.of("ATL", "SFO")
        );

        List<String> result = findItinerary(inputs);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> ticket: tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        LinkedList<String> res = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String curr = stack.peek();
            if(!adj.containsKey(curr) || adj.get(curr).isEmpty()) {
                res.addFirst(stack.pop());
            } else {
                stack.push(adj.get(curr).poll());
            }
        }

        return res;
    }
}
