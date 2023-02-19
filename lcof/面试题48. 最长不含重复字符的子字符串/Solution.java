import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    /**
     * 动态规划 + 哈希表
     * 执行用时：4 ms, 在所有 Java 提交中击败了91.88%的用户
     * 内存消耗：41.4 MB, 在所有 Java 提交中击败了68.35%的用户
     * @param s
     * @return
     */
    public int solution1(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0, len = s.length();
        for(int j = 0; j < len; j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    } 

    /**
     * 滑动窗口 + 双指针
     * 执行用时：2 ms, 在所有 Java 提交中击败了97.07%的用户
     * 内存消耗：41.7 MB, 在所有 Java 提交中击败了36.29%的用户
     * @param input
     */
    private static void slidingWindow(String input) {
        Map<Character, Integer> dic = new HashMap<>();
        int[] freq = new int[128];
        int left = 0, right = -1;
        int res = 0;
        while(left < input.length()) {
            if (right + 1 < input.length() && freq[input.charAt(right + 1)] == 0) {
                right++;// (0)
                freq[input.charAt(right)]++;// (97,1)
            } else {
                freq[input.charAt(left)]--;
                left++;
            }
            res = Math.max(res, right - left + 1);// (1)
        }
        System.out.println(res); // stack.stream().count()
    }
    
    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了54.39%的用户
     * 内存消耗：41.2 MB, 在所有 Java 提交中击败了90.18%的用户
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, j = 0;
        Set<Character> vis = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            while (vis.contains(s.charAt(i))) {
                vis.remove(s.charAt(j++));
            }
            vis.add(s.charAt(i));
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

}