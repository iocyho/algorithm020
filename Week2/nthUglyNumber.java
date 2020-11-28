package Week2;


/**
 * @Description LeetCode-264 丑数
 * @Author chenyihao
 * @Date 2020/11/26
 * @Version 1.0
 **/
public class nthUglyNumber {

    public static void main(String[] args) {
        int result = new nthUglyNumber().nthUglyNumber(10);
        System.out.println(result);
    }

    public int nthUglyNumber(int n) {
        // 1是特殊的丑数，2、3、5为丑数因子，丑数乘以丑数因子仍然是丑数
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int currUgly;
        for (int i = 1; i < n; i++) {
            // 通过三指针的方式逐个找出丑数，存入结果数组中
            currUgly = Math.min(Math.min(uglyNums[i2] * 2, uglyNums[i3] * 3), uglyNums[i5] * 5);
            uglyNums[i] = currUgly;

            if (currUgly == uglyNums[i2] * 2) {
                i2++;
            }
            if (currUgly == uglyNums[i3] * 3) {
                i3++;
            }
            if (currUgly == uglyNums[i5] * 5) {
                i5++;
            }
        }
        return uglyNums[n - 1];
    }
}
