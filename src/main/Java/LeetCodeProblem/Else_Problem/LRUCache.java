package LeetCodeProblem.Else_Problem;

import java.util.HashMap;

public class LRUCache {

    public static class Node<V>{
        public V value;
        public Node<V> last;
        public Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class NodeDoubleLinkedList<V> {
        private Node<V> head;
        private Node<V> tail;

        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addNode(Node<V> newNode){
            if (newNode == null){
                return;
            }

            if (this.head == null){
                this.head = newNode;
                this.tail = newNode;
            }else {
                this.tail.next = newNode;
                newNode.last = this.tail;
                this.tail = newNode;
            }
        }

        public void moveNodeToTail(Node<V> node){
            if (this.tail == node){
                return;
            }
            if (this.head == node){
                this.head = node.next;
                this.head.last = null;
            }else {
                node.last.next = node.next;
                node.next.last = node.last;
            }

            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }

        public Node<V> removeHead(){
            if (this.head == null){
                return null;
            }
            Node<V> result = this.head;
            if (this.head == this.tail){
                this.head = null;
                this.tail = null;
            }else {
                this.head = result.next;
                result.next = null;
                this.head.last = null;
            }
            return result;
        }
    }

    public static class LRUCacheDemo<K, V>{

        private HashMap<K, Node<V>> keyNodeMap;
        private HashMap<Node<V>, K> nodeKeyMap;
        private NodeDoubleLinkedList<V> nodeList;
        private int capacity;

        public LRUCacheDemo(int capacity) {
            if (capacity < 1){
                throw new RuntimeException("should be more than 0.");
            }
            this.keyNodeMap = new HashMap<>();
            this.nodeKeyMap = new HashMap<>();
            this.nodeList = new NodeDoubleLinkedList<V>();
            this.capacity = capacity;
        }

        public V get(K key){
            if (this.keyNodeMap.containsKey(key)){
                Node<V> node = this.keyNodeMap.get(key);
                this.nodeList.moveNodeToTail(node);
                return node.value;
            }
            return null;
        }

        public void set(K key, V value){
            if (this.keyNodeMap.containsKey(key)){
                Node<V> node = this.keyNodeMap.get(key);
                node.value = value;
                this.nodeList.moveNodeToTail(node);
            }else {
                Node<V> newNode = new Node<>(value);
                this.keyNodeMap.put(key, newNode);
                this.nodeKeyMap.put(newNode, key);
                this.nodeList.addNode(newNode);
                if (this.keyNodeMap.size() == this.capacity + 1){
                    this.removeMostUnusedCache();
                }
            }
        }

        private void removeMostUnusedCache() {
            Node<V> removeNode = this.nodeList.removeHead();
            K removeKey = this.nodeKeyMap.get(removeNode);
            this.nodeKeyMap.remove(removeNode);
            this.keyNodeMap.remove(removeKey);
        }
    }

    public static void main(String[] args) {
        LRUCacheDemo lruCache = new LRUCacheDemo<>(2);
        lruCache.set(0, 3);
        lruCache.set(1, 4);
        lruCache.set(2, 5);
        for (int i = 0; i < lruCache.capacity; i++){
            System.out.println(lruCache.get(i));
        }
        System.out.println(lruCache.capacity);
    }
}
