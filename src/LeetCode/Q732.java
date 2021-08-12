package LeetCode;

public class Q732 {
    class Node {
        Node left = null;
        Node right = null;
        int start;
        int end;
        int val;

        public Node(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }

        public void acc(int s, int e) {
            if(s == start && e == end && left == null && right == null) {
                val++;
                max = Math.max(max, val);
                return;
            }
            int mid = (start + end) / 2;
            if(left == null) left = new Node(start, mid, val);
            if(right == null) right = new Node(mid, end, val);
            if(e <= mid) left.acc(s, e);
            else if(s >= mid) right.acc(s, e);
            else {
                left.acc(s, mid);
                right.acc(mid, e);
            }
        }

        public void print() {
            if(left == null && right == null) System.out.printf("[%s, %s)=%s, ", start, end, val);
            else {
                if(left != null) left.print();
                if(right != null) right.print();
            }
        }
    }

    Node root = new Node(0, 1_000_000_000, 0);
    int max = 0;

    public int book(int start, int end) {
        root.acc(start, end);
        return max;
    }
}
