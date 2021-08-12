package LeetCode;

class Q1000 {
    int[][][] memo; // from i to j, k piles
    int[] prefix;
    int k;

    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if(n == 1) return 0;
        this.k = K;
        memo = new int[n][n][K+1];
        prefix = new int[n+1];

        for(int i = 0; i < n; i++) prefix[i+1] = prefix[i] + stones[i];

        int res = dfs(stones, 1, 0, n-1);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // merge from s to e into p piles
    private int dfs(int[] arr, int p, int s, int e) {
        if(memo[s][e][p] != 0) return memo[s][e][p];
        if(e - s < p-1) return Integer.MAX_VALUE; // can't find
        if(s == e) return (p == 1) ? 0 : Integer.MAX_VALUE;

        if(p == 1) {
            int subCost = dfs(arr, k, s, e); // from s to e, make it into k piles so next turn can be merged into 1
            if(subCost < Integer.MAX_VALUE) memo[s][e][p] = prefix[e+1] - prefix[s] + subCost;
            else memo[s][e][p] = Integer.MAX_VALUE;
            return memo[s][e][p];
        }

        int res = Integer.MAX_VALUE;
        for(int k = s; k < e; k++) {
            int left = dfs(arr, p-1, s, k);  // put from s to k into one pile
            if(left == Integer.MAX_VALUE) continue;
            int right = dfs(arr, 1, k+1, e);
            if(right == Integer.MAX_VALUE) continue;
            res = Math.min(left + right, res);
        }

        memo[s][e][p] = res;
        return res;
    }
}
