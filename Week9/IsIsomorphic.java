package Week9;

/**
 * @Description LeetCode-205 同构字符串
 * @Author chenyihao
 * @Date 2021/1/15
 * @Version 1.0
 **/
public class IsIsomorphic {

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        boolean result = new IsIsomorphic().isIsomorphic(s, t);
        System.out.println(result);
        assert result;
    }

    public boolean isIsomorphic(String s, String t) {
        // 题目中并没有限定输入的字符串在ASCII范围内，可能还是用哈希表更严谨
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (preIndexOfS[s.charAt(i)] != preIndexOfT[t.charAt(i)]) {
                return false;
            }
            preIndexOfS[s.charAt(i)] = i + 1;
            preIndexOfT[t.charAt(i)] = i + 1;
        }
        return true;
    }

}
