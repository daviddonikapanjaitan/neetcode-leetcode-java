package C4LinkedList.P5CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, node1);
        Node node3 = new Node(3, node2);
        Node node4 = new Node(4, node3);
        Node node5 = new Node(5, node4);
        node1.next = node2;
        node1.next.next = node3;
        node1.next.next.next = node4;
        node1.next.next.next.next = node5;

        Node resultNode = copyRandomList(node1);
        System.out.println(resultNode.val);
        System.out.println(resultNode.next.val);
        System.out.println(resultNode.next.next.val);
        System.out.println(resultNode.next.next.next.val);
    }

    public static Node copyRandomList(Node head) {
        Map<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);

        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            oldToCopy.put(cur, copy);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node copy = oldToCopy.get(cur);
            copy.next = oldToCopy.get(cur.next);
            copy.random = oldToCopy.get(cur.random);
            cur = cur.next;
        }

        return oldToCopy.get(head);
    }

    public static class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
        public Node(int val, Node random) {
            this.val = val;
            this.random = random;
        }
    }
}
