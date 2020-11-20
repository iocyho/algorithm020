package Week1;

/**
 * @Description LeetCode-42 接雨水
 * @Author chenyihao
 * @Date 2020/11/20
 * @Version 1.0
 **/
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap(height));
    }

    /**
     * 可以存水的部分，必须是跨3个以上索引(2个也行，算特殊情况，容量为0)，
     * 且中间的所有值都必须小于左右两端的值。
     *
     * <p>以数组中的最大值为界，将数组分左右两边，分别计算。
     *
     * <p>定义快慢指针，初始指向数组首元素。慢指针停在左边，快指针不断右移，
     * 直到快指针对应的值大于等于慢指针对应的值，即找到了可能存在的有效容量，
     * 计算出容量后累加到最终结果上。慢指针移动到快指针指向的位置，快指针继
     * 续右移，重复上面操作，直到快指针将整个数组遍历完一次。
     *
     * <p>快指针第一轮遍历完成后，慢指针会指向数组中的最大值(分界值)，找出了
     * 左右两边的分界处，至此左半部分计算完成。
     *
     * <p>左半部分计算完成后，计算右半部分。将快慢指针都指向数组尾元素，快指针
     * 不断左移，从右往左遍历数组，重复左部份的计算步骤。直至快指针指向分界值。
     * 右半部分也计算完成。左右两边计算出的有效容量加起来就是最终结果。
     */
    public int trap(int[] height) {
        int result = 0;

        // 计算左半部分
        if (height.length < 3) {
            return result;
        }
        int slow = 0;
        int fast = 1;
        while (fast < height.length) {
            if (height[fast] >= height[slow]) {
                // 计算容量
                result += (fast - slow - 1) * height[slow];
                for (int i = slow + 1; i < fast; i++) {
                    result -= height[i];
                }
                slow = fast;
            }
            fast++;
        }

        // 分界值
        int divide = slow;

        // 计算右半部分
        if (height.length - slow < 3) {
            return result;
        }
        slow = height.length - 1;
        fast = slow - 1;
        while (fast >= divide) {
            if (height[fast] >= height[slow]) {
                // 计算容量
                result += (slow - fast - 1) * height[slow];
                for (int i = fast + 1; i < slow; i++) {
                    result -= height[i];
                }
                slow = fast;
            }
            fast--;
        }
        return result;
    }
}
