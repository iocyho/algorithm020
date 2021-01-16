package Week9;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description LeetCode-438 找到字符串中所有字母异位词
 * @Author chenyihao
 * @Date 2021/1/16
 * @Version 1.0
 **/
public class FindAnagrams {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = new FindAnagrams().findAnagrams(s, p);
        System.out.println(result);
    }

    // 双指针滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int[] charMapOfP = new int[26];
        for (char ch : p.toCharArray()) {
            charMapOfP[ch - 'a']++;
        }

        int left = 0;
        int right = p.length() - 1;
        char[] charArrayOfS = s.toCharArray();
        // 窗口范围与p的长度相等
        while ((right - left) >= (p.length() - 1)) {
            // 窗口右侧到达右边界
            if (right > charArrayOfS.length - 1) {
                break;
            }
            // 校验是否为异位词
            if (isMatch(left, right, charArrayOfS, charMapOfP)) {
                result.add(left);
            }
            left++;
            right++;
        }
        return result;
    }

    /**
     * 校验是否为异位词
     */
    private boolean isMatch(int left, int right, char[] charArrayOfS, int[] charMapOfP) {
        // 统计窗口中各个字符出现的次数
        int[] charMapOfWindow = new int[26];
        for (int i = left; i <= right; i++) {
            charMapOfWindow[charArrayOfS[i] - 'a']++;
        }
        // 如果窗口中的字符与p中的字符存在不一致，则说明不是异位词
        for (int j = left; j <= right; j++) {
            if (charMapOfWindow[charArrayOfS[j] - 'a'] != charMapOfP[charArrayOfS[j] - 'a']) {
                return false;
            }
        }
        return true;
    }

}
