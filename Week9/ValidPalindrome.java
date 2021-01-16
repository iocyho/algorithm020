package Week9;

/**
 * @Description LeetCode-680 验证回文字符串
 * @Author chenyihao
 * @Date 2021/1/16
 * @Version 1.0
 **/
public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "aba";
        boolean result = new ValidPalindrome().validPalindrome(s);
        System.out.println(result);
        assert result;
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // 不相等时跳过，校验剩余的字符串是否回文
                return valid(left + 1, right, s) || valid(left, right + 1, s);
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean valid(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
