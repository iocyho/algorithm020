package Week3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description LeetCode-77 组合
 * @Author chenyihao
 * @Date 2020/12/4
 * @Version 1.0
 **/
public class Combine {


    public static void main(String[] args) {
        System.out.println(new Combine().combine(5, 3));
    }

    private List<List<Integer>> result = new ArrayList<>();
    private Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return result;
    }

    private void dfs(int n, int k, int begin) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 提前减枝
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            dfs(n, k, i + 1);
            // 回溯的核心操作，一次递归完成后恢复路径栈，才能尝试其它路径
            path.removeLast();
        }
    }


}
