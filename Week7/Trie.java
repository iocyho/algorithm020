package Week7;

/**
 * @Description LeetCode-208 实现前缀树
 * @Author chenyihao
 * @Date 2021/1/1
 * @Version 1.0
 **/
public class Trie {

    /**
     * 节点构造
     */
    class TrieNode {
        private boolean isEnd;
        TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        // 这样可以保证传入的word是空字符串时，树中仍然只有root节点
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.next[ch - 'a'] == null) {
                node.next[ch - 'a'] = new TrieNode();
            }
            node = node.next[ch - 'a'];
        }
        // isEnd不是指树的末尾，而是该节点是否为一个单词的结尾
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.next[ch - 'a'];
            if (node == null) {
                return false;
            }
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.next[ch - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}
