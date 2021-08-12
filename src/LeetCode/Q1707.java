package LeetCode;

public class Q1707 {
    class Node {
        Node[] children;

        public Node() {
            this.children = new Node[2];
        }

        public void insert(String s, int idx) {
            if(idx == s.length()) return;
            int v = s.charAt(idx) - '0';
            if(this.children[v] == null) this.children[v] = new Node();
            this.children[v].insert(s, idx+1);
        }

        public String query(String target, String bound, int idx, int currT, int currB, StringBuilder sb) {
            if(idx == target.length()) return sb.toString();
            // should go to 1
            int bDigit = bound.charAt(idx) - '0';
            if(this.children[1] != null && (target.charAt(idx) == '1' || this.children[0] == null) && currT*2+1 <= currB*2+bDigit) {
                sb.append('1');
                String res = this.children[1].query(target, bound, idx+1, currT*2+1, currB*2+bDigit, sb);
                if(res != null) return res;
                sb.setLength(sb.length() - 1);
            }
            // should go to 0
            if(this.children[0] != null && currT*2 <= currB*2+bDigit) {
                sb.append('0');
                String res = this.children[0].query(target, bound, idx+1, currT*2, currB*2+bDigit, sb);
                if(res != null) return res;
                sb.setLength(sb.length() - 1);
            }
            return null;
        }
    }

    Node root = new Node();
    public int[] maximizeXor(int[] nums, int[][] queries) {
        for(int i: nums) {
            String s = String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0');
            root.insert(s, 0);
        }

        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            String t = String.format("%32s", Integer.toBinaryString(Integer.MAX_VALUE ^ q[0])).replace(' ', '0');
            String r = root.query(t, String.format("%32s", Integer.toBinaryString(q[1])).replace(' ', '0'), 0, 0, 0, new StringBuilder());
            if(r == null) res[i] = -1;
            else res[i] = q[0] ^ Integer.parseInt(r, 2);
        }
        return res;
    }
}
