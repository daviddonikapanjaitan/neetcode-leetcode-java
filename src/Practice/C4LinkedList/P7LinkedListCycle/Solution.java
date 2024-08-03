package Practice.C4LinkedList.P7LinkedListCycle;

public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(6);
        node1.next.next.next.next.next.next = new ListNode(7);
        node1.next.next.next.next.next.next = node1;
        boolean result = hasCycle(node1);
        System.out.println(result);

        ListNode node2 = new ListNode(3);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(0);
        node2.next.next.next = new ListNode(4);
        boolean result2 = hasCycle(node2);
        System.out.println(result2);
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }

        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }
}
