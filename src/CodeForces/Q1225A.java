package CodeForces;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Code-forces Submission Template.
 * Actual solution is in the taskC part.
 * Remove the package declaration when submission.
 */
public class Q1225A {
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
            int a = in.nextInt();
            int b = in.nextInt();
            String res = "";
            if(a + 1 == b) res = a + "9 " + b + "0";
            else if(a == b) res = a + "0 " + b + "1";
            else if(a == 9 && b == 1) res = "99 100";
            else res = "-1";

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