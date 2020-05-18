package CodeForces;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Code-forces Submission Template.
 * Actual solution is in the taskC part.
 * Remove the package declaration when submission which is located in the first line.
 */
public class Q1285D {
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
            int n = in.nextInt();
            List<Integer> A = new LinkedList<>();
            for(int i = 0; i < n; i++) A.add(in.nextInt());
            int res = dfs(A, 30);

            out.println(res);
        }

        private int dfs(List<Integer> A, int bits) {
            if(A.isEmpty() || bits < 0) return 0;
            List<Integer> L = new LinkedList<>(), R = new LinkedList<>();
            int mask = 1 << bits;
            for(int i: A) {
                if((mask & i) == 0) L.add(i); // required bit is 0
                else R.add(i); // current bit is 1
            }
            if(L.size() == 0) return dfs(R, bits-1);
            if(R.size() == 0) return dfs(L, bits-1);
            return Math.min(dfs(L, bits-1), dfs(R, bits-1)) + (1 << bits);
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