package Week8;

import java.util.Arrays;

/**
 * @Description LeetCode-1122 数组的相对排序
 * @Author chenyihao
 * @Date 2021/1/7
 * @Version 1.0
 **/
public class RelativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] result = new RelativeSortArray().relativeSortArray(arr1, arr2);
        Arrays.stream(result).forEach(System.out::println);

    }

    // 计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 1.找出arr1的最大值，确定计数数组边界
        int max = 0;
        for (int num : arr1) {
            max = Math.max(num, max);
        }

        // 2.计算arr1中各个元素的出现次数
        int[] countArray = new int[max + 1];
        for (int i : arr1) {
            countArray[i]++;
        }

        // 3.对arr1在arr2中存在的元素进行排序
        int index = 0;
        for (int j : arr2) {
            while (countArray[j] > 0 ) {
                arr1[index++] = j;
                countArray[j]--;
            }
        }

        // 4.对剩下不在arr2中的元素进行排序
        for (int k = 0; k <= max; k++) {
            while (countArray[k] > 0) {
                arr1[index++] = k;
                countArray[k]--;
            }
        }

        return arr1;
    }

}
