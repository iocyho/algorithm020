package Week4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @Description LeetCode-127 单词接龙
 * @Author chenyihao
 * @Date 2020/12/11
 * @Version 1.0
 **/
public class LadderLength {

    public static void main(String[] args) {
        String[] words = {"hot","dot","dog","lot","log","cog"};
        System.out.println(new LadderLength().ladderLength("hit", "cog", Arrays.asList(words)));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        // 先把初始值排除
        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 广度优先遍历
        // starWord与endword本身各占一步，即符合转换条件时，最少也有2步
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // 依次遍历队列中的单词
                String currentWord = queue.poll();
                // 如果当前单词可以仅改变一个字符就与endWord相同，则返回step + 1;
                if (changeWordByOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 逐个修改currentWord的字符，看是否能与endWord匹配
     * @param currentWord
     * @param endWord
     * @param visited
     * @param wordSet
     */
    private boolean changeWordByOneLetter(String currentWord, String endWord,
            Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] currentChars = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char originChar = currentChars[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originChar) {
                    continue;
                }
                currentChars[i] = k;
                String nextWord = String.valueOf(currentChars);
                // 先判断转换后的字符串是否在字典中存在
                if (!wordSet.contains(nextWord)) {
                    continue;
                }
                // 如果存在，再判断是否就是endWord
                if (nextWord.equals(endWord)) {
                    return true;
                }
                // 不是endWord的情况下标记为已访问
                if (!visited.contains(nextWord)) {
                    queue.add(nextWord);
                    visited.add(nextWord);
                }
            }
            // 还原
            currentChars[i] = originChar;
        }

        return false;
    }

}
