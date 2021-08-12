package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Q1531 {
    TreeMap<Integer, Integer> lmap = new TreeMap<>();

    class Item{
        char ch;
        int cnt;
        public Item(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }

        public int len() {
            if(this.cnt == 1) return 1;
            if(this.cnt <= 9) return 2;
            if(this.cnt <= 99) return 3;
            return 4;
        }

        public String toString() {
            return "" + ch + (cnt > 1 ? cnt : "");
        }
    }

    int[][] dp;

    public int getLengthOfOptimalCompression(String s, int k) {
        lmap.put(1, 1);
        lmap.put(9, 2);
        lmap.put(99, 3);
        lmap.put(999, 4);
        List<Item> items = convertToItems(s.toCharArray());

        dp = new int[items.size()+1][k+1]; // max decrease at i-th index while have j remaining to remove
        for(int i = 0; i < items.size(); i++) Arrays.fill(dp[i], -1); // leave last row blank

        int totalLength = items.stream().map(i -> i.len()).reduce(0, (a, b) -> a + b);

        dfs(items, 0, k);
        int reduced = 0;
        for(int i: dp[0]) reduced = Math.max(reduced, i);
        return totalLength - reduced;
    }

    private int dfs(List<Item> items, int index, int remain) {
        if(dp[index][remain] != -1) return dp[index][remain];
        Item item = items.get(index);
        Integer key = lmap.floorKey(item.cnt); // max value we can have our item.cnt to become

        int res = dfs(items, index+1, remain);
        while(key != null) {
            int dr = item.cnt - key; // how much we cost on remain
            if(dr > remain) break;
            int dec = item.len() - lmap.get(key); // if change cnt to key, length we can decrease
            int next = dfs(items, index+1, remain - dr);
            res = Math.max(res, dec + next);
            key = lmap.lowerKey(key);
        }

        // totally remove our item
        if(remain >= item.cnt) {
            int vremain = remain - item.cnt;
            if(index > 0 && index < items.size() - 1 && items.get(index-1).ch == items.get(index+1).ch) {
                // merge prev and next
                Item pitem = items.get(index-1), nitem = items.get(index+1);
                Item vitem = new Item(pitem.ch, pitem.cnt + nitem.cnt);
                int mdec = pitem.len() + nitem.len() - vitem.len() + item.cnt;  // decrease by merging

                res = Math.max(res, mdec + dfs(items, index + 2, vremain));
                key = lmap.floorKey(vitem.cnt);

                while(key != null) {
                    int dr = vitem.cnt - key;
                    if(dr > vremain) break;
                    int dec = vitem.len() - lmap.get(key);
                    int next = dfs(items, index+2, vremain - dr);
                    res = Math.max(res, mdec + dec + next);
                    key = lmap.lowerKey(key);
                }
            }
            else {
                int next = dfs(items, index+1, vremain);
                res = Math.max(res, next + item.cnt);
            }
        }

        dp[index][remain] = res;
        return res;
    }

    private List<Item> convertToItems(char[] arr) {
        List<Item> res = new ArrayList<>();
        if(arr.length == 0) return res;
        Item curr = new Item(arr[0], 1);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == curr.ch) curr.cnt++;
            else {
                res.add(curr);
                curr = new Item(arr[i], 1);
            }
        }
        res.add(curr);
        return res;
    }
}
