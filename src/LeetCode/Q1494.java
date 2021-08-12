package LeetCode;

import java.util.Arrays;

class Q1494 {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        int[] pre = new int[n];
        for(int[] e: dependencies) pre[e[1]-1] |= (1 << (e[0]-1));

        int[] dp = new int[1<<n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        outer: for(int i = 0; i < dp.length; i++) {
            // 1s: done, 0s, not done
            int available = 0;
            for(int j = 0; j < n; j++) {
                if((i & (1<<j)) == (1<<j) && (i & pre[j]) != pre[j]) continue outer;
                if((i & pre[j]) == pre[j]) available |= (1<<j); // have done all pres of j
            }
            available &= (~i); // only do those haven't done

            for(int s = available; s > 0; s = (s-1) & available) {
                // for all bit subset of available
                if(Integer.bitCount(s) <= k) {
                    // if undone in s can be done in one semester
                    dp[i|s] = Math.min(dp[i|s], dp[i] + 1); // done i as well as s
                }
            }
        }
        return dp[dp.length-1];
    }
}
