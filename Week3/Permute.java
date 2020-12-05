package Week3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description LeetCode-46 全排列
 * @Author chenyihao
 * @Date 2020/12/5
 * @Version 1.0
 **/
public class Permute {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Permute().permute(nums));
    }

    private List<List<Integer>> result = new ArrayList<>();
    private Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums);
        return result;
    }

    private void dfs(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.addLast(nums[i]);
            dfs(nums);
            // 回溯，一次递归结束后，恢复到先前的状态，尝试下一条路径
            path.removeLast();
        }
    }

}
