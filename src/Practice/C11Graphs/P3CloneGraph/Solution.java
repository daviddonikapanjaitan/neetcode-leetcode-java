package Practice.C11Graphs.P3CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        two.setNeighbours(List.of(one, three));
        three.setNeighbours(List.of(two, four));
        four.setNeighbours(List.of(one, three));
        one.setNeighbours(List.of(two, four));

        Node output = cloneGraph(one);
        System.out.println(output.val);
        for(Node val: output.neighbors){
            System.out.println(val.val);
        }
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();

        return dfs(node, oldToNew);
    }

    private Node dfs(Node node, Map<Node, Node> oldToNew) {
        if(node == null) {
            return null;
        }

        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }

        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        for(Node nei: node.neighbors) {
            copy.neighbors.add(dfs(nei, oldToNew));
        }

        return copy;
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val){
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
        public void setNeighbours(List<Node> _neighbors) {
            this.neighbors = _neighbors;
        }
    }
}
