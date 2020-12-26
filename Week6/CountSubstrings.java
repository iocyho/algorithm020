package Week6;

/**
 * @Description LeetCode-647 回文子串
 * @Author chenyihao
 * @Date 2020/12/26
 * @Version 1.0
 **/
public class CountSubstrings {

    public static void main(String[] args) {
        int result = new CountSubstrings().countSubstrings("abc");
        System.out.println(result);
        assert result == 3;
    }


    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                // 回文字符串的头和尾必定相等，去掉头尾后剩下的字符串也一定还是回文字符串
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    result++;
                }
            }
        }

        return result;
    }

}
