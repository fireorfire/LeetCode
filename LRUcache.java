class Node {
    public int key;
    public int val;
    public Node prev, next;
    public Node(int k, int i) {
        key = k;
        val = i;
    }
}

public class LRUCache {
    
    private HashMap<Integer, Node> hash = new HashMap<>();
    private Node head = new Node(-1, -1), tail = new Node(-1, -1);
    private int count = 0, capacity = 0;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!hash.containsKey(key)) return -1;
        Node node = hash.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
        return node.val;
    }
    
    public void set(int key, int value) {
        Node node;
        if(hash.containsKey(key)) {
            node = hash.get(key);
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }else {
            node = new Node(key, value);
            count++;
        }
        hash.put(key, node);
        if(count > capacity) {
            Node cut = tail.prev;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            hash.remove(cut.key);
            count--;
        }
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
        
    }
}