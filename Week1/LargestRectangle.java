package Week1;

/**
 * @Description LeetCode-84 柱状图中的最大矩形
 * @Author chenyihao
 * @Date 2020/11/18
 * @Version 1.0
 **/
public class LargestRectangle {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangle().largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        int result = 0;
        // 以当前元素为中心，左探找到边界，再右探找到边界，求出面积。遍历比对得出最大面积
        for (int i = 0; i < heights.length; i++) {
            // 左探，遇到更小的值后停下
            int leftBoard = i;
            for (int l = i - 1; l >= 0; l--) {
                if (heights[l] < heights[i]) {
                    break;
                }
                leftBoard = l;
            }

            // 右探，遇到更小的值后停下
            int rightBoard = i;
            for (int r = i + 1; r < heights.length; r++) {
                if (heights[r] < heights[i]) {
                    break;
                }
                rightBoard = r;
            }

            // 求面积(柱子本身长度为1)
            int area = (rightBoard - leftBoard + 1) * heights[i];
            result = Math.max(area, result);
        }
        return result;
    }
}
