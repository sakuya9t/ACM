package CodeForces;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Code-forces Submission Template.
 * Actual solution is in the taskC part.
 * Remove the package declaration when submission which is located in the first line.
 */
public class Q1305C {
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
            int m = in.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) nums[i] = in.nextInt();
            if(n > m) {
                out.println(0);
                return;
            }

            long res = 1;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < i; j++) {
                    res = (res * (Math.abs(nums[j] - nums[i]) % m)) % m;
                }
            }

            out.println(res);
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