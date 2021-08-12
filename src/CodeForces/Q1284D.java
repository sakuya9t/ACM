package CodeForces;

import java.io.*;
import java.util.*;

/**
 * Code-forces Submission Template.
 * Actual solution is in the taskC part.
 * Remove the package declaration when submission which is located in the first line.
 */
public class Q1284D {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    public static class TaskC {
        void solve(int testNumber, InputReader in, PrintWriter out) {
            int inputNum = in.nextInt();
            int[] startA = new int[inputNum], endA = new int[inputNum], startB = new int[inputNum], endB = new int[inputNum];
            for(int i = 0; i < inputNum; i++) {
                startA[i] = in.nextInt();
                endA[i] = in.nextInt();
                startB[i] = in.nextInt();
                endB[i] = in.nextInt();
            }
            boolean res = check(inputNum, startA, endA, startB, endB) && check(inputNum, startB, endB, startA, endA);
            out.println(res ? "YES" : "NO");
        }

        boolean check(int n, int[] sa, int[] ea, int[] sb, int[] eb) {
            TreeSet<Integer> start = new TreeSet<>(), end = new TreeSet<>();
            Event[] events = new Event[2*n];
            for(int i = 0; i < n; i++) {
                events[2*i] = new Event(sa[i], sb[i], eb[i], 1);
                events[2*i+1] = new Event(ea[i] + 1, sb[i], eb[i], 0);
            }

            Arrays.sort(events, (a, b) -> a.t == b.t ? a.isIn - b.isIn : a.t - b.t);

            for(int i = 0; i < 2*n; i++) {
                if(events[i].isIn == 1) {
                    if(!start.isEmpty()) {
                        int maxS = start.last(), minE = end.first();
                        if(maxS > events[i].e || minE < events[i].s) return false;
                    }
                    start.add(events[i].s);
                    end.add(events[i].e);
                }
                else {
                    start.remove(events[i].s);
                    end.remove(events[i].e);
                }
            }
            return true;
        }

    }

    static class Event {
        int t, s, e, isIn;

        public Event(int t, int s, int e, int isIn) {
            this.t = t;
            this.s = s;
            this.e = e;
            this.isIn = isIn;
        }
    }

    public static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}