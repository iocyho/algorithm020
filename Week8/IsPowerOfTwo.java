package Week8;

/**
 * @Description LeetCode-231 2的幂
 * @Author chenyihao
 * @Date 2021/1/9
 * @Version 1.0
 **/
public class IsPowerOfTwo {

    public static void main(String[] args) {
        boolean result = new IsPowerOfTwo().isPowerOfTwo(1);
        System.out.println(result);
        assert result;
    }

    // 当一个数是2的幂时，则二进制表示中仅包含一个1
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        long x = (long)n;
        // x & (-x) 获取二进制中最右边的1
        return (x & (-x)) == x;
    }

}
