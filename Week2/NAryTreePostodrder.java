package Week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description LeetCode-590 N叉树的后序遍历
 * @Author chenyihao
 * @Date 2020/11/24
 * @Version 1.0
 **/
public class NAryTreePostodrder {

    public List<Integer> postorder(Node root) {
        if (null == root) {
            return new ArrayList<>(0);
        }
        LinkedList<Integer> ans = new LinkedList<>();
        traversal(root, ans);
        return ans;
    }

    private void traversal(Node root, LinkedList<Integer> ans) {
        // 这里双端队列实际起到栈的作用，从尾部进再从尾部出
        LinkedList<Node> dq = new LinkedList<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            Node node = dq.pollLast();
            // 左-右-根
            ans.addFirst(node.val);
            for (Node child : node.children) {
                if (null != child) {
                    // left -> right1 -> right2，像这样从左到右逐个接到尾部
                    dq.add(child);
                }
            }
        }
        // 栈 -> 双端队列，把过程体现出来？
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
