package org.solutions.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
        class Node {
            Node next, prev;
            int key, val;
            Node() {
            }
            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Map<Integer, Node> cache;
        Node first, last;
        int capacity;


        public LRUCache(int capacity) {
            first = new Node();
            last = new Node();
            first.next = last;
            last.prev = first;
            cache = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if(cache.containsKey(key)) {
                Node entry = cache.get(key);
                delete(entry);
                insert(entry);
                return entry.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)) {
                Node entry = cache.get(key);
                delete(entry);
                cache.remove(key);
            } else if(cache.size()>=capacity) {
                cache.remove(last.prev.key);
                delete(last.prev);
            }

            insert(new Node(key, value));
            cache.put(key, first.next);
        }

        public void delete(Node entry) {
            Node prevNode = entry.prev, nextNode = entry.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        public void insert(Node entry) {
            entry.prev = first;
            entry.next = first.next;
            first.next = entry;
            entry.next.prev = entry;
        }
}
