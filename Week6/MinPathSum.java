package Week6;

import java.util.Arrays;

/**
 * @Description LeetCode-64 最小路径和
 * @Author chenyihao
 * @Date 2020/12/22
 * @Version 1.0
 **/
public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new MinPathSum().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        // 每行只遍历一轮，因此不需要二维数组
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1];
    }
}
