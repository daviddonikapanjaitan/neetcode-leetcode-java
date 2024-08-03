package C4LinkedList.P9LRUCache;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        int result = 0;
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        result = lRUCache.get(1);    // return 1
        System.out.println(result);
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        result = lRUCache.get(2);    // returns -1 (not found)
        System.out.println(result);
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        result = lRUCache.get(1);    // return -1 (not found)
        System.out.println(result);
        result = lRUCache.get(3);    // return 3
        System.out.println(result);
        result = lRUCache.get(4);    // return 4
        System.out.println(result);
    }

    public static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public static class LRUCache {

        private int cap;
        private HashMap<Integer, Node> cache;
        private Node left;
        private Node right;

        public LRUCache(int capacity){
            this.cap = capacity;
            this.cache = new HashMap<>();
            this.left = new Node(0, 0);
            this.right = new Node(0, 0);
            this.left.next = this.right;
            this.right.prev = this.left;
        }

        private void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void insert(Node node) {
            Node prev=  this.right.prev;
            prev.next = node;
            node.prev = prev;
            node.next = this.right;
            this.right.prev = node;
        }

        public int get(int key) {
            if(cache.containsKey(key)) {
                Node node = cache.get(key);
                remove(node);
                insert(node);
                return node.val;
            }

            return -1;
        }

        public void put(int key, int value){
            if(cache.containsKey(key)){
                remove(cache.get(key));
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            insert(newNode);

            if(cache.size() > cap){
                Node lru = this.left.next;
                remove(lru);
                cache.remove(lru.key);
            }
        }
    }
}
