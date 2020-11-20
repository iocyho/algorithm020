package Week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description LeetCode-1 两数之和
 * @Author chenyihao
 * @Date 2020/11/17
 * @Version 1.0
 **/
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        Arrays.stream(new TwoSum().twoSum(nums, 9)).forEach(System.out::print);
    }

    /**
     * target - 当前元素 = 待查的另外一个元素值
     * 所以需要找出“待查的另外一个元素值”在数组种是否存在
     * 每遍历到一个元素时，都可以将当前元素缓存到HashMap中，
     * 后续元素直接通过hashMap查询“待查元素”是否存在即可，不用再重头遍历数组
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (null == nums || nums.length < 2) {
            return result;
        }

        Map<Integer, Integer> tmpMap = new HashMap<>(nums.length / 2);
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (tmpMap.containsKey(tmp)) {
                result[0] = tmpMap.get(tmp);
                result[1] = i;
                break;
            }
            tmpMap.put(nums[i], i);
        }
        return result;
    }

}
