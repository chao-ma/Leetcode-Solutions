import java.util.*;

class LRUCache {

    public static class DoubleListNode {
        public DoubleListNode left = null, right = null;
        public int val, key;
        public DoubleListNode(int key, int value) {this.key = key; val = value;}
    }
    
    private int capacity;
    private DoubleListNode hub;
    private Map<Integer, DoubleListNode> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hub = new DoubleListNode(0, 0);
        hub.left = hub;
        hub.right = hub;
        map = new HashMap<>();
    }
    
    private void remove(DoubleListNode node) {
        if (map.containsKey(node.key)) {
            node.left.right = node.right;
            node.right.left = node.left;
            node.left = null;
            node.right = null;
            map.remove(node.key);
        }
    }
    
    private void insert(DoubleListNode node) {
        map.put(node.key, node);
        node.right = hub.right;
        hub.right.left = node;
        node.left = hub;
        hub.right = node;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        DoubleListNode node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            get(key);
        } else {
            DoubleListNode node = new DoubleListNode(key, value);
            insert(node);
            if (map.size() > capacity) {
                remove(hub.left);
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LRUCache cache = new LRUCache(5);
        cache.set(1, 2);
        cache.set(2, 3);
        cache.set(3, 4);
        cache.set(4, 5);
        cache.set(5, 6);
        cache.get(1);
        cache.set(6, 7);
        System.out.println(cache.get(3));
        cache.set(3, -3);
        System.out.println(cache.get(3));
        
    }

}
