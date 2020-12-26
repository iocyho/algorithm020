package Week6;

import java.util.Arrays;

/**
 * @Description LeetCode-621 任务调度器
 * @Author chenyihao
 * @Date 2020/12/23
 * @Version 1.0
 **/
public class LeastInterval {

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        int result = new LeastInterval().leastInterval(tasks, n);
        System.out.println(result);
        assert 8 == result;
    }

    public int leastInterval(char[] tasks, int n) {
        // 1.找出执行次数最多的任务
        int[] bucket = new int[26];
        for (char task : tasks) {
            bucket[task - 'A']++;
        }
        Arrays.sort(bucket);
        int maxTimes = bucket[25];


        // 2.找出执行次数最多的任务种类数
        int maxCount = 1;
        for (int i = 25; i >= 1; i--) {
            if (bucket[i] != bucket[i - 1]) {
                break;
            }
            maxCount++;
        }

        // 3.计算最短时间
        return Math.max((maxTimes - 1) * (n + 1) + maxCount, tasks.length);
    }

}
