package Week8;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description LeetCode-146 LRU 缓存机制
 * @Author chenyihao
 * @Date 2021/1/8
 * @Version 1.0
 **/
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // 1
        lruCache.put(3 , 3);
        System.out.println(lruCache.get(2)); // -1
        lruCache.put(4 , 4);
        System.out.println(lruCache.get(1)); // -1
        System.out.println(lruCache.get(3)); // 3
        System.out.println(lruCache.get(4)); // 4
    }

    // 通过Hash表+链表实现
    private Map<Integer, DLinkedNode> cache;
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        // 伪头部与伪尾部
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        // 元素已存在，直接挪到头部
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        // 元素不存在，创建新节点
        DLinkedNode newNode = new DLinkedNode(key, value);
        addToHead(newNode);
        cache.put(key, newNode);
        size++;
        // 容量超出时删除最后一个元素
        if (size > capacity) {
            cache.remove(removeTail().key);
            size--;
        }
    }

    private void addToHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(DLinkedNode node) {
        // 先从链表中删除元素，再把元素添加到链表头部
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode last = tail.pre;
        removeNode(last);
        return last;
    }



    /**
     * 链表节点
     */
    class DLinkedNode {

        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
