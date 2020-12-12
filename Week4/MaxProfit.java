package Week4;

/**
 * @Description LeetCode-122 买卖股票的最佳时机II
 * @Author chenyihao
 * @Date 2020/12/10
 * @Version 1.0
 **/
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new MaxProfit().maxProfit(prices));

    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        // 贪心算法
        // 因为知道每一天的收益，两两一组遍历，只要后一天的收益比前一天高，就前一天买入，后一天卖出
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

}
