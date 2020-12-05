package Week3;

/**
 * @Description LeetCode-236 二叉树的最近公共祖先
 * @Author chenyihao
 * @Date 2020/12/2
 * @Version 1.0
 **/
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 1.左右都不包含目标值
        if (left == null && right == null) {
            return null;
        }
        // 2.只有一边包含目标值
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        // 3.两边各包含一个目标值(left != null && right != null)
        // TODO 这里可以减枝优化，当左子树同时包含两个值时，全部上层的右子树都可以不用再找了
        return root;
    }


    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
