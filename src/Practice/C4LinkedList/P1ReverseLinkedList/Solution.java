package Practice.C4LinkedList.P1ReverseLinkedList;

public class Solution {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode result = reverseList(listNode);
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
        System.out.println(result.next.next.next.val);
        System.out.println(result.next.next.next.next.val);
    }

    public static ListNode reverseList(ListNode head) {
        return rev(head, null);
    }

    public static ListNode rev(ListNode node, ListNode pre){
        if(node == null){
            return pre;
        }
        ListNode temp = node.next;
        node.next = pre;
        return rev(temp, node);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
