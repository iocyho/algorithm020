package Week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description LeetCode-589 N叉树的前序遍历
 * @Author chenyihao
 * @Date 2020/11/24
 * @Version 1.0
 **/
public class NAryTreePreodrder {

    public List<Integer> preorder(Node root) {
        if (null == root) {
            return new LinkedList<>();
        }
        LinkedList<Integer> ans = new LinkedList<>();
        // 实际起到栈的作用，从尾部添加元素，先入后出
        LinkedList<Node> dq = new LinkedList<>();

        dq.add(root);
        while (!dq.isEmpty()) {
            Node node = dq.pollLast();
            // 前序遍历与后序遍历的区别主要在add的插入顺序
            // 根-左-右
            ans.add(node.val);
            // 以及子节点的入栈顺序
            for (int i = node.children.size() - 1; i >= 0; i--) {
                if (node.children.get(i) != null) {
                    // right -> left1 -> left2，像这样从右到左逐个接到尾部
                    dq.add(node.children.get(i));
                }
            }
        }
        return ans;
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
