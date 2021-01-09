package Week8;

/**
 * @Description LeetCode-191 位1的个数
 * @Author chenyihao
 * @Date 2021/1/6
 * @Version 1.0
 **/
public class HammingWeight {

    public static void main(String[] args) {
        int result = new HammingWeight().hammingWeight(11);
        System.out.println(result);
        assert 3 == result;
    }

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            // 去掉最低位的1
            n &= (n - 1);
        }
        return sum;
    }

}
